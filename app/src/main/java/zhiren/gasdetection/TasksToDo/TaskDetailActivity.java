package zhiren.gasdetection.TasksToDo;

import android.app.Dialog;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import utils.ToastUtil;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;

public class TaskDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.tvRight)
    TextView mTvRight;
    @BindView(R.id.ivEdit)
    ImageView mIvEdit;
    @BindView(R.id.tvNum)
    TextView mTvNum;
    @BindView(R.id.tvName)
    TextView mTvName;
    @BindView(R.id.tvTel)
    TextView mTvTel;
    @BindView(R.id.tvCity)
    TextView mTvCity;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.tvCommu)
    TextView mTvCommu;
    @BindView(R.id.tvFire)
    TextView mTvFire;
    @BindView(R.id.ivRecord)
    ImageView mIvRecord;
    @BindView(R.id.btnEnter)
    Button mBtnEnter;
    @BindView(R.id.btnNotMeet)
    Button mBtnNotMeet;
    @BindView(R.id.btnNotAllow)
    Button mBtnNotAllow;
    @BindView(R.id.tvRecord)
    TextView mTvRecord;
    @BindView(R.id.chronometer)
    Chronometer mChronometer;

    private int num = 0;//录音按钮点击的次数

    @OnClick({R.id.iv_back, R.id.ivEdit, R.id.ivRecord, R.id.btnEnter, R.id.btnNotMeet, R.id.btnNotAllow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ivEdit:
                break;
            case R.id.ivRecord:
                num++;
                if (num % 2 == 0) {
                    mChronometer.setVisibility(View.GONE);
                    mIvRecord.setImageResource(R.mipmap.record_start_icon);
                    mTvRecord.setText("开始录音");
                } else {
                    mIvRecord.setImageResource(R.mipmap.record_stop_icon);
                    mTvRecord.setText("录音中");
                    mChronometer.setVisibility(View.VISIBLE);
                    mChronometer.setBase(SystemClock.elapsedRealtime());//计时前时间清零
                    mChronometer.start();
                }

                break;
            case R.id.btnEnter:
                break;
            case R.id.btnNotMeet:
                break;
            case R.id.btnNotAllow:
                break;
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(this);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_nomal, null);
        TextView tvNo=dialogView.findViewById(R.id.tvNo);
        TextView tvYes=dialogView.findViewById(R.id.tvYes);
        tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tvYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ToastUtil.showToast(TaskDetailActivity.this,"录音文件已保存");
            }
        });

        dialog.setContentView(dialogView);

        WindowManager.LayoutParams lp     = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //注意要在Dialog show之后，再将宽高属性设置进去，才有效果
        dialog.show();
        window.setAttributes(lp);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_task_detail;
    }

    @Override
    protected void initData() {

    }
}
