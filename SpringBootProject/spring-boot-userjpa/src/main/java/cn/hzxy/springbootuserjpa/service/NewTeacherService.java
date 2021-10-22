package cn.hzxy.springbootuserjpa.service;

import cn.hzxy.springbootuserjpa.entity.NewTeacher;

import java.util.List;

public interface NewTeacherService {
    NewTeacher findById(String id);

    List<NewTeacher> findAll();

    NewTeacher sava(NewTeacher newTeacher);

    void delete(String id);
}
