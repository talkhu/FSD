package fsd.assigment4.java.report;

import fsd.assigment4.java.entity.DeductionReport;
import fsd.assigment4.java.entity.PredictionReport;
import fsd.assigment4.java.entity.SalaryInput;
import fsd.assigment4.java.util.FormatTools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class DeductionReportGenerator {

    FormatTools ft = new FormatTools();
    public void ductGenerator(SalaryInput salaryInput, ArrayList<PredictionReport> predictionReportList) {

        ArrayList<DeductionReport> deductionReport = new ArrayList<DeductionReport>();
        BigDecimal amount = BigDecimal.ZERO;
        BigDecimal startingSalary = salaryInput.getStartingSalary();
        for ( int yearNumber = 0; yearNumber < salaryInput.getYears(); yearNumber++ ) {
            PredictionReport predictionReport = new PredictionReport();
            DeductionReport DeductionReport = new DeductionReport();
            DeductionReport.setYearNumber(yearNumber+1);
            DeductionReport.setStartingSalary(startingSalary);
            DeductionReport.setDeductionFrequency(salaryInput.getDeductionFrequency());
            DeductionReport.setDeductionsOnIncome(salaryInput.getDeductionsOnIncome());
            amount = this.calAmount(startingSalary,salaryInput.getDeductionFrequency(),salaryInput.getDeductionsOnIncome());
            DeductionReport.setDeductionAmount(amount);
            startingSalary = startingSalary.subtract(amount);
            predictionReport = predictionReportList.get(yearNumber);
            predictionReport.setDeductionAmount(DeductionReport.getDeductionAmount());
            predictionReportList.set(yearNumber,predictionReport);
            deductionReport.add(DeductionReport);

        }

        this.print(deductionReport);
    }

    private BigDecimal calAmount (BigDecimal startingSalary ,int ductFrequency, BigDecimal deductions) {
        BigDecimal retAmount = BigDecimal.ZERO;
        BigDecimal tmpAmount = BigDecimal.ZERO;
        BigDecimal salary = startingSalary;
        for(int frequency = 1 ; frequency <= ductFrequency; frequency++) {
            tmpAmount = salary.multiply(deductions.divide(new BigDecimal(100)));
            salary = salary.subtract(tmpAmount);
            retAmount = retAmount.add(tmpAmount);
        }
        return retAmount;
    }

    public void print(ArrayList<DeductionReport> deductionReport) {

        System.out.println();
        System.out.println("b. Deductmement Report");

        String format = "%-5s | %16s | %16s | %12s | %16s\n";
        System.out.format(format, "Year", "Starting Salary", "# of Deduction", "Deduction %", "Deduction Amount");


        for (DeductionReport row : deductionReport) {
            System.out.format(format, row.getYearNumber(),ft.formatMoney(row.getStartingSalary()),row.getDeductionFrequency(),row.getDeductionsOnIncome(),ft.formatMoney(row.getDeductionAmount()));
        }

    }
}