package zhiren.gasdetection.TasksToDo;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;
import zhiren.gasdetection.adapter.LeftMenuAdapter;
import zhiren.gasdetection.adapter.RightMenuAdapter;

// 二级分类筛选页面
public class CategoryActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.lvLeft)
    ListView mLvLeft;
    @BindView(R.id.lvRight)
    ListView mLvRight;
    @BindView(R.id.etSearch)
    EditText mEtSearch;
    @BindView(R.id.tvLeft)
    TextView mTvLeft;
    @BindView(R.id.tvRight)
    TextView mTvRight;
    @BindView(R.id.llContainer)
    LinearLayout mLlContainer;
    @BindView(R.id.tvNoFound)
    TextView mTvNoFound;

    private LeftMenuAdapter leftMenuAdapter;
    private RightMenuAdapter rightMenuAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_category;
    }

    @Override
    protected void initData() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("复兴村");
        arrayList.add("云飞路");
        arrayList.add("云霞路");
        arrayList.add("江汉路");
        arrayList.add("江汉路");

        leftMenuAdapter = new LeftMenuAdapter(this, arrayList);
        rightMenuAdapter = new RightMenuAdapter(this, arrayList);
        mLvLeft.setAdapter(leftMenuAdapter);
        mLvRight.setAdapter(rightMenuAdapter);
        mText.setVisibility(View.GONE);
        mEtSearch.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initListener() {
        mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leftMenuAdapter.setSelectItem(position);
                leftMenuAdapter.notifyDataSetInvalidated();
                rightMenuAdapter.setSelectItem(0);
                rightMenuAdapter.notifyDataSetInvalidated();
            }
        });
        mLvRight.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rightMenuAdapter.setSelectItem(position);
                rightMenuAdapter.notifyDataSetInvalidated();
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

}
