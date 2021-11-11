package com.example.demo2.listener;

import com.example.demo2.entity.NewTeacher;

import com.example.demo2.service.NewTeacherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class NewTeacherListener implements ServletContextListener {
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private NewTeacherService newTeacherService;
    private static final String ALL_NEWTEACHER = "ALL_NEWTEACHER_LIST";

    Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);
//        newTeacherService = WebApplicationContextUtils
//                            .getWebApplicationContext(sce.getServletContext())
//                            .getBean(NewTeacherServiceImpl.class);
//
//        redisTemplate = (RedisTemplate) WebApplicationContextUtils
//                        .getRequiredWebApplicationContext(sce.getServletContext())
//                        .getBean("redisTemplate");
        //查询数据库中全部教室
        List<NewTeacher> newTeachersList = newTeacherService.findALL();
        //清除缓存
        redisTemplate.delete(ALL_NEWTEACHER);
        //将查出的信息存放到redis缓存中
//        redisTemplate.opsForValue()
        redisTemplate.opsForList().leftPushAll(ALL_NEWTEACHER,newTeachersList);
        List<NewTeacher> queryTeacherList = redisTemplate.opsForList().range(ALL_NEWTEACHER, 0, -1);
        System.out.println("缓存中目前的用户数有：" + queryTeacherList.size() + "人");
        System.out.println("ServletContext上下文初始化！");
        logger.info("缓存中目前的用户数有：" + queryTeacherList.size() + "人");
        logger.info("ServletContext上下文初始化！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext上下文销毁！");
        logger.info("ServletContext上下文销毁！");
    }
}
