import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by tcgogogo on 17/2/19.
 */
public class Employer {

    public static Scanner in = new Scanner(System.in);

    public void addEmployee() throws IOException {
        String name;
        int jobNum;
        int salary;
        String date;

        System.out.print("输入员工姓名: ");
        name = in.next();
        System.out.print("输入员工工号: ");
        jobNum = in.nextInt();
        System.out.print("输入员工薪水: ");
        salary = in.nextInt();
        date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        Employee newcomer = new Employee(name, jobNum, new Salary(salary, date));
        if (FileUtils.QueryIsExistFile(jobNum)) {
            System.out.println("该员工已存在,添加失败");
            return;
        }
        FileHelper fileHelper = new FileHelper(newcomer);
        StringBuffer content = new StringBuffer();
        content.append(newcomer.getName() + " ");
        content.append(newcomer.getSalary().getMoney() + " ");
        content.append(newcomer.getSalary().getDate() + "\n");
        fileHelper.writeToFile(content.toString());
    }

    public void deleteEmployee() {
        int jobNum;
        System.out.print("输入要开除的员工工号: ");
        jobNum = in.nextInt();
        if (FileUtils.QueryIsExistFile(jobNum)) {
            FileUtils.getFile(jobNum).delete();
            System.out.println("成功删除");
        }
        else {
            System.out.println("该员工不存在");
        }
    }

    public void querySalary() throws IOException {
        int jobNum;
        System.out.print("输入要查询的员工工号: ");
        jobNum = in.nextInt();
        if (FileUtils.QueryIsExistFile(jobNum)) {
            System.out.println(new FileHelper(jobNum).readFromFile());
        }
        else {
            System.out.println("该员工不存在");
        }
    }

    public void modifySalary() throws IOException {
        int jobNum;
        System.out.print("输入要修改的员工工号: ");
        jobNum = in.nextInt();
        if (FileUtils.QueryIsExistFile(jobNum)) {
            FileHelper fileHelper = new FileHelper(jobNum);
            System.out.print("薪资增减: ");
            String tmp = in.next();
            int changeNum = Integer.parseInt(new String(tmp.substring(1)));
            if (tmp.charAt(0) == '-') {
                changeNum = -changeNum;
            }
            String[] data = fileHelper.readFromFile().toString().split(" ");
            String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            // before
            Salary salary = new Salary(Integer.parseInt(data[1]), data[2]);
            Employee e = new Employee(data[0], jobNum, salary);

            // after
            salary.setDate(date);
            salary.setMoney(salary.getMoney() + changeNum);
            e.setSalary(salary);

            StringBuffer content = new StringBuffer();
            content.append(e.getName() + " ");
            content.append(e.getSalary().getMoney() + " ");
            content.append(e.getSalary().getDate() + "\n");
            fileHelper.writeToFile(content.toString());
        }
        else {
            System.out.println("该员工不存在");
        }
    }
}
