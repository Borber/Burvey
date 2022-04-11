package cn.borber.burvey.model.DAO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author BORBER
 */
@Data
@TableName("users")
public class UserDAO {
    @TableId
    private Long id;
    private String name;
    private String password;
    private String email;
    @TableLogic(value = "0")
    private boolean deleted;
}
