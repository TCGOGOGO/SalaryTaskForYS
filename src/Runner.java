import java.io.IOException;
import java.util.Scanner;

/**
 * Created by tcgogogo on 17/2/19.
 */
public class Runner {

    public static void main(String[] agrs) throws IOException {
        int tp;
        Scanner in = new Scanner(System.in);
        Employer employer = new Employer();
        while(true) {
            System.out.println("1. 添加员工");
            System.out.println("2. 辞职员工");
            System.out.println("3. 查询薪水");
            System.out.println("4. 修改薪水");
            System.out.println("5. 退出");
            tp = in.nextInt();
            switch (tp) {
                case 1:
                    employer.addEmployee();
                    break;
                case 2:
                    employer.deleteEmployee();
                    break;
                case 3:
                    employer.querySalary();
                    break;
                case 4:
                    employer.modifySalary();
                    break;
                default:
                    return;
            }
        }
    }
}
