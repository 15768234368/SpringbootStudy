package com.example.demo2.service.impl;

import com.example.demo2.entity.NewTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo2.repository.TeacherRepository;
import com.example.demo2.service.NewTeacherService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class NewTeacherServiceImpl implements NewTeacherService {

    @Resource(name = "teacherRepository")
    private TeacherRepository teacherRepository;

    @Override
    public NewTeacher findById(String id) {
        return teacherRepository.findById(id).orElse(null);
//        return teacherRepository.findById(id).get();
    }

    @Override
    public List<NewTeacher> findALL() {
        return teacherRepository.findAll();
//        return teacherRepository.findAll();
    }


    @Override
    public NewTeacher save(NewTeacher newTeacher) {
        //出现空指针异常
//        String error = null;
//        error.split("/");
        return teacherRepository.save(newTeacher);
//        return teacherRepository.save(newTeacher);
    }

    @Override
    public void delete(String id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Page<NewTeacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public List<NewTeacher> findByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public List<NewTeacher> findByNameLike(String name) {
        return teacherRepository.findByNameLike(name);
    }

    @Override
    public List<NewTeacher> findByIdIn(Collection<String> ids) {
        return teacherRepository.findByIdIn(ids);
    }

}