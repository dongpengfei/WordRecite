package com.wordrecite.activity.word;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.wordrecite.R;
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
		
		ListView newWordList=(ListView) findViewById(R.id.lv_newwords);
		String[] words={"mark","mark","mark"};
		String[] types={"n.","n.","n."};
		String[] translates={"标记","标记","标记"};
		int[] colors={R.color.newword_list_clolor_first,R.color.newword_list_color_second,R.color.newword_list_color_third};
		
		NewWordListAdapter newAdapter=new NewWordListAdapter(words, types, translates, this, colors);
		newWordList.setAdapter(newAdapter);	
		
		MachineMetrics ScreenSize=new MachineMetrics(this);
		
		TextView prior =(TextView) findViewById(R.id.newword_list_prior);
		TextView next=(TextView) findViewById(R.id.newword_list_next);
		prior.setWidth((ScreenSize.getScreenWidth())/2);
		next.setWidth((ScreenSize.getScreenWidth())/2);
		//prior.setBackgroundColor(R.color.newword_prior_color);
		prior.setTextSize(30);
		prior.setText("前一页");
		//next.setBackgroundColor(R.color.newword_prior_color);
		next.setTextSize(30);
		next.setText("后一页");
	}
}
