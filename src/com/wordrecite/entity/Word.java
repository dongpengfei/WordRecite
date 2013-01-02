package com.wordrecite.entity;

import java.util.Date;

public class Word {

	private int id; // 序号
	private String english; // 英文
	private String chinese; // 中文
	private String property; // 词性
	private String soundmark; // 音标
	private String sentence; // 例句
	private String sound; // 声音文件
	private String image; // 图片文件
	private int status; // 状态，0：删除或未审核，1：通过审核、正常使用，2、需要复习
	private Date createdTime; // 创建时间
	private Date modifiedTime; // 最后更改时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getSoundmark() {
		return soundmark;
	}

	public void setSoundmark(String soundmark) {
		this.soundmark = soundmark;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
