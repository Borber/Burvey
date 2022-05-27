package cn.borber.burvey.model.DO;

import com.baomidou.mybatisplus.annotation.*;

import lombok.Data;

/**
 * @author BORBER
 */
@Data
@TableName("forms") // mybatisplus 的注解, 直接将类对应到数据库的表中
public class FormDO {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private String creator;
    private Boolean star;
    private Boolean publish;
    @TableField("need_key")
    private Boolean needKey;
    @TableField("the_key")
    private String theKey;
    @TableField("start_time")
    private String startTime;
    @TableField("end_time")
    private String endTime;
    private String data;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer flag;
}
