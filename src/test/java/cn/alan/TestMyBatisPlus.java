package cn.alan;

import cn.alan.beans.Employee;
import cn.alan.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    // insert()：方法根据实体对象非空属性值进行插入
    @Test
    public void testInsert(){
        Employee employee = new Employee("Tom2","男");
        employee.setSalary(20000.0);
        // insert()：方法根据实体对象非空属性值进行插入
        Integer result = employeeMapper.insert(employee);

        System.out.println("Insert Result:" + result);

        Integer keyId = employee.getId();
        System.out.println("KeyId:" + keyId);
    }

    // 2. insertAllColumn()，方法根据实体对象非空属性值进行插入,空值部分插入NULL
    @Test
    public void testInsertAllColumn(){
        Employee employee = new Employee("Tom3","男");
        employee.setSalary(20000.0);
        // insertAllColumn()方法根据实体对象非空属性值进行插入,空值部分插入NULL
        Integer result = employeeMapper.insertAllColumn(employee);

        System.out.println("Insert Result:" + result);

        Integer keyId = employee.getId();
        System.out.println("KeyId:" + keyId);
    }

    // 3. update --- updateById()、updateAllColumnById()
    @Test
    public void testUpdate(){
        Employee employee = new Employee("JerryTom","女");
        employee.setSalary(20000.0);
        employee.setId(3);
        //
        Integer result;
        // 3.1 updateById():通过id进行修改，只修改有值的字段
        result = employeeMapper.updateById(employee);
        System.out.println("updateById result :" + result);

        // 3.2 通过ID修改所有列，未赋值的置为NULL
        result = employeeMapper.updateAllColumnById(employee);
        System.out.println("updateAllColumnById result :" + result);
    }

    // 4. select -- selectById()、selectOne()、selectBatchIds()
    @Test
    public void testSelect(){
        // 4.1 selectById()：通过ID进行查询
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);

        // 4.2 selectOne():通过某个条件或条件组合进行查询
        Employee queryEmployee =  new Employee();
        queryEmployee.setLastName("jerry4");
        // 该方法最多只允许返回一条结果，如有多条，则会出错
        Employee result = employeeMapper.selectOne(queryEmployee);
        System.out.println(result);

        // 4.3 selectBatchIds():通过多个ID进行查询
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        ids.add(8);

        List<Employee> resultList = employeeMapper.selectBatchIds(ids);
        System.out.println(resultList);

        // 4.4 selectByMap():通过Map对象封装查询条件,map中的key为数据表字段名称
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("lastName","Tom");
        columnMap.put("gender","男");

        resultList = employeeMapper.selectByMap(columnMap);
        System.out.println(resultList);

        // 4.5 selectPage():分页查询,不建议用，有分页插件，性能比这个方法好
        resultList = employeeMapper.selectPage(new Page<Employee>(1,5),null);
        System.out.println(resultList);
    }

    // 5. delete ----- deleteById()、deleteByMap()、deleteBatchIds()
    @Test
    public void testDelete(){
        //5.1 deleteById():删除指定ID的数据记录
        Integer result;
        result = employeeMapper.deleteById(1);
        System.out.println("deleteById() result: " + result);

        // 5.2 deleteByMap():根据条件进行删除
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("lastName","Jack1");
        columnMap.put("gender","男");
        result = employeeMapper.deleteByMap(columnMap);
        System.out.println("deleteByMap() Result: " + result);

        // 5.3 deleteBatchIds():批量删除
        List<Integer> ids = new ArrayList<>();
        ids.add(3);
        ids.add(4);
        ids.add(5);
        result = employeeMapper.deleteBatchIds(ids);
        System.out.println("deleteBatchIds() result: " + result);
    }

    // 6.
    @Test
    public void testWrapSelect(){
        // 分页查询，lastName中含有Tom且性别为男的所有员工
        Wrapper wrapper = new EntityWrapper<Employee>();
        wrapper.like("lastName","Tom").eq("gender","男");
        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(1,5),wrapper);
        System.out.println(list);
    }
}
