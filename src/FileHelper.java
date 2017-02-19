/**
 * Created by tcgogogo on 17/2/19.
 */
import java.io.*;

public class FileHelper {

    public File file;

    public FileHelper(int jobNum) throws IOException {
        file = new File(FileUtils.dir + jobNum);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public FileHelper(Employee e) throws IOException {
        file = new File(FileUtils.dir + e.getJobNum());
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void writeToFile(String content) throws FileNotFoundException {
        FileOutputStream fileOut = new FileOutputStream(file, true);
        try {
            fileOut.write(content.getBytes("utf-8"));
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile() throws IOException {
        FileInputStream fileIn = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileIn));
        String line = "";
        String ans = "";
        while((line = br.readLine()) != null) {
            ans = line;
        }
        br.close();
        return ans;
    }
}
