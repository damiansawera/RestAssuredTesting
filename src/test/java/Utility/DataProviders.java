package Utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException {

        String path = "TestData/UserTestData.xlsx";
        XlsxHelper xlsxHelper = new XlsxHelper(path);

        int rowNum = xlsxHelper.getRowCount("Test1");
        int colCount = xlsxHelper.getCellCount("Test1", 1);

        String apidata[][] = new String[rowNum][colCount];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colCount; j++) {
                apidata[i-1][j] = xlsxHelper.getCellData("Test1", i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name = "Usernames")
    public Object[][] getUsernames() throws IOException {

        String path = "TestData/UserTestData.xlsx";
        XlsxHelper xlsxHelper = new XlsxHelper(path);

        int rowNum = xlsxHelper.getRowCount("Test1");

        String apidata[][] = new String[rowNum][1];

        for (int i = 0; i < rowNum; i++) {
            apidata[i][0] = xlsxHelper.getCellData("Test1", i + 1, 1);
        }
        return apidata;
    }

}
