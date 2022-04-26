package cn.borber.burvey.model.DO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author BORBER
 */
@Data
@TableName("users")
public class UserDO {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String email;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer flag;
}
