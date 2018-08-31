package zhiren.gasdetection.UserLogin;

import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import utils.CheckNetwork;
import utils.StringUtil;
import utils.ToastUtil;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.etPhone)
    EditText mEtPhone;
    @BindView(R.id.etPW)
    EditText mEtPW;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        boolean connected = CheckNetwork.isNetworkConnected(this);
        if (connected) {
            String phone = mEtPhone.getText().toString();
            String password = mEtPW.getText().toString();
            if (StringUtil.isEmpty(phone) || StringUtil.isEmpty(password)) {
                ToastUtil.showToast(this, "手机号或密码未输入");
            } else {
                startActivity(MainActivity.class);
            }
        } else {
            ToastUtil.showToast(this, "网络未连接");
        }
    }
}
