package cn.borber.burvey.service.impl;

import cn.borber.burvey.common.util.CurrUserUtil;
import cn.borber.burvey.mapper.FormMapper;
import cn.borber.burvey.model.DO.FormDO;
import cn.borber.burvey.model.DTO.BaseFormDTO;
import cn.borber.burvey.model.DTO.FormDTO;
import cn.borber.burvey.model.VO.FormAddVO;
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
public class IFormServiceImpl implements IFormService {

    @Autowired
    private FormMapper formMapper;

    @Override
    public boolean add(FormAddVO vo) {
        FormDO form = new FormDO();
        BeanUtils.copyProperties(vo, form);
        form.setCreator(CurrUserUtil.get().getUserId());
        formMapper.insert(form);
        return true;
    }

    @Override
    public FormDTO one(Integer id) {
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
    public Integer delete(Integer id) {
        return formMapper.deleteById(id);
    }
}
