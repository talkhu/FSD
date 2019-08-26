package fsd.assigment4.java.report;

import fsd.assigment4.java.entity.IncrementReport;
import fsd.assigment4.java.entity.PredictionReport;
import fsd.assigment4.java.entity.SalaryInput;
import fsd.assigment4.java.util.FormatTools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class IncrementReportGenerator {

    FormatTools ft = new FormatTools();
    public void incrtGenerator(SalaryInput salaryInput, ArrayList<PredictionReport> predictionReportList) {

        ArrayList<IncrementReport> incrementList = new ArrayList<IncrementReport>();
        BigDecimal amount = BigDecimal.ZERO;
        BigDecimal startingSalary = salaryInput.getStartingSalary();
        for ( int yearNumber = 0; yearNumber < salaryInput.getYears(); yearNumber++ ) {
            IncrementReport incrementReport = new IncrementReport();
            PredictionReport predictionReport = new PredictionReport();
            predictionReport.setStartingSalary(startingSalary);
            incrementReport.setYearNumber(yearNumber+1);
            incrementReport.setStartingSalary(startingSalary);
            incrementReport.setIncrtFrequency(salaryInput.getIncrtFrequency());
            incrementReport.setIncrtPercent(salaryInput.getIncrtPercent());
            amount = this.calAmount(startingSalary,salaryInput.getIncrtFrequency(),salaryInput.getIncrtPercent());
            incrementReport.setIncrementAmount(amount);
            startingSalary = startingSalary.add(amount);
            predictionReport.setYearNumber(yearNumber+1);
            predictionReport.setIncrementAmount(incrementReport.getIncrementAmount());
            incrementList.add(incrementReport);
            predictionReportList.add(predictionReport);
        }

        this.print(incrementList);
    }

    private BigDecimal calAmount (BigDecimal startingSalary ,int incrtFrequency, BigDecimal incrtPercent) {
       BigDecimal retAmount = BigDecimal.ZERO;
       BigDecimal tmpAmount = BigDecimal.ZERO;
       BigDecimal salary = startingSalary;
       for(int frequency = 1 ; frequency <= incrtFrequency; frequency++) {
           tmpAmount = salary.multiply(incrtPercent.divide(new BigDecimal(100)));
           salary = salary.add(tmpAmount);
           retAmount = retAmount.add(tmpAmount);
       }
       return retAmount;
    }

    public void print(ArrayList<IncrementReport> incrementList) {

        System.out.println();
        System.out.println("a. Increment Report");

        String format = "%-5s | %16s | %16s | %12s | %16s\n";
        System.out.format(format, "Year", "Starting Salary", "# of Increments", "Increment %", "Increment Amount");


        for (IncrementReport row : incrementList) {
            System.out.format(format, row.getYearNumber(),ft.formatMoney(row.getStartingSalary()),row.getIncrtFrequency(),row.getIncrtPercent(),ft.formatMoney(row.getIncrementAmount()));
        }

    }
}
