import com.fja.dao.UserDao;
import com.fja.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    private InputStream is;
    private SqlSessionFactory ssf;
    private SqlSession ss;
    private UserDao mapper;
    @Before
    public void before() throws IOException {
         is = Resources.getResourceAsStream("mybatis-config.xml");
         ssf = new SqlSessionFactoryBuilder().build(is);
         ss = ssf.openSession(true);
         mapper = ss.getMapper(UserDao.class);
    }

    @org.junit.Test
    public void test() {
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
    @org.junit.Test
    public void selectOne(){
        User user = mapper.selectOne(10);
        System.out.println(user);
    }
    @org.junit.Test
    public void insert(){
        User u=new User("杜治狗子");
        int user = mapper.insert(u);
        System.out.println(user);
    }
    @org.junit.Test
    public void update(){
        User u=new User(9,"杜治狗子");
        int update = mapper.update(u);
        System.out.println(update);
    }
    @org.junit.Test
    public void delete(){
        int update = mapper.delete(16);
        System.out.println(update);
    }

    @After
    public void after() {
        System.out.println("Test.after");
    }
}