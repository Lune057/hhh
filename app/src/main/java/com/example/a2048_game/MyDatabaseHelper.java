package com.example.a2048_game;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

// 自定义的数据库辅助类，继承自SQLiteOpenHelper
public class MyDatabaseHelper extends SQLiteOpenHelper {

    // SQL语句，用于创建名为Book的表

    public static final String CREATE_USER = "Create table User("
            + "id integer primary key  ," // id字段，整型，主键，自增
            + "password text NOT NULL,"
            + "name text NOT NULL)"; // name字段，文本类型
    //   后面可以根据情况增加表语句
//    public static final String CREATE_CATEGORY="Create table Category("
//            +"id integer primary key autoincrement,"
//            +"category_name text,"
//            +"category_code integer)";
    // 上下文对象，可用于访问应用特定的资源和类，以及调用应用级别的操作，如启动活动、发送广播等
    private Context mContext;


    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query("User", null, null, null, null, null, null);
    }



    // 构造方法，接收四个参数：上下文、数据库名、游标工厂和数据库版本号
    // 在这个构造方法中，我们通过super关键字调用父类的构造方法来初始化SQLiteOpenHelper对象
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context; // 保存上下文对象，以便后续使用
    }

    // 当数据库首次创建时调用此方法
    // 在这个方法中，我们执行CREATE_BOOK SQL语句来创建Book表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER); // 执行SQL语句，创建表
        // 使用Toast显示一条消息，表明数据库已成功创建
        // 注意：在实际应用中，最好不要在数据库辅助类中直接处理UI相关的操作
        Toast.makeText(mContext, "create successded", Toast.LENGTH_SHORT).show();
        // 注意："create successded" 有一个拼写错误，应该是 "create succeeded"
    }

    // 当数据库需要升级时调用此方法
    // 目前此方法为空，可以根据需要添加数据库升级的逻辑
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 例如，可以在这里删除旧表并重新创建，或者添加新的表和字段等
        db.execSQL("drop table if exists User");
//        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}