package com.example.xier_android_obj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private List<GroupBean> groupList = new ArrayList<>();

    private RecyclerView recyclerView;

    private GroupAdapter adapter;

    /*
        附加题：相邻的列表Item不同。（一左一右）
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGroup();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new GroupAdapter(groupList);
        recyclerView.setAdapter(adapter);

    }

    private void initGroup() {
        GroupBean group = new GroupBean(R.drawable.cat, "小猫一号", "小猫一号粉丝群");
        groupList.add(group);
        GroupBean group2 = new GroupBean(R.drawable.cat2, "小猫二号", "小猫二号粉丝群");
        groupList.add(group2);
        GroupBean group3 = new GroupBean(R.drawable.cat3, "小猫三号", "小猫三号粉丝群");
        groupList.add(group3);
        GroupBean group4 = new GroupBean(R.drawable.cat4, "小猫四号", "小猫四号粉丝群");
        groupList.add(group4);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_group:
                IntoAddActivity();
                break;
            case R.id.clear_group:
                clearGroupList();
                break;
            case R.id.exit:
                ActivityCollector.finishAll();
                break;
            default:
                break;
        }
        return true;
    }

    private void clearGroupList() {
        groupList.clear();
        adapter.notifyDataSetChanged();
    }

    private void IntoAddActivity() {
        Intent intent = new Intent(this, AddActivity.class);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    GroupBean newGroup = new GroupBean(R.drawable.cat,
                            data.getStringExtra("creatorName_return"),
                            data.getStringExtra("groupName_return"));
                    groupList.add(newGroup);
                    //adapter.notifyDataSetChanged();这个是Tips里面的，不会改变滑动位置
                    adapter.notifyItemInserted(groupList.size() - 1);
                    recyclerView.scrollToPosition(groupList.size() - 1);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}