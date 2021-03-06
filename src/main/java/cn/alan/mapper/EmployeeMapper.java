package cn.alan.mapper;

import cn.alan.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * Mapper接口
 *
 * 基于Mybatis:  在Mapper接口中编写CRUD相关的方法  提供Mapper接口所对应的SQL映射文件 以及 方法对应的SQL语句.
 *
 * 基于MP:  让XxxMapper接口继承 BaseMapper接口即可.
 * 		   BaseMapper<T> : 泛型指定的就是当前Mapper接口所操作的实体类类型
 *
 */

public interface EmployeeMapper extends BaseMapper<Employee> {
    // 自定义的方法
    int deleteAll();

}
