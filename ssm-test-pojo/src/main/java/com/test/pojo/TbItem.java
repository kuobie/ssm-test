package com.test.pojo;

import lombok.Data;

@Data
public class TbItem  extends BasicDTO {
    private Long id;

    private String title;

    private String sellPoint;

    private Long price;

    private Integer num;

    private String barcode;

    private String image;

    private Long cid;

    private Byte status;


}