package com.innowise.model;

import com.google.gson.annotations.Expose;
import com.innowise.enums.Sex;
import com.innowise.exceptions.CustomException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private String secondName;
    @Expose
    private Sex sex;
    @Expose
    private LocalDate birthday;

    public User(Long id, String name, String secondName, Sex sex, LocalDate birthday) throws CustomException {
        this.id = id;

        if((name.length() > 0 && name.split("\\s+").length == 1)) {
            this.name = name;
        } else {
            throw new CustomException("Name must contain 1 word");
        }
        if(name.split("\\s+").length == 1) {
            this.secondName = secondName;
        } else {
            throw new CustomException("Second name must be one word");
        }
        if((sex == Sex.MALE)
                || (sex == Sex.FEMALE)
                || (sex == Sex.ANY)) {
            this.sex = sex;
        } else {
            throw new CustomException("Sex of incorrect type");
        }
        this.birthday = birthday;
    }

    public String getFullName() {
        return name + " " + secondName;
    }
}
