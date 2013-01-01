package com.wordrecite.common;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;

public class MachineMetrics {
	private DisplayMetrics displayMetrics;
	private Activity activity;

	public MachineMetrics(Activity activity) {
		this.displayMetrics = new DisplayMetrics();
		this.activity = activity;
		activity.getWindowManager().getDefaultDisplay()
				.getMetrics(displayMetrics);
	}

	/**
	 * 获取屏幕高度
	 * 
	 * @return
	 */
	public int getScreenHeight() {
		int height = displayMetrics.heightPixels;
		if (isEmulator()) {
			return height;
		} else {
			return (int) (height * displayMetrics.density);
		}
	}

	/**
	 * 获取屏幕宽度
	 * 
	 * @return
	 */
	public int getScreenWidth() {
		int width = displayMetrics.widthPixels;
		if (isEmulator()) {
			return width;
		} else {
			return (int) (width * displayMetrics.density);
		}
	}

	/**
	 * 获取屏幕密度
	 * 
	 * @return
	 */
	public float getDentity() {
		return displayMetrics.density;
	}

	/**
	 * 判断是否是android虚拟机
	 * 
	 * @return
	 */
	public final boolean isEmulator() {
		return Build.BRAND.toLowerCase().indexOf("generic") != -1
				&& Build.MODEL.toLowerCase().indexOf("sdk") != -1;
	}

}
