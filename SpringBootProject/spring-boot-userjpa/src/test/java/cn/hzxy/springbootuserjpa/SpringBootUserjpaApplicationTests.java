package cn.hzxy.springbootuserjpa;

import cn.hzxy.springbootuserjpa.entity.NewTeacher;
import cn.hzxy.springbootuserjpa.service.NewTeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUserjpaApplicationTests {
    @Resource
    private NewTeacherService newTeacherService;

    @Test
    public void testRepository() {
        List<NewTeacher> teacherList = newTeacherService.findAll();
        System.out.println("findAll():" + teacherList.size());
    }

}
