//package retrofit;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import component.basic.model.Img;
//import component.com.model.ComBox;
//import component.com.model.ComStation;
//import component.com.model.ComTool;
//import component.company.model.Company;
//import component.company.model.CompanyProduct;
//import component.custom.model.Custom;
//import component.custom.model.CustomDeliver;
//import component.custom.model.CustomOrder;
//import component.finance.model.FinanceCnInvoice;
//import component.finance.model.FinanceEnInvoice;
//import component.finance.model.FinancePayOutsourcing;
//import component.finance.model.FinancePaySupply;
//import component.flow.model.FlowMessage;
//import component.flow.model.FlowNode;
//import component.half.model.HalfInOrder;
//import component.half.model.HalfInOrderSpace;
//import component.half.model.HalfOutOrder;
//import component.half.model.HalfOutOrderSpace;
//import component.half.model.HalfSpace;
//import component.half.model.HalfStock;
//import component.half.model.HalfStockCheck;
//import component.item.model.ItemInOrder;
//import component.item.model.ItemInOrderSpace;
//import component.item.model.ItemOutOrder;
//import component.item.model.ItemPaySupply;
//import component.item.model.ItemSpace;
//import component.item.model.ItemStock;
//import component.item.model.ItemStockCheck;
//import component.material.model.MaterialInOrder;
//import component.material.model.MaterialInOrderSpace;
//import component.material.model.MaterialOutOrder;
//import component.material.model.MaterialOutOrderSpace;
//import component.material.model.MaterialSpace;
//import component.material.model.MaterialStock;
//import component.material.model.MaterialStockCheck;
//import component.mould.model.Mould;
//import component.mould.model.MouldSpace;
//import component.outsourcing.model.Outsourcing;
//import component.outsourcing.model.OutsourcingOrder;
//import component.produce.model.ProduceBom;
//import component.produce.model.ProduceBomBatch;
//import component.produce.model.ProduceBomProcess;
//import component.produce.model.ProduceDailyBom;
//import component.produce.model.ProduceDailyPlan;
//import component.produce.model.ProducePlan;
//import component.produce.model.ProducePlanBatch;
//import component.produce.model.ProducePlanProcess;
//import component.produce.model.ProduceReceiveBom;
//import component.produce.model.ProduceReceivePlan;
//import component.produce.model.ProduceReworkHalf;
//import component.produce.model.ProduceReworkProduct;
//import component.produce.model.ProduceTest;
//import component.product.model.ProductInOrder;
//import component.product.model.ProductInOrderSpace;
//import component.product.model.ProductOutOrder;
//import component.product.model.ProductOutOrderSpace;
//import component.product.model.ProductSpace;
//import component.product.model.ProductStock;
//import component.product.model.ProductStockCheck;
//import component.supply.model.Supply;
//import component.supply.model.SupplyPurchaseOrder;
//import component.supply.model.SupplyPurchasePlan;
//import component.system.model.RemindMessage;
//import component.system.model.RemindNoticeUser;
//import component.system.model.SystemLog;
//import component.system.model.SystemUser;
//import component.system.model.UpdateInfo;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//import retrofit2.http.GET;
//import retrofit2.http.Multipart;
//import retrofit2.http.POST;
//import retrofit2.http.Part;
//import retrofit2.http.PartMap;
//import retrofit2.http.Path;
//import retrofit2.http.Query;
//import rx.Observable;
//
//public interface ApiService {
//    /*
//     * 用户登录
//     * */
//    @GET("/login_commit")
//    Observable<BaseModel<SystemUser>> login(
//            @Query("username") String username,
//            @Query("password") String password,
//            @Query("token") String token
//    );
//
//    /*
//     * 用户资料
//     * */
//    @GET("/system_user/personal/{id}")
//    Observable<BaseModel<SystemUser>> profile(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  系统用户列表
//     * */
//    @GET("/system_user/list")
//    Observable<BaseModel<ArrayList<SystemUser>>> systemUser(
//            @Query("query.name") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  操作日志
//     * */
//    @GET("/system_log/list")
//    Observable<BaseModel<ArrayList<SystemLog>>> systemLog(
//            @Query("query.name") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  系统用户详情
//     * */
//    @GET("/system_user/detail/{id}")
//    Observable<BaseModel<SystemUser>> systemUserDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料库存列表
//     * */
//    @GET("/material_stock/list")
//    Observable<BaseModel<ArrayList<MaterialStock>>> materialStock(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料库存详情
//     * */
//    @GET("/material_stock/detail/{id}")
//    Observable<BaseModel<MaterialStock>> materialStockDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料入库单列表
//     * */
//    @GET("/material_in_order/list")
//    Observable<BaseModel<ArrayList<MaterialInOrder>>> materialInOrder(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料入库单详情
//     * */
//    @GET("/material_in_order/detail/{id}")
//    Observable<BaseModel<MaterialInOrder>> materialInOrderDetail(
//            @Path("id") int id,
//            @Query("spaceId") Integer spaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料提交检验
//     * */
//    @GET("/material_in_order/test_commit")
//    Observable<BaseModel<MaterialInOrder>> materialTest(
//            @Query("inOrderId") int inOrderId,
//            @Query("testId") int testId,
//            @Query("testRemark") String testRemark,
//            @Query("inOrderMaterialIds") String inOrderMaterialIds,
//            @Query("res") String res,
//            @Query("failNums") String failNums,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料入库仓位扫描
//     * */
//    @GET("/material_space/qrcode/{id}")
//    Observable<BaseModel<MaterialSpace>> materialSpaceScann(
//            @Path("id") int id,
//            @Query("spaceStockId") int spaceStockId,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 原料扫码入库
//     * */
//    @GET("/material_in_order/qrcode/{id}")
//    Observable<BaseModel<MaterialInOrderSpace>> materialInOrderScann(
//            @Path("id") int QRId,
//            @Query("spaceId") Integer spaceId,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 原料入库保存输入数量入库
//     * */
//    @GET("/material_in_order/input_commit")
//    Observable<BaseModel<MaterialInOrderSpace>> saveInputInOrderNum(
//            @Query("inOrderId") int inOrderId,
//            @Query("spaceId") int spaceId,
//            @Query("materialId") int materialId,
//            @Query("inStock") int inStock,
//            @Query("inOrderSpaceId") Integer inOrderSpaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料提交入库
//     * */
//    @GET("/material_in_order/in_stock_commit")
//    Observable<BaseModel<MaterialInOrder>> materialInStockCommit(
//            @Query("inOrderId") int inOrderId,
//            @Query("isAll") boolean isAll,
//            @Query("token") String token
//    );
//
//    /*
//     *原料出库列表
//     * */
//    @GET("/material_out_order/list")
//    Observable<BaseModel<ArrayList<MaterialOutOrder>>> materialOutOrder(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料出库详情
//     * */
//    @GET("/material_out_order/detail/{id}")
//    Observable<BaseModel<MaterialOutOrder>> materialOutOrderDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料出库扫描
//     * */
//    @GET("/material_out_order/qrcode/{id}")
//    Observable<BaseModel<MaterialOutOrderSpace>> scannMaterialOutOrder(
//            @Path("id") int id,
//            @Query("outOrderId") int outOrderId,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 原料提交出库
//     * */
//    @GET("/material_out_order/out_stock_commit")
//    Observable<BaseModel<MaterialOutOrder>> materialOutStockCommit(
//            @Query("outOrderId") int outOrderId,
//            @Query("outOrderSpaceIds") String outOrderSpaceIds,
//            @Query("preOutStocks") String preOutStocks,
//            @Query("outStocks") String outStocks,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料盘点管理列表
//     * */
//    @GET("/material_stock_check_manage/list")
//    Observable<BaseModel<ArrayList<MaterialStock>>> materialCheckManage(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料盘点管理详情
//     * */
//    @GET("/material_stock_check_manage/detail/{id}")
//    Observable<BaseModel<MaterialStock>> materialCheckManageDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料提交盘点
//     * */
//    @GET("/material_stock_check_manage/check_commit")
//    Observable<BaseModel<MaterialStock>> materialCheckCommit(
//            @Query("stockId") int stockId,
//            @Query("spaceStockIds") String spaceStockIds,
//            @Query("spaceIds") String spaceIds,
//            @Query("inOrderSpaceIds") String inOrderSpaceIds,
//            @Query("beforeStocks") String beforeStocks,
//            @Query("afterStocks") String afterStocks,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料盘点查询列表
//     * */
//    @GET("/material_stock_check/list")
//    Observable<BaseModel<ArrayList<MaterialStockCheck>>> materialCheckQuery(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料盘点查询详情
//     * */
//    @GET("/material_stock_check/detail/{id}")
//    Observable<BaseModel<MaterialStockCheck>> materialCheckQueryDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品库存列表
//     * */
//    @GET("/half_stock/list")
//    Observable<BaseModel<ArrayList<HalfStock>>> halfStock(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品库存详情
//     * */
//    @GET("/half_stock/detail/{id}")
//    Observable<BaseModel<HalfStock>> halfStockDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品入库单列表
//     * */
//    @GET("/half_in_order/list")
//    Observable<BaseModel<ArrayList<HalfInOrder>>> halfInOrder(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 半成品入库单详情
//     * */
//    @GET("/half_in_order/detail/{id}")
//    Observable<BaseModel<HalfInOrder>> halfInOrderDetail(
//            @Path("id") int id,
//            @Query("spaceId") Integer spaceId,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 半成品入库保存输入数量入库
//     * */
//    @GET("/half_in_order/input_commit")
//    Observable<BaseModel<HalfInOrderSpace>> saveHalfInputInOrderNum(
//            @Query("inOrderId") int inOrderId,
//            @Query("spaceId") int spaceId,
//            @Query("halfId") int halfId,
//            @Query("inStock") int inStock,
//            @Query("inOrderSpaceId") Integer inOrderSpaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品入库仓位扫描
//     * */
//    @GET("/half_space/qrcode/{id}")
//    Observable<BaseModel<HalfSpace>> halfSpaceScann(
//            @Path("id") int id,
//            @Query("spaceStockId") int spaceStockId,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品扫码入库
//     * */
//    @GET("/half_in_order/qrcode/{id}")
//    Observable<BaseModel<HalfInOrderSpace>> halfInOrderScann(
//            @Path("id") int id,
//            @Query("spaceId") Integer spaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品提交入库
//     * */
//    @GET("/half_in_order/in_stock_commit")
//    Observable<BaseModel<HalfInOrder>> halfInStockCommit(
//            @Query("inOrderId") int inOrderId,
//            @Query("isAll") boolean isAll,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 半成品出库列表
//     * */
//    @GET("/half_out_order/list")
//    Observable<BaseModel<ArrayList<HalfOutOrder>>> halfOutOrder(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 半成品出库详情
//     * */
//    @GET("/half_out_order/detail/{id}")
//    Observable<BaseModel<HalfOutOrder>> halfOutOrderDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品出库扫描
//     * */
//    @GET("/half_out_order/qrcode/{id}")
//    Observable<BaseModel<HalfOutOrderSpace>> scannHalfOutOrder(
//            @Path("id") int id,
//            @Query("outOrderId") int outOrderId,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品提交出库
//     * */
//    @GET("/half_out_order/out_stock_commit")
//    Observable<BaseModel<HalfOutOrder>> halfOutStockCommit(
//            @Query("outOrderId") int outOrderId,
//            @Query("outOrderSpaceIds") String outOrderSpaceIds,
//            @Query("preOutStocks") String preOutStocks,
//            @Query("outStocks") String outStocks,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品盘点管理列表
//     * */
//    @GET("/half_stock_check_manage/list")
//    Observable<BaseModel<ArrayList<HalfStock>>> halfCheckManage(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品盘点管理详情
//     * */
//    @GET("/half_stock_check_manage/detail/{id}")
//    Observable<BaseModel<HalfStock>> halfCheckManageDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品提交盘点
//     * */
//    @GET("/half_stock_check_manage/check_commit")
//    Observable<BaseModel<HalfStock>> halfCheckCommit(
//            @Query("stockId") int stockId,
//            @Query("spaceStockIds") String spaceStockIds,
//            @Query("spaceIds") String spaceIds,
//            @Query("inOrderSpaceIds") String inOrderSpaceIds,
//            @Query("beforeStocks") String beforeStocks,
//            @Query("afterStocks") String afterStocks,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品盘点查询列表
//     * */
//    @GET("/half_stock_check/list")
//    Observable<BaseModel<ArrayList<HalfStockCheck>>> halfCheckQuery(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品盘点查询详情
//     * */
//    @GET("/half_stock_check/detail/{id}")
//    Observable<BaseModel<HalfStockCheck>> halfCheckQueryDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品库存列表
//     * */
//    @GET("/product_stock/list")
//    Observable<BaseModel<ArrayList<ProductStock>>> productStock(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品库存详情
//     * */
//    @GET("/product_stock/detail/{id}")
//    Observable<BaseModel<ProductStock>> productStockDetail(
//            @Path("id") int id,
//            @Query("areaType") Integer areaType,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品入库单列表
//     * */
//    @GET("/product_in_order/list")
//    Observable<BaseModel<ArrayList<ProductInOrder>>> productInOrder(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 成品入库单详情
//     * */
//    @GET("/product_in_order/detail/{id}")
//    Observable<BaseModel<ProductInOrder>> productInOrderDetail(
//            @Path("id") int id,
//            @Query("spaceId") Integer spaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品入库仓位扫描
//     * */
//    @GET("/product_space/qrcode/{id}")
//    Observable<BaseModel<ProductSpace>> productSpaceScann(
//            @Path("id") int id,
//            @Query("spaceStockId") int spaceStockId,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品入库保存输入数量入库
//     * */
//    @GET("/product_in_order/input_commit")
//    Observable<BaseModel<ProductInOrderSpace>> saveProductInputInOrderNum(
//            @Query("inOrderId") int inOrderId,
//            @Query("spaceId") int spaceId,
//            @Query("productId") int productId,
//            @Query("inStock") int inStock,
//            @Query("inOrderSpaceId") Integer inOrderSpaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品扫码入库
//     * */
//    @GET("/product_in_order/qrcode/{id}")
//    Observable<BaseModel<ProductInOrderSpace>> productInOrderScann(
//            @Path("id") int id,
//            @Query("spaceId") Integer spaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品提交入库
//     * */
//    @GET("/product_in_order/in_stock_commit")
//    Observable<BaseModel<ProductInOrder>> productInStockCommit(
//            @Query("inOrderId") int inOrderId,
//            @Query("isAll") boolean isAll,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品出库列表
//     * */
//    @GET("/product_out_order/list")
//    Observable<BaseModel<ArrayList<ProductOutOrder>>> productOutOrder(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 成品出库详情
//     * */
//    @GET("/product_out_order/detail/{id}")
//    Observable<BaseModel<ProductOutOrder>> productOutOrderDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 成品出库扫描
//     * */
//    @GET("/product_out_order/qrcode/{id}")
//    Observable<BaseModel<ProductOutOrderSpace>> scannProductOutOrder(
//            @Path("id") int id,
//            @Query("outOrderId") int outOrderId,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品提交出库
//     */
//    @GET("/product_out_order/out_stock_commit")
//    Observable<BaseModel<ProductOutOrder>> productOutStockCommit(
//            @Query("outOrderId") int outOrderId,
//            @Query("outOrderSpaceIds") String outOrderSpaceIds,
//            @Query("preOutStocks") String preOutStocks,
//            @Query("outStocks") String outStocks,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 成品盘点管理列表
//     * */
//    @GET("/product_stock_check_manage/list")
//    Observable<BaseModel<ArrayList<ProductStock>>> productCheckManage(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 成品盘点管理详情
//     * */
//    @GET("/product_stock_check_manage/detail/{id}")
//    Observable<BaseModel<ProductStock>> productCheckManageDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品提交盘点
//     * */
//    @GET("/product_stock_check_manage/check_commit")
//    Observable<BaseModel<ProductStock>> productCheckCommit(
//            @Query("stockId") int stockId,
//            @Query("spaceStockIds") String spaceStockIds,
//            @Query("spaceIds") String spaceIds,
//            @Query("inOrderSpaceIds") String inOrderSpaceIds,
//            @Query("beforeStocks") String beforeStocks,
//            @Query("afterStocks") String afterStocks,
//            @Query("token") String token
//    );
//
//    /*
//     *成品盘点查询列表
//     * */
//    @GET("/product_stock_check/list")
//    Observable<BaseModel<ArrayList<ProductStockCheck>>> productCheckQuery(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品盘点查询详情
//     * */
//    @GET("/product_stock_check/detail/{id}")
//    Observable<BaseModel<ProductStockCheck>> productCheckQueryDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 加工单列表
//     * */
//    @GET("/produce_plan/list")
//    Observable<BaseModel<ArrayList<ProducePlan>>> producePlan(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 加工单详情
//     * */
//    @GET("/produce_plan/detail/{id}")
//    Observable<BaseModel<ProducePlan>> producePlanDetail(
//            @Path("id") int id,
//            @Query("op") String op,
//            @Query("userId") int userId,
//            @Query("token") String token
//    );
//
//    /*
//     * 加工单领料
//     * */
//    @GET("/produce_plan/receive_commit")
//    Observable<BaseModel<ProducePlan>> planReceiveCommit(
//            @Query("producePlanId") int producePlanId,
//            @Query("receiveId") int receiveId,
//            @Query("materialSubIds") String materialSubIds,
//            @Query("materialActualNums") String materialActualNums,
//            @Query("halfSubIds") String halfSubIds,
//            @Query("halfActualNums") String halfActualNums,
//            @Query("remark") String remark,
//            @Query("token") String token
//    );
//
//    /*
//     * 加工单提交待检验
//     * */
//    @GET("/produce_plan/actual_num_commit")
//    Observable<BaseModel<ProducePlan>> planTestCommit(
//            @Query("producePlanId") int producePlanId,
//            @Query("actualNum") int actualNum,
//            @Query("actualId") int actualId,
//            @Query("token") String token
//    );
//
//    /*
//     * 加工单提交待入库
//     * */
//    @GET("/produce_plan/pre_in_stock_commit")
//    Observable<BaseModel<ProducePlan>> planInStock(
//            @Query("batchIds") String batchIds,
//            @Query("successNums") String successNums,
//            @Query("testId") int testId,
//            @Query("testRemarks") String testRemarks,
//            @Query("token") String token
//    );
//
//    /*
//     *子加工单列表
//     * */
//    @GET("/produce_bom/list")
//    Observable<BaseModel<ArrayList<ProduceBom>>> produceBom(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("query.isEnable") boolean isEnable,
//            @Query("query.set") Boolean set,
//            @Query("query.state") Boolean state,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 子加工单详情
//     * */
//    @GET("/produce_bom/detail/{id}")
//    Observable<BaseModel<ProduceBom>> produceBomDetail(
//            @Path("id") int id,
//            @Query("op") String op,
//            @Query("userId") int userId,
//            @Query("token") String token
//    );
//
//    /*
//     * 子加工单领料
//     * */
//    @GET("/produce_bom/receive_commit")
//    Observable<BaseModel<ProduceBom>> bomReceiveCommit(
//            @Query("produceBomId") int produceBomId,
//            @Query("receiveId") int receiveId,
//            @Query("materialSubIds") String materialSubIds,
//            @Query("materialActualNums") String materialActualNums,
//            @Query("halfSubIds") String halfSubIds,
//            @Query("halfActualNums") String halfActualNums,
//            @Query("remark") String remark,
//            @Query("token") String token
//    );
//
//    /*
//     * （外协）子加工单提交待检验
//     * 子加工单选择boxIds，外协子加工单输入actualNum
//     * */
//    @GET("/produce_bom/actual_num_commit")
//    Observable<BaseModel<ProduceBom>> bomTestCommit(
//            @Query("produceBomId") int produceBomId,
//            @Query("boxIds") String boxIds,
//            @Query("actualNum") Integer actualNum,
//            @Query("actualId") int actualId,
//            @Query("token") String token
//    );
//
//    /*
//     * （外协）子加工单提交待入库
//     * */
//    @GET("/produce_bom/pre_in_stock_commit")
//    Observable<BaseModel<ProduceBom>> bomInStock(
//            @Query("batchIds") String batchIds,
//            @Query("boxIds") String boxIds,
//            @Query("successNums") String successNums,
//            @Query("testId") int testId,
//            @Query("testRemarks") String testRemarks,
//            @Query("token") String token
//    );
//
//    /*
//     * 加工单领料单列表
//     * */
//    @GET("/produce_receive/list_plan")
//    Observable<BaseModel<ArrayList<ProduceReceivePlan>>> planReceive(
//            @Query("query.code") String query,
//            @Query("query.flag") boolean flag,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 子加工单领料单/外协出库单列表
//     * */
//    @GET("/produce_receive/list_bom")
//    Observable<BaseModel<ArrayList<ProduceReceiveBom>>> bomReceive(
//            @Query("query.code") String query,
//            @Query("query.isEnable") boolean isEnable,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 加工单领料单详情
//     * */
//    @GET("/produce_receive/detail_plan/{id}")
//    Observable<BaseModel<ProduceReceivePlan>> planReceiveDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 子加工单领料单/外协出库单详情
//     * */
//    @GET("/produce_receive/detail_bom/{id}")
//    Observable<BaseModel<ProduceReceiveBom>> bomReceiveDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 交付计划列表
//     * */
//    @GET("/custom_deliver/list")
//    Observable<BaseModel<ArrayList<CustomDeliver>>> deliveryPlan(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 交付计划详情
//     * */
//    @GET("/custom_deliver/detail/{id}")
//    Observable<BaseModel<CustomDeliver>> deliveryPlanDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料检验流水列表
//     * */
//    @GET("/material_in_order_test/list")
//    Observable<BaseModel<ArrayList<MaterialInOrder>>> materialQC(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 原料检验流水详情
//     * */
//    @GET("/material_in_order_test/detail/{id}")
//    Observable<BaseModel<MaterialInOrder>> materialQCDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品检验流水列表
//     * */
//    @GET("/produce_half_test/list")
//    Observable<BaseModel<ArrayList<ProduceBomBatch>>> halfTest(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品检验流水详情
//     * */
//    @GET("/produce_half_test/detail/{id}")
//    Observable<BaseModel<ProduceBomBatch>> halfTestDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品检验流水列表
//     * */
//    @GET("/produce_product_test/list")
//    Observable<BaseModel<ArrayList<ProducePlanBatch>>> productTest(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品检验流水详情
//     * */
//    @GET("/produce_product_test/detail/{id}")
//    Observable<BaseModel<ProducePlanBatch>> productTestDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 企业列表
//     * */
//    @GET("/company/list")
//    Observable<BaseModel<ArrayList<Company>>> company(
//            @Query("query.name") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 企业详情
//     * */
//    @GET("/company/detail/{id}")
//    Observable<BaseModel<Company>> companyDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 产品列表
//     * */
//    @GET("/company_product/list")
//    Observable<BaseModel<ArrayList<CompanyProduct>>> product(
//            @Query("query.name") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 产品详情
//     * */
//    @GET("/company_product/detail/{id}")
//    Observable<BaseModel<CompanyProduct>> productDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 供应商列表
//     * */
//    @GET("/supply/list")
//    Observable<BaseModel<ArrayList<Supply>>> supply(
//            @Query("query.name") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  供应商详情
//     * */
//    @GET("/supply/detail/{id}")
//    Observable<BaseModel<Supply>> supplyDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  生产管理检验流水列表
//     * */
//    @GET("/produce_test/list")
//    Observable<BaseModel<ArrayList<ProduceTest>>> checkFlow(
//            @Query("query.userId") String userId,
//            @Query("query.type") int type,
//            @Query("query.code") String code,
//            @Query("page.num") int page,
//            @Query("token") String token
//
//    );
//
//    /*
//     *  生产管理检验流水详情
//     * */
//    @GET("/produce_test/detail/{id}")
//    Observable<BaseModel<ProduceTest>> checkFlowDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  机台扫描
//     * */
//    @GET("/com_station/qrcode/{id}")
//    Observable<BaseModel<ComStation>> scanStation(
//            @Path("id") int id,
//            @Query("mouldId") Integer mouldId,
//            @Query("userId") Integer userId,
//            @Query("token") String token
//    );
//
//    /*
//     *  机台扫描得到（子）加工单的详情
//     * */
//    @GET("/com_station/detail/{id}")
//    Observable<BaseModel<ComStation>> scanStationDetail(
//            @Path("id") int id,
//            @Query("planId") int planId,
//            @Query("bomId") int bomId,
//            @Query("processId") int processId,
//            @Query("userId") int userId,
//            @Query("token") String token
//    );
//
//
//    /*
//     *  扫描料框二维码
//     * */
//    @GET("/com_box/qrcode/{id}")
//    Observable<BaseModel<ComBox>> scanBox(
//            @Path("id") int id,
//            @Query("op") String op,
//            @Query("bomId") int bomId,
//            @Query("token") String token
//    );
//
//
//    /*
//     *  半成品入料框
//     * */
//    @GET("/com_box/in_commit")
//    Observable<BaseModel<ComBox>> halfInBox(
//            @Query("boxId") int boxId,
//            @Query("bomId") int bomId,
//            @Query("num") int num,
//            @Query("token") String token
//    );
//
//    /*
//     *  工序检验流水
//     * */
//    @GET("/produce_test/list")
//    Observable<BaseModel<ArrayList<ProduceTest>>> processTest(
//            @Query("query.code") String query,
//            @Query("query.userId") int userId,
//            @Query("query.type") int type,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  工序检验流水详情
//     * */
//    @GET("/produce_test/detail/{id}")
//    Observable<BaseModel<ProduceTest>> processTestDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  机台对应加工单工序详情
//     * */
//    @GET("/com_station/plan_process/{id}")
//    Observable<BaseModel<ProducePlanProcess>> planProcessDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  机台对应子加工单工序详情
//     * */
//    @GET("/com_station/bom_process/{id}")
//    Observable<BaseModel<ProduceBomProcess>> bomProcessDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  提交工序检验
//     * */
//    @GET("/produce_test/save_commit")
//    Observable<BaseModel<ProduceTest>> processTestSubmit(
//            @Query("planId") int planId,
//            @Query("bomId") int bomId,
//            @Query("processId") int processId,
//            @Query("stationId") int stationId,
//            @Query("teamId") int teamId,
//            @Query("testNum") int testNum,
//            @Query("failType") Integer failType,
//            @Query("failNum") int failNum,
//            @Query("uselessNum") int uselessNum,
//            @Query("remark") String remark,
//            @Query("testId") int testId,
//            @Query("isSuccess") boolean isSuccess,
//            @Query("type") int type,
//            @Query("token") String token
//    );
//
//    /*
//     *  通知提醒列表
//     * */
//    @GET("/remind_notice_user/list")
//    Observable<BaseModel<ArrayList<RemindNoticeUser>>> noticeList(
//            @Query("query.userId") int userId,
//            @Query("query.status") int status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  通知提醒详情
//     * */
//    @GET("/remind_notice_user/detail/{id}")
//    Observable<BaseModel<RemindNoticeUser>> noticeDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  模具列表
//     * */
//    @GET("/mould/list")
//    Observable<BaseModel<ArrayList<Mould>>> mouldList(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  模具详情
//     * */
//    @GET("/mould/detail/{id}")
//    Observable<BaseModel<Mould>> mouldDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  模具仓位扫描
//     * */
//    @GET("/mould_space/qrcode/{id}")
//    Observable<BaseModel<MouldSpace>> mouldSpaceScan(
//            @Path("id") int id,
//            @Query("mouldId") Integer mouldId,
//            @Query("userId") Integer userId,
//            @Query("token") String token
//    );
//
//    /*
//     *  模具二维码
//     * */
//    @GET("/mould/qrcode/{id}")
//    Observable<BaseModel<Mould>> mouldScan(
//            @Path("id") int id,
//            @Query("op") String op,
//            @Query("userId") int userId,
//            @Query("token") String token
//    );
//
//    /*
//     *  原料追溯
//     * */
//    @GET("/material_in_order/back/{id}")
//    Observable<BaseModel<MaterialInOrderSpace>> materialTraceBack(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  成品追溯
//     * */
//    @GET("/product_in_order/back/{id}")
//    Observable<BaseModel<ProductInOrderSpace>> productTraceBack(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  采购计划列表
//     * */
//    @GET("/supply_purchase_plan/list")
//    Observable<BaseModel<ArrayList<SupplyPurchasePlan>>> purchasePlanList(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  采购计划详情
//     * */
//    @GET("/supply_purchase_plan/detail/{id}")
//    Observable<BaseModel<SupplyPurchasePlan>> purchasePlanDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  采购订单审核
//     * */
//    @GET("/supply_purchase_order/audit_commit")
//    Observable<BaseModel<SupplyPurchaseOrder>> purchaseOrderAudit(
//            @Query("id") int id,
//            @Query("opinionCode") String opinionCode,
//            @Query("opinionId") int opinionId,
//            @Query("content") String content,
//            @Query("userId") int userId,
//            @Query("op") String op,
//            @Query("token") String token
//    );
//
//    /*
//     *  客户列表
//     * */
//    @GET("/custom/list")
//    Observable<BaseModel<ArrayList<Custom>>> customerList(
//            @Query("query.name") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  客户详情
//     * */
//    @GET("/custom/detail/{id}")
//    Observable<BaseModel<Custom>> customerDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  扫描料框二维码入库（半成品）
//     * */
//    @GET("/com_box/qrcode/{id}")
//    Observable<BaseModel<ComBox>> scanBoxInStock(
//            @Path("id") int id,
//            @Query("inOrderId") int inOrderId,
//            @Query("spaceId") Integer spaceId,
//            @Query("op") String op,
//            @Query("token") String token
//    );
//
//
//    /*
//     *  扫描料框二维码出库（半成品）
//     * */
//    @GET("/com_box/qrcode/{id}")
//    Observable<BaseModel<ComBox>> scanBoxOutStock(
//            @Path("id") int id,
//            @Query("outOrderId") int outOrderId,
//            @Query("op") String op,
//            @Query("token") String token
//    );
//
//    /*
//     *  填写加工单生产统计
//     * */
//    @GET("/produce/daily_plan_commit")
//    Observable<BaseModel<ProduceDailyPlan>> planDailyCommit(
//            @Query("planId") int planId,
//            @Query("productId") int productId,
//            @Query("dailyPlanIds") String dailyIds,
//            @Query("processIds") String processIds,
//            @Query("teamIds") String teamIds,
//            @Query("operatorIds") String operatorIds,
//            @Query("countNums") String countNums,
//            @Query("countReworks") String countReworks,
//            @Query("countFails") String countFails,
//            @Query("timeHours") String timeHours,
//            @Query("timeNums") String timeNums,
//            @Query("timeReworks") String timeReworks,
//            @Query("timeFails") String timeFails,
//            @Query("remarks") String remarks,
//            @Query("userId") int userId,
//            @Query("token") String token
//    );
//
//    /*
//     *  填写子加工单生产统计
//     * */
//    @GET("/produce/daily_bom_commit")
//    Observable<BaseModel<ProduceDailyBom>> bomDailyCommit(
//            @Query("bomId") int bomId,
//            @Query("halfId") int halfId,
//            @Query("dailyBomIds") String dailyIds,
//            @Query("processIds") String processIds,
//            @Query("teamIds") String teamIds,
//            @Query("operatorIds") String operatorIds,
//            @Query("countNums") String countNums,
//            @Query("countReworks") String countReworks,
//            @Query("countFails") String countFails,
//            @Query("timeHours") String timeHours,
//            @Query("timeNums") String timeNums,
//            @Query("timeReworks") String timeReworks,
//            @Query("timeFails") String timeFails,
//            @Query("remarks") String remarks,
//            @Query("userId") int userId,
//            @Query("token") String token
//    );
//
//    /*
//     * 销售订单列表
//     * */
//    @GET("/custom_order/list")
//    Observable<BaseModel<ArrayList<CustomOrder>>> customerOrderList(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  销售订单详情
//     * */
//    @GET("/custom_order/detail/{id}")
//    Observable<BaseModel<CustomOrder>> customerOrderDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 采购订单列表
//     * */
//    @GET("/supply_purchase_order/list")
//    Observable<BaseModel<ArrayList<SupplyPurchaseOrder>>> purchaseOrderList(
//            @Query("query.code") String query,
//            @Query("query.auditStatus") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  采购订单详情
//     * */
//    @GET("/supply_purchase_order/detail/{id}")
//    Observable<BaseModel<SupplyPurchaseOrder>> purchaseOrderDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  APP版本更新
//     * */
//    @GET("/update_info")
//    Observable<BaseModel<UpdateInfo>> update(
//            @Query("token") String token
//    );
//
//    /*
//     * 原料保存无固定包装数量入库
//     * */
//    @GET("/material_in_order/pack_num_input_commit")
//    Observable<BaseModel<MaterialInOrderSpace>> packnumInputCommit(
//            @Query("inOrderId") int inOrderId,
//            @Query("spaceId") int spaceId,
//            @Query("materialId") int materialId,
//            @Query("inStock") int inStock,
//            @Query("inWeight") int inWeight,
//            @Query("inOrderSpaceId") int inOrderSpaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品保存无固定包装数量入库
//     * */
//    @GET("/product_in_order/pack_num_input_commit")
//    Observable<BaseModel<ProductInOrderSpace>> productPacknumInputCommit(
//            @Query("inOrderId") int inOrderId,
//            @Query("spaceId") int spaceId,
//            @Query("productId") int productId,
//            @Query("inStock") int inStock,
//            @Query("inOrderSpaceId") int inOrderSpaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 其他物品库存列表
//     * */
//    @GET("/item_stock/list")
//    Observable<BaseModel<ArrayList<ItemStock>>> itemStock(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 其他物品库存详情
//     * */
//    @GET("/item_stock/detail/{id}")
//    Observable<BaseModel<ItemStock>> itemStockDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 其他物品入库单列表
//     * */
//    @GET("/item_in_order/list")
//    Observable<BaseModel<ArrayList<ItemInOrder>>> itemInOrder(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 其他物品入库单详情
//     * */
//    @GET("/item_in_order/detail/{id}")
//    Observable<BaseModel<ItemInOrder>> itemInOrderDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 其他物品出库列表
//     * */
//    @GET("/item_out_order/list")
//    Observable<BaseModel<ArrayList<ItemOutOrder>>> itemOutOrder(
//            @Query("query.code") String query,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 其他物品出库详情
//     * */
//    @GET("/item_out_order/detail/{id}")
//    Observable<BaseModel<ItemOutOrder>> itemOutOrderDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 其他物品盘点管理列表
//     * */
//    @GET("/item_stock_check_manage/list")
//    Observable<BaseModel<ArrayList<ItemStock>>> itemCheckManage(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//
//    /*
//     * 物品盘点管理详情
//     * */
//    @GET("/item_stock_check_manage/detail/{id}")
//    Observable<BaseModel<ItemStock>> itemCheckManageDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 物品提交盘点
//     * */
//    @GET("/item_stock_check_manage/check_commit")
//    Observable<BaseModel<ItemStock>> itemCheckCommit(
//            @Query("stockId") int stockId,
//            @Query("spaceStockIds") String spaceStockIds,
//            @Query("inOrderSpaceIds") String inOrderSpaceIds,
//            @Query("beforeStocks") String beforeStocks,
//            @Query("afterStocks") String afterStocks,
//            @Query("token") String token
//    );
//
//    /*
//     *物品盘点查询列表
//     * */
//    @GET("/item_stock_check/list")
//    Observable<BaseModel<ArrayList<ItemStockCheck>>> itemCheckQuery(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 物品盘点查询详情
//     * */
//    @GET("/item_stock_check/detail/{id}")
//    Observable<BaseModel<ItemStockCheck>> itemCheckQueryDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 物品入库仓位扫描
//     * */
//    @GET("/item_space/qrcode/{id}")
//    Observable<BaseModel<ItemSpace>> itemSpaceScann(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 物品入库保存输入数量入库
//     * */
//    @GET("/item_in_order/input_commit")
//    Observable<BaseModel<ItemInOrderSpace>> saveItemInputInOrderNum(
//            @Query("inOrderId") int inOrderId,
//            @Query("itemId") int itemId,
//            @Query("inStock") int inStock,
//            @Query("inOrderSpaceId") Integer inOrderSpaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 物品扫码入库
//     * */
//    @GET("/item_in_order/qrcode/{id}")
//    Observable<BaseModel<ItemInOrderSpace>> itemInOrderScann(
//            @Path("id") int id,
//            @Query("spaceId") Integer spaceId,
//            @Query("token") String token
//    );
//
//    /*
//     * 物品提交入库
//     * */
//    @GET("/item_in_order/in_stock_commit")
//    Observable<BaseModel<ItemInOrder>> itemInStockCommit(
//            @Query("inOrderId") int inOrderId,
//            @Query("isAll") boolean isAll,
//            @Query("token") String token
//    );
//
//    /*
//     * 物品提交出库
//     */
//    @GET("/item_out_order/out_stock_commit")
//    Observable<BaseModel<ItemOutOrder>> itemOutStockCommit(
//            @Query("outOrderId") int outOrderId,
//            @Query("outOrderSpaceIds") String outOrderSpaceIds,
//            @Query("preOutStocks") String preOutStocks,
//            @Query("outStocks") String outStocks,
//            @Query("token") String token
//    );
//
//    /*
//     * 外协供应商列表
//     * */
//    @GET("/outsourcing/list")
//    Observable<BaseModel<ArrayList<Outsourcing>>> outsourcing(
//            @Query("query.name") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 外协供应商详情
//     * */
//    @GET("/outsourcing/detail/{id}")
//    Observable<BaseModel<Outsourcing>> outsourcingDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 外协采购单列表
//     * */
//    @GET("/outsourcing_order/list")
//    Observable<BaseModel<ArrayList<OutsourcingOrder>>> outsourcingOrder(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 外协采购单详情
//     * */
//    @GET("/outsourcing_order/detail/{id}")
//    Observable<BaseModel<OutsourcingOrder>> outsourcingOrderDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 多张图片上传
//     * */
//    @Multipart
//    @POST("/img/uploads")
//    Observable<BaseModel<ArrayList<Img>>> uploadImages(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);
//
//    /*
//     * 单张图片上传
//     * */
//    @Multipart
//    @POST("/img/upload")
//    Observable<BaseModel<Img>> uploadImage(@PartMap Map<String, RequestBody> map, @Part MultipartBody.Part part);
//
//    /*
//     * 删除网络图片
//     * */
//    @GET("/img/delete/{id}")
//    Observable<BaseModel<Img>> deleteImage(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  操作消息列表
//     * */
//    @GET("/remind_message/list")
//    Observable<BaseModel<ArrayList<RemindMessage>>> messageList(
//            @Query("query.userId") int userId,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  操作消息详情
//     * */
//    @GET("/remind_message/detail/{id}")
//    Observable<BaseModel<RemindMessage>> messageDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  审核消息列表
//     * */
//    @GET("/remind_message/list_flow")
//    Observable<BaseModel<ArrayList<FlowMessage>>> messageFlowList(
//            @Query("query.userId") int userId,
//            @Query("query.status") Integer status,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  审核消息详情
//     * */
//    @GET("/remind_message/detail_flow/{id}")
//    Observable<BaseModel<FlowMessage>> messageFlowDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//
//    /*
//     *  设备列表
//     * */
//    @GET("/com_equipment/list")
//    Observable<BaseModel<ArrayList<ComStation>>> equipmentList(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  设备详情
//     * */
//    @GET("/com_equipment/detail/{id}")
//    Observable<BaseModel<ComStation>> equipmentDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  量检具列表
//     * */
//    @GET("/com_tool/list")
//    Observable<BaseModel<ArrayList<ComTool>>> toolList(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  量检具详情
//     * */
//    @GET("/com_tool/detail/{id}")
//    Observable<BaseModel<ComTool>> toolDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//
//    /*
//     *  首页模具仓位扫描
//     * */
//    @GET("/mould_space/qrcode/{id}")
//    Observable<BaseModel<MouldSpace>> mouldSpaceScan(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 首页原料扫码
//     * */
//    @GET("/material_in_order/qrcode/{id}")
//    Observable<BaseModel<MaterialInOrderSpace>> materialInOrderScann(
//            @Path("id") int QRId,
//            @Query("token") String token
//    );
//
//    /*
//     * 首页成品扫码
//     * */
//    @GET("/product_in_order/qrcode/{id}")
//    Observable<BaseModel<ProductInOrderSpace>> productInOrderScann(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  首页扫描料框二维码
//     * */
//    @GET("/com_box/qrcode/{id}")
//    Observable<BaseModel<ComBox>> scanBox(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  首页机台扫描
//     * */
//    @GET("/com_station/qrcode/{id}")
//    Observable<BaseModel<ComStation>> scanStation(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  节点详情
//     * */
//    @GET("/node/{id}")
//    Observable<BaseModel<FlowNode>> nodeDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  成品出库单审批列表
//     * */
//    @GET("/product_out_order/list_audit")
//    Observable<BaseModel<ArrayList<ProductOutOrder>>> productOutAuditList(
//            @Query("query.code") String query,
//            @Query("query.auditStatus") Integer auditStatus,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  成品出库单审批详情
//     * */
//    @GET("/product_out_order/detail_audit/{id}")
//    Observable<BaseModel<ProductOutOrder>> productOutAuditDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  成品出库单审批
//     * */
//    @GET("/product_out_order/audit_commit")
//    Observable<BaseModel<ProductOutOrder>> productOutAudit(
//            @Query("id") int id,
//            @Query("opinionCode") String opinionCode,
//            @Query("opinionId") int opinionId,
//            @Query("content") String content,
//            @Query("userId") int userId,
//            @Query("op") String op,
//            @Query("token") String token
//    );
//
//
//    /*
//     *  国内发票审批列表
//     * */
//    @GET("/finance_cn_invoice/list")
//    Observable<BaseModel<ArrayList<FinanceCnInvoice>>> cnInvoiceAuditList(
//            @Query("query.code") String query,
//            @Query("query.auditStatus") Integer auditStatus,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  国内发票审批详情
//     * */
//    @GET("/finance_cn_invoice/detail/{id}")
//    Observable<BaseModel<FinanceCnInvoice>> cnInvoiceAuditDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  国内发票审批
//     * */
//    @GET("/finance_cn_invoice/audit_commit")
//    Observable<BaseModel<FinanceCnInvoice>> cnInvoiceAudit(
//            @Query("id") int id,
//            @Query("opinionCode") String opinionCode,
//            @Query("opinionId") int opinionId,
//            @Query("content") String content,
//            @Query("userId") int userId,
//            @Query("op") String op,
//            @Query("token") String token
//    );
//
//    /*
//     *  国外发票审批列表
//     * */
//    @GET("/finance_en_invoice/list")
//    Observable<BaseModel<ArrayList<FinanceEnInvoice>>> enInvoiceAuditList(
//            @Query("query.code") String query,
//            @Query("query.auditStatus") Integer auditStatus,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  国外发票审批详情
//     * */
//    @GET("/finance_en_invoice/detail/{id}")
//    Observable<BaseModel<FinanceEnInvoice>> enInvoiceAuditDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  原料采购付款审批列表
//     * */
//    @GET("/finance_pay_supply/list")
//    Observable<BaseModel<ArrayList<FinancePaySupply>>> paySupplyAuditList(
//            @Query("query.code") String query,
//            @Query("query.auditStatus") Integer auditStatus,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  原料采购付款审批详情
//     * */
//    @GET("/finance_pay_supply/detail/{id}")
//    Observable<BaseModel<FinancePaySupply>> paySupplyAuditDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  原料采购付款审批
//     * */
//    @GET("/finance_pay_supply/audit_commit")
//    Observable<BaseModel<FinancePaySupply>> paySupplyAudit(
//            @Query("id") int id,
//            @Query("opinionCode") String opinionCode,
//            @Query("opinionId") int opinionId,
//            @Query("content") String content,
//            @Query("userId") int userId,
//            @Query("op") String op,
//            @Query("token") String token
//    );
//
//    /*
//     *  外协采购单审批列表
//     * */
//    @GET("/finance_pay_outsourcing/list")
//    Observable<BaseModel<ArrayList<FinancePayOutsourcing>>> payOutsourcingAuditList(
//            @Query("query.code") String query,
//            @Query("query.auditStatus") Integer auditStatus,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  外协采购单审批详情
//     * */
//    @GET("/finance_pay_outsourcing/detail/{id}")
//    Observable<BaseModel<FinancePayOutsourcing>> payOutsourcingAuditDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  外协采购单审批
//     * */
//    @GET("/finance_pay_outsourcing/audit_commit")
//    Observable<BaseModel<FinancePayOutsourcing>> payOutsourcingAudit(
//            @Query("id") int id,
//            @Query("opinionCode") String opinionCode,
//            @Query("opinionId") int opinionId,
//            @Query("content") String content,
//            @Query("userId") int userId,
//            @Query("op") String op,
//            @Query("token") String token
//    );
//
//    /*
//     * 物品采购单审批列表
//     * */
//    @GET("/item_pay_supply/list")
//    Observable<BaseModel<ArrayList<ItemPaySupply>>> itemPaySupplyAuditList(
//            @Query("query.code") String query,
//            @Query("query.auditStatus") Integer auditStatus,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     *  物品采购单审批详情
//     * */
//    @GET("/item_pay_supply/detail/{id}")
//    Observable<BaseModel<ItemPaySupply>> itemPaySupplyAuditDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     *  物品采购单审批
//     * */
//    @GET("/item_pay_supply/audit_commit")
//    Observable<BaseModel<ItemPaySupply>> itemPaySupplyAudit(
//            @Query("id") int id,
//            @Query("opinionCode") String opinionCode,
//            @Query("opinionId") int opinionId,
//            @Query("content") String content,
//            @Query("userId") int userId,
//            @Query("op") String op,
//            @Query("token") String token
//    );
//
//    /*
//     *  扫描机台二维码
//     * */
//    @GET("/com_station/qrcode/{id}")
//    Observable<BaseModel<ComStation>> scanStation(
//            @Path("id") int id,
//            @Query("bomProcessId") int bomProcessId,
//            @Query("planId") int planId,
//            @Query("bomId") int bomId,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品返工返修列表
//     * */
//    @GET("/produce_rework_half/list")
//    Observable<BaseModel<ArrayList<ProduceReworkHalf>>> halfReworkList(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 半成品返工返修详情
//     * */
//    @GET("/produce_rework_half/detail/{id}")
//    Observable<BaseModel<ProduceReworkHalf>> halfReworkDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品返工返修列表
//     * */
//    @GET("/produce_rework_product/list")
//    Observable<BaseModel<ArrayList<ProduceReworkProduct>>> productReworkList(
//            @Query("query.code") String query,
//            @Query("page.num") int page,
//            @Query("token") String token
//    );
//
//    /*
//     * 成品返工返修详情
//     * */
//    @GET("/produce_rework_product/detail/{id}")
//    Observable<BaseModel<ProduceReworkProduct>> productReworkDetail(
//            @Path("id") int id,
//            @Query("token") String token
//    );
//}
//
//
//
//
//
