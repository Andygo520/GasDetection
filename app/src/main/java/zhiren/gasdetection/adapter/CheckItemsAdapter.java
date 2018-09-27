package zhiren.gasdetection.adapter;

import android.content.Context;
import android.widget.TextView;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

import model.CheckItems;
import zhiren.gasdetection.R;

/**
 * Author: andy
 * Time:2018/9/20 0020
 * Description:安检项使用的适配器
 */

public class CheckItemsAdapter extends SuperAdapter<CheckItems.ProjectData> {
    boolean pass = false;//合格与否

    public CheckItemsAdapter(Context context, List<CheckItems.ProjectData> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, CheckItems.ProjectData item) {
        holder.setText(R.id.tvItem, item.getProject_no() + "  " + item.getName());
        holder.setText(R.id.tvResult, item.getResult());
        TextView tvResult = holder.findViewById(R.id.tvResult);
        tvResult.setTextColor(pass ? tvResult.getContext().getResources().getColor(R.color.color_green)
                : tvResult.getContext().getResources().getColor(R.color.color_red));
    }

    public void setPass(boolean bool) {
        this.pass = bool;
    }

}
