package zhiren.gasdetection.UserLogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.CheckNetwork;
import utils.ToastUtil;
import zhiren.gasdetection.R;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etPhone)
    EditText mEtPhone;
    @BindView(R.id.etPW)
    EditText mEtPW;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
       boolean connected = CheckNetwork.isNetworkConnected(this);
       if (connected){
             String phone=mEtPhone.getText().toString();
             String password=mEtPW.getText().toString();

       }else {
           ToastUtil.showToast(this,"网络未连接");
       }
    }
}
