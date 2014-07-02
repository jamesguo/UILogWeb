package ctrip.system.dao;

import com.common.viewmodel.BaseSearchFilter;
import com.common.viewmodel.TestAssertionSearchFilter;
import com.common.viewmodel.TestDetailSearchFilter;
import com.common.viewmodel.TestPlanSummarySearchFilter;
import ctrip.system.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestPlanSummaryDao extends BaseDao {


    @SuppressWarnings("unchecked")
    public List<TestPlanSummary> getAllTestSummaries(TestPlanSummarySearchFilter testPlanSummarySearchFilter) {
        return (List<TestPlanSummary>) getSqlMapClientTemplate().queryForList("getAllTestPlanSummaries", testPlanSummarySearchFilter);
    }

    public Integer getAllTestPlanSummariesCount(TestPlanSummarySearchFilter testPlanSummarySearchFilter) {
        return (Integer) getSqlMapClientTemplate().queryForObject("getAllTestPlanSummariesCount", testPlanSummarySearchFilter);
    }

    @SuppressWarnings("unchecked")
    public List<TestPlanDetail> getAllTestDetail(TestDetailSearchFilter testDetailSearchFilter) {
        return (List<TestPlanDetail>) getSqlMapClientTemplate().queryForList("getAllTestDetail", testDetailSearchFilter);

    }

    public int getAllTestDetailCount(TestDetailSearchFilter testDetailSearchFilter) {
        return (Integer) getSqlMapClientTemplate().queryForObject("getAllTestDetailCount", testDetailSearchFilter);

    }


    @SuppressWarnings("unchecked")
    public List<TestCaseAssertion> getAllTestAssertion(TestAssertionSearchFilter testAssertionSearchFilter) {
        return (List<TestCaseAssertion>) getSqlMapClientTemplate().queryForList("getAllTestAssertion", testAssertionSearchFilter);

    }

    public int getAllTestAssertionCount(TestAssertionSearchFilter testAssertionSearchFilter) {
        return (Integer) getSqlMapClientTemplate().queryForObject("getAllTestAssertionCount", testAssertionSearchFilter);

    }


    public TestCaseDetail getTestCaseDetailById(int id){
          return (TestCaseDetail) getSqlMapClientTemplate().queryForObject("getTestCaseDetail",id);
    }


    @SuppressWarnings("unchecked")
    public List<TestSuite> getAllTestSuite(BaseSearchFilter baseSearchFilter) {
        return (List<TestSuite>) getSqlMapClientTemplate().queryForList("getAllTestSuite", baseSearchFilter);

    }

    public int getAllTestSuiteCount(BaseSearchFilter baseSearchFilter) {
        return (Integer) getSqlMapClientTemplate().queryForObject("getAllTestSuiteCount", baseSearchFilter);

    }


}
