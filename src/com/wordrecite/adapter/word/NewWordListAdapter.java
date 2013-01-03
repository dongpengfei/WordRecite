package com.wordrecite.adapter.word;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wordrecite.activity.R;
import com.wordrecite.entity.Word;

public class NewWordListAdapter extends BaseAdapter {
	private Context context;
	private List<Word> wordList;
	private int[] colors;

	public NewWordListAdapter(Context context, List<Word> wordList, int[] colors) {
		this.context = context;
		this.wordList = wordList;
		this.colors = colors;
	}

	@Override
	public int getCount() {
		return wordList.size();
	}

	@Override
	public Object getItem(int position) {
		return wordList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(
				R.layout.newword_item, null); // 获得View
		convertView.setBackgroundColor(context.getResources().getColor(
				colors[position]));

		/* 填充Item */
		TextView wordText = (TextView) convertView
				.findViewById(R.id.item_newword_new);
		wordText.setText(wordList.get(position).getEnglish().toString());
		TextView typeText = (TextView) convertView
				.findViewById(R.id.item_newword_type);
		typeText.setText(wordList.get(position).getProperty().toString());
		TextView translateText = (TextView) convertView
				.findViewById(R.id.item_newword_translate);
		translateText.setText(wordList.get(position).getChinese().toString());

		return convertView;
	}
}
