package com.example.listviewwithcheckbox;

public class SingleRow {

	String title;
	Boolean isChecked = false;

	SingleRow(String title, Boolean isChecked) {
		this.title = title;
		this.isChecked = isChecked;
	}

	public String getTitle() {
		return this.title;
	}

	public boolean isSelected() {
		return this.isChecked;
	}

	public void setSelected(boolean selected) {
		this.isChecked = selected;
	}

}