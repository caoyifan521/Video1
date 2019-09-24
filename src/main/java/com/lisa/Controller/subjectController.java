package com.lisa.Controller;

import com.lisa.common.JsonResult;
import com.lisa.entity.subject;
import com.lisa.service.subjectService;
import com.lisa.vo.subjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/subject")
public class subjectController {
    @Autowired
    private subjectService service;
    @RequestMapping("/query.do")
    public JsonResult findAll(){
        JsonResult jsonResult = new JsonResult();
        try {
            List<subject> list = service.findAll();
            jsonResult.setCode(0);
            jsonResult.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(1);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
    }
    @RequestMapping("/info.do")
    public JsonResult findSubJectInfo(HttpServletRequest request){
        String id = request.getParameter("id");
        JsonResult result = new JsonResult();
        try {
            subjectInfo list = service.findSubJectInfo(Integer.parseInt(id));
            System.out.println(list);
            result.setCode(1);
            result.setInfo(list);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }
        return  result;
    }
}
