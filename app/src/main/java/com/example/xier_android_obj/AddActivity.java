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
                intent.putExtra("creatorName_return",creatorNameAdded.getText().toString());
                intent.putExtra("groupName_return",groupNameAdded.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}