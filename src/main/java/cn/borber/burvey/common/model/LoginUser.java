package cn.borber.burvey.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BORBER
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
    String userId;
    String token;
}