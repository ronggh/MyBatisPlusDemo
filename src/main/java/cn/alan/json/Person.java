package cn.alan.json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Person implements Serializable {
    @JSONField(name = "ID")
    private Integer id;
    private String name;
    private Integer age;
}
