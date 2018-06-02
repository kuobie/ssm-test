package com.test.service;

import com.test.pojo.ItemQuery;
import com.test.pojo.TbItem;

import java.util.List;

public interface TestService {

    List<TbItem> getItemList(ItemQuery itemQuery);

    Boolean addItem(TbItem tbItem);

    Boolean updateItem(TbItem tbItem);

    Boolean deleteItem(Long id);
}
