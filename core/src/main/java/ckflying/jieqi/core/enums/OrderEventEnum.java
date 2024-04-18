package ckflying.jieqi.core.enums;

public enum OrderEventEnum {

    CONFIRM_INQUIRY,//("询价方填写确定"),
    REJECT_INQUIRY,//("驳回修改"),
    CALLBACK_INQUIRY,//("主动撤回"),
    INQUIRY_CHECK_PASS,//("审核通过"),
    PUBLISH_REJECT,//("发布驳回"),
    PUBLISH,//("发布"),
    OFFER_PRICE,//("询价单已报价"),
    CALL_BACK_OFFER_PRICE,//("供应商主动撤回"),
    OPEN_PRICE,//("开价"),
    NEGOTIATION_PRICE,//("议价"),
    ADD_PROVIDER,//("添加供应商"),
    CONFIRM_PRICE,//("确认定价结果"),
    CANCEL,//("询价单已作废"),

}
