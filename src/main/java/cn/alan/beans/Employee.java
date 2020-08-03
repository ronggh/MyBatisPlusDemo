package cn.alan.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

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

@TableName(value = "t_employee")
// lombok
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {
    /*
     * @TableId:
     * 	 value: 指定表中的主键列的列名， 如果实体属性名与列名一致，可以省略不指定.
     *   type: 指定主键策略.
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NonNull
    private String lastName;
    @NonNull
    private String gender;
    private String email;


    // 如果不需在要数据库表中存储
    @TableField(exist = false)
    private Double salary;
}


