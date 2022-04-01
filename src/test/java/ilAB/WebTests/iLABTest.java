package ilAB.WebTests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ilAB.Data.Data;
import ilAB.WebUtilities.webUtilities;
import ilAB.extentReports.Reporting;
import ilAB.pageObjects.WebFunctions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.ResultSet;


public class iLABTest {
    public webUtilities web = new webUtilities();
    public WebFunctions iLAB = new WebFunctions();
    public Reporting repo = new Reporting();
   public Data data =new Data();
    String sUrl,sBrowser;
    ExtentReports reports;
    //ResultSet resultSet;
    //Recordset rs;

    @Parameters({"ILABURL", "Browser"})
    @BeforeTest
    public void init(String sAdactinUrl,String Browser){
        sUrl = sAdactinUrl;
        sBrowser = Browser;
        //dataStore=sdatastore;
        web.setWebDriver(web.initializeWebDriver(sBrowser));
       reports = repo.initializeExtentReports("reports/report.html");
    }

    @Test
    public void Apply () throws InterruptedException {

        ExtentTest test= reports.createTest("Apply at iLAB");
        test.assignAuthor("MUTSHAFA_L");
        ExtentTest node;
        ResultSet rs;


        try {
              //connecting to the database and retrieve data
            rs= data.ConnectAndQuerySQL("jdbc:mysql://localhost:3306/ilab",
                    "root", "Livhu98#", "Select * from ilabdata");
            int iRow= data.rowCount(rs);
            web.navigate(sUrl);
            for (int i=1;i<=iRow;i++) {
                if (rs.next()) {

                   node = test.createNode("iLAB south africa unsuccessful application for  :"+rs.getString("FirstName" )+ "\t"+"using " +"\t" +sBrowser +"\t" +"Browser");
                    iLAB.careers(web.getWebDriver(), node);
                    iLAB.country(web.getWebDriver(), node);
                    iLAB.openings(web.getWebDriver(), node);
                    iLAB.Apply(web.getWebDriver(),rs,node);
                    iLAB.validate(web.getWebDriver(),node);
                }
            }
            rs.close();


        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }

    }


        @AfterTest
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        web.getWebDriver().quit();
        reports.flush();
    }
}
