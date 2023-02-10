package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

import java.util.Date;

public class Employee {
    public String name;
    public String id;
    public String startDate;

    public Employee(String name, String id, String startDate) {
        this.name = name;
        this.id = id;
        this.startDate = startDate;

    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String job;

    public String salary;
}
