package zhiren.gasdetection.AnJian;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import model.CheckItemsDetail;
import retrofit.Api;
import retrofit.RxHelper;
import retrofit.RxSubscriber;
import utils.SPHelper;
import utils.ToastUtil;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;
import zhiren.gasdetection.TasksToDo.CategoryActivity;
import zhiren.gasdetection.adapter.CheckDetailAdapter;

public class CheckItemDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.tvBrand)
    TextView mTvBrand;
    @BindView(R.id.tvVersion)
    TextView mTvVersion;
    @BindView(R.id.tvYear)
    TextView mTvYear;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.etNote)
    EditText mEtNote;
    @BindView(R.id.tvUpVedio)
    TextView mTvUpVedio;
    @BindView(R.id.ivVedio)
    ImageView mIvVedio;
    @BindView(R.id.tvUpPhoto)
    TextView mTvUpPhoto;
    @BindView(R.id.btnEnter)
    Button mBtnEnter;
    @BindView(R.id.tvWidth)
    EditText mTvWidth;
    @BindView(R.id.tvHeight)
    EditText mTvHeight;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_detail;
    }

    @Override
    protected void initData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("itemName");
        int itemId = bundle.getInt("itemId");
        mText.setText(name);
        getList(itemId);
    }

    @OnClick({R.id.iv_back, R.id.tvUpVedio, R.id.tvUpPhoto,
            R.id.btnEnter, R.id.tvBrand, R.id.tvVersion, R.id.tvYear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tvUpVedio:
                break;
            case R.id.tvUpPhoto:
                break;
            case R.id.btnEnter:
                break;
            case R.id.tvBrand:
                Bundle bundle = new Bundle();
                bundle.putInt("flag", 1);
                startActivity(CategoryActivity.class, bundle);
                break;
            case R.id.tvVersion:
                break;
            case R.id.tvYear:
                break;
        }
    }

    public void getList(int itemId) {
        int id = SPHelper.getInt(this, "id");
        Api.getDefault().checkProjectItemList(id, itemId)
                .compose(RxHelper.<CheckItemsDetail>handleResult())
                .subscribe(new RxSubscriber<CheckItemsDetail>(this) {
                    @Override
                    protected void _onNext(CheckItemsDetail checkItemsDetail) {
                        mRecyclerView.setAdapter(new CheckDetailAdapter(CheckItemDetailActivity.this,
                                checkItemsDetail.getProject_data(), R.layout.check_item));
                    }

                    @Override
                    protected void _onError(String message) {
                        ToastUtil.showToast(CheckItemDetailActivity.this, message);
                    }

                    @Override
                    protected boolean showDialog() {
                        return false;
                    }
                });
    }
}
