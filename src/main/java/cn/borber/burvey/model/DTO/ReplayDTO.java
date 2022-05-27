package cn.borber.burvey.model.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BORBER
 */
@Data
public class ReplayDTO implements Serializable {
    private String time;
    private String data;
}
