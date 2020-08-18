package cn.alan;

import cn.alan.json.Person;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJson {
    @Test
    public void testPerson(){
        Person person = new Person();
        person.setId(1);
        person.setName("Tom");
        person.setAge(20);

        System.out.println(person);

        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);
    }

    @Test
    public void testPersonList(){
        List<Person> list = new ArrayList<>();

        Person person = new Person();
        person.setId(1);
        person.setName("Tom");
        person.setAge(20);

        Person person2 = new Person();
        person2.setId(2);
        person2.setName("Marry");
        person2.setAge(30);

        list.add(person);
        list.add(person2);

        String jsonString  = JSON.toJSONString(list);
        System.out.println(jsonString);

    }
}
