package com.cn.bafang.backstage.manage.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/kotlin")
class KotlinTestController {

    @RequestMapping("/findUsers")
    @ResponseBody
    fun getUsers():String{
        return "hello";
    }
}