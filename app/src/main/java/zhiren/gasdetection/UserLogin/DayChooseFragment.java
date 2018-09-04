package zhiren.gasdetection.UserLogin;


import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.DateTimePicker;
import zhiren.gasdetection.BaseFragment;
import zhiren.gasdetection.R;

/**
 * 日期选择——按日选择
 */
public class DayChooseFragment extends BaseFragment {

    @BindView(R.id.rbBegin)
    RadioButton mRbBegin;
    @BindView(R.id.rbEnd)
    RadioButton mRbEnd;
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.ivDelete)
    ImageView mIvDelete;
    @BindView(R.id.wheelview_container)
    LinearLayout mWheelviewContainer;

    private DatePicker datePicker;//日期选择
    private static final String YEAR_MONTH_DAY_FORMAT = "%s年%s月%s日";
    private int year, month, day;
    private boolean begin_date_flag = true;
    private String begin, end;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_day_choose;
    }

    @Override
    protected void initData() {
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);//月份为实际月份减1
        day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        Log.d("yearmonth", "year:" + year + "month:" + month);
        datePicker = new DatePicker(getActivity(), DateTimePicker.YEAR_MONTH_DAY);
//      设置选项偏移量，可用来要设置显示的条目数，范围为1-5，1显示3行、2显示5行、3显示7行……
        datePicker.setOffset(2);
        datePicker.setUseWeight(true);
        datePicker.setLineSpaceMultiplier(4);
        datePicker.setRangeStart(2016, 1, 1);
        datePicker.setRangeEnd(year, month + 1, day);
        datePicker.setSelectedItem(year, month + 1, day);
        datePicker.setResetWhileWheel(false);
        //得到选择器视图，可内嵌到其他视图容器，不需要调用show方法
        mWheelviewContainer.addView(datePicker.getContentView());
        mRbBegin.setText(String.format(YEAR_MONTH_DAY_FORMAT, year, month + 1, day));

        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbBegin:
                        end = String.format(YEAR_MONTH_DAY_FORMAT,
                                datePicker.getSelectedYear(), datePicker.getSelectedMonth(), datePicker.getSelectedDay());
                        mRbBegin.setChecked(true);
                        mRbBegin.setText(begin);
                        begin_date_flag = true;
                        break;
                    case R.id.rbEnd:
                        begin = String.format(YEAR_MONTH_DAY_FORMAT,
                                datePicker.getSelectedYear(), datePicker.getSelectedMonth(), datePicker.getSelectedDay());
                        mRbEnd.setChecked(true);
                        mRbEnd.setText(end);
                        begin_date_flag = false;
                        break;
                    default:
                        break;
                }
            }
        });

        datePicker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                if (begin_date_flag) {
                    mRbBegin.setText(String.format(YEAR_MONTH_DAY_FORMAT
                            , year, datePicker.getSelectedMonth(), datePicker.getSelectedDay()));
                } else {
                    mRbEnd.setText(String.format(YEAR_MONTH_DAY_FORMAT
                            , year, datePicker.getSelectedMonth(), datePicker.getSelectedDay()));
                }
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                if (begin_date_flag) {
                    mRbBegin.setText(String.format(YEAR_MONTH_DAY_FORMAT
                            , datePicker.getSelectedYear(), month, datePicker.getSelectedDay()));
                } else {
                    mRbEnd.setText(String.format(YEAR_MONTH_DAY_FORMAT
                            , datePicker.getSelectedYear(), month, datePicker.getSelectedDay()));
                }
            }

            @Override
            public void onDayWheeled(int index, String day) {
                if (begin_date_flag) {
                    mRbBegin.setText(String.format(YEAR_MONTH_DAY_FORMAT
                            , datePicker.getSelectedYear(), datePicker.getSelectedMonth(), day));
                } else {
                    mRbEnd.setText(String.format(YEAR_MONTH_DAY_FORMAT
                            , datePicker.getSelectedYear(), datePicker.getSelectedMonth(), day));
                }
            }
        });
    }

    @OnClick(R.id.ivDelete)
    public void onViewClicked() {
        mRbBegin.setText("开始日期");
        mRbEnd.setText("结束日期");
        mRbBegin.setChecked(false);
        mRbEnd.setChecked(false);
    }
}
