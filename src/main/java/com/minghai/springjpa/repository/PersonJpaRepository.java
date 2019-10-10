package com.minghai.springjpa.repository;

import com.minghai.springjpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PersonJpaRepository  extends JpaRepository<Person, Long> {

    /**
     * 自定义查询，根据姓名查询person
     * @param name
     * @return
     */
    @Query("select p from Person p where p.name = :name")
    Optional<Person> findByname(@Param("name") String name);

    @Query("select p.name from Person p where p.id = :id")
    String findPersonNameById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Person p set p.name = ?1 where p.id = ?2")
    void updatePersonNameById(String name, Long id);
}
