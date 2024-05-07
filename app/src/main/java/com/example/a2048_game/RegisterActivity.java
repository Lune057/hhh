package com.example.a2048_game;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new MyDatabaseHelper(this,"2048game.db",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        Button buttonTest = findViewById(R.id.test);

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name", "name");
                values.put("password","123");
                values.put("id","123");
                db.insert("User", null, values);
                Toast.makeText(RegisterActivity.this,"注册成功", Toast.LENGTH_SHORT).show();



            }
        });

        // 初始化“已有账号？去登录”按钮
        Button btnAlreadyHaveAccount = findViewById(R.id.btn_already_have_account);

        // 为按钮添加点击事件监听器
        btnAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建跳转到登录页面的Intent
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                // 启动登录页面
                startActivity(intent);
            }
        });
        // 给注册按钮加点击事件监听器
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // 检查用户名是否为空
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "输入为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // 查询数据库以确认账号是否存在
        if (!isUsernameExists(username)) {
            // 写入数据库
            writeUsernameToDatabase(username, password);
            // 跳转到主页
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isUsernameExists(String username) {
        // 这里应该有查询数据库的逻辑
        // 返回一个布尔值，表示用户名是否存在
        return false; // 示例值
    }

    private void writeUsernameToDatabase(String username, String password) {
        // 这里应该有将用户名和密码写入数据库的逻辑
    }







}