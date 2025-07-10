package com.example.db.FieldChange;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class FieldChangeInteger {
    private Integer oldField;
    private Integer newField;
}
