package cn.borber.burvey.model.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加表单VO
 * @author BORBER
 */
@Data
public class FormAddVO implements Serializable {
    private String name;
    private Boolean star;
    private Boolean needKey;
    private String theKey;
    private String startTime;
    private String endTime;
    private String data;
}
