package cn.borber.burvey.model.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BORBER
 */
@Data
public class BaseUserDTO implements Serializable {
    Long id;
    String token;
}
