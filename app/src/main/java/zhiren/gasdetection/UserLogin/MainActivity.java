package zhiren.gasdetection.UserLogin;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhiren.gasdetection.AnJian.CheckResultActivity;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.InstallService.InstallDetailActivity;
import zhiren.gasdetection.R;
import zhiren.gasdetection.TasksToDo.CategoryActivity;
import zhiren.gasdetection.TasksToDo.TaskDetailActivity;
import zhiren.gasdetection.TrainingTest.TrainingTestActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_data)
    ImageView mIvData;
    @BindView(R.id.iv_photo)
    ImageView mIvPhoto;
    @BindView(R.id.tvChangePW)
    TextView mTvChangePW;
    @BindView(R.id.tvName)
    TextView mTvName;
    @BindView(R.id.ivSex)
    ImageView mIvSex;
    @BindView(R.id.tvPhone)
    TextView mTvPhone;
    @BindView(R.id.tvNum)
    TextView mTvNum;
    @BindView(R.id.tvCompany)
    TextView mTvCompany;
    @BindView(R.id.tvIntro)
    TextView mTvIntro;
    @BindView(R.id.llAnJian)
    LinearLayout mLlAnJian;
    @BindView(R.id.llDianHuo)
    LinearLayout mLlDianHuo;
    @BindView(R.id.llYinCang)
    LinearLayout mLlYinCang;
    @BindView(R.id.tvTest)
    TextView mTvTest;
    @BindView(R.id.tvGetMaterial)
    TextView mTvGetMaterial;
    @BindView(R.id.tvAddGuest)
    TextView mTvAddGuest;
    @BindView(R.id.tvCheck)
    TextView mTvCheck;
    @BindView(R.id.tvReform)
    TextView mTvReform;
    @BindView(R.id.tvFire)
    TextView mTvFire;
    @BindView(R.id.tvInstall)
    TextView mTvInstall;
    @BindView(R.id.tvInspect)
    TextView mTvInspect;
    @BindView(R.id.tvCommunity)
    TextView mTvCommunity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mTvCheck.setText("户内燃气\n安全检查");
        mTvReform.setText("户内隐患\n整改");
        mTvFire.setText("点火通气");
        mTvInstall.setText("器具安装\n服务");
        mTvInspect.setText("巡线巡检");
        mTvCommunity.setText("微社区");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.moveTaskToBack(true);
    }

    @OnClick({R.id.iv_data, R.id.tvChangePW, R.id.llAnJian, R.id.llDianHuo,
            R.id.tvCheck, R.id.tvReform, R.id.tvFire, R.id.tvInstall,
            R.id.llYinCang, R.id.tvTest, R.id.tvGetMaterial, R.id.tvAddGuest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_data:
                startActivity(MyDataActivity.class);
                break;
            case R.id.tvChangePW:
                break;
            case R.id.llAnJian:
                startActivity(CategoryActivity.class);
                break;
            case R.id.llDianHuo:
                break;
            case R.id.llYinCang:
                break;
            case R.id.tvGetMaterial:
                break;
            case R.id.tvAddGuest:
                startActivity(CustomerActivity.class);
                break;
            case R.id.tvTest:
                startActivity(TrainingTestActivity.class);
                break;
            case R.id.tvCheck:
                startActivity(TaskDetailActivity.class);
                break;
            case R.id.tvReform:
                break;
            case R.id.tvFire:
                startActivity(CheckResultActivity.class);
                break;
            case R.id.tvInstall:
                startActivity(InstallDetailActivity.class);
                break;
        }
    }

}
