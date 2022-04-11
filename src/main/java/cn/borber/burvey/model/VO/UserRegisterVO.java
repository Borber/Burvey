package cn.borber.burvey.model.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BORBER
 */
@Data
public class UserRegisterVO implements Serializable {
    private String name;
    private String password;
    private String email;
}
