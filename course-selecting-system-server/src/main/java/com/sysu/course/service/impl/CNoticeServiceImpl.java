package com.sysu.course.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.sysu.course.common.util.Result;
import com.sysu.course.dao.CNoticeDao;
import com.sysu.course.entity.Notice;
import com.sysu.course.service.CNoticeService;

@WebService
public class CNoticeServiceImpl implements CNoticeService{

	protected  Logger log = Logger.getLogger(getClass());

    @Resource
    private CNoticeDao noticeDao;
    
	public String queryNotice() {
		log.info("queryAllNotice");
        List<Notice> list = null;
        String result = "";
        try {
            list = noticeDao.getAllNotice();
            result = String.format(Result.RESULT_SUCCEED, JSON.toJSON(list));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("queryNotice :"+e.getMessage());
            result = String.format(Result.RESULT_FAIL, "001");
        }
        return result;
	}

	public String queryNoticeByCourseId(long courseId) {
		log.info("queryNoticeByCourseId");
        List<Notice> list = null;
        String result = "";
		try {
			list = noticeDao.getCourseNoticesById(courseId);
            result = String.format(Result.RESULT_SUCCEED, JSON.toJSON(list));
		} catch (Exception e) {
			e.printStackTrace();
            log.error("queryNoticeByCourseId :"+e.getMessage());
            result = String.format(Result.RESULT_FAIL, "002");
		}
		return result;
	}

	public String createNotice(Notice notice) {
		log.info("createNotice");
        String result = "";
		try {
			noticeDao.createNotice(notice);
            result = String.format(Result.RESULT_SUCCEED);
		} catch (Exception e) {
			e.printStackTrace();
            log.error("createNotice :"+e.getMessage());
            result = String.format(Result.RESULT_FAIL, "003");
		}
		return result;
	}

	public String deleteNotice(long courseId) {
		log.info("deleteNotice");
        String result = "";
		try {
			noticeDao.deleteNoticeById(courseId);
            result = String.format(Result.RESULT_SUCCEED);
		} catch (Exception e) {
			e.printStackTrace();
            log.error("deleteNotice :"+e.getMessage());
            result = String.format(Result.RESULT_FAIL, "004");
		}
		return result;
	}

	public String updateNotice(long courseId, Notice newNotice) {
		log.info("updateNotice");
        String result = "";
		try {
			noticeDao.updateNoticeById(courseId, newNotice);
            result = String.format(Result.RESULT_SUCCEED, JSON.toJSON(newNotice));
		} catch (Exception e) {
			e.printStackTrace();
            log.error("deleteNotice :"+e.getMessage());
            result = String.format(Result.RESULT_FAIL, "005");
		}
		return result;
	}


}
