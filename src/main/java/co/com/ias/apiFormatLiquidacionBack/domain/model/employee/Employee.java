package co.com.ias.apiFormatLiquidacionBack.domain.model.employee;

public class Employee {

    private final Long idEmployee;
    private final Document document;
    private final Job job;

    public Long getIdEmployee() {
        return idEmployee;
    }

    private final Name name;

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


    public StartDate getStartDate() {
        return startDate;
    }

    public Employee(Long idEmployee, Document document, Job job, Name name, StartDate startDate) {
        this.idEmployee = idEmployee;
        this.document = document;
        this.job = job;
        this.name = name;
        this.startDate = startDate;
    }
}
