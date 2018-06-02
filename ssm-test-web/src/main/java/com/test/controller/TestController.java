package com.test.controller;

import com.test.pojo.ItemQuery;
import com.test.pojo.TbItem;
import com.test.response.BaseResponse;
import com.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping("/getItemList")
    @ResponseBody
    public List<TbItem> getItem(ItemQuery query) {

        try {
            List<TbItem> itemList = testService.getItemList(query);
            BaseResponse baseResponse = new BaseResponse(itemList);
            return itemList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @RequestMapping("/addItem")
    @ResponseBody
    public Boolean addItem(TbItem tbItem) {

        try {
            Boolean flag = testService.addItem(tbItem);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @RequestMapping("/updateItem")
    @ResponseBody
    public Boolean updateItem(TbItem tbItem) {

        try {
            Boolean flag = testService.updateItem(tbItem);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @RequestMapping("/deleteItem")
    @ResponseBody
    public Boolean updateItem(Long id) {

        try {
            Boolean flag = testService.deleteItem(id);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
