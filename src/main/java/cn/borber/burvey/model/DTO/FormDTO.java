package cn.borber.burvey.model.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * 表单返回结构
 * @author BORBER
 */
@Data
public class FormDTO implements Serializable {
    private Integer id;
    private String name;
    /**
     *TODO 使用id查询name
     */
    private String creator;
    private Boolean star;
    private String startTime;
    private String endTime;
    private String data;
}
