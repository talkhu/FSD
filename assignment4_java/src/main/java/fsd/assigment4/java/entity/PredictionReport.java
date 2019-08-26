package fsd.assigment4.java.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PredictionReport {
    private BigDecimal startingSalary;
    private BigDecimal incrementAmount;
    private BigDecimal deductionAmount;
    private BigDecimal SalaryGrowth;
    private int yearNumber;

}
