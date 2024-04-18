package ckflying.jieqi.core.biz;

import ckflying.jieqi.core.enums.OrderStatusEnum;
import ckflying.jieqi.core.statebiz.OrderMessageDto;
import org.springframework.stereotype.Service;

@Service
public class XjOrderBiz {

    public Boolean checkHasJump(int orderId){
        return orderId > 100;
    }

    public void updateStatus(OrderMessageDto orderMessageDto, OrderStatusEnum source, OrderStatusEnum target){
        System.out.println("order id =" + orderMessageDto.getOrderId()
        + "状态由【" + source.name() + "】变为【" + target.name() + "】");
    }
}
