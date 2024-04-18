package ckflying.jieqi.core.Controller;

import ckflying.jieqi.core.enums.OrderEventEnum;
import ckflying.jieqi.core.enums.OrderStatusEnum;
import ckflying.jieqi.core.statebiz.OrderMessageDto;
import ckflying.jieqi.core.statebiz.OrderStateBiz;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderStateBiz orderStateBiz;

    @PostMapping("/confirm")
    public String confirm(){
        OrderMessageDto orderMessageDto = new OrderMessageDto();
        orderMessageDto.setStatus(OrderStatusEnum.WAIT_INQUIRY_CONFIRM);
        orderMessageDto.setOrderSn("XJ11");
        orderMessageDto.setOrderId(11);
        orderStateBiz.execute(OrderEventEnum.CONFIRM_INQUIRY, orderMessageDto);

        OrderMessageDto orderMessageDto2 = new OrderMessageDto();
        orderMessageDto2.setStatus(OrderStatusEnum.WAIT_INQUIRY_CONFIRM);
        orderMessageDto2.setOrderSn("XJ211");
        orderMessageDto2.setOrderId(211);
        orderStateBiz.execute(OrderEventEnum.CONFIRM_INQUIRY, orderMessageDto2);
        return "success";
    }

    @PostMapping("/check")
    public String check(){
        OrderMessageDto orderMessageDto = new OrderMessageDto();
        orderMessageDto.setStatus(OrderStatusEnum.WAIT_INQUIRY_CONFIRM);
        orderMessageDto.setOrderSn("XJ11");
        orderMessageDto.setOrderId(11);
        orderStateBiz.execute(OrderEventEnum.INQUIRY_CHECK_PASS, orderMessageDto);

        OrderMessageDto orderMessageDto2 = new OrderMessageDto();
        orderMessageDto2.setStatus(OrderStatusEnum.WAIT_INQUIRY_CONFIRM);
        orderMessageDto2.setOrderSn("XJ211");
        orderMessageDto2.setOrderId(211);
        orderStateBiz.execute(OrderEventEnum.INQUIRY_CHECK_PASS, orderMessageDto);
        return "success";
    }

    @PostMapping("/callback")
    public String callback(){
        OrderMessageDto orderMessageDto = new OrderMessageDto();
        orderMessageDto.setStatus(OrderStatusEnum.WAIT_INQUIRY_CONFIRM);
        orderMessageDto.setOrderSn("XJ11");
        orderMessageDto.setOrderId(11);
        orderStateBiz.execute(OrderEventEnum.CALLBACK_INQUIRY, orderMessageDto);

        OrderMessageDto orderMessageDto2 = new OrderMessageDto();
        orderMessageDto2.setStatus(OrderStatusEnum.WAIT_INQUIRY_CONFIRM);
        orderMessageDto2.setOrderSn("XJ211");
        orderMessageDto2.setOrderId(211);
        orderStateBiz.execute(OrderEventEnum.CALLBACK_INQUIRY, orderMessageDto);
        return "success";
    }
}
