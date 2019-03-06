package com.qfedu.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfo{

    @RequestMapping("userDetail")
    public ModelAndView user DetailAction(String username,Integer userType) throws Exception{

        modelAndView.addObject(attributeName:"username",username);


        if(userType==1){
            return "/studentdetail.html";
        }
        else if (userType==2){
            return "/teacherdetial.html";
        }else{
            throw new Exception("非法操作。。。");
        }

        return modelAndView;
    }
}