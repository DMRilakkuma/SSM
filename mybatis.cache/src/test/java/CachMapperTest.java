import com.atguigu.mybatis.mapper.CachMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: MC
 * @program: SSM
 * @create: 2022-07-25 19:13
 * @Description:
 */

public class CachMapperTest {

    /*
     * mybatis的一级缓存:
     * mybatis的一级缓存是sqlSeession级别的，即通过同一个sqlSession查询的数据会被缓存
     * 再次使用同一个sqlSession查询同一条数据,会从缓存中获取
     * 使一级缓存失效的四种情况：
     * 1.不同的sqlSession对应不同的一级缓存
     * 2.同一个sqlSession但是查询条件不同
     * 3.同一个sqlSession两次查询期间执行任何一次增删改操作
     * 4.同一个sqlSession两次查询期间手动清空了缓存
     *
     * mybatis的二级缓存
     * mybatis的二级缓存是sqlSessionFactory级别，即通过同一个sqlSessionFactory的所获取的sqlSession对象查询的数据会被
     * 缓存，在通过同一个sqlSessionFactory所获取的sqlsession查询相同的数据会从缓存中获取
     * mybatis二级缓存开启的条件:
     * a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
       b>在映射文件中设置标签<cache/>
       c>二级缓存必须在SqlSession关闭或提交之后有效
       d>查询的数据所转换的实体类类型必须实现序列化的接口

     * */

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CachMapper mapper1 = sqlSession1.getMapper(CachMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CachMapper mapper2 = sqlSession2.getMapper(CachMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();
    }

    @Test
    public void testGetEmpById() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CachMapper mapper1 = sqlSession1.getMapper(CachMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

        sqlSession1.clearCache();
        // mapper1.insertEmp(new Emp(null,"小红",25,"男"));

        Emp emp2 = mapper1.getEmpById(1);
        System.out.println(emp2);

       /* SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CachMapper mapper2 = sqlSession2.getMapper(CachMapper.class);
        Emp emp3 = mapper2.getEmpById(1);
        System.out.println(emp3);*/

    }
}