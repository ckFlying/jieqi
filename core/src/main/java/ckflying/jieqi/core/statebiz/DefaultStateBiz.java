package ckflying.jieqi.core.statebiz;

import ckflying.jieqi.core.enums.OrderEventEnum;
import ckflying.jieqi.core.enums.StateMachineNameEnum;
import org.apache.shiro.util.Initializable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.ObjectStateMachine;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public abstract class DefaultStateBiz<S, E, O extends MyMessageDto<S>> {

    protected StateMachine<S, E> stateMachine;

    @Resource
    private List<MyStateMachineBuilder<S, E>> builders;

    @PostConstruct
    public void init() throws Exception {
        MyStateMachineBuilder<S, E> builder = builders.stream().filter(e -> e.getName().equals(getNameEnum().name())).findFirst().orElse(null);
        if(builder == null){
            throw new Exception("MyStateMachineBuilder exist null");
        }
        stateMachine = builder.build();
    }



    abstract StateMachineNameEnum getNameEnum();

    @Transactional(rollbackFor = Exception.class)
    public void execute(E e, O o){
        Message<E> eventMsg = MessageBuilder.withPayload(e)
                // key 与 status change 时不同，对应的model也不同
                .setHeader(o.getClass().getName(), o)
                .build();


        stateMachine.sendEvent(eventMsg);
    }
}
