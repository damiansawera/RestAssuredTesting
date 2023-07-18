package utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class UserDataProviders {

    @DataProvider(name = "UsernamesAndPasswords")
    public Object[][] getUsernamesAndPasswords() throws IOException {
        Object[][] usernames = getUsernames();
        Object[][] passwords = getPasswords();

        return mergeDataProviders(usernames, passwords);
    }
    @DataProvider(name = "Usernames")
    public Object[][] getUsernames() throws IOException {
        return getDataByColumnIndex("Test1", 1);
    }
    @DataProvider(name = "Passwords")
    public Object[][] getPasswords() throws IOException {
        return getDataByColumnIndex("Test1", 5);
    }

    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException {
        return getDataByColumnIndex("Test1", -1);
    }

    public Object[][] getDataByColumnIndex(String sheetName, int columnIndex) throws IOException {

        String path = "test_data/UserTestData.xlsx";
        XlsxHelper xlsxHelper = new XlsxHelper(path);

        int rowNum = xlsxHelper.getRowCount(sheetName);
        int colCount = xlsxHelper.getCellCount(sheetName, 1);

        String apidata[][];

        if (columnIndex == -1){
            apidata = new String[rowNum][colCount];
            for (int i = 1; i <= rowNum; i++) {
                for (int j = 0; j < colCount; j++) {
                    apidata[i-1][j] = xlsxHelper.getCellData("Test1", i, j);
                }
            }
        } else {
                apidata = new String[rowNum][1];
            for (int i = 0; i < rowNum; i++) {
                apidata[i][0] = xlsxHelper.getCellData("Test1", i + 1, columnIndex);
            }
        }
        return apidata;
    }
    private Object[][] mergeDataProviders(Object[][] dataProvider1, Object[][] dataProvider2) {
        int rowCount = Math.max(dataProvider1.length, dataProvider2.length);
        Object[][] mergedData = new Object[rowCount][2];

        for (int i = 0; i < rowCount; i++) {
            mergedData[i][0] = (i < dataProvider1.length) ? dataProvider1[i][0] : null;
            mergedData[i][1] = (i < dataProvider2.length) ? dataProvider2[i][0] : null;
        }

        return mergedData;
    }


}
