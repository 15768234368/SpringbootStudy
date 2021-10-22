package cn.hzxy.springbootuserjpa.service.impl;

import cn.hzxy.springbootuserjpa.entity.NewTeacher;
import cn.hzxy.springbootuserjpa.repository.TeacherRepository;
import cn.hzxy.springbootuserjpa.service.NewTeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewTeacherServiceImpl implements NewTeacherService {
    @Resource
    private TeacherRepository teacherRepository;


    @Override
    public NewTeacher findById(String id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public List<NewTeacher> findAll() {
        List<NewTeacher> newTeacherList = teacherRepository.findAll();
        return newTeacherList;
    }

    @Override
    public NewTeacher sava(NewTeacher newTeacher) {
        return teacherRepository.save(newTeacher);
    }

    @Override
    public void delete(String id) {
        teacherRepository.deleteById(id);
    }
}
