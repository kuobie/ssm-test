package com.test.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ItemQuery {

    private Integer page = 1;

    private Integer rows = 10;

    private Integer start;
    private Integer end;
}
