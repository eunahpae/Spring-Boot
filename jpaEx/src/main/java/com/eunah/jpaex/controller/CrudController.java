package com.eunah.jpaex.controller;

import com.eunah.jpaex.entity.CrudEntity;
import com.eunah.jpaex.repository.CrudentityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CrudController {

    private final CrudentityRepository crudentityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("search")
    public String searchAllMember() {
        return crudentityRepository.findAll().toString();
    }

    @GetMapping("searchParamRepo")
    public String searchParamRepoMember(@RequestParam(value = "name") String name) {
        return crudentityRepository.searchParamRepo(name).toString();
    }

    @GetMapping("insert")
    public String insertMember(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        if (crudentityRepository.findById(name).isPresent()) {
            return "동일한 이름이 이미 있습니다.";
        } else {
            CrudEntity entity = CrudEntity.builder().name(name).age(age).build();
            crudentityRepository.save(entity);
            return "이름 : " + name + " 나이 : " + age + "으로 추가 되었습니다.";
        }
    }

    @GetMapping("update")
    public String updateMember(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age) {
        if (crudentityRepository.findById(name).isEmpty()) {
            return "입력한 " + name + "이 존재하지 않습니다.";
        } else {
            crudentityRepository.save(CrudEntity.builder().name(name).age(age).build());
            return name + "의 나이를 " + age + "로 변경 완료";
        }
    }
    @GetMapping("delete")
    public String deleteMember(@RequestParam(value = "name") String name) {
        if (crudentityRepository.findById(name).isEmpty()) {
            return "입력한 " + name + "이 존재하지 않습니다.";
        } else {
            CrudEntity entity;
            crudentityRepository.delete(entity = CrudEntity.builder().name(name).build());
            return name + "삭제 완료";
        }
    }

}
