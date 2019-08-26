package fsd.assigment4.java.entity;

import java.math.BigDecimal;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;

@Data
@ValidateOnExecution
public class SalaryInput {
    //@DecimalMin(value = "50", message = "startingSalary must greater than 1")

    private BigDecimal startingSalary;

    private BigDecimal incrtPercent;

    private int incrtFrequency;

    private BigDecimal deductionsOnIncome;

    private int deductionFrequency;

    private int years;

}
