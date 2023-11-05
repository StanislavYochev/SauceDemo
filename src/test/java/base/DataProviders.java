package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "validUserNameFromCsv")
    public Object[][] readValidUserNameFromCsv(){
        try{
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++){
                csvDataObj[i] = csvData.get(1);
            }
            return csvDataObj;
        }catch (IOException e){
            System.out.println("Could not find CSV file!");
            return null;
        }catch (CsvException e){
            System.out.println("It is not possible to work with the CSV file!");
            return null;
        }
    }

    @DataProvider(name = "wrongUsers")
    public Object[][] getWrongUsers(){
        return new Object[][]{
                {"wrongUsername", "secret_sauce"},
                {"visual_user", "wrong password"},
                {"wrongUsername","wrong password"}
        };
    }
}
