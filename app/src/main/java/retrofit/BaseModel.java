//package retrofit;
//
//
//import component.common.vo.Page;
//
///**
// * Created by Administrator on 2017/4/17.
// * 泛型类BaseModel，它是所有接口返回的数据的基类，类型形参T可以是任意类型
// */
//
//public class BaseModel<T> {
//
//    public boolean status = true;
//    public String msg = "成功";
//    public Page page;
//    public T data;
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public Page getPage() {
//        return page;
//    }
//
//    public void setPage(Page page) {
//        this.page = page;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//}
