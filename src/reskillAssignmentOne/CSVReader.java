package reskillAssignmentOne;
import java.io.*;

public class CSVReader {
    private String filePath= "C:\\Reskill\\salesrecords.txt";
    private  String line="";
    private  String[] CSVvalues;

    public String[] readCSVFile (String filePath) throws FileNotFoundException,IOException{
        BufferedReader br;
        {
            try {
                br = new BufferedReader(new FileReader(filePath));
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    CSVvalues = line.split(",");
                }
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            } catch (IOException ioe) {
                throw new IOException();
            }
        }
    return CSVvalues;
    }
}
