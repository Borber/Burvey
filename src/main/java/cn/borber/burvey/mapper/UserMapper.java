package cn.borber.burvey.mapper;

import cn.borber.burvey.model.DO.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户表操作
 * @author BORBER
 */
@Repository
public interface UserMapper extends BaseMapper<UserDO> {
}
