package com.test.mapper;


import com.test.pojo.ItemQuery;
import com.test.pojo.TbItem;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface TestDao {

    @Select("select * from tb_item order by updated desc limit #{query.start} , #{query.end} ")
    List<TbItem> getItemList(@Param("query") ItemQuery query);

    @Insert("insert into tb_item (created,updated,title,price,num) values (now(),now(),#{tbItem.title},#{tbItem.price},#{tbItem.num})")
    Boolean addItem(@Param("tbItem") TbItem tbItem);

    @Update("update tb_item set updated=now(),title =#{tbItem.title},price=#{tbItem.price},num=#{tbItem.num}) where id = #{tbItem.id}")
    Boolean updateItem(@Param("tbItem") TbItem tbItem);

    @Delete("delete from tb_item where id=#{id}")
    Boolean deleteItem(@Param("id") Long id);
}
