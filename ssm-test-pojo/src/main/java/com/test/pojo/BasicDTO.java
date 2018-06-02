package com.test.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class BasicDTO implements Serializable {

    private Date created;

    private Date updated;
}
