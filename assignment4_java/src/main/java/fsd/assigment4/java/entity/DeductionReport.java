package fsd.assigment4.java.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeductionReport extends SalaryInput{
    private BigDecimal IncrementAmount;
    private BigDecimal deductionAmount;
    private BigDecimal SalaryGrowth;
    private int yearNumber;
}
