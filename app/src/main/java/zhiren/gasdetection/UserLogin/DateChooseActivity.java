package zhiren.gasdetection.UserLogin;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.DateTimePicker;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;

public class DateChooseActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.tvRight)
    TextView mTvRight;
    @BindView(R.id.rbMonth)
    RadioButton mRbMonth;
    @BindView(R.id.rbDay)
    RadioButton mRbDay;
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.ivDelete)
    ImageView mIvDelete;
    @BindView(R.id.wheelview_container)
    LinearLayout mWheelviewContainer;
    @BindView(R.id.rbBegin)
    RadioButton mRbBegin;
    @BindView(R.id.rbEnd)
    RadioButton mRbEnd;

    private DatePicker datePicker;//日期选择
    private boolean month_flag = true;//选中月份的标志
    private static final String YEAR_MONTH_FORMAT = "%s年%s月";
    private static final String YEAR_MONTH_DAY_FORMAT = "%s年%s月%s日";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_date_choose;
    }

    @Override
    protected void initListener() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbMonth:
                        month_flag = true;
                        datePicker = new DatePicker(DateChooseActivity.this, DateTimePicker.YEAR_MONTH);
                        mTv.setVisibility(View.GONE);
                        mRbEnd.setVisibility(View.GONE);
                        break;
                    case R.id.rbDay:
                        month_flag = false;
                        datePicker = new DatePicker(DateChooseActivity.this, DateTimePicker.YEAR_MONTH_DAY);
                        mTv.setVisibility(View.VISIBLE);
                        mRbEnd.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }
        });
        datePicker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                mRbBegin.setText(String.format(month_flag ? YEAR_MONTH_FORMAT : YEAR_MONTH_DAY_FORMAT
                        , year, datePicker.getSelectedMonth(), datePicker.getSelectedDay()));
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                mRbBegin.setText(String.format(month_flag ? YEAR_MONTH_FORMAT : YEAR_MONTH_DAY_FORMAT
                        , datePicker.getSelectedYear(), month, datePicker.getSelectedDay()));
            }

            @Override
            public void onDayWheeled(int index, String day) {
                mRbBegin.setText(String.format(month_flag ? YEAR_MONTH_FORMAT : YEAR_MONTH_DAY_FORMAT
                        , datePicker.getSelectedYear(), datePicker.getSelectedMonth(), day));
            }
        });
    }

    @Override
    protected void initData() {
        datePicker = new DatePicker(this, DateTimePicker.YEAR_MONTH);
//      设置选项偏移量，可用来要设置显示的条目数，范围为1-5，1显示3行、2显示5行、3显示7行……
        datePicker.setOffset(1);
        datePicker.setUseWeight(true);
        datePicker.setTextPadding(15);
        datePicker.setLineSpaceMultiplier(4);
        datePicker.setRangeStart(2018, 9, 3);
//      datePicker.setRangeEnd(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH);
        //得到选择器视图，可内嵌到其他视图容器，不需要调用show方法
        mWheelviewContainer.addView(datePicker.getContentView());
    }

    @OnClick({R.id.iv_back, R.id.tvRight, R.id.ivDelete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tvRight:
                break;
            case R.id.ivDelete:
                if (month_flag) {
                    mRbBegin.setText("选择月份");
                } else {
                    mRbBegin.setText("开始日期");
                    mRbEnd.setText("结束日期");
                }
                break;
        }
    }
}
