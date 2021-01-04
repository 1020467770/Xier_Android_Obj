package com.example.xier_android_obj;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acitivity);

        Intent intent = getIntent();
        TextView creatorName = findViewById(R.id.name_creator);
        TextView groupName = findViewById(R.id.name_group);
        ImageView imageView = findViewById(R.id.img_group);

        creatorName.setText(intent.getStringExtra("grp_creatorName"));
        groupName.setText(intent.getStringExtra("grp_groupName"));
        imageView.setImageResource(intent.getIntExtra("grp_imgId",R.drawable.cat));
    }
}