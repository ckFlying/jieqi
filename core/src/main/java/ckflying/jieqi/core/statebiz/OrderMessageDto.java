package ckflying.jieqi.core.statebiz;

import ckflying.jieqi.core.enums.OrderStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderMessageDto extends MyMessageDto<OrderStatusEnum> {

    private String orderSn;

    private Integer orderId;
}
