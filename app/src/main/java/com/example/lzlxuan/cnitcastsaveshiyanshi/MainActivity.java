package com.example.lzlxuan.cnitcastsaveshiyanshi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
 private EditText editText;
 private EditText etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

 private void initView(){
    etNumber=(EditText) findViewById(R.id.et_number);
    etPassword=(EditText) findViewById(R.id.et_password);
        findViewById(R.id.btn_login).setOnContextClickListener(this);

 }
public void onClick(View v){
    String number=etNumber.getText().toString().trim();
    String password=etPassword.getText().toString();
    if (TextUtils.isEmpty(number)){
        Toast.makeText(this,"请输入QQ号码",Toast.LENGTH_SHORT).show();
        return;


    }
if (TextUtils.isEmpty(password)){
        Toast.makeText(this,"请输入QQ密码",Toast.LENGTH_SHORT).show();;
        return;;

}
  Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();;

}}

