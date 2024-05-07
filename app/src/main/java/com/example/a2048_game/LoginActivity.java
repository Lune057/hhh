package com.example.a2048_game;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private EditText etUsername, etPassword;
    private Button btnLogin;
    Button btnBoard;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHelper = new MyDatabaseHelper(this, "2048game.db", null, 1);
//        这里设置app一启动数据库就自动打开或者生成
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);


        btnBoard = findViewById(R.id.btn_LeaderBoard);
        listView = findViewById(R.id.listView);


        // LoginActivity.java
        View btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // 这里替换为您的实际登录验证逻辑
//                boolean loginSuccessful = validateAndLogin(userID, password);

                String query = "SELECT * FROM User WHERE id=? and password=?";
                Cursor cursor = db.rawQuery(query, new String[]{userID, password});

                boolean exists = cursor.moveToFirst();
                cursor.close();
                if (!exists) {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
//                if (loginSuccessful) {
//                    // 保存登录状态
//                    SharedPreferences preferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putBoolean("isUserLoggedIn", true);
//                    editor.apply();
//
//                    // 跳转至主页面
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish(); // 关闭登录Activity，避免用户通过返回键回到登录页面
//                } else {
//                    Toast.makeText(LoginActivity.this, "登录失败，请检查输入信息", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        //排行榜的绑定
        btnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查询数据库 Users 表的所有用户
                List<User> users = queryAllUsersFromDatabase();

                // 创建一个新的 Intent 跳转到新页面
                Intent intent = new Intent(LoginActivity.this, LeaderBoardActivity.class);

                // 将用户列表传递给新页面
//                intent.putParcelableArrayListExtra("users", (ArrayList<? extends Parcelable>) users);

                startActivity(intent);
            }

            private List<User> queryAllUsersFromDatabase() {
                return null;
            }
        });


        // 查询数据库获取用户数据的方法
//        private List<User> queryUsersFromDatabase() {
//            // 这里实现查询数据库的逻辑
//            // 示例：假设数据库中有一个名为"users"的表
//            // 可以使用相关的数据库操作方法获取用户数据
//            return new ArrayList<>();
//        }


        // 替换为您的实际登录验证逻辑
//        private boolean validateAndLogin(String etUsername, String etPassword) {
//        // 示例：仅检查输入不为空
//        return !etUsername.isEmpty() && !etPassword.isEmpty();
//    }


    }
}




