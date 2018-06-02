package com.test.mapper;


import com.test.pojo.TbUser;
import org.apache.ibatis.annotations.Param;

public interface TestDao {


    TbUser getUser(@Param("id") Integer id);
}
