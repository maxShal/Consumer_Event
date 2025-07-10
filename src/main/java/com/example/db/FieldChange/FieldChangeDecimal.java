package com.example.db.FieldChange;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
public class FieldChangeDecimal {
    private BigDecimal oldField;
    private BigDecimal newField;
}
