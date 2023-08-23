package org.kainos.ea.cli;

public class SalesEmployee extends Employee {
    private int employeeId;
    private String name;
    private double salary;
    private double monthlySales;
    private float commissionRate;

    public SalesEmployee(int employeeId, String name, double salary, double monthlySales, float commissionRate) {
        super(employeeId, name, salary);
        setCommissionRate(commissionRate);
        setMonthlySales(monthlySales);
    }

    public double calcPay() {
        return getSalary()/12 + (monthlySales*commissionRate);
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(double monthlySales) {
        this.monthlySales = monthlySales;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }
}