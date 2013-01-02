package com.wordrecite.module.word;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wordrecite.db.DBHandler;
import com.wordrecite.entity.Word;

public class WordManager {

	private DBHandler helper;
	private SQLiteDatabase db;

	public WordManager(Context context) {
		helper = new DBHandler(context);
		db = helper.getWritableDatabase();
	}

	/**
	 * 从数据库中取单词，从offset开始，取limit条
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Word> select(int offset, int limit) {
		List<Word> wordList = new ArrayList<Word>();

		/* 从数据库取 */
		String sql = "select * from wr_word limit " + offset + " ," + limit
				+ "order by id asc";
		Cursor cursor = db.rawQuery(sql, null);
		/* 循环添加到List */
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			Word word = new Word();
			word.setId(cursor.getInt(cursor.getColumnIndex("id")));
			word.setEnglish(cursor.getString(cursor.getColumnIndex("english")));
			word.setChinese(cursor.getString(cursor.getColumnIndex("chinese")));
			word.setProperty(cursor.getString(cursor.getColumnIndex("property")));
			word.setSoundmark(cursor.getString(cursor
					.getColumnIndex("soundmark")));
			word.setSentence(cursor.getString(cursor.getColumnIndex("sentence")));
			word.setSound(cursor.getString(cursor.getColumnIndex("sound")));
			word.setImage(cursor.getString(cursor.getColumnIndex("image")));
			word.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
			/* 使用转换器将Date转换为String存储 */
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			try {
				word.setCreatedTime(format.parse(cursor.getString(cursor
						.getColumnIndex("created_time"))));
				word.setModifiedTime(format.parse(cursor.getString(cursor
						.getColumnIndex("modified_time"))));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			wordList.add(word);
		}

		db.close();
		return wordList;
	}

	/**
	 * 根据id查询一个单词
	 * 
	 * @param id
	 * @return
	 */
	public Word select(int id) {
		Word word = new Word();

		/* 从数据库取 */
		String sql = "select from wr_word where id=" + id + "order by id asc";
		Cursor cursor = db.rawQuery(sql, null);

		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			word.setId(cursor.getInt(cursor.getColumnIndex("id")));
			word.setEnglish(cursor.getString(cursor.getColumnIndex("english")));
			word.setChinese(cursor.getString(cursor.getColumnIndex("chinese")));
			word.setProperty(cursor.getString(cursor.getColumnIndex("property")));
			word.setSoundmark(cursor.getString(cursor
					.getColumnIndex("soundmark")));
			word.setSentence(cursor.getString(cursor.getColumnIndex("sentence")));
			word.setSound(cursor.getString(cursor.getColumnIndex("sound")));
			word.setImage(cursor.getString(cursor.getColumnIndex("image")));
			word.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
			/* 使用转换器将Date转换为String存储 */
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			try {
				word.setCreatedTime(format.parse(cursor.getString(cursor
						.getColumnIndex("created_time"))));
				word.setModifiedTime(format.parse(cursor.getString(cursor
						.getColumnIndex("modified_time"))));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return word;

	}

	/**
	 * 插入新单词
	 * 
	 * @param word
	 * @return
	 */
	public boolean insert(Word word) {
		return true;
	}

	/**
	 * 更新单词
	 * 
	 * @param word
	 * @return
	 */
	public boolean update(Word word) {
		return true;
	}

	/**
	 * 标记删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		return true;
	}

	/**
	 * 将标记删除的单词全部删除
	 * 
	 * @return
	 */
	public boolean deleteByTask() {
		return true;
	}
}
