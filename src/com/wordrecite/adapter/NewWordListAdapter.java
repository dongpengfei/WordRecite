package com.wordrecite.adapter;

import java.util.List;

import com.wordrecite.activity.R;
import com.wordrecite.entity.Word;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewWordListAdapter extends BaseAdapter{
	Context context;
	List<Word> wordList;
	int[] colors;
	public NewWordListAdapter(Context context,List<Word> wordList,int[] colors){
		this.context=context;
		this.wordList=wordList;
		this.colors=colors;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return wordList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return wordList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView=LayoutInflater.from(context).inflate(R.layout.newword_item, null);
		LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.newword_item_ll);
		ll.setBackgroundColor(R.color.newword_list_clolor_first);
		TextView wordText=(TextView) convertView.findViewById(R.id.item_newword_new);
		wordText.setText(wordList.get(position).getEnglish().toString());
		TextView typeText=(TextView) convertView.findViewById(R.id.item_newword_type);
		typeText.setText(wordList.get(position).getProperty().toString());
		TextView translateText=(TextView) convertView.findViewById(R.id.item_newword_translate);
		translateText.setText(wordList.get(position).getChinese().toString());
		return convertView;
	}

}
