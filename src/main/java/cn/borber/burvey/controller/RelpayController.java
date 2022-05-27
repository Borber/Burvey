package cn.borber.burvey.controller;

import cn.borber.burvey.model.BaseResponseBody;
import cn.borber.burvey.model.VO.ReplayVO;
import cn.borber.burvey.service.IReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/replay")
public class RelpayController {
    @Autowired
    private IReplayService replayService;

    @PostMapping("/{id}")
    public BaseResponseBody add(ReplayVO vo) {
        return BaseResponseBody.success(replayService.add(vo));
    }
}
