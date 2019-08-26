# Salary Income Predictior Reports

## Tech 

1. java8 stream api
2. maven
3. builder pattern

## Setup

```sh
git clone https://github.com/talkhu/FSD.git
cd FSD/
mvn clean package
java -cp ./target/*.jar fsd.assigment4.java.SalaryIncomePredictor
```

Sample output:
```
$java -cp ./target/*.jar fsd.assigment4.java.SalaryIncomePredictor

Input starting salary: 1000
Input Increment to be received in percent 10
Input increment received frequency: quarterly:4 half-yearly:2 annually:1 etc: 4
Input deductions on income: 2
Input deductions received frequency: quarterly:4 half-yearly:2 annually:1 etc : 4
Input prediction years: 3

Salary Income Predictior Reports 

a. Increment Report
Year  |  Starting Salary |  # of Increments |  Increment % | Increment Amount
1     |           1000.0 |                4 |           10 |            464.1
2     |           1464.1 |                4 |           10 |           679.49
3     |          2143.59 |                4 |           10 |           994.84

b. Deductmement Report
Year  |  Starting Salary |   # of Deduction |  Deduction % | Deduction Amount
1     |           1000.0 |                4 |            2 |            77.63
2     |           922.37 |                4 |            2 |            71.61
3     |           850.76 |                4 |            2 |            66.05

C. Predicition Report
Year  |  Starting Salary | Increment Amount | Deduction Amount |    Salary Growth
1     |           1000.0 |            464.1 |        77.63 |           386.47
2     |          1386.47 |           679.49 |        71.61 |           607.88
3     |          1994.35 |           994.84 |        66.05 |           928.79

```
