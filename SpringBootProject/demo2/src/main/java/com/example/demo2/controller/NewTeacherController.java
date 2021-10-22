package com.example.demo2.controller;

import com.example.demo2.entity.NewTeacher;
import com.example.demo2.service.NewTeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/newTeacher/*")
public class NewTeacherController {
    @Resource
    private NewTeacherService newTeacherService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    /*
    里面的required=false表示非必须存在的，忽略当前要注入的bean，如果有直接注入
    没有跳过，不会报错，如果不写默认的是true,在运行注入的时候，该bean必须存在，否则就会注入失败，没有的的话就直接报错的哦！！！
     */
    @RequestMapping("/targetLogin")
    public String targetLogin(@RequestParam(value = "username",required = false) String username,
                              @RequestParam(value = "password",required = false) String password,
                              Model model) throws IOException{
        List<NewTeacher> newTeacherList = newTeacherService.findALL();
        for(NewTeacher newTeacher:newTeacherList){
            if (newTeacher.getName().equals(username)  && newTeacher.getPassword().equals(password)) {
                System.out.println("SUCCESS");
                model.addAttribute("newTeachers", newTeacherList);
                return "newTeacher";
            }
        }
        System.out.println("ERROR");
        return "error";
    }
    @RequestMapping("registerAdd")
    public String registerAdd(@RequestParam(value = "username",required = false) String username,
                              @RequestParam(value = "password",required = false) String password,
                              @RequestParam(value = "repassword",required = false) String repassword) throws IOException{
        int index = 0;
        if (!password.equals(repassword)) {
            System.out.println("Password and rePassword is not the same!");
            return "repeatUser";
        }
        List<NewTeacher> newTeacherList = newTeacherService.findALL();
        for(NewTeacher newTeacher:newTeacherList){
            if (newTeacher.getName().equals(username)) {
                System.out.println("RepeatUser");
                return "repeatUser";
            }
            index = Integer.parseInt(newTeacher.getId());
        }

        NewTeacher teacher = new NewTeacher();
        teacher.setId(String.valueOf(index+1));
        teacher.setName(username);
        teacher.setPassword(password);
        newTeacherService.save(teacher);
        return "registerSuccess";
    }
}
