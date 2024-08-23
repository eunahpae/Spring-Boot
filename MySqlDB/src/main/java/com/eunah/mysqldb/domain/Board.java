package com.eunah.mysqldb.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Board {
    private int boardId;
    private String title;
    private String content;
    private String name;
    private Timestamp createDate;
    private int read;
    private int memberId;

}
