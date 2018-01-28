package cn.gcu.design.btss.repositories;

import cn.gcu.design.btss.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/21 13:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSave(){
        User user = new User();
        user.setId("1002");
        user.setWxname("fuck ufck");
        user.setPhone("13544494187");
        user.setPhoto("fuck photo");
        User save = userRepository.save(user);
    }

    @Test
    public void testQuery(){
//        List<User> list = userRepository.findByUserWxnameAndUserPhoto("fuck", "myphoto");
//        List<User> list = userRepository.findByUserWxnameAndUserPhotoAllIgnoreCase("fuck","Fuck Photo");
//        List<User> list = userRepository.findByUserWxnameIgnoreCase("fuck");
//        List<User> list = userRepository.findByUserWxnameIgnoreCaseAndUserPhoto("fuck", "myphoto");
       /* for (User user :
                list) {
            System.out.println(user);
        }*/
    }
}