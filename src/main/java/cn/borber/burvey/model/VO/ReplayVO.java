package cn.borber.burvey.model.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReplayVO implements Serializable {
    private String formId;
    private String time;
    private String data;
}
