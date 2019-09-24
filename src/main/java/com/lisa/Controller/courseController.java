package com.lisa.Controller;

import com.github.pagehelper.Page;
import com.lisa.common.JsonResult;
import com.lisa.entity.course;
import com.lisa.service.courseService;
import com.lisa.vo.courseInfo;
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
@RequestMapping("/course")
public class courseController {
    @Autowired
    private courseService service;
    @RequestMapping("/query.do")
    public JsonResult findAll(){
        JsonResult jsonResult = new JsonResult();
        try {
            List<course> all = service.findAll();
            jsonResult.setCode(0);
            jsonResult.setInfo(all);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
    }
    @RequestMapping("/query2.do")
    public Map<String,Object> findAll2(Integer page, Integer limit){
        List<courseInfo> list = service.findAll2(page, limit);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }
    @RequestMapping("/add.do")
    public JsonResult add(course s){
        JsonResult jsonResult = new JsonResult();
        try {
            service.add(s);
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
            course c = service.findById(Integer.parseInt(id));
            jsonResult.setCode(0);
            jsonResult.setInfo(c);
        } catch (Exception e) {
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
            e.printStackTrace();
        }
        return jsonResult;
    }
    @RequestMapping("/update.do")
    public JsonResult update(course s,HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult jsonResult = new JsonResult();
        try {
            s.setId(Integer.parseInt(id));
            service.update(s);
            jsonResult.setCode(0);
            jsonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
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
}
