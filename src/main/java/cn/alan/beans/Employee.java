package cn.alan.beans;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * javaBean
 * <p>
 * 定义JavaBean中成员变量时所使用的类型:
 * 因为每个基本类型都有一个默认值:
 * int ==> 0
 * boolean ==> false
 */

/*
 * MybatisPlus会默认使用实体类的类名到数据中找对应的表.
 *
 */

@TableName(value="t_employee")
public class Employee {
    /*
     * @TableId:
     * 	 value: 指定表中的主键列的列名， 如果实体属性名与列名一致，可以省略不指定.
     *   type: 指定主键策略.
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String lastName;
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee() {
    }

    public Employee(String lastName, String gender) {
        this.lastName = lastName;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
