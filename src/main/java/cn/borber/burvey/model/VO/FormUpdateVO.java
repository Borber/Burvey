package cn.borber.burvey.model.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BORBER
 */
@Data
public class FormUpdateVO implements Serializable {
    private String id;
    private String data;
}
