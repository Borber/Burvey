package cn.borber.burvey;

import cn.borber.burvey.mapper.UserMapper;
import cn.borber.burvey.model.DAO.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
class BurveyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserDAO> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}
