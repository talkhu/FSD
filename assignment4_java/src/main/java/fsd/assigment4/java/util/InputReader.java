package fsd.assigment4.java.util;

import fsd.assigment4.java.entity.SalaryInput;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputReader extends SalaryInput {
    private Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    private String read(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private InputReader readStartingSalary() {
        String input = read("Input starting salary: ");
        try {
            BigDecimal result = new BigDecimal(input);
            if (result.compareTo(BigDecimal.ONE) >= 0) {
                this.setStartingSalary(result);
                return this;

            } else {
                System.err.println("Starting salary cannot be less than 1.");
                return this.readStartingSalary();
            }

        } catch (Exception ex) {
            System.err.println("Input must be a double value.");
            return this.readStartingSalary();
        }

    }


    private InputReader readIncrtPercent() {
        String input = read("Input Increment to be received in percent ");
        try {
            BigDecimal result = new BigDecimal(input);
            if (result.compareTo(BigDecimal.ONE) >= 0) {
                this.setIncrtPercent(result);
                return this;

            } else {
                System.err.println("Starting salary cannot be less than 0.");
                return this.readIncrtPercent();
            }

        } catch (Exception ex) {
            System.err.println("Input must be a number.");
            return this.readIncrtPercent();
        }

    }

    private InputReader readIncrementFrequency() {
        String input = read("Input increment received frequency: quarterly:4 half-yearly:2 annually:1 etc: ");
        try {
            this.setIncrtFrequency(Integer.valueOf(input));
            return this;

        } catch (Exception e) {
            System.err.print("Frequency must be one of the following values:");
            System.err.println(Integer.valueOf(input));
            return this.readIncrementFrequency() ;
        }
    }

    private InputReader readDeductionsOnIncome() {
        String input = read("Input deductions on income: ");
        try {
            BigDecimal result = new BigDecimal(input);
            if (result.compareTo(BigDecimal.ONE) >= 0) {
                this.setDeductionsOnIncome(result);
                return this;

            } else {
                System.err.println("Deductions on income cannot be less than 0.");
                return this.readDeductionsOnIncome();
            }

        } catch (Exception ex) {
            System.err.println("Input must be a number.");
            return this.readDeductionsOnIncome();
        }

    }

    private InputReader readDeductionsFrequency() {
        String input = read("Input deductions received frequency: quarterly:4 half-yearly:2 annually:1 etc : ");

        try {
            this.setDeductionFrequency(Integer.valueOf(input));
            return this;

        } catch (Exception e) {
            System.err.print("Frequency must be one of the following values:");
            System.err.println(Integer.valueOf(input));
            return this.readDeductionsFrequency();
        }
    }

    private InputReader readPredictionYears() {
        String input = read("Input prediction years: ");
        try {
            int result = Integer.valueOf(input);
            if (result > 0) {
                this.setYears(result);
                return this;

            } else {
                System.err.println("Prediction years must be greater than 0.");
                return this.readPredictionYears();
            }

        } catch (Exception e) {
            System.err.println("Input must be an integer.");
            return this.readPredictionYears();
        }
    }


    public SalaryInput inputBuild() {
        this.readStartingSalary();
        this.readIncrtPercent();
        this.readIncrementFrequency();
        this.readDeductionsOnIncome();
        this.readDeductionsFrequency();
        this.readPredictionYears();
        return (SalaryInput) this;
    }
}
