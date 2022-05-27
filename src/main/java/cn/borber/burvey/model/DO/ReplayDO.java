package cn.borber.burvey.model.DO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
@Data
public class ReplayDO  implements Serializable {
    @TableId(type= IdType.AUTO)
    private String id;
    @TableField("user_id")
    private String userId;
    @TableField("form_id")
    private String formId;
    private String time;
    private String data;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer flag;
}
