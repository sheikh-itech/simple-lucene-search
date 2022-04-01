package com.search.lucene.beans;

/**
 * @author Hapheej
 *
 */
public class Text {

	private String text;
	private String textColor;
	private String textFamily;
	private String textSize;
	private String height;
	private String width;
	private Long textId;
	private byte pageNo;

	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getTextFamily() {
		return textFamily;
	}
	public void setTextFamily(String textFamily) {
		this.textFamily = textFamily;
	}
	public String getTextSize() {
		return textSize;
	}
	public void setTextSize(String textSize) {
		this.textSize = textSize;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public Long getTextId() {
		return textId;
	}
	public void setTextId(Long textId) {
		this.textId = textId;
	}
	public byte getPageNo() {
		return pageNo;
	}
	public void setPageNo(byte pageNo) {
		this.pageNo = pageNo;
	}
	
}
