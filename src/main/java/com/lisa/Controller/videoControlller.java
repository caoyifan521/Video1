package com.lisa.Controller;

import com.github.pagehelper.Page;
import com.lisa.common.JsonResult;
import com.lisa.entity.video;
import com.lisa.service.videoService;
import com.lisa.vo.videoInfo;
import com.lisa.vo.videoInfo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/video")
public class videoControlller {
    @Autowired
    private videoService service;
    @RequestMapping("/query.do")
    public Map<String,Object> findByCondition(Integer page,Integer limit,String title,String speakerName,String courseTitle){
        List<videoInfo> list = service.findAll(page, limit, title, speakerName, courseTitle);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }
    @RequestMapping("/add.do")
    public JsonResult addVideo(video v){
        JsonResult result = new JsonResult();
        try {
            service.addVideo(v);
            result.setCode(0);
            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(e.getMessage());
        }


        return result;

    }
    @RequestMapping("/delete.do")
    public JsonResult deleteById(Integer id){
        JsonResult jsonResult = new JsonResult();
        try {
            service.deleteById(id);
            jsonResult.setCode(0);
            jsonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
    }
    @RequestMapping("/queryById.do")
    public JsonResult findById(HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult jsonResult = new JsonResult();
        try {
            List<videoInfo2> list = service.findById(Integer.parseInt(id));
            jsonResult.setCode(0);
            jsonResult.setInfo(list);
        } catch (Exception e) {
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
            e.printStackTrace();
        }
        return jsonResult;
    }
    @RequestMapping("/update.do")
    public JsonResult update(video v,HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult jsonResult = new JsonResult();
        try {
            v.setId(Integer.parseInt(id));
            service.update(v);
            jsonResult.setCode(0);
            jsonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
    }
    @RequestMapping("/getvideo.do")
    public JsonResult getVideo(HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult result = new JsonResult();
        try {
            String videourl = service.findById1(Integer.parseInt(id));
            result.setCode(0);
            result.setInfo(videourl);
        } catch (NumberFormatException e) {
            result.setCode(1);
            result.setInfo(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("/play.do")
    public JsonResult playvideo(HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult result = new JsonResult();
        try {
            videoInfo list = service.findAll2(Integer.parseInt(id));
            result.setCode(0);
            result.setInfo(list);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/query2.do")
    public JsonResult findALL2(){
        JsonResult jsonResult = new JsonResult();
        try {
            List<videoInfo2> list = service.findAll3();
            jsonResult.setCode(0);
            jsonResult.setInfo(list);
        } catch (Exception e) {
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
            e.printStackTrace();
        }
        return jsonResult;
    }
    @RequestMapping("/deleteAll.do")
    public JsonResult deleteManyVideo(String ids) {
//        System.err.println(ids);
        String[] idArr = ids.split(",");
        int[] id = new int[idArr.length];
        for (int i = 0; i <idArr.length;i++ ){
            id[i] = Integer.parseInt(idArr[i]);
        }
        service.deleteManyVideo(id);

        return new JsonResult(0, null);

    }
}
