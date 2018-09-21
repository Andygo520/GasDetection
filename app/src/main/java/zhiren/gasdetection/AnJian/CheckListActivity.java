package zhiren.gasdetection.AnJian;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import model.CheckItems;
import retrofit.Api;
import retrofit.RxHelper;
import retrofit.RxSubscriber;
import utils.SPHelper;
import utils.ToastUtil;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;
import zhiren.gasdetection.adapter.CheckItemsAdapter;

// 安检单列表页面
public class CheckListActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.list)
    ListView mList;
    @BindView(R.id.btn)
    Button mBtn;

    private List<CheckItems.ProjectData> dataList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_list;
    }

    @Override
    protected void initData() {
        mText.setText("安检单列表");
        getList();
    }

    @Override
    protected void initListener() {
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemId = dataList.get(position).getId();
                String itemName = dataList.get(position).getName();
                Log.d("itemId", itemId + "");
                Bundle bundle = new Bundle();
                bundle.putInt("itemId", itemId);
                bundle.putString("itemName", itemName);
                startActivity(CheckItemDetailActivity.class, bundle);
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn:
                break;
        }
    }

    public void getList() {
        int id = SPHelper.getInt(this, "id");
        Api.getDefault().checkProjectList(id)
                .compose(RxHelper.<CheckItems>handleResult())
                .subscribe(new RxSubscriber<CheckItems>(this) {
                    @Override
                    protected void _onNext(CheckItems checkItems) {
                        dataList = checkItems.getProject_data();
                        mList.setAdapter(new CheckItemsAdapter(CheckListActivity.this, dataList, R.layout.check_items_item));
                    }

                    @Override
                    protected void _onError(String message) {
                        ToastUtil.showToast(CheckListActivity.this, message);
                    }

                    @Override
                    protected boolean showDialog() {
                        return false;
                    }
                });
    }
}
