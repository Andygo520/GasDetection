package utils;

/**
 * Created by Administrator on 2017/4/26.
 */

public class _Url {
    public static final String LOGIN = "login_commit";
    public static final String PROFILE = "system_user";
    public static final String CHECK_STOCK = "material_stock_check";
    public static final String STOCK_CHECK_MANAGE = "material_stock_check_manage";
    public static final String CHECK_COMMIT = "material_stock_check_manage";
    public static final String IN_ORDER_DETAIL = "material_in_order";
    public static final String MATERIAL_OUT_ORDER_DETAIL = "material_out_order";
    public static final String OUT_COMMIT = "material_out_order";
    public static final String STOCK_DETAIL = "material_stock";
    public static final String PRODUCT_CHECK_STOCK = "product_stock_check";
    public static final String PRODUCT_CHECK_STOCK_MANAGE = "product_stock_check_manage";

    public static final String PRODUCT_CHECK_STOCK_COMMIT = "product_stock_check_manage";

    public static final String PRODUCT_STOCK_DETAIL = "product_stock";
    public static final String MATERIAL_IN_ORDER = "material_in_order";
    public static final String MATERIAL_SPACE = "material_space";
    public static final String HALF_SPACE = "half_space";
    public static final String PRODUCT_SPACE = "product_space";

    public static final String MATERIAL_CHECK_MANAGE = "material_stock_check_manage";
    public static final String MATERIAL_CHECK_QUERY = "material_stock_check";

    public static final String STOCK = "material_stock";

    public static final String MATERIAL_OUT_ORDER = "material_out_order";

    public static final String PRODUCT_CHECK_MANAGE = "product_stock_check_manage";
    public static final String PRODUCT_CHECK_QUERY = "product_stock_check";

    public static final String PRODUCT_STOCK = "product_stock";

    public static final String PRODUCE_PLAN = "produce_plan";//加工单列表
    public static final String PRODUCE_BOM = "produce_bom";//子加工单列表
    public static final String DELIVERY_PLAN = "custom_deliver";

    public static final String RECEIVE = "produce_receive";

    public static final String PLAN_RECEIVE = "produce_plan";//加工单领料
    public static final String PRODUCT_PRE_IN_STOCK_COMMIT = "/produce_plan/pre_in_stock_commit?batchId={batchId}&successNum={successNum}&testId={testId}&testRemark={testRemark}";//成品提交待入库
    public static final String PRODUCT_ACTUAL_NUM_COMMIT = "/produce_plan/actual_num_commit?producePlanId={ID}&actualNum={actualNum}&actualId={actualId}&lastProcessBoxIds={lastProcessBoxIds}&status={status}";//成品提交待检验

    public static final String BOM_RECEIVE_MATERIAL_COMMIT = "/produce_bom/receive_commit?produceBomId={ID}&receiveId={receiveId}";//子加工单领料
    public static final String HALF_PRODUCT_PRE_IN_STOCK_COMMIT = "/produce_bom/pre_in_stock_commit?batchId={batchId}&successNum={successNum}&testId={testId}&testRemark={testRemark}";//半成品提交待入库
    public static final String HALF_PRODUCT_ACTUAL_NUM_COMMIT = "/produce_bom/actual_num_commit?produceBomId={ID}&actualNum={actualNum}&actualId={actualId}&lastProcessBoxIds={lastProcessBoxIds}&status={status}";//半成品提交待检验


    public static final String PRODUCT_IN_ORDER = "product_in_order";
    public static final String PRODUCT_OUT_ORDER = "product_out_order";
    public static final String PRODUCT_IN_ORDER_DETAIL = "/product_in_order/detail/{id}";
    public static final String PRODUCT_OUT_ORDER_DETAIL = "/product_out_order/detail/{id}";
    public static final String PRODUCT_IN_ORDER_COMMIT = "/product_in_order/in_stock_commit?inOrderId={inOrderId}&inOrderSpaceIds={inOrderSpaceIds}&preInStocks={preInStocks}&inStocks={inStocks}";
    public static final String PRODUCT_OUT_COMMIT = "/product_out_order/out_stock_commit?outOrderId={outOrderId}&outOrderSpaceIds={outOrderSpaceIds}&preOutStocks={preOutStocks}&outStocks={outStocks}";

    public static final String MATERIAL_TEST_LIST = "material_in_order_test";
    public static final String HALF_TEST_LIST = "produce_half_test";
    public static final String PRODUCT_TEST_LIST = "produce_product_test";

    public static final String COMPANY = "company";


    public static final String PRODUCT = "company_product";

    public static final String SUPPLY_LIST = "supply";


    //    半成品仓库
    public static final String HALF_STOCK = "half_stock";
    public static final String HALF_IN_ORDER = "half_in_order";
    public static final String HALF_OUT_ORDER = "half_out_order";
    public static final String HALF_CHECK_MANAGE = "half_stock_check_manage";
    public static final String HALF_CHECK_QUERY = "half_stock_check";

    //    系统设置
    public static final String SYSTEM_LOG = "system_log";
    public static final String SYSTEM_USER = "system_user";

    // 报表地址
    public static final String MATERIAL_REPORT = "http://benxiao.cnmar.com:8091/material_report/show";
    public static final String HALF_REPORT = "http://benxiao.cnmar.com:8091/half_report/show";
    public static final String PRODUCT_REPORT = "http://benxiao.cnmar.com:8091/product_report/show";

    //  生产管理
    public static final String SCANN_STATION = "com_station";//机台扫描
    public static final String BOX = "com_box";//料框扫描
    public static final String MOULD_SPACE = "mould_space";//模具仓位
    public static final String PROCESS_TEST = "produce_test";//检验流水

    public static final String NOTICE = "remind_notice_user";//通知提醒
    public static final String MESSAGE = "remind_message";//消息提醒
    public static final String MOULD = "mould";//模具二维码
    public static final String MOULD_IN_ORDER = "mould_in_order";//模具入库
    public static final String MOULD_OUT_ORDER = "mould_out_order";//模具出库
    public static final String SUPPLY_PURCHASE_PLAN = "supply_purchase_plan";//采购计划
    public static final String CUSTOMER = "custom";//客户
    public static final String PRODUCE = "produce";//生产管理
    public static final String CUSTOM_ORDER = "custom_order";//销售订单
    public static final String SUPPLY_PURCHASE_ORDER = "supply_purchase_order";//供应商采购订单
    public static final String UPDATE = "update_info";//版本更新
    public static final String ITEM_STOCK = "item_stock";//物品仓库
    public static final String ITEM_IN_ORDER = "item_in_order";
    public static final String ITEM_OUT_ORDER = "item_out_order";
    public static final String ITEM_CHECK_MANAGE = "item_stock_check_manage";
    public static final String ITEM_CHECK_QUERY = "item_stock_check";
    public static final String ITEM_SPACE = "item_space";
    public static final String OUTSOURCING = "outsourcing";//外协供应商
    public static final String OUTSOURCING_ORDER = "outsourcing_order";//外协采购单
    public static final String UPLOAD_IMAGE = "img";//图片上传
    public static final String EQUIPMENT = "com_equipment";//设备
    public static final String COMTOOL = "com_tool";//量检具
    public static final String NODE = "node"; //流程节点
    public static final String CN_INVOICE = "finance_cn_invoice"; //国内发票审批
    public static final String EN_INVOICE = "finance_en_invoice"; //国外发票审批
    public static final String ITEM_PAY_SUPPLY = "item_pay_supply"; //物品采购单审批
    public static final String PAY_OUTSOURCING = "finance_pay_outsourcing"; //外协采购单审批
    public static final String PAY_SUPPLY = "finance_pay_supply"; //原料采购付款审批
    public static final String PRODUCT_REWORK = "produce_rework_product"; //成品返工返修
    public static final String HALF_REWORK = "produce_rework_half"; //半成品返修
}
