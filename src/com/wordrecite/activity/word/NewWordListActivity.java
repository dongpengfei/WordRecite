package com.wordrecite.activity.word;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.wordrecite.activity.R;
import com.wordrecite.adapter.NewWordListAdapter;
import com.wordrecite.common.MachineMetrics;
import com.wordrecite.db.DBHandler;
import com.wordrecite.entity.Word;
import com.wordrecite.module.word.WordManager;

public class NewWordListActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newword_list);
		
		int offset=0;
		WordManager newWord=new WordManager(this);
		List<Word> wordList =newWord.select(offset, 5);
		ListView newWordList=(ListView) findViewById(R.id.lv_newwords);
		int[] colors={R.color.newword_list_clolor_first,R.color.newword_list_color_second,R.color.newword_list_color_third};
		
		NewWordListAdapter newAdapter=new NewWordListAdapter(this, wordList,colors);
		newWordList.setAdapter(newAdapter);	
		MachineMetrics ScreenSize=new MachineMetrics(this);
		TextView prior =(TextView) findViewById(R.id.newword_list_prior);
		TextView next=(TextView) findViewById(R.id.newword_list_next);
		prior.setWidth((ScreenSize.getScreenWidth())/2);
		next.setWidth((ScreenSize.getScreenWidth())/2);
		//prior.setBackgroundColor(R.color.newword_prior_color);
		prior.setTextSize(30);
		prior.setText("上一页");
		//next.setBackgroundColor(R.color.newword_prior_color);
		next.setTextSize(30);
		next.setText("下一页");
	}
}
