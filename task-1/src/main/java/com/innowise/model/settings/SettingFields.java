package com.innowise.model.settings;

import com.google.gson.annotations.Expose;
import java.time.LocalDate;
import java.util.List;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SettingFields {
    @Expose
    private LocalDate dateFrom;
    @Expose
    private LocalDate dateTo;
    @Expose
    private UsersAndType showFor;
    @Expose
    private String sortBy;
    @Expose
    private List<String> useDepartments;
    @Expose
    private double startCostEUR;
    @Expose
    private double startCostUSD;

}
