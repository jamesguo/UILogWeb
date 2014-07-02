package com.common.viewmodel;

/**
 * Created with IntelliJ IDEA.
 * User: flai
 * Date: 14-4-30
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */
public class TestDetailSearchFilter extends BaseSearchFilter {
    private String testSuiteNO;
    private String testPlanName;
    private int case_number;
    public String getTestSuiteNO() {
        return testSuiteNO;
    }

    public void setTestSuiteNO(String testSuiteNO) {
        this.testSuiteNO = testSuiteNO;
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
