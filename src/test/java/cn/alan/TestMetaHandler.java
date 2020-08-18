package cn.alan;

import cn.alan.beans.Emp;
import cn.alan.mapper.EmpMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.SchemaOutputResolver;

public class TestMetaHandler {
    ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmpMapper empMapper = context.getBean("empMapper",EmpMapper.class);

    @Test
    public void testInsert(){
        Emp emp = new Emp();
        emp.setName("Tom2");
        emp.setDeleteFlag(1);
        emp.setCreateTime("2222-12-23");
        empMapper.insert(emp);

        //
//        emp = empMapper.selectById(emp.getId());
//        System.out.println(emp);
    }

    @Test
    public void testUpdate(){
        Emp emp = new Emp();
        emp.setId(8);
        emp.setName("Marry");
        empMapper.updateById(emp);

        //
//        System.out.println(empMapper.selectById(2));
    }
}
