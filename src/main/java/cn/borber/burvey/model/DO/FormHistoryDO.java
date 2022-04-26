package cn.borber.burvey.model.DO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author BORBER
 */
@TableName("history_forms")
@Data
public class FormHistoryDO implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;
    @TableField("form_id")
    private Integer formId;
    @TableField("old_data")
    private String oldData;
    @TableLogic
    private Integer flag;
}
