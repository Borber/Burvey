package cn.borber.burvey.service;

import cn.borber.burvey.model.DTO.ReplayDTO;
import cn.borber.burvey.model.VO.ReplayVO;

import java.util.List;

/**
 *
 * @author BORBER
 */
public interface IReplayService {
    /**
     * 添加新的回复
     * @param vo 入参
     * @return 添加成功
     */
    boolean add(ReplayVO vo);

    /**
     * 查询相应问卷的所有回复
     * @param id 问卷ID
     * @return 该问卷的所有回复
     */
    List<ReplayDTO> list(String id);
}
