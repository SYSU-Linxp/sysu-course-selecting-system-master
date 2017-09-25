package com.sysu.course.entity;

import java.io.Serializable;

public class Evaluation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8867531388866627648L;

    private long cevlId;
    private long courseId;
    private long stuId;
    private float attendance;
    private float interst;
    private float hwamount;
    private float hwhard;
    
	public long getCevlId() {
		return cevlId;
	}
	public void setCevlId(long cevlId) {
		this.cevlId = cevlId;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public long getStuId() {
		return stuId;
	}
	public void setStuId(long stuId) {
		this.stuId = stuId;
	}
	public float getAttendance() {
		return attendance;
	}
	public void setAttendance(float attendance) {
		this.attendance = attendance;
	}
	public float getInterst() {
		return interst;
	}
	public void setInterst(float interst) {
		this.interst = interst;
	}
	public float getHwamount() {
		return hwamount;
	}
	public void setHwamount(float hwamount) {
		this.hwamount = hwamount;
	}
	public float getHwhard() {
		return hwhard;
	}
	public void setHwhard(float hwhard) {
		this.hwhard = hwhard;
	}
    
    
}
