package com.lisa.Controller;

import com.lisa.common.JsonResult;
import com.lisa.entity.admin;
import com.lisa.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/admin")
public class adminController {
    @Autowired
    private adminService service;

    @RequestMapping("/login.do")
    public JsonResult login(String username, String password, HttpSession session){
        JsonResult result = new JsonResult();
        try {
            admin ad = service.login(username,password);
            session.setAttribute("admin",ad);
            result.setCode(0);
            result.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setInfo(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/info.do")
    public JsonResult getInfo(HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        HttpSession session = request.getSession();
        admin admin = (admin) session.getAttribute("admin");
        System.out.println(admin.getUsername());
        if (admin!=null){
            jsonResult.setCode(1);
            jsonResult.setInfo(admin.getUsername());
            return jsonResult;
        }else {
            jsonResult.setCode(0);
            jsonResult.setInfo(null);
            return jsonResult;
        }

    }
}
