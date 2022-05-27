package cn.borber.burvey.model.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BORBER
 */
@Data
public class FormPublishVO implements Serializable {
    private String id;
    private Boolean status;
}
