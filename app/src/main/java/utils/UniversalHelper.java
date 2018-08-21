package utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cnmar.benxiao.R;
import com.cnmar.benxiao.activity.FileDisplayActivity;
import com.cnmar.benxiao.activity.ImageExternalPreviewActivity;
import com.cnmar.benxiao.activity.ViewPicActivity;
import com.cnmar.benxiao.retrofit.Api;
import com.cnmar.benxiao.retrofit.RxHelper;
import com.cnmar.benxiao.retrofit.RxSubscriber;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.othershe.dutil.DUtil;
import com.othershe.dutil.callback.SimpleDownloadCallback;

import java.io.File;
import java.io.Serializable;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import component.basic.model.Img;
import component.basic.vo.PackTypeVo;
import component.flow.model.FlowMessage;
import component.flow.model.FlowNode;
import component.half.model.Half;
import component.item.model.Item;
import component.material.model.Material;
import component.product.model.Product;
import component.project.model.ProjectAfterInventory;
import component.project.model.ProjectBeforeInventory;
import component.system.model.RemindMessage;
import component.system.model.SystemDept;
import component.system.model.SystemUser;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2016/9/6.
 */
public class UniversalHelper {
    public static final long Refresh_Lasting_Time = 400;//刷新进度条显示的时长
    public static final long Max_Num_Per_Page = 10;//每页最多显示的条数
    public static final int QC_DEPT_ID = 7;//品质部ID
    public static final int WL_DEPT_ID = 10;//物流部ID
    public static final int SC_DEPT_ID = 5;// 生产部ID
    public static final int JM_ROLE_ID = 20;//架模工角色ID
    public static final int CKZG_ROLE_ID = 48;//仓库主管角色ID
    public static final int CGY_ROLE_ID = 49;//仓管员角色ID

    public static String getToken(String url) {
        String token = url.replaceAll("http://192.168.1.112:8092/", "");
        if (token.indexOf("/") == 0) {
            token = token.substring(1, token.length());
        }
        if (token.indexOf("/") != -1) {
            token = token.substring(0, token.indexOf("/"));
        }
        if (token.indexOf("?") != -1) {
            token = token.substring(0, token.indexOf("?"));
        }
        try {
            token = md5Encode(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


    /**
     * 从Date中得到字符串数据
     */
    public static String getDateString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateString = sdf.format(date);
        return dateString;
    }

    /**
     * 设置单选按钮的图标
     */
    public static void setRadioGroupIcon(Context context, RadioButton[] rbs, int[] ids) {
        List<Drawable> drawables = new ArrayList<>();
//        得到屏幕宽度，单位为像素px
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        if (screenWidth > 1000) {
            for (int i = 0; i < ids.length; i++) {
                drawables.add(context.getResources().getDrawable(ids[i]));
                drawables.get(i).setBounds(0, 15, 70, 85);//第一0是距左边距离，第二15是距上边距离，长宽为70
                //                动态设置单选按钮文本上下左右的图片
                rbs[i].setCompoundDrawables(null, drawables.get(i), null, null);//只放上边
            }
        } else if (screenWidth > 500 && screenWidth <= 1000) {
            for (int i = 0; i < ids.length; i++) {
                drawables.add(context.getResources().getDrawable(ids[i]));
                drawables.get(i).setBounds(0, 15, 50, 65);//第一0是距左边距离，第二15是距上边距离，长宽为50
                //                动态设置单选按钮文本上下左右的图片
                rbs[i].setCompoundDrawables(null, drawables.get(i), null, null);//只放上边
            }
        } else if (screenWidth <= 500) {
            for (int i = 0; i < ids.length; i++) {
                drawables.add(context.getResources().getDrawable(ids[i]));
                drawables.get(i).setBounds(0, 15, 30, 45);//第一0是距左边距离，第二15是距上边距离，长宽为30
                //                动态设置单选按钮文本上下左右的图片
                rbs[i].setCompoundDrawables(null, drawables.get(i), null, null);//只放上边
            }
        }
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    //   字符串若太长，就只显示length个字符加省略号
    public static String shortText(int length, String string) {
        if (string.length() > length) {
            string = string.substring(0, length) + "...";
        }
        return string;
    }

    //    原料单位统一处理
    public static String getUnit(Material material) {
//       没有包装
        if (material.getPackType() == PackTypeVo.empty.getKey()) {
            return material.getUnit().getName();
        } else {
//       包装数量不固定
            if (material.getPackNum() == 0) {
                return material.getUnit().getName() + "/" + material.getPackUnitVo().getValue();
            } else {
                return material.getPackNum() + material.getUnit().getName() + "/" + material.getPackUnitVo().getValue();
            }
        }
    }

    // 半成品单位统一处理
    public static String getHalfUnit(Half half) {
//       没有包装
        if (half.getPackType() == PackTypeVo.empty.getKey()) {
            return half.getUnit().getName();
        } else {
//       包装数量不固定
            if (half.getPackNum() == 0) {
                return half.getUnit().getName() + "/" + half.getPackUnitVo().getValue();
            } else {
                return half.getPackNum() + half.getUnit().getName() + "/" + half.getPackUnitVo().getValue();
            }
        }
    }

    //    成品单位统一处理
    public static String getProductUnit(Product product) {
//       没有包装
        if (product.getPackType() == PackTypeVo.empty.getKey()) {
            return product.getUnit().getName();
        } else {
//       包装数量不固定
            if (product.getPackNum() == 0) {
                return product.getUnit().getName() + "/" + product.getPackUnitVo().getValue();
            } else {
                return product.getPackNum() + product.getUnit().getName() + "/" + product.getPackUnitVo().getValue();
            }
        }
    }

    //    物品单位统一处理
    public static String getItemUnit(Item item) {
//       没有包装
        if (item.getPackType() == PackTypeVo.empty.getKey()) {
            return item.getUnit().getName();
        } else {
            return item.getPackNum() + item.getUnit().getName() + "/" + item.getPackUnitVo().getValue();
        }
    }

    public static RequestBody convertToRequestBody(String param) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), param);
        return requestBody;
    }

    public static List<MultipartBody.Part> filesToMultipartBodyParts(List<File> fileList) {
        List<MultipartBody.Part> partList = new ArrayList<>();
        for (int i = 0; i < fileList.size(); i++) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), fileList.get(i));
            MultipartBody.Part part = MultipartBody.Part.createFormData("file" + i, fileList.get(i).getName(), requestBody);
            partList.add(part);
        }
        return partList;
    }

    public static MultipartBody.Part fileToMultipartBodyPart(List<File> fileList) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), fileList.get(0));
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", fileList.get(0).getName(), requestBody);
        return part;
    }

    // 进入相册
    public static void openGallery(Activity activity, List<LocalMedia> selectList, int max) {
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//              .theme(themeId)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                .maxSelectNum(max)
                .imageSpanCount(4)// 每行显示个数
                .selectionMode(PictureConfig.MULTIPLE)// 多选
                .previewImage(true)// 是否可预览图片
                .isCamera(true)// 是否显示拍照按钮
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示
//                .selectionMedia(selectList)// 是否传入已选图片
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    //    删除网络列表图片
    public static void deleteImage(final Context context, int id) {
        String token = UniversalHelper.getToken(_Url.UPLOAD_IMAGE);
        Api.getDefault().deleteImage(id, token)
                .compose(RxHelper.<Img>handleResult())
                .subscribe(new RxSubscriber<Img>(context) {
                    @Override
                    protected void _onNext(Img img) {
                        ToastUtil.showToast(context, context.getString(R.string.delete_done));
                    }

                    @Override
                    protected void _onError(String message) {
                        ToastUtil.showToast(context, message);
                    }

                    @Override
                    protected boolean showDialog() {
                        return false;
                    }
                });
    }

    //    删除单张网络图片
    public static void deleteImage(final Context context, final RelativeLayout relativeLayout, int id) {
        String token = UniversalHelper.getToken(_Url.UPLOAD_IMAGE);
        Api.getDefault().deleteImage(id, token)
                .compose(RxHelper.<Img>handleResult())
                .subscribe(new RxSubscriber<Img>(context) {
                    @Override
                    protected void _onNext(Img img) {
//                      删除成功，就隐藏显示图片的控件
                        relativeLayout.setVisibility(View.GONE);
                        ToastUtil.showToast(context, context.getString(R.string.delete_done));
                    }

                    @Override
                    protected void _onError(String message) {
                        ToastUtil.showToast(context, message);
                    }

                    @Override
                    protected boolean showDialog() {
                        return false;
                    }
                });
    }

    //    图片预览
    public static void imagePreview(Activity activity, List<Img> imgList, int position) {
        Intent intent = new Intent(activity, ImageExternalPreviewActivity.class);
        intent.putExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, (Serializable) imgList);
        intent.putExtra(PictureConfig.DIRECTORY_PATH, "/Benxiao");
        intent.putExtra(PictureConfig.EXTRA_POSITION, position);
        activity.startActivity(intent);
        activity.overridePendingTransition(com.luck.picture.lib.R.anim.a5, 0);
    }

    //    获取用户所属部门Id
    public static int getDeptId(Context context) {
        return SPHelper.getInt(context, "deptId");
    }

    //    获取用户Id
    public static int getUserId(Context context) {
        return SPHelper.getInt(context, "userId");
    }

    //    用户是不是超级管理员
    public static boolean isSuper(Context context) {
        return SPHelper.getBoolean(context, "isSuper");
    }

    //    浏览开始文件清单
    public static void viewFile(Context context, ProjectBeforeInventory item) {
        String path = item.getFile().getPath();
        final String pathUrl = UrlHelper.URL_IMAGE + path;
        String fileName = item.getFile().getName();
        Log.d("pathUrl", pathUrl);
//      图片文件单独查看
        if (fileName.contains(".jpeg") || fileName.contains(".jpg")
                || fileName.contains(".png") || fileName.contains(".gif")) {
//          下载文件后跳转显示
            downloadFile(context, pathUrl, fileName);
            Intent intent = new Intent(context, ViewPicActivity.class);
            intent.putExtra("pathUrl", pathUrl);
            context.startActivity(intent);
            return;
        }
        FileDisplayActivity.show(context, pathUrl, fileName);
    }

    //    浏览结束文件清单
    public static void viewFile(Context context, ProjectAfterInventory item) {
        String path = item.getFile().getPath();
        final String pathUrl = UrlHelper.URL_IMAGE + path;
        String fileName = item.getFile().getName();
        Log.d("pathUrl", pathUrl);
//      图片文件单独查看
        if (fileName.contains(".jpeg") || fileName.contains(".jpg")
                || fileName.contains(".png") || fileName.contains(".gif")) {
//          下载文件后跳转显示
            downloadFile(context, pathUrl, fileName);
            Intent intent = new Intent(context, ViewPicActivity.class);
            intent.putExtra("pathUrl", pathUrl);
            context.startActivity(intent);
            return;
        }
        FileDisplayActivity.show(context, pathUrl, fileName);
    }

    public static void downloadFile(final Context context, String pathUrl, String fileName) {
        DUtil.init(context)
                .url(pathUrl)
                .path(Environment.getExternalStorageDirectory() + "/Benxiao/")
                .name(fileName)
                .childTaskCount(3)
                .build()
                .start(new SimpleDownloadCallback() {
                    @Override
                    public void onProgress(long currentSize, long totalSize, float progress) {
                        super.onProgress(currentSize, totalSize, progress);
                    }

                    @Override
                    public void onFinish(File file) {
                        super.onFinish(file);
                        Log.d("pathUrl", file.getPath());
                    }

                    @Override
                    public void onError(String error) {
                        ToastUtil.showToast(context, error);
                    }
                });
    }

    //           跳转到拨号界面
    public static void toDialActivity(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }

    //           消息详情跳转到单号审核页面
    public static void startAuditActivity(Context context, Class cls, FlowMessage message) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("Id", message.getDataId());//保存单号Id
        intent.putExtra("flag", 1);// 通过该标志在详情页面可以输入意见进行审核操作
        context.startActivity(intent);
    }

    //           消息详情跳转到单号页面
    public static void startActivity(Context context, Class cls, RemindMessage message) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("Id", message.getDataId());//保存单号Id
        context.startActivity(intent);
    }

    //     流程节点详情
    public static void getNodeDetail(final Context context, int id, final TextView tv) {
        String token = UniversalHelper.getToken(_Url.NODE);
        Api.getDefault().nodeDetail(id, token)
                .compose(RxHelper.<FlowNode>handleResult())
                .subscribe(new RxSubscriber<FlowNode>(context) {
                    @Override
                    protected void _onNext(FlowNode flowNode) {
                        List<SystemDept> depts = flowNode.getDepts();
                        List<SystemUser> users = flowNode.getUsers();
                        List<Integer> deptIdList = new ArrayList<Integer>();
                        List<Integer> userIdList = new ArrayList<Integer>();
                        for (SystemDept dept : depts) {
                            deptIdList.add(dept.getId());
                        }
                        for (SystemUser user : users) {
                            userIdList.add(user.getId());
                        }
                        int deptId = UniversalHelper.getDeptId(context);
                        int userId = UniversalHelper.getUserId(context);
//                     登录用户属于具有审核权限的部门或者是有审核权限的人就能进行审核操作
                        if (userIdList.contains(userId) || deptIdList.contains(deptId)) {
                            tv.setText(R.string.audit);
                            tv.setEnabled(true);
                            tv.setTextColor(context.getResources().getColor(R.color.colorBase));
                        }
                    }

                    @Override
                    protected void _onError(String message) {
                        ToastUtil.showToast(context, message);
                    }

                    @Override
                    protected boolean showDialog() {
                        return false;
                    }
                });
    }

    //  是否是架模工角色
    public static boolean isJMRole(Context context) {
        ArrayList<Integer> list = (ArrayList<Integer>) ACache.get(context).getAsObject("roleId");
        if (list.contains(UniversalHelper.JM_ROLE_ID)) {
            return true;
        } else {
            return false;
        }
    }

    //   是否是仓库主管或仓管员角色
    public static boolean isCKRole(Context context) {
        ArrayList<Integer> list = (ArrayList<Integer>) ACache.get(context).getAsObject("roleId");
        if (list.contains(UniversalHelper.CKZG_ROLE_ID)
                || list.contains(UniversalHelper.CGY_ROLE_ID)) {
            return true;
        } else {
            return false;
        }
    }

}
