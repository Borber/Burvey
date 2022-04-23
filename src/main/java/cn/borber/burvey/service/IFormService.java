package cn.borber.burvey.service;

import cn.borber.burvey.model.DTO.BaseFormDTO;
import cn.borber.burvey.model.DTO.FormDTO;
import cn.borber.burvey.model.VO.FormAddVO;

import java.util.List;

/**
 * 用于表单相关操作
 * @author BORBER
 */
public interface IFormService {

    /**
     * 新增表单数据
     * @return 添加成功
     */
    boolean add(FormAddVO vo);
    /**
     * 通过id获取表单具体数据
     * @param id 表格id
     * @return 表格的具体数据
     */
    FormDTO one(Integer id);

    /**
     * 获取当前用户加星表单
     * @return 加星表格简略数据
     */
    List<BaseFormDTO> stars();

    /**
     * 获取用户创建的所有表单的数据
     * @return 所有表单
     */
    List<BaseFormDTO> list();

    /**
     * 逻辑删除表单
     * @param id 表单ID
     * @return 删除成功
     */
    Integer delete(Integer id);
}
