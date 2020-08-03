package cn.alan;

import cn.alan.beans.ArEmployee;
import cn.alan.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.geom.Area;
import java.util.List;

public class TestAr {
    //
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);

    // 1. AR(Active Record)模式插入
    @Test
    public void testInsert() {
        ArEmployee arEmployee = new ArEmployee();
        arEmployee.setLastName("Peter1");
        arEmployee.setEmail("peter1@sina.com");
        arEmployee.setGender("男");

        boolean result = arEmployee.insert();
        System.out.println(result);
    }

    // 2. AR模式更新
    @Test
    public void testUpdate() {
        ArEmployee arEmployee = new ArEmployee();
        arEmployee.setId(16);
        arEmployee.setLastName("Peter2");
        arEmployee.setEmail("peter2@sina.com");
        arEmployee.setGender("男");

        boolean result = arEmployee.updateById();
        System.out.println(result);
    }

    // 3. AR查询
    @Test
    public void testSelect() {
        // 3.1 selectById(id)
        ArEmployee arEmployee = new ArEmployee();
        // ArEmployee result = arEmployee.selectById(16);
        // 3.2 selectById()
        //arEmployee.setId(16);
        //ArEmployee result = arEmployee.selectById();
        //System.out.println(result);

        // 3.3 selectAll()
        List<ArEmployee> list = arEmployee.selectAll();
        System.out.println(list);

        // 3.4 selectList()
        list = arEmployee.selectList(new EntityWrapper<ArEmployee>().like("lastName","Tom"));
        System.out.println(list);

        // 3.5 selectCount()
        Integer count = arEmployee.selectCount(new EntityWrapper<ArEmployee>().eq("gender","男"));
        System.out.println(count);
    }

    // 4. AR delete
    @Test
    public void testDelete(){
        ArEmployee arEmployee = new ArEmployee();
        // 4.1 deleteById(id)
        // boolean result = arEmployee.deleteById(8);
        // 4.2 deleteById()，注意，这块的处理是：删除不存在的数据，逻辑上也是成功的
        arEmployee.setId(8);
        boolean result = arEmployee.deleteById();
        System.out.println(result);

        // 4.3 条件删除
        boolean res = arEmployee.delete(new EntityWrapper<ArEmployee>().like("lastName","Rose"));
        System.out.println(res);
    }

    // 5. 分页
    @Test
    public void testPage(){
        ArEmployee arEmployee = new ArEmployee();
        Page<ArEmployee> page = arEmployee.selectPage(new Page<ArEmployee>(1,3),
                new EntityWrapper<ArEmployee>().like("lastName","Tom"));
        List<ArEmployee> list = page.getRecords();
        System.out.println(list);

    }
}
