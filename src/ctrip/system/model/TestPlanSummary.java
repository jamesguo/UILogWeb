package ctrip.system.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: flai
 * Date: 14-4-29
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */


//select sum(is_pass_validation) as passCaseNumber,count(id) as totalCaseNumber ,(sum(is_pass_validation)/count(id))*100 as passRate, test_plan_name,max(timestamp) as end_time, min(timestamp) as start_time
//        from test
//        where test_suite_no=287101983
//        group by test_plan_name
public class TestPlanSummary {

    private String testPlanName;
    private int passCaseNumber;
    private int totalCaseNumber;
    private float passRate;
    private Date endDate;
    private Date startDate;
    private int case_number;


    public int getPassCaseNumber() {
        return passCaseNumber;
    }

    public void setPassCaseNumber(int passCaseNumber) {
        this.passCaseNumber = passCaseNumber;
    }

    public int getTotalCaseNumber() {
        return totalCaseNumber;
    }

    public void setTotalCaseNumber(int totalCaseNumber) {
        this.totalCaseNumber = totalCaseNumber;
    }

    public float getPassRate() {
        return passRate;
    }

    public void setPassRate(float passRate) {
        this.passRate = passRate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTestPlanName() {
        return testPlanName;
    }

    public void setTestPlanName(String testPlanName) {
        this.testPlanName = testPlanName;
    }

    public int getCase_number() {
        return case_number;
    }

    public void setCase_number(int case_number) {
        this.case_number = case_number;
    }
}
