package com.test.mapper.provider;

import com.test.pojo.ItemQuery;

public class ItemSqlProvider {

    public String getItemList(final ItemQuery query) {
        System.out.println(query);
        return "select * from tb_item" + "limit 1";
    }
}
