package cn.borber.burvey.model.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BORBER
 */
@Data
public class BaseFormDTO implements Serializable {
    private Integer id;
    private String name;
    private Boolean star;
    private String startTime;
    private String endTime;
}
