package cn.alan;

import cn.alan.mapper.EmpMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLogicDelete {
    ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmpMapper empMapper = context.getBean("empMapper",EmpMapper.class);

    @Test
    public void testDeleteLogic(){
        Integer result = empMapper.deleteById(8);
        System.out.println("result :" + result);
    }

    // 

}
