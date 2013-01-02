package com.wordrecite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
	private static final String DB_NAME = "word_recite.db";
	private static final int DB_VERSION = 1;

	public DBHandler(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/* 建表wr_word */
		String createTable = "CREATE TABLE wr_word ("
				+ "id integer primary key autoincrement,"
				+ "english varchar(30) not null,"
				+ "chinese varchar(50) not null," + "property varchar(10) ,"
				+ "soundmark varchar(30) ," + "sentence varchar(100),"
				+ "sound varchar(50)," + "image varchar(50),"
				+ "status integer(5) not null,"
				+ "created_time varchar(20) not null,"
				+ "modified_time varchar(20) not null);";
		db.execSQL(createTable);
		/* 初始化数据 */
		String initData = "insert into wr_word values (null, 'hello', '你好', 'n', 'hə''lo', 'Hello, boy', '', '', 1, '2012-01-01', '2012-01-01')";
		db.execSQL(initData);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
