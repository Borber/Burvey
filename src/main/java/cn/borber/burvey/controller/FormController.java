package cn.borber.burvey.controller;

import cn.borber.burvey.model.BaseResponseBody;
import cn.borber.burvey.model.VO.FormAddVO;
import cn.borber.burvey.model.VO.FormGetByKeyVO;
import cn.borber.burvey.model.VO.FormPublishVO;
import cn.borber.burvey.model.VO.FormUpdateVO;
import cn.borber.burvey.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author BORBER
 */
@RestController
@RequestMapping("/")
public class FormController {

    @Autowired
    private IFormService formService;

    @PostMapping("form")
    public BaseResponseBody add(@RequestBody FormAddVO vo) {
        return BaseResponseBody.success(formService.add(vo));
    }

    @GetMapping("form")
    public BaseResponseBody list() {
        return BaseResponseBody.success(formService.list());
    }

    @PostMapping("form/{id}")
    public BaseResponseBody one(@PathVariable("id") String id) {
        return BaseResponseBody.success(formService.one(id));
    }

    @PostMapping("form/p/{id}")
    public BaseResponseBody oneByKey(@PathVariable("id") String id, @RequestBody FormGetByKeyVO vo) {
        return BaseResponseBody.success(formService.oneByKey(id, vo.getKey()));
    }
    @PutMapping("form/{id}")
    public BaseResponseBody put(@PathVariable("id") String id, @RequestBody FormUpdateVO vo) {
        return BaseResponseBody.success(formService.update(id, vo));
    }

    @PostMapping("form-star")
    public BaseResponseBody stars() {
        return BaseResponseBody.success(formService.stars());
    }

    @DeleteMapping("form/{id}")
    public BaseResponseBody delete(@PathVariable("id") String id) {
        return BaseResponseBody.success(formService.delete(id));
    }

    @PostMapping("form-publish")
    public BaseResponseBody publish(@RequestBody FormPublishVO vo) {
        return BaseResponseBody.success(formService.publish(vo));
    }

}
