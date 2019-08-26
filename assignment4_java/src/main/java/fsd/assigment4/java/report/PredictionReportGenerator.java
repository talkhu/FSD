package fsd.assigment4.java.report;

import fsd.assigment4.java.entity.DeductionReport;
import fsd.assigment4.java.entity.PredictionReport;
import fsd.assigment4.java.entity.SalaryInput;
import fsd.assigment4.java.util.FormatTools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class PredictionReportGenerator {

    FormatTools ft = new FormatTools();
    public void predtGenerator(ArrayList<PredictionReport> predictionReportList) {

        BigDecimal salaryGrowth  = BigDecimal.ZERO;
        BigDecimal startingSalary = BigDecimal.ZERO;;
        startingSalary = predictionReportList.get(0).getStartingSalary();
        for ( int num = 0; num < predictionReportList.size(); num++ ) {
            PredictionReport predictionReport = new PredictionReport();

            predictionReport = predictionReportList.get(num);
            salaryGrowth = predictionReportList.get(num).getIncrementAmount().subtract(predictionReportList.get(num).getDeductionAmount());
            predictionReport.setSalaryGrowth(salaryGrowth);
            if(num >0 ) {
              startingSalary = startingSalary.add(predictionReportList.get(num-1).getSalaryGrowth());
              predictionReport.setStartingSalary(startingSalary);
            }

            predictionReportList.set(num,predictionReport);
        }

        this.print(predictionReportList);
    }

    public void print(ArrayList<PredictionReport> predictionReportList) {

        System.out.println();
        System.out.println("C. Predicition Report");

        String format = "%-5s | %16s | %16s | %12s | %16s\n";
        System.out.format(format, "Year", "Starting Salary", "Increment Amount", "Deduction Amount", "Salary Growth");


        for (PredictionReport row : predictionReportList) {
            System.out.format(format, row.getYearNumber(),ft.formatMoney(row.getStartingSalary()),ft.formatMoney(row.getIncrementAmount()),ft.formatMoney(row.getDeductionAmount()),ft.formatMoney(row.getSalaryGrowth()));
        }

    }
}