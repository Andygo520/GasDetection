package utils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.cnmar.benxiao.activity.WelcomeActivity;


/**
 * Created by Administrator on 2017/8/1.
 */

public class PollingService extends Service {

    public static final String ACTION = "com.ryantang.service.PollingService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onStart(Intent intent, int startId) {
        new PollingThread().start();
    }

    int count = 0;

    class PollingThread extends Thread {
        @Override
        public void run() {
            System.out.println("Polling...");
            count++;
            System.out.println("Polling..." + count);
            //当计数能被5整除时弹出通知
            if (count % 5 == 0) {
                int userId = SPHelper.getInt(PollingService.this, "userId");
                WelcomeActivity.sendNotice(userId, PollingService.this);//发送通知
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service:onDestroy");
    }
}