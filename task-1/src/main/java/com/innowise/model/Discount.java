package com.innowise.model;

import com.google.gson.annotations.Expose;
import com.innowise.enums.DiscountType;
import com.innowise.exceptions.CustomException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Discount {
    @Expose
    private Long id;
    @Expose
    private DiscountType type;

    public Discount(Long id, DiscountType type) throws CustomException {
        this.id = id;
        if(type == DiscountType.MANY || type == DiscountType.ONE) {
            this.type = type;
        } else {
            throw new CustomException("Incorrect discount type");
        }
    }
}
