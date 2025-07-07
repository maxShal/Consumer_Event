package com.example.web;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FieldChange<T> {
    private T oldField;
    private T newField;

}