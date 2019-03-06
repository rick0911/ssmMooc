package com.mage.action;

import com.mage.domain.Document;
import com.mage.service.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qfedu.domain.UserInfo;

import java.util.List;

@Controller
public class DocumentAction {

    @RequestMapping("UserInfo")
    public ModelAndView user DetailAction(String username,Integer userType) throws Exception{

        modelAndView.addObject(attributeName:"username",username);

    }