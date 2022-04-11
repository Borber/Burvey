package cn.borber.burvey.mapper;

import cn.borber.burvey.model.DAO.UserDAO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author BORBER
 */
@Repository
public interface UserMapper extends BaseMapper<UserDAO> {
}
