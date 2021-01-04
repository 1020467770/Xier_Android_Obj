package com.example.xier_android_obj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_acitivity);
        EditText creatorNameAdded = (EditText) findViewById(R.id.added_ET_creator_name);
        EditText groupNameAdded = (EditText) findViewById(R.id.added_ET_group_name);
        Button button = (Button) findViewById(R.id.added_Btn_send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String creatorName=creatorNameAdded.getText().toString();
                String groupName=groupNameAdded.getText().toString();
                if("".equals(creatorName)||"".equals(groupName)){//判断是否添加成功
                    setResult(RESULT_CANCELED,intent);
                }else{
                    intent.putExtra("creatorName_return",creatorName);
                    intent.putExtra("groupName_return",groupName);
                    setResult(RESULT_OK,intent);
                }
                finish();
            }
        });

    }
}