package fsd.assigment4.java;
import fsd.assigment4.java.entity.DeductionReport;
import fsd.assigment4.java.entity.PredictionReport;
import fsd.assigment4.java.entity.SalaryInput;
import fsd.assigment4.java.report.DeductionReportGenerator;
import fsd.assigment4.java.report.IncrementReportGenerator;
import fsd.assigment4.java.report.PredictionReportGenerator;
import fsd.assigment4.java.util.InputReader;

import java.util.ArrayList;

public class SalaryIncomePredictor {

    public static void main(String[] args) {
        ArrayList<PredictionReport> predicitonReportList = new ArrayList<PredictionReport>();

        InputReader inputReader = new InputReader();
        IncrementReportGenerator incrementReportGenerator = new IncrementReportGenerator();
        DeductionReportGenerator deductionReportGenerator = new DeductionReportGenerator();
        PredictionReportGenerator predictionReportGenerator = new PredictionReportGenerator();

        SalaryInput salaryInput = inputReader.inputBuild();
        System.out.println();
        System.out.println("Salary Income Predictior Reports ");
        incrementReportGenerator.incrtGenerator(salaryInput,predicitonReportList);
        deductionReportGenerator.ductGenerator(salaryInput,predicitonReportList);
        predictionReportGenerator.predtGenerator(predicitonReportList);
    }
}
