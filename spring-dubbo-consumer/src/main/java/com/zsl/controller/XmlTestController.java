package com.zsl.controller;

import com.zsl.pojo.Student;
import com.zsl.service.DubboTestService;
import com.zsl.service.RestTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:zsl
 * @Despriction:
 * @Date:Create in 2019/6/2 18:26
 * @Modify:
 */
@RestController
@RequestMapping("/xml")
public class XmlTestController {

    @Autowired
    private DubboTestService dubboTestService;

    @Autowired
    private RestTestService restTestService;

    @GetMapping("/dubbo/{id : \\d+}")
    public Student dubboMethod(@PathVariable("id") Integer id){
        Student s = dubboTestService.dubboTestMethod(id);
        return s;
    }

    @GetMapping("/rest/get/{id : \\d+}")
    public Student restGetMethod(@PathVariable("id") Integer id){
        Student student = restTestService.restGetTestMethod(id);
        return student;
    }
    
    @PostMapping("/rest/post")
    public String  restPostMethod(@RequestBody Student student){
        String s = restTestService.restPostTestMethod(student);
        return s;
    }
}