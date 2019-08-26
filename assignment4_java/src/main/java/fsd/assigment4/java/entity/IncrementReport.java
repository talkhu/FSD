package fsd.assigment4.java.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IncrementReport extends SalaryInput {
    private BigDecimal incrementAmount;
    private int yearNumber;
}
