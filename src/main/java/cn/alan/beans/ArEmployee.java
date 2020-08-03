package cn.alan.beans;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@TableName(value = "t_employee")
public class ArEmployee extends Model<ArEmployee> {
    private Integer id;
    private String lastName;
    private String gender;
    private String email;

    // 指定当前实体类的主健属性
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
