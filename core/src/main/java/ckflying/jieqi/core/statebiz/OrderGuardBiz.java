package ckflying.jieqi.core.statebiz;

import ckflying.jieqi.core.enums.OrderEventEnum;
import ckflying.jieqi.core.enums.OrderStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class OrderGuardBiz {

    public MyGuard<OrderStatusEnum, OrderEventEnum, OrderMessageDto> checkAllowJump(){
        return new MyGuard<OrderStatusEnum, OrderEventEnum, OrderMessageDto>() {
            @Override
            public boolean check(OrderStatusEnum source, OrderStatusEnum target,
                                 OrderEventEnum orderEventEnum, OrderMessageDto o) {
                if(o.getOrderId() > 100){
                    return true;
                }
                return false;
            }
        };
    }
}
