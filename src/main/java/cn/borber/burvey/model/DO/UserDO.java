package cn.borber.burvey.model.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableLogic(value = "0")
    private Integer flag;
}
