package com.sysu.course.service;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sysu.course.entity.Notice;

@WebService
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public interface CNoticeService {
    @GET
    @Path("/notice") 
    public String queryNotice();
    
    @GET
    @Path("/notice/{courseId}") 
    public String queryNoticeByCourseId(@PathParam("courseId")long courseId);
    
    @POST
    @Path("notice")
    public String createNotice(Notice notice);
    
    @DELETE
    @Path("notice/{courseId}")
    public String deleteNotice(@PathParam("courseId")long courseId);
    
    @PUT
    @Path("notice/{courseId}")
    public String updateNotice(@PathParam("courseId")long courseId, Notice newNotice);
}
