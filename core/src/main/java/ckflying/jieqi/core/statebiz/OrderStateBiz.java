package ckflying.jieqi.core.statebiz;

import ckflying.jieqi.core.biz.XjOrderBiz;
import ckflying.jieqi.core.enums.OrderEventEnum;
import ckflying.jieqi.core.enums.OrderStatusEnum;
import ckflying.jieqi.core.enums.StateMachineNameEnum;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderStateBiz extends DefaultStateBiz<OrderStatusEnum, OrderEventEnum, OrderMessageDto> {

    @Override
    StateMachineNameEnum getNameEnum() {
        return StateMachineNameEnum.XJ_STATE_NAME;
    }
}
