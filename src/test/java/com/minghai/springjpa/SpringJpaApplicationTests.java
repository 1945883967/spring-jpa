package com.minghai.springjpa;

import com.minghai.springjpa.repository.PersonJpaRepository;
import com.minghai.springjpa.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringJpaApplicationTests {

    @Autowired
    private PersonJpaRepository personRepository;
//    private Long id;

    @Test
    public void contextLoads() {
        Person person = new Person("minghai",20);
        personRepository.save(person);
    }

    @Test
    public void findPersonById(){
        long id = 1;
        Optional<Person> byId = personRepository.findById(id);
        System.out.println(byId.get());
    }

    @Test
    public void deleteById(){
        personRepository.deleteById(1L);
    }

    @Test
    public void testUpdate(){
        Person person = new Person("SnailClimb", 23);
        Person savedPerson = personRepository.save(person);
        // 更新 person 对象的姓名
        savedPerson.setName("UpdatedName");
        personRepository.save(savedPerson);
    }


    /**
     * 自定义查询
     */
    @Test
    public void testFindByIdOneself(){
        Optional<Person> minghai = personRepository.findByname("minghai");
        System.out.println(minghai.get());


        String personName = personRepository.findPersonNameById(4L);
        log.info("name = {}",personName);


        personRepository.updatePersonNameById("minghaiSpringData",4L);
    }

}
