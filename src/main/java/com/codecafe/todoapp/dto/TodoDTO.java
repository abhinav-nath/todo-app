package com.codecafe.todoapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class TodoDTO {
    private String title;
    private String description;
    private Date targetDate;
    private Date endDate;
}

