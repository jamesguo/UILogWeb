package ctrip.system.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: flai
 * Date: 14-5-4
 * Time: 上午10:09
 * To change this template use File | Settings | File Templates.
 */
public class TestSuite {
    private String testSuiteNo;
    private Date testDate;
    private String user;


    public String getTestSuiteNo() {
        return testSuiteNo;
    }

    public void setTestSuiteNo(String testSuiteNo) {
        this.testSuiteNo = testSuiteNo;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
