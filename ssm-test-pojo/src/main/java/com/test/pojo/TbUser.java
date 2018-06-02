package com.test.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class TbUser {

    private Integer id;

    private String userName;

    private String passWord;

    private String phone;

    private String email;

    private Date created;

    private Date updated;
}
