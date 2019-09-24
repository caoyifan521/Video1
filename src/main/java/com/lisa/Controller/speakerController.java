package com.lisa.Controller;

import com.github.pagehelper.Page;
import com.lisa.common.JsonResult;
import com.lisa.entity.speaker;
import com.lisa.service.speakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/speaker")
@ResponseBody
public class speakerController {
    @Autowired
    private speakerService service;
    @RequestMapping("/query.do")
    public JsonResult findAll(){
        JsonResult result = new JsonResult();
        try {
            List<speaker> list = service.findAll();
            result.setCode(0);
            result.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(null);
        }
        return result;
    }
    @RequestMapping("/query2.do")
    public Map<String,Object> findAll2(Integer page,Integer limit){
        List<speaker> list = service.findAll2(page, limit);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }
    @RequestMapping("/add.do")
    public JsonResult add(speaker s){
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
    public JsonResult queryById(HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult jsonResult = new JsonResult();
        try {
            speaker s = service.queryById(Integer.parseInt(id));
            jsonResult.setCode(0);
            jsonResult.setInfo(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
        }

        return jsonResult;
    }
    @RequestMapping("/update.do")
    public JsonResult update(speaker s,HttpServletRequest request){
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
