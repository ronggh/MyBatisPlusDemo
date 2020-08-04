package cn.alan;

import cn.alan.beans.ArEmployee;
import cn.alan.beans.Employee;
import cn.alan.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMySqlInjector {
    //
    ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper employeeMapper = context.getBean("employeeMapper",EmployeeMapper.class);

    // 1.
    @Test
    public void testMySqlInjector(){
        Integer result = employeeMapper.deleteAll();
        System.out.println("result : " + result);
    }
}
