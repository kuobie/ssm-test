package com.test.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ItemQuery {

    private Integer page;

    private Integer rows;

    private Integer start;
    private Integer end;
}
