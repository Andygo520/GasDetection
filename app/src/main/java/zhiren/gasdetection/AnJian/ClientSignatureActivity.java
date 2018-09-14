package zhiren.gasdetection.AnJian;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;
import zhiren.gasdetection.TasksToDo.SignatureActivity;

// 确认签名页面
public class ClientSignatureActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.tvUpPhoto)
    TextView mTvUpPhoto;
    @BindView(R.id.ivSignature)
    ImageView mIvSignature;
    @BindView(R.id.btn1)
    RadioButton mBtn1;
    @BindView(R.id.btn2)
    RadioButton mBtn2;
    @BindView(R.id.btn3)
    RadioButton mBtn3;
    @BindView(R.id.btnFree)
    Button mBtnFree;
    @BindView(R.id.btnCharge)
    Button mBtnCharge;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_client_signature;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            byte[] bytes = data.getByteArrayExtra("bitmap");
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//            Bitmap bitmap = data.getParcelableExtra("bitmap");
            Log.d("signatureBitmap", "??" + bitmap.toString());
            mTvUpPhoto.setVisibility(View.GONE);
            mIvSignature.setVisibility(View.VISIBLE);
            mIvSignature.setImageBitmap(bitmap);
        }
    }

    @OnClick({R.id.iv_back, R.id.tvUpPhoto, R.id.ivSignature, R.id.btnFree, R.id.btnCharge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ivSignature:
            case R.id.tvUpPhoto:
                Intent intent = new Intent(this, SignatureActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.btnFree:
                break;
            case R.id.btnCharge:
                break;
        }
    }
}
