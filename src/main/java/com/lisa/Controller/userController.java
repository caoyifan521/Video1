package com.lisa.Controller;

import com.lisa.common.JsonResult;
import com.lisa.entity.user;
import com.lisa.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@ResponseBody
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService service;
    @RequestMapping("/login.do")
    public JsonResult login(String email, String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        JsonResult jsonResult = new JsonResult();
        try {
            user u = service.login(email, password);
            session.setAttribute("user",u);
            jsonResult.setCode(1);
            jsonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(0);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
    }
    @RequestMapping("/regist.do")
    public JsonResult regist(String email,String password,String pswagain){
        JsonResult jsonResult = new JsonResult();
        try {
            service.add(email, password, pswagain);
            jsonResult.setCode(1);
            jsonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(0);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
    }
    @RequestMapping("/info.do")
    public JsonResult getInfo(HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        HttpSession session = request.getSession();
        user user = (user) session.getAttribute("user");

        if (user!=null){
           jsonResult.setCode(1);
           jsonResult.setInfo(user.getEmail());
            return jsonResult;
        }else {
            jsonResult.setCode(0);
            jsonResult.setInfo(null);
            return jsonResult;
        }

    }
    @RequestMapping("/myInfo.do")
    public JsonResult getMyInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        JsonResult result = new JsonResult();
        user us = (user)session.getAttribute("user");
        user user = service.findByid(us.getId());
        if (user!=null){
            result.setCode(1);
            result.setInfo(user);
            return result;
        }else {
            result.setCode(0);
            result.setInfo("未登录");
            return result;
        }
    }
    @RequestMapping("/update.do")
    public JsonResult update(user u){
        JsonResult jsonResult = new JsonResult();
        try {
            service.update(u);
            jsonResult.setCode(1);
            jsonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(0);
            jsonResult.setInfo(e.getMessage());
        }
        return jsonResult;
    }
    @RequestMapping("/upload.do")
    public JsonResult uploadFile2(@RequestParam("file") MultipartFile upfile, HttpSession session){

        user u = (user) session.getAttribute("user");
        if(u == null){
            new JsonResult(0, "未登陆");
        }
        // 上传文件的目录
        String dir = "F:/upload";
        // 获取上传的文件的文件名
        String fileName = upfile.getOriginalFilename();

        // 判断目录是否存在
        File dirFile = new File(dir);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }



        // 要保存的文件的File对象
        File newFile = new File(dir, fileName);
        try {
            // 保存文件
            upfile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取上传文件的输入流，进行流的拷贝，也可以实现文件的上传
        //InputStream inputStream = upfile.getInputStream();

        // 操作数据库
        service.updateHeadImg(u.getId(), "/upload/" + fileName);

        return new JsonResult(1, "上传成功");
    }
}
