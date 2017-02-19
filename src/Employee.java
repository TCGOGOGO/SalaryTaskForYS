/**
 * Created by tcgogogo on 17/2/19.
 */
public class Employee {

    private String name;
    private int jobNum;
    private Salary salary;

    public Employee(String name, int jobNum, Salary salary) {
        this.name = name;
        this.jobNum = jobNum;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setJobNum(int jobNum) {
        this.jobNum = jobNum;
    }

    public int getJobNum() {
        return jobNum;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Salary getSalary() {
        return salary;
    }
}
