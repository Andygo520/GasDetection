package zhiren.gasdetection.TasksToDo;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhiren.gasdetection.BaseActivity;
import zhiren.gasdetection.R;
import zhiren.gasdetection.adapter.ListDropDownAdapter;

// 多条件筛选页面
public class DropDownMenuActivity extends BaseActivity {

    @BindView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;

    private String headers[] = {"全部街道", "全部小区"};
    private List<View> popupViews = new ArrayList<>();

    private ListDropDownAdapter streetAdapter;
    private ListDropDownAdapter communityAdapter;

    private String streets[] = {"复兴村", "云飞路", "云霞路", "江汉路"};
    private String communities[] = {"泛海兰之园", "复兴村小区", "泛海兰之园", "唐家墩社区", "唐家墩社区", "复兴村小区"};

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_drop_down_menu;
    }

    @Override
    protected void initData() {
        //init street menu
        final ListView streetView = new ListView(this);
        streetView.setDividerHeight(0);
        streetAdapter = new ListDropDownAdapter(this, Arrays.asList(streets));
        streetView.setAdapter(streetAdapter);

        //init community menu
        final ListView communityView = new ListView(this);
        communityView.setDividerHeight(0);
        communityAdapter = new ListDropDownAdapter(this, Arrays.asList(communities));
        communityView.setAdapter(communityAdapter);

        //init popupViews
        popupViews.add(streetView);
        popupViews.add(communityView);

        //add item click event
        streetView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                streetAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[0] : streets[position]);
//                mDropDownMenu.closeMenu();
            }
        });

        communityView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                streetAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[1] : communities[position]);
//                mDropDownMenu.closeMenu();
            }
        });

        //init context view
        TextView contentView = new TextView(this);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        contentView.setText("内容显示区域");
        contentView.setGravity(Gravity.CENTER);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, contentView);
    }
}
