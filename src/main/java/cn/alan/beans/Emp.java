package cn.alan.beans;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@ToString
@TableName(value = "t_emp")
public class Emp {
    private Integer id;
    private String name;

    @TableField(value = "delete_flag")
    @TableLogic // 表明这是一个用来表示逻辑删除的字段
    private Integer deleteFlag;

    // 自动填充字段
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private String createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
}
