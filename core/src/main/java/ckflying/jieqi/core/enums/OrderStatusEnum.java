package ckflying.jieqi.core.enums;

public enum OrderStatusEnum {
    WAIT_INQUIRY_CONFIRM,//("WAIT_INQUIRY_CONFIRM", "待询价方确认"),
    CHECK_HAS_JUMP,//判断是否跳过待询价方审核 中间态
    WAIT_INQUIRY_CHECK,//("WAIT_INQUIRY_CHECK", "待询价方审核"),
    WAIT_INQUIRY_PUBLISHED,//("WAIT_INQUIRY_PUBLISHED", "待询价方发布"),
    PROVIDER_BIDDING,//("PROVIDER_BIDDING", "供应商报价中"),
    PROVIDER_BIDDEN,//("PROVIDER_BIDDEN", "供应商已报价"),
    ORDER_OPEN_PRICE,//("ORDER_OPEN_PRICE", "项目已开价"),
    ORDER_CONFIRM_PRICE,//("ORDER_CONFIRM_PRICE", "项目已定价"),
    ORDER_CANCEL,//("ORDER_CANCEL", "项目已作废"),;

}
