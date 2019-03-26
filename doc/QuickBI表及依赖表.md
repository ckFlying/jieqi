## QuickBI的表及依赖表

    bi_report.bi_cache_generalize_shop(QucikBI-推广-店铺纬度报表)的依赖表：
	- 1. bi_quick_bi.bi_cat_all_month
	- 2. bi_report.bi_cache_company_annual_sale
	- 3. bi_quick_bi.bi_promo_ztc
#
	bi_report.bi_cache_oms_order_packet_info(QuickBI自助取数-OMS订单包裹信息)的依赖表：
    	- 1. romeo.party
    	- 2. romeo.order_shipment
    	- 3. ecshop.ecs_order_info
    	- 4. oms.party
    	- 5. wmsclient.wms_actual_package
    	- 6. oms.warehouse_shipping_choose
    	- 7. oms.warehouse_shipping_choose_result
    	- 8. oms.order_goods
    	- 9. oms.order_info
    	- 10. oms.order_goods
    	- 11. oms.sku
    	- 12. oms.goods
    	- 13. oms.shop
    	- 14. oms.warehouse
    	- 15. oms.payment
    	- 16. oms.shipping
    	- 17. oms.region
    	- 18. bi_temp.strategic_batch_quickbi_oms_order_packet_info
    	- 19. romeo.shipment
    	- 20. ecshop.ecs_order_goods
    	- 21. ecshop.ecs_goods
    	- 22. romeo.facility
    	- 23. ecshop.ecs_payment
    	- 24. ecshop.distributor
    	- 25. ecshop.ecs_region
#
    bi_report.bi_cache_activity_selection_predict(QuickBI自助取数-活动预估VS实际销售)的依赖表：
    	- 1. bi_strategic.strategic_activities
    	- 2. bi_strategic.strategic_activities_selection
    	- 3. bi_strategic.strategic_shop
    	- 4. oms.goods_group
    	- 5. oms.goods_group_detail
    	- 6. oms.sku
    	- 7. oms.party
    bi_report.bi_cache_activity_selection_actual(QuickBI自助取数-活动预估VS实际销售)的依赖表：
    	- 1. bi_strategic.strategic_activities
    	- 2. bi_strategic.strategic_shop
    	- 3. oms.shop
    	- 4. oms.origin_order
    	- 5. oms.order_info
    	- 6. oms.order_goods
    	- 7. oms.sku
    	- 8. oms.goods
    	- 9. oms.goods_custom_category
    bi_report.bi_cache_activity_selection_actual(QuickBI自助取数-活动预估VS实际销售)的依赖表：
    	- 1. bi_report.bi_cache_activity_selection_predict
    	- 2. bi_report.bi_cache_activity_selection_actual
#
    bi_report.bi_cache_company_annual_sale(QuickBI自助取数-公司业务全年销售总览)的依赖表：
    	- 1. bi_report.bi_cache_daily_sycm_self_fetch_data
    	- 2. bi_report.bi_cache_erp_shop_info
    	- 3. bi_quick_bi.yy_predict_shop_amount_yearly
    	- 4. bi_quick_bi.yy_extension_target_yearly
    	- 5. bi_quick_bi.strategic_quick_bi_extend_ckshow_shop_total
    	- 6. bi_quick_bi.ct_weekly_report_shop_month
    	- 7. bi_quick_bi.crm_amount_target_yearly
    	- 8. bi_report.crm_month_insert_0
    	- 9. bi_temp.strategic_batch_quickbi_company_annual_sale
#
    bi_report.crm_dimension_shop_insert_0(QuickBI自助取数-CRM店铺维度缓存)的依赖表：
    	- 1. bi_report.bi_cache_company_annual_sale
    	- 2. bi_report.crm_month_insert_0
    	- 3. bi_quick_bi.crm_amount_target_yearly
    bi_report.crm_dimension_shop_insert_12(QuickBI自助取数-CRM店铺维度缓存)的依赖表：
    	- 1. bi_report.bi_cache_company_annual_sale
    	- 2. bi_report.crm_month_insert_12
    bi_report.crm_dimension_shop_insert_24(QuickBI自助取数-CRM店铺维度缓存)的依赖表：
    	- 1. bi_report.bi_cache_company_annual_sale
    	- 2. bi_report.crm_month_insert_24
#
    bi_report.crm_result_kpi_insert_0(CRM结果KPI缓存)的依赖表：
    	- 1. bi_report.bi_cache_company_annual_sale
    	- 2. bi_report.crm_month_insert_0
    	- 3. bi_quick_bi.crm_amount_target_yearly
    bi_report.crm_result_kpi_insert_12(QuickBI自助取数-CRM店铺维度缓存)的依赖表：
    	- 1. bi_report.bi_cache_company_annual_sale
    	- 2. bi_report.crm_month_insert_12
    	- 4. bi_quick_bi.crm_amount_target_yearly
    bi_report.crm_result_kpi_insert_24(QuickBI自助取数-CRM店铺维度缓存)的依赖表：
    	- 1. bi_report.bi_cache_company_annual_sale
    	- 2. bi_report.crm_month_insert_24
    	- 4. bi_quick_bi.crm_amount_target_yearly
#
    bi_report.bi_cache_ct_kf_presale_report(QuickBI售前客服结果KPI)的依赖表：
    	- 1. bi_quick_bi.yy_pre_sale_service_target_yearly
    	- 2. bi_report.bi_cache_company_annual_sale cas1
    	- 3. bi_report.bi_cache_ct_kf_self_monthly_by_shop
    	- 4. bi_report.bi_cache_ct_kf_shop_monthly_by_category
    	- 5. bi_report.bi_cache_ct_kf_self_monthly_by_category
    	- 6. bi_quick_bi.ct_weekly_report_shop_month
    	- 7. bi_report.bi_cache_erp_shop_info
    	- 8. bi_report.bi_cache_ct_kf_shop_monthly_by_shop
#
    bi_report.bi_cache_ct_kf_shop_monthly_by_shop(QuickBI售前客服结果KPI前置SQL)的依赖表：
    	- 1. bi_quick_bi.ct_weekly_report_shop_month
    	- 2. bi_quick_bi.yy_pre_sale_service_target_yearly
    bi_report.bi_cache_ct_kf_shop_monthly_by_category(QuickBI售前客服结果KPI前置SQL)的依赖表：
    	- 1. bi_quick_bi.ct_weekly_report_shop_month
    	- 2. bi_report.bi_cache_erp_shop_info
    bi_report.bi_cache_ct_kf_self_monthly_by_shop(QuickBI售前客服结果KPI前置SQL)的依赖表：
    	- 1. bi_quick_bi.ct_weekly_report_cs_month
    bi_report.bi_cache_ct_kf_self_monthly_by_category(QuickBI售前客服结果KPI前置SQL)的依赖表：
    	- 1. bi_quick_bi.ct_weekly_report_cs_month
    	- 2. bi_report.bi_cache_erp_shop_info
#
    bi_report.bi_cache_daily_sycm_flow(QuickBI-数据指标-流量来源统计)的依赖表：
    	- 1. bi_strategic.strategic_input_daily_sycm_flow_pc
    	- 2. bi_strategic.strategic_input_daily_sycm_flow_wifi
    	- 3. bi_strategic.strategic_shop
#
    bi_report.bi_cache_daily_sycm_goods_effect(QuickBI-数据指标-商品效果统计)的依赖表：
    	- 1. bi_strategic.strategic_input_daily_sycm_goods_effect
    	- 2. bi_strategic.strategic_shop
#
    bi_report.bi_cache_daily_sycm_self_fetch_data(QuickBI-数据指标-店铺整体统计)的依赖表：
    	- 1. bi_strategic.strategic_input_daily_sycm_self_fetch_data_one
    	- 2. bi_strategic.strategic_shop
    	- 3. bi_strategic.strategic_input_daily_sycm_self_fetch_data_two
    	- 4. bi_strategic.strategic_input_daily_sycm_self_fetch_data_three
#
    bi_report.bi_cache_erp_shop_info(QuickBI自助取数-老REP店铺信息)的依赖表：
    	- 1. ecshop.taobao_shop_conf
    	- 2. ecshop.distributor_detail_info
    	- 3. oms.party
    	- 4. bi_strategic.strategic_shop
#
    bi_report.bi_cache_goods_effect_total(QuickBI自助取数-商品效果信息合计)的依赖表：
    	- 1. bi_report.bi_cache_daily_sycm_goods_effect
    	- 2. bi_strategic.strategic_shop
    	- 3. oms.party
#
    bi_report.bi_cache_monthly_sycm_flow(QuickBI-数据指标-流量来源月统计)的依赖表：
    	- 1. bi_strategic.strategic_input_monthly_sycm_flow_pc
    	- 2. bi_strategic.strategic_input_monthly_sycm_flow_wifi
    	- 3. bi_strategic.strategic_shop
#
    bi_report.bi_cache_oms_claim_settlement(QuickBI自助取数-OMS理赔金额)的依赖表：
    	- 1. oms.compensation
    	- 2. oms.compensation_action
    	- 3. oms.shop
    	- 4. bi_temp.strategic_batch_quickbi_oms_claim_settlement
#
    bi_report.bi_cache_oms_order_goods_info(QuickBI自助取数-OMS订单商品详情表-数据同步)的依赖表：
    	- 1. oms.order_goods
    	- 2. oms.order_info
    	- 3. oms.party
    	- 4. oms.sku
    	- 5. oms.goods
    	- 6. oms.goods_custom_category
    	- 7. oms.goods_group
    	- 8. oms.inventory_detail
    	- 9. oms.shop
    	- 10.bi_temp.strategic_batch_quickbi_oms_order_goods_info
#
    bi_report.bi_cache_oms_order_info_circulation_time(QuickBI自助取数-OMS订单信息与流转耗时表)的依赖表：
    	- 1. wmsclient.wms_order
    	- 2. wmsclient.wms_actual_package
    	- 3. oms.order_action
    	- 4. oms.order_info
    	- 5. oms.origin_order
    	- 6. oms.party
    	- 7. oms.warehouse
    	- 8. oms.region
    	- 9. oms.shipping
    	- 10.oms.distributor
    	- 11.oms.shop
    	- 12.oms.order_reserve
    	- 13.oms.order_process
    	- 14.oms.payment
    	- 15.bi_temp.strategic_batch_quickbi_oms_order_info_circulation_time
#
    bi_report.bi_cache_oms_purchase_order_info(QuickBI自助取数-OMS采购订单信息表)的依赖表：
    	- 1. oms.provider_adjust_price
    	- 2. oms.order_purchase_detail
    	- 3. oms.order_invoice
    	- 4. oms.order_payable_detail
    	- 5. oms.order_action
    	- 6. oms.order_purchase
    	- 7. oms.party
    	- 8. oms.provider
    	- 9. oms.inventory_lock_tag
    	- 10.oms.warehouse
    	- 11.oms.order_goods
    	- 12.oms.sku 
    	- 13.oms.goods
    	- 14.oms.inventory_detail
    	- 15.oms.sys_user
    	- 16.bi_temp.strategic_batch_quickbi_oms_purchase_order_info
#
    bi_report.bi_cache_oms_snapshot_inventory_statistics_daily(QuickBI自助取数-OMS库存快照表_商品维度按日数据同步)的依赖表：
    	- 1. oms.`inventory_detail`
    	- 2. oms.`inventory`
    	- 3. omssupply.order_goods_inventory_statistics
    	- 4. oms.sku
    	- 5. oms.goods
    	- 6. oms.party
    	- 7. oms.warehouse
    	- 8. oms.`order_info`
#
    bi_report.bi_cache_order_facility_scale_actual(QuickBI自助取数-业务单量分仓实际表)的依赖表：
    	- 1. bi_report.bi_cache_oms_order_info_circulation_time
        - 2. bi_temp.strategic_batch_quickbi_order_facility_scale_actual
#
    bi_report.bi_cache_order_facility_switch(QuickBI自助取数-订单转仓明细)的依赖表：
    	- 1. oms.order_info
    	- 2. oms.party
    	- 3. oms.shop
    	- 4. oms.region
    	- 5. oms.warehouse_shipping_choose_result
    	- 6. oms.warehouse_shipping_choose
    	- 7. oms.warehouse
    	- 8. bi_temp.strategic_batch_quickbi_order_facility_switch
#
    bi_report.bi_cache_promotion_channel(QuickBI自助取数-推广-渠道维度)的依赖表：
    	- 1. bi_quick_bi.ztc_item_monthly
    	- 2. bi_report.bi_cache_erp_shop_info
    	- 3. bi_quick_bi.yy_extension_target_yearly
    	- 4. bi_report.bi_cache_company_annual_sale
    	- 5. bi_quick_bi.bi_promo_ztc
    	- 6. bi_quick_bi.bi_cat_all_month
    	- 7. bi_quick_bi.strategic_creative_click_monthly
    	- 8. bi_quick_bi.sjyh_extend_data_month
    	- 9. bi_quick_bi.pxb_star_shop_account_monthly
    	- 10.bi_quick_bi.pxb_brand_click_account_monthly
    	- 11.bi_quick_bi.pxb_special_brand_account_monthly
    	- 12.bi_quick_bi.tbk_monthly_effect_report_order_detail
#
    bi_report.bi_cache_qbt_brand_big_plate(QuickBI自助取数-情报通品牌大盘)的依赖表：
    	- 1. spider.qbt_category_monthly_report
    	- 2. spider.`qbt_category_relation`
    	- 3. bi_temp.strategic_batch_quickbi_qbt_brand_big_plate
#
    bi_report.bi_cache_qbt_category_big_plate(QuickBI自助取数-情报通品类大盘数据同步)的依赖表：
    	- 1. spider.qbt_category_monthly_report
    	- 2. spider.`qbt_category_relation`
    	- 3. bi_temp.strategic_batch_quickbi_qbt_category_big_plate
#
    bi_report.bi_cache_qbt_hot_sale_goods(QuickBI自助取数-情报通热销商品数据同步)的依赖表：
    	- 1. spider.qbt_hot_sale_goods
    	- 2. bi_temp.strategic_batch_quickbi_qbt_hot_sale_goods
#
    bi_report.bi_cache_qbt_hot_sale_shops(QuickBI自助取数-情报通热销店铺数据同步)的依赖表：
    	- 1. spider.qbt_hot_sale_shops
    	- 2. spider.qbt_category_relation
    	- 3. bi_temp.strategic_batch_quickbi_qbt_hot_sale_shops
#
    bi_report.bi_cache_seller_goods_relation(QuickBI自助取数-商家编码和淘宝商品id映射关系同步)的依赖表：
    	- 1. ecshop.sync_taobao_items
    	- 2. ecshop.distribution_group_goods
    	- 3. ecshop.sync_taobao_items_sku
    	- 4. oms.shop_sku
    	- 5. oms.sku
    	- 6. oms.goods_group
    	- 7. oms.goods_group_detail
    	- 8. oms.shop
#
    bi_report.bi_cache_shop_order_facility_scale_info(QuickBI自助取数-业务单量分仓预估信息)的依赖表：
    	- 1. report.v_monthday
    	- 2. bi_strategic.strategic_shop
    	- 3. bi_strategic.strategic_input_kpi_order_facility_scale
    	- 4. bi_strategic.strategic_input_kpi_predict_monthly_operate_apply_money
    	- 5. bi_report.bi_cache_shop_order_facility_scale_info
    	- 6. oms.party
#
    bi_report.bi_cache_generalize_shop(QucikBI-推广-店铺纬度报表)的依赖表：
    	- 1. bi_report.bi_cache_company_annual_sale
    	- 2. bi_quick_bi.strategic_quick_bi_extend_ckshow_shop_total
    	- 3. bi_quick_bi.yy_extension_target_yearly
    	- 4. bi_quick_bi.bi_promo_ztc
    	- 5. bi_quick_bi.sjyh_extend_data_month
    	- 6. bi_quick_bi.pxb_brand_click_account_monthly
    	- 7. bi_quick_bi.ztc_item_monthly
    	- 8. bi_quick_bi.strategic_creative_click_monthly
    	- 9. bi_quick_bi.pxb_star_shop_account_monthly
    	- 10.bi_quick_bi.bi_cat_all_month
#
    bi_report.oms_cache_supply_chain_goods(QucikBI供应量商品信息同步)的依赖表：
    	- 1. oms.goods
    	- 2. oms.party
    	- 3. oms.sku
    	- 4. oms.goods_custom_category
    	- 5. oms.goods_brand
#
    bi_report.bi_cache_custom_service_result_monthly(QuickBI售后客服结果KPI月统计)的依赖表：
    	- 1. bi_report.bi_cache_company_annual_sale
    	- 2. bi_report.bi_cache_daily_sycm_self_fetch_data
    	- 3. bi_strategic.`strategic_custom_service_report_monthly`
    	- 4. bi_report.bi_cache_oms_claim_settlement
#
    bi_report.yy_predict_shop_amount_yearly(QucikBI-年度销量汇总数据同步)的依赖表：
    	- 1. bi_quick_bi.yy_predict_shop_amount_yearly

    

