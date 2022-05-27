package cn.borber.burvey.service;

import cn.borber.burvey.model.DTO.BaseFormDTO;
import cn.borber.burvey.model.DTO.FormDTO;
import cn.borber.burvey.model.VO.FormAddVO;
import cn.borber.burvey.model.VO.FormPublishVO;
import cn.borber.burvey.model.VO.FormUpdateVO;

import java.util.List;

/**
 * 用于表单相关操作
 * @author BORBER
 */
public interface IFormService {

    /**
     * 新增表单数据
     * @param vo 添加VO
     * @return 添加成功
     */
    boolean add(FormAddVO vo);

    /**
     * 更新表单
     * @param id 文章ID
     * @param vo 更新VO
     * @return 更新成功
     */
    boolean update(String id, FormUpdateVO vo);


    /**
     * 更改发布状态
     * @param vo 入参
     * @return 修改成功
     */
    boolean publish(FormPublishVO vo);

    /**
     * 通过id获取表单具体数据
     * @param id 表格id
     * @return 表格的具体数据
     */
    FormDTO one(String id);

    /**
     * 通过id, 密码获取表单具体数据
     * @param id 表格id
     * @param key 密码
     * @return 表格的具体数据
     */
    FormDTO oneByKey(String id, String key);

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
    boolean delete(String id);
}
