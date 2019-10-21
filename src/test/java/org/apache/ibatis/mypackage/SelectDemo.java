package org.apache.ibatis.mypackage;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * selectOne方式寻找xml方式：
 * namespace.id
 * id
 */

public class SelectDemo {

  public static void main(String[] args) throws Exception {
    /*
     * 1.加载mybatis的配置文件，初始化mybatis，创建出SqlSessionFactory，是创建SqlSession的工厂
     * 这里只是为了演示的需要，SqlSessionFactory临时创建出来，在实际的使用中，SqlSessionFactory只需要创建一次，当作单例来使用
     */
    InputStream inputStream = Resources.getResourceAsStream("resources/mybatisConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(inputStream);

    //2. 从SqlSession工厂 SqlSessionFactory中创建一个SqlSession，进行数据库操作
    SqlSession sqlSession = factory.openSession();
    Employee e = new Employee();
    e.setEmail("12@qq.com");
    sqlSession.insert("insert", e);

    //3.使用SqlSession查询
    Map<String, Object> params = new HashMap<>();

    Map<Object, Object> objectObjectMap = sqlSession.selectMap("selectByPrimaryKey", "employeeId");
    System.out.println(objectObjectMap);
    //Object o = sqlSession.selectOne("selectByPrimaryKey", 100);
    //System.out.println(o.toString());

    sqlSession.select("selectByPrimaryKey", resultContext -> {
      System.out.println("resultContext:" + resultContext.getResultCount());
      System.out.println("resultContext:" + resultContext.getResultObject());
    });

    params.put("min_salary", 10000);
    //a.查询工资低于10000的员工
    List<Employee> result = sqlSession.selectList("EmployeesMapper.selectByPrimaryKey", 1);
    //b.未传最低工资，查所有员工
    List<Employee> result1 = sqlSession.selectList("EmployeesMapper.selectByPrimaryKey");
    System.out.println("薪资低于10000的员工数：" + result.size());
    //~output :   查询到的数据总数：5
    System.out.println("所有员工数: " + result1.size());
    //~output :  所有员工数: 8
  }

}
