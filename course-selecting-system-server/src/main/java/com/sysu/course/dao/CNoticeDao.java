package com.sysu.course.dao;

import java.util.List;

import com.sysu.course.entity.Notice;

public interface CNoticeDao {
	
	public List<Notice> getAllNotice();
    public List<Notice> getCourseNoticesById(long courseId);
    public void createNotice(Notice notice);
    public void updateNoticeById(long courseId, Notice newNotice);
    public void deleteNoticeById(long courseId);
}
