package cn.alan;

import cn.alan.beans.Employee;
import cn.alan.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.management.counter.Variability;

import javax.sql.DataSource;
import java.sql.Connection;

public class TestMyBatisPlus {
    //
    private ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");

    //
    private EmployeeMapper employeeMapper = context.getBean("employeeMapper",EmployeeMapper.class);

    @Test
    public void testDataSource() throws Exception{
        DataSource ds = context.getBean("dataSource",DataSource.class);
        System.out.println(ds);
        Connection connection = ds.getConnection();
        System.out.println(connection);
    }


    //
    @Test
    public void testInsert(){
        Integer result = employeeMapper.insert(new Employee("Tom","男"));
        System.out.println("Insert Result:" + result);
    }
}
