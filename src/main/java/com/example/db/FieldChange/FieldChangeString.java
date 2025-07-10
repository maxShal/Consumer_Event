package com.example.db.FieldChange;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class FieldChangeString {
    private String oldField;
    private String newField;
}
