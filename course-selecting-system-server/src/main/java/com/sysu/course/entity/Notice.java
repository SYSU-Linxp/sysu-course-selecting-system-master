package com.sysu.course.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2193008398423790648L;
    
	private long noticeId;
	private String title;
	private String content;
	private Timestamp createtime;
	private long courseId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(long noticeId) {
		this.noticeId = noticeId;
	}
	public Timestamp getTimestamp() {
		return createtime;
	}
	public void setTimestamp(Timestamp createtime) {
		this.createtime = createtime;
	}

}
