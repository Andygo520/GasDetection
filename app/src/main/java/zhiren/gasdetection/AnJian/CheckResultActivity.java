package zhiren.gasdetection.AnJian;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.helper.printer.BlueToothService;
import com.qs.helper.printer.PrintService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import utils.ToastUtil;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;

public class CheckResultActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.tvNo)
    TextView mTvNo;
    @BindView(R.id.tvName)
    TextView mTvName;
    @BindView(R.id.tvPhone)
    TextView mTvPhone;
    @BindView(R.id.tvTableNo)
    TextView mTvTableNo;
    @BindView(R.id.tvType)
    TextView mTvType;
    @BindView(R.id.tvCommunity)
    TextView mTvCommunity;
    @BindView(R.id.tvStaffName)
    TextView mTvStaffName;
    @BindView(R.id.tvStaffNo)
    TextView mTvStaffNo;
    @BindView(R.id.tvStartTime)
    TextView mTvStartTime;
    @BindView(R.id.tvFinishTime)
    TextView mTvFinishTime;
    @BindView(R.id.tvRuHu)
    TextView mTvRuHu;
    @BindView(R.id.tvZhengGai)
    TextView mTvZhengGai;
    @BindView(R.id.tvFirst)
    TextView mTvFirst;
    @BindView(R.id.tvFirstSolve)
    TextView mTvFirstSolve;
    @BindView(R.id.tvSecond)
    TextView mTvSecond;
    @BindView(R.id.tvSecondSolve)
    TextView mTvSecondSolve;
    @BindView(R.id.tvThird)
    TextView mTvThird;
    @BindView(R.id.tvThirdSolve)
    TextView mTvThirdSolve;
    @BindView(R.id.tvPay)
    TextView mTvPay;
    @BindView(R.id.tvSum)
    TextView mTvSum;
    @BindView(R.id.tvPayType)
    TextView mTvPayType;
    @BindView(R.id.tvExpire1)
    TextView mTvExpire1;
    @BindView(R.id.tvExpire2)
    TextView mTvExpire2;
    @BindView(R.id.tvExpire3)
    TextView mTvExpire3;
    @BindView(R.id.ivSign)
    ImageView mIvSign;
    @BindView(R.id.btnBack)
    Button mBtnBack;
    @BindView(R.id.btnPrint)
    Button mBtnPrint;

    private BluetoothAdapter btAdapt;
    private Handler handler = null;
    private Handler mhandler = null;
    private BlueToothService service;
    protected static final String TAG = "CheckResultActivity";
    List<String> lstDevices = new ArrayList<String>();
    ArrayAdapter<String> adtDevices;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_result;
    }

    @Override
    protected void initData() {
        mText.setText("安检结果");
        btAdapt = BluetoothAdapter.getDefaultAdapter();// 初始化本机蓝牙功能
        adtDevices = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lstDevices);
    }

    public void checkBlueToothConnectAndPrint() {
        if (service == null) {
            service = new BlueToothService(this, mhandler);
        }
//      检测手机是否打开蓝牙
        if (service.IsOpen()) {
            PrintService.pl.printText("1269eagfawegaads\n");
        } else {
            ToastUtil.showToast(this, "手机蓝牙未开启，请开启蓝牙后再试");
        }
    }

    public void searchBlueToothDevice() {
        if (btAdapt.getState() == BluetoothAdapter.STATE_OFF) {// 如果蓝牙还没开启
            ToastUtil.showToast(this, "请先打开蓝牙");
            return;
        }
        if (btAdapt.isDiscovering())
            btAdapt.cancelDiscovery();
        lstDevices.clear();
        Object[] lstDevice = btAdapt.getBondedDevices().toArray();
        for (int i = 0; i < lstDevice.length; i++) {
            BluetoothDevice device = (BluetoothDevice) lstDevice[i];
            String str = "" + device.getName() + "|"
                    + device.getAddress();
            lstDevices.add(str); // 获取设备名称和mac地址
            adtDevices.notifyDataSetChanged();
        }
        setTitle("本机蓝牙地址：" + btAdapt.getAddress());
        btAdapt.startDiscovery();
    }


    @OnClick({R.id.iv_back, R.id.btnBack, R.id.btnPrint})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnPrint:
                searchBlueToothDevice();
                break;
        }
    }
}
