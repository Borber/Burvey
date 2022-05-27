package cn.borber.burvey.service.impl;

import cn.borber.burvey.common.util.CurrUserUtil;
import cn.borber.burvey.mapper.ReplayMapper;
import cn.borber.burvey.model.DO.ReplayDO;
import cn.borber.burvey.model.DTO.ReplayDTO;
import cn.borber.burvey.model.VO.ReplayVO;
import cn.borber.burvey.service.IReplayService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReplayServiceImpl implements IReplayService {
    @Autowired
    private ReplayMapper replayMapper;

    @Override
    public boolean add(ReplayVO vo) {
        ReplayDO replayDO = new ReplayDO();
        BeanUtils.copyProperties(vo, replayDO);
        replayDO.setUserId(CurrUserUtil.get().getUserId());
        replayMapper.insert(replayDO);
        return true;
    }

    @Override
    public List<ReplayDTO> list(String id) {
        return replayMapper
                .selectList(new LambdaQueryWrapper<ReplayDO>().eq(ReplayDO::getFormId, id))
                .stream()
                .map(item -> {
                    ReplayDTO dto = new ReplayDTO();
                    BeanUtils.copyProperties(item, dto);
                    return dto;
                }).collect(Collectors.toList());
    }
}
