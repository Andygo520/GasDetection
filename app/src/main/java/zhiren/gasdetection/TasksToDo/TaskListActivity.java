package zhiren.gasdetection.TasksToDo;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import model.CheckTask;
import retrofit.Api;
import retrofit.RxHelper;
import retrofit.RxSubscriber;
import utils.ToastUtil;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;
import zhiren.gasdetection.adapter.TaskAdapter;

// 安检任务列表页
public class TaskListActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.etSearch)
    EditText mEtSearch;
    @BindView(R.id.listView)
    ListView mListView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_task_list;
    }

    @Override
    protected void initData() {
        mText.setVisibility(View.GONE);
        mEtSearch.setVisibility(View.VISIBLE);
        int id = getIntent().getExtras().getInt("id");
        getList(1, id, true, "", "", "");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    public void getList(int page, int id, boolean token, String street, String area, String key) {
        Api.getDefault().checkTaskList(page, id, token, street, area, key)
                .compose(RxHelper.<CheckTask>handleResult())
                .subscribe(new RxSubscriber<CheckTask>(this) {
                    @Override
                    protected void _onNext(CheckTask checkTask) {
                        mListView.setAdapter(new TaskAdapter(TaskListActivity.this, checkTask.getTask_data(), R.layout.task_list_item));
                    }

                    @Override
                    protected void _onError(String message) {
                        ToastUtil.showToast(TaskListActivity.this, message);
                    }

                    @Override
                    protected boolean showDialog() {
                        return false;
                    }
                });
    }
}
