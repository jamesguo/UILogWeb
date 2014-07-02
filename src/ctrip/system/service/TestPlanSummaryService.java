package ctrip.system.service;

import com.common.viewmodel.*;
import ctrip.system.dao.TestPlanSummaryDao;
import ctrip.system.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TestPlanSummaryService {

    @Resource(name = "testPlanSummaryDao")
    private TestPlanSummaryDao testPlanSummaryDao;


    public GridView<TestPlanSummary> getAllTestPlanSummary(TestPlanSummarySearchFilter testPlanSummarySearchFilter) {
        testPlanSummarySearchFilter.setPageIndex(testPlanSummarySearchFilter.getPageSize()*testPlanSummarySearchFilter.getPageIndex());
        List<TestPlanSummary> testPlanSummaries = testPlanSummaryDao.getAllTestSummaries(testPlanSummarySearchFilter);
        Integer testPlanSummariesCount = testPlanSummaryDao.getAllTestPlanSummariesCount(testPlanSummarySearchFilter);
        GridView<TestPlanSummary> gridView = new GridView<TestPlanSummary>();
        gridView.setData(testPlanSummaries);
        gridView.setTotal(testPlanSummariesCount);
        return gridView;
    }

    public GridView<TestPlanDetail> getAllTestPlanDetail(TestDetailSearchFilter testDetailSearchFilter) {
        testDetailSearchFilter.setPageIndex(testDetailSearchFilter.getPageSize()*testDetailSearchFilter.getPageIndex());
        List<TestPlanDetail> testPlanDetails = testPlanSummaryDao.getAllTestDetail(testDetailSearchFilter);
        Integer testPlanSummariesCount = testPlanSummaryDao.getAllTestDetailCount(testDetailSearchFilter);
        GridView<TestPlanDetail> gridView = new GridView<TestPlanDetail>();
        gridView.setData(testPlanDetails);
        gridView.setTotal(testPlanSummariesCount);
        return gridView;
    }


    public GridView<TestCaseAssertion> getAllTestPlanAssertion(TestAssertionSearchFilter testAssertionSearchFilter) {
        testAssertionSearchFilter.setPageIndex(testAssertionSearchFilter.getPageSize()*testAssertionSearchFilter.getPageIndex());
        List<TestCaseAssertion> testCaseAssertions = testPlanSummaryDao.getAllTestAssertion(testAssertionSearchFilter);
        Integer testPlanSummariesCount = testPlanSummaryDao.getAllTestAssertionCount(testAssertionSearchFilter);
        GridView<TestCaseAssertion> gridView = new GridView<TestCaseAssertion>();
        gridView.setData(testCaseAssertions);
        gridView.setTotal(testPlanSummariesCount);
        return gridView;
    }


    public TestCaseDetail getTestCaseDetailById(Integer id){
        return testPlanSummaryDao.getTestCaseDetailById(id);
    }

    public GridView<TestSuite> getAllTestSuite(BaseSearchFilter baseSearchFilter) {
        baseSearchFilter.setPageIndex(baseSearchFilter.getPageSize()*baseSearchFilter.getPageIndex());
        List<TestSuite> testSuites = testPlanSummaryDao.getAllTestSuite(baseSearchFilter);
        Integer testSuiteCount = testPlanSummaryDao.getAllTestSuiteCount(baseSearchFilter);
        GridView<TestSuite> gridView = new GridView<TestSuite>();
        gridView.setData(testSuites);
        gridView.setTotal(testSuiteCount);
        return gridView;
    }


}

