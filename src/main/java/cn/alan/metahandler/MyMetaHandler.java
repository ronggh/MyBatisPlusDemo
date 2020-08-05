package cn.alan.metahandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义公共字段填充处理器
 */
public class MyMetaHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 获取要填充字段的值,使用实体类中的属性，而不是数据表中的字段
        Object createTime = getFieldValByName("createTime", metaObject);
        Object updateTime = getFieldValByName("updateTime", metaObject);

        // 无值，则自动填充
        Date date = new Date();
        String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        if (createTime == null) {
            System.out.println("=============满足自动填充条件============");
            setFieldValByName("createTime", strDate, metaObject);
        }

        if (updateTime == null) {
            System.out.println("=============满足自动填充条件============");
            setFieldValByName("updateTime", strDate, metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 获取要填充字段的值
        Object updateTime = getFieldValByName("updateTime", metaObject);

        //
        if (updateTime == null) {
            System.out.println("=============满足自动填充条件============");
            Date date = new Date();
            String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            setFieldValByName("updateTime", strDate, metaObject);
        }
    }
}
