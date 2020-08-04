package cn.alan;

import cn.alan.beans.ArEmployee;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPlugin {
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // １.测试分页插件
    @Test
    public void testPaging(){
        ArEmployee arEmployee = new ArEmployee();
        Page<ArEmployee> page = arEmployee.selectPage(new Page<ArEmployee>(1,3),
                new EntityWrapper<ArEmployee>().like("lastName","Tom"));
        List<ArEmployee> list = page.getRecords();
        System.out.println(list);
        // 分页信息
        System.out.println("总条数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    // 2. 测试SQL执行分析插件
    @Test
    public void testSqlExplain(){
        // 全删一张表，看是否会被拦截
        ArEmployee arEmployee = new ArEmployee();
        arEmployee.delete(null);
    }

    // 3. 测试SQL性能
    @Test
    public void testSqlPerformance(){
        // 插入一条数据来测试
        ArEmployee arEmp = new ArEmployee();
        arEmp.setLastName("Peter1");
        arEmp.setGender("男");
        arEmp.setEmail("peter1@sina.com");

        boolean result = arEmp.insert();
        System.out.println(result);
    }

    // 4. 测试 乐观锁插件
     @Test
    public void testOptimisticLocker(){
        // 需要表中增加一个version字段，实体类中使用@Version注解
     }

}
