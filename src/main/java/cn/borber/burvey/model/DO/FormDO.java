package cn.borber.burvey.model.DO;

import com.baomidou.mybatisplus.annotation.*;

import lombok.Data;

/**
 * @author BORBER
 */
@Data
@TableName("forms")
public class FormDO {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private String creator;
    private Boolean star;
    @TableField("need_key")
    private Boolean needKey;
    private String key;
    @TableField("start_time")
    private String startTime;
    @TableField("end_time")
    private String endTime;
    private String data;
    @TableLogic
    private Integer flag;
}
