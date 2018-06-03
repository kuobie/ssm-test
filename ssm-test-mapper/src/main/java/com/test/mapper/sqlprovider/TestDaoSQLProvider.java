package com.test.mapper.sqlprovider;

import com.test.pojo.ItemQuery;
import org.apache.ibatis.jdbc.SQL;

public class TestDaoSQLProvider {

    public String getItemList(final ItemQuery query) {

        return new SQL(){
            {
                SELECT("*");
                FROM("tb_item");
            }

        }.toString() + " limit " + (query.getPage() - 1)*query.getRows() + "," + query.getRows();

    }
}
