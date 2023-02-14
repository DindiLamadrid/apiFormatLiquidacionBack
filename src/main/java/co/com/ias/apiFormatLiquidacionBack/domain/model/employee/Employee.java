package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

public class Employee {

    private final Document document;
    private final Job job;
    private final Name name;

    private final Salary salary;

    public Job getJob() {
        return job;
    }

    private final StartDate startDate;

    public Document getDocument() {
        return document;
    }

    public Name getName() {
        return name;
    }

    public Salary getSalary() {
        return salary;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public Employee(Document document, Job job, Name name, Salary salary, StartDate startDate) {
        this.document = document;
        this.job = job;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }
}
