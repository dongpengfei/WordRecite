package com.wordrecite.adapter;

import com.wordrecite.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewWordListAdapter extends BaseAdapter{
	String[] words;
	String[] types;
	String[] translates;
	Context context;
	int[] colors;
	public NewWordListAdapter(String[] words,String[] types,String[] translates,Context context,int[] colors){
		this.words=words;
		this.types=types;
		this.translates=translates;
		this.context=context;
		this.colors=colors;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return words.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return words[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView=LayoutInflater.from(context).inflate(com.wordrecite.R.layout.newword_item, null);
		LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.newword_item_ll);
		ll.setBackgroundColor(R.color.newword_list_clolor_first);
		TextView wordText=(TextView) convertView.findViewById(R.id.item_newword_new);
		wordText.setText(words[position]);
		TextView typeText=(TextView) convertView.findViewById(R.id.item_newword_type);
		typeText.setText(types[position]);
		TextView translateText=(TextView) convertView.findViewById(R.id.item_newword_translate);
		translateText.setText(translates[position]);
		return convertView;
	}

}
