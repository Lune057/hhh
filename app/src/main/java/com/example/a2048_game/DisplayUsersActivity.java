package com.example.a2048_game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DisplayUsersActivity extends AppCompatActivity {

    private ListView userList;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_users);

        userList = findViewById(R.id.user_list);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
//            users = extras.getParcelableArrayList("users");
            users = extras.getParcelable("users");
            UserAdapter adapter = new UserAdapter(this, users);
            userList.setAdapter(adapter);
        }
    }

    // 创建一个适配器类，继承自BaseAdapter
    private class UserAdapter extends BaseAdapter {
        public UserAdapter(DisplayUsersActivity displayUsersActivity, ArrayList<User> users) {
        }

        // 实现相关方法，如 getCount(), getItem(), getItemId() 等
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(DisplayUsersActivity.this).inflate(R.layout.user_item_layout, parent, false);
                viewHolder.tvUsername = convertView.findViewById(R.id.tv_username);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

//            User user = users.get(position);
//            viewHolder.tvUsername.setText(user.getUsername());
            // 根据需要设置其他视图内容

            return convertView;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        private class ViewHolder {
            TextView tvUsername;
            // 其他视图控件
        }
    }
}