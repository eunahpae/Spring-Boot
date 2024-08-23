package com.eunah.jpaex.repository;

import com.eunah.jpaex.entity.CrudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudentityRepository extends JpaRepository<CrudEntity, String> {
    @Query(value = "select name, age from sample_member where name= :name", nativeQuery = true)
    List<CrudEntity> searchParamRepo(@Param("name") String name);
}
