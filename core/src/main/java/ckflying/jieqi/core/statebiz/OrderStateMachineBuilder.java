package ckflying.jieqi.core.statebiz;

import ckflying.jieqi.core.biz.XjOrderBiz;
import ckflying.jieqi.core.enums.OrderEventEnum;
import ckflying.jieqi.core.enums.OrderStatusEnum;
import ckflying.jieqi.core.enums.StateMachineNameEnum;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;
import org.springframework.statemachine.config.StateMachineBuilder;

import javax.annotation.Resource;
import java.util.EnumSet;
import java.util.Optional;

@Component
public class OrderStateMachineBuilder implements MyStateMachineBuilder<OrderStatusEnum, OrderEventEnum> {

    @Resource
    private OrderGuardBiz orderGuardBiz;

    @Resource
    private XjOrderBiz xjOrderBiz;

    @Override
    public String getName() {
        return StateMachineNameEnum.XJ_STATE_NAME.name();
    }

    @Override
    public StateMachine<OrderStatusEnum, OrderEventEnum> build() throws Exception {
        StateMachineBuilder.Builder<OrderStatusEnum, OrderEventEnum> builder = StateMachineBuilder.builder();

        builder.configureConfiguration()
                .withConfiguration()
                .autoStartup(true)
                .machineId(getName())
                .listener(listener());

        // 初始化状态机，并指定状态集合
        // 详细说明下，由于XXX将用户实名+申请额度的流程都统一承载在订单维度，所以这里有个分支流程处理相关数据
        // 包括实名、业务审核、资料补全、证件上传、贷前额度审核等节点
        // 这块流程与订单流程全都耦合在一起，拆出来工作量及代价都比较大，所以在订单系统中统一维护起来
        // 故XXX的业务状态最多，也最复杂
        builder.configureStates()
                .withStates()
                .initial(OrderStatusEnum.WAIT_INQUIRY_CONFIRM)
                .choice(OrderStatusEnum.CHECK_HAS_JUMP)
                .end(OrderStatusEnum.ORDER_CONFIRM_PRICE)
                .end(OrderStatusEnum.ORDER_CANCEL)
                .states(EnumSet.allOf(OrderStatusEnum.class)) // 所有状态，避免有遗漏
        ;

        // 指定状态机有哪些节点，即迁移动作
        builder.configureTransitions()
                // XXX的创建，并不是CREATE状态，而是为待实名WAIT_REAL_NAME_AUTH或者待借款WAIT_BORROW状态，
                // 所以需要虚拟节点，自己跳转
                .withExternal()
                .source(OrderStatusEnum.WAIT_INQUIRY_CONFIRM)
                .target(OrderStatusEnum.CHECK_HAS_JUMP)
                .event(OrderEventEnum.CONFIRM_INQUIRY)
                .and()
                .withChoice()
                .source(OrderStatusEnum.CHECK_HAS_JUMP)
                .first(OrderStatusEnum.WAIT_INQUIRY_CHECK, orderGuardBiz.checkAllowJump().guard())
                .last(OrderStatusEnum.WAIT_INQUIRY_PUBLISHED)

                .and()
                .withExternal()
                .source(OrderStatusEnum.WAIT_INQUIRY_CHECK)
                .target(OrderStatusEnum.PROVIDER_BIDDING)
                .event(OrderEventEnum.INQUIRY_CHECK_PASS)

                .and()
                .withExternal()
                .source(OrderStatusEnum.WAIT_INQUIRY_PUBLISHED)
                .target(OrderStatusEnum.WAIT_INQUIRY_CONFIRM)
                .event(OrderEventEnum.CALLBACK_INQUIRY)
        ;


        return builder.build();
    }

    private Action<OrderStatusEnum, OrderEventEnum> changeStatusAction1(){
        return new Action<OrderStatusEnum, OrderEventEnum>() {
            @Override
            public void execute(StateContext<OrderStatusEnum, OrderEventEnum> stateContext) {
                System.out.println(stateContext.getSource().getId().name() + "变为1" + stateContext.getTarget().getId().name());
            }
        };

    }

    private Action<OrderStatusEnum, OrderEventEnum> changeStatusAction2(){
        return new Action<OrderStatusEnum, OrderEventEnum>() {
            @Override
            public void execute(StateContext<OrderStatusEnum, OrderEventEnum> stateContext) {
                System.out.println(stateContext.getSource().getId().name() + "变为2" + stateContext.getTarget().getId().name());
            }
        };

    }

    private Action<OrderStatusEnum, OrderEventEnum> changeStatusAction3(){
        return new Action<OrderStatusEnum, OrderEventEnum>() {
            @Override
            public void execute(StateContext<OrderStatusEnum, OrderEventEnum> stateContext) {
                System.out.println(stateContext.getSource().getId().name() + "变为3" + stateContext.getTarget().getId().name());
            }
        };

    }

    private Action<OrderStatusEnum, OrderEventEnum> changeStatusAction4(){
        return new Action<OrderStatusEnum, OrderEventEnum>() {
            @Override
            public void execute(StateContext<OrderStatusEnum, OrderEventEnum> stateContext) {
                System.out.println(stateContext.getSource().getId().name() + "变为3" + stateContext.getTarget().getId().name());
            }
        };

    }

    private MyStateMachineListener<OrderStatusEnum, OrderEventEnum, OrderMessageDto> listener() {
        return new MyStateMachineListener<OrderStatusEnum, OrderEventEnum, OrderMessageDto>() {

            @Override
            public void stateChanged(State<OrderStatusEnum, OrderEventEnum> from, State<OrderStatusEnum, OrderEventEnum> to,
                                     OrderMessageDto orderMessageDto) {
                xjOrderBiz.updateStatus(orderMessageDto, from.getId(), to.getId());
            }

            @Override
            public void eventNotAccepted(OrderMessageDto orderMessageDto) {
                System.err.println("order id =" + orderMessageDto.getOrderId()
                        + "状态有误");
            }

            private Object ofNullableState(State<OrderStatusEnum, OrderEventEnum> s) {
                return Optional.ofNullable(s)
                        .map(State::getId)
                        .orElse(null);
            }
        };
    }
}
