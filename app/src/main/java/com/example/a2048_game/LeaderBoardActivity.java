package com.example.a2048_game;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

class LeaderBoardActivity extends AppCompatActivity {

    private ListView leaderboardListView;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        leaderboardListView = findViewById(R.id.leaderboardListView);

        // 假设DatabaseHelper已经实现
//        dbHelper = new MyDatabaseHelper(this);

        // 查询数据库并填充ListView
        fillLeaderboardListView();
    }

    private void fillLeaderboardListView() {
        List<User> users = (List<User>) dbHelper.getAllUsers(); // 假设getAllUsers()返回所有用户
        ArrayAdapter<User> adapter = new ArrayAdapter<>(this,
                R.layout.list_item_leaderboard,
                R.id.tvUsername,
                users);

        leaderboardListView.setAdapter(adapter);
    }
}
