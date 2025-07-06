package com.example.event;


@Setter
@Getter
public class FieldChange<T> {
    private T oldField;
    private T newField;

}