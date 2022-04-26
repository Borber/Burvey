package cn.borber.burvey.service.impl;

import cn.borber.burvey.common.exception.BaseException;
import cn.borber.burvey.common.util.CurrUserUtil;
import cn.borber.burvey.mapper.FormHistoryMapper;
import cn.borber.burvey.mapper.FormMapper;
import cn.borber.burvey.model.DO.FormDO;
import cn.borber.burvey.model.DO.FormHistoryDO;
import cn.borber.burvey.model.DTO.BaseFormDTO;
import cn.borber.burvey.model.DTO.FormDTO;
import cn.borber.burvey.model.VO.FormAddVO;
import cn.borber.burvey.model.VO.FormUpdateVO;
import cn.borber.burvey.service.IFormService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BORBER
 */
@Service
public class FormServiceImpl implements IFormService {

    @Autowired
    private FormMapper formMapper;

    @Autowired
    private FormHistoryMapper formHistoryMapper;

    @Override
    public boolean add(FormAddVO vo) {
        FormDO form = new FormDO();
        BeanUtils.copyProperties(vo, form);
        form.setCreator(CurrUserUtil.get().getUserId());
        formMapper.insert(form);
        return true;
    }

    @Override
    public boolean update(FormUpdateVO vo) {
        FormDO form = formMapper.selectById(vo.getId());
        if (form == null) {
            throw new BaseException("非法用户操作");
        }
        FormHistoryDO historyDO = new FormHistoryDO();
        historyDO.setFormId(form.getId());
        historyDO.setOldData(form.getData());
        form.setData(vo.getData());
        if (form.getCreator().equals(CurrUserUtil.get().getUserId())) {
            formHistoryMapper.insert(historyDO);
            formMapper.updateById(form);
            return true;
        }
        throw new BaseException("非法用户操作");
    }

    @Override
    public FormDTO one(String id) {
        FormDO form = formMapper.selectById(id);
        FormDTO formDTO = new FormDTO();
        BeanUtils.copyProperties(form, formDTO);
        return formDTO;
    }

    @Override
    public List<BaseFormDTO> stars() {
        return list().stream().filter(BaseFormDTO::getStar).collect(Collectors.toList());
    }

    @Override
    public List<BaseFormDTO> list() {
        return formMapper
                .selectList(new LambdaQueryWrapper<FormDO>().eq(FormDO::getCreator, CurrUserUtil.get().getUserId()))
                .stream()
                .map(item -> {
                    BaseFormDTO dto = new BaseFormDTO();
                    BeanUtils.copyProperties(item, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        FormDO form = formMapper.selectById(id);
        if (form == null) {
            throw new BaseException("表单" + id +"不存在");
        }
        if (form.getCreator().equals(CurrUserUtil.get().getUserId())){
            formMapper.deleteById(id);
            return true;
        }
        throw new BaseException("非法用户操作");
    }
}
