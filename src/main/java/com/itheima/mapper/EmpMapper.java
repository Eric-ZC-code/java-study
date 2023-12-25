package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    /*查询总记录数*/
    @Select("select count(*) from emp")
    Long count();

    /*分页查询，获取列表数据*/
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    List<Emp> page(Integer start, Integer pageSize);

    /*员工信息查询*/
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /*批量删除员工信息*/
    void delete(List<Integer> ids);

    /*新增员工*/
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void save(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /*根据ID更新员工信息*/
    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
