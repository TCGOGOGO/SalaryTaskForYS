import java.io.File;

/**
 * Created by tcgogogo on 17/2/19.
 */
public class FileUtils {

    public static String dir = "/Users/tcgogogo/Desktop/Java/Salary/data/";

    public static boolean QueryIsExistFile(int jobNum) {
        if(new File(dir + jobNum).exists()) {
            return true;
        }
        return false;
    }

    public static File getFile(int jobNum) {
        return new File(dir + jobNum);
    }
}
