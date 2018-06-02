package com.test.service.impl;

import com.test.mapper.TestDao;
import com.test.pojo.ItemQuery;
import com.test.pojo.TbItem;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<TbItem> getItemList(ItemQuery query) {
        query.setStart((query.getPage()-1) * query.getRows());
        query.setEnd(query.getRows());

        List<TbItem> itemList = testDao.getItemList(query);
        return itemList;
    }

    @Override
    public Boolean addItem(TbItem tbItem) {

        return testDao.addItem(tbItem);
    }


    @Override
    public Boolean updateItem(TbItem tbItem) {
        return testDao.updateItem(tbItem);
    }

    @Override
    public Boolean deleteItem(Long id) {
        return testDao.deleteItem(id);
    }
}
