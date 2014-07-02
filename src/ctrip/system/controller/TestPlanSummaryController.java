package ctrip.system.controller;

import com.common.WebResponse;
import com.common.viewmodel.*;
import ctrip.system.model.*;
import ctrip.system.service.TestPlanSummaryService;
import ctrip.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/system")
public class TestPlanSummaryController {

    @Resource
    private TestPlanSummaryService testPlanSummaryService;


    @ResponseBody
    @RequestMapping(value = "/listTestSummary.do")
    public GridView<TestPlanSummary> getAllTestPlanSummaries(TestPlanSummarySearchFilter testPlanSummarySearchFilter, HttpServletRequest request,
                                                             HttpServletResponse response) {

        return testPlanSummaryService.getAllTestPlanSummary(testPlanSummarySearchFilter);

    }

    @ResponseBody
    @RequestMapping(value = "/listTestDetail.do")
    public GridView<TestPlanDetail> getAllTestPlanDetails(TestDetailSearchFilter testDetailSearchFilter, HttpServletRequest request,
                                                          HttpServletResponse response) {

        return testPlanSummaryService.getAllTestPlanDetail(testDetailSearchFilter);

    }

    @ResponseBody
    @RequestMapping(value = "/listTestAssert.do")
    public GridView<TestCaseAssertion> getAllTestPlanAssertion(TestAssertionSearchFilter testAssertionSearchFilter, HttpServletRequest request,
                                                               HttpServletResponse response) {

        String contextPath = request.getContextPath();
        String logPath = request.getRealPath("").replace("\\","/")+testAssertionSearchFilter.getPath();
        File file = new File(logPath);
        File[] childFiles = file.listFiles();
        List testCaseAssertions = new ArrayList();
        if (childFiles != null && childFiles.length > 0)
        {
            File afile[];
            int j = (afile = childFiles).length;
            for (int i = 0; i < j; i++)
            {
                File temp = afile[i];
                if (temp.isFile())
                {
                    TestCaseAssertion model = new TestCaseAssertion();
                    model.setFileName(temp.getName());
                    model.setFilePath((new StringBuilder(String.valueOf(contextPath))).append("/log/").append(temp.getAbsolutePath().replace("\\","/").split("/log/")[1]).toString());
                    model.setFileRealPath(temp.getAbsolutePath());
                    testCaseAssertions.add(model);
                }
            }

        }
        GridView gridView = new GridView();
        gridView.setData(testCaseAssertions);
        gridView.setTotal(testCaseAssertions.size());
        return gridView;

    }


    @ResponseBody
    @RequestMapping(value = "/getDetail.do")
    public TestCaseDetail getDetail(Integer testId, HttpServletRequest request,
                                    HttpServletResponse response) {

        return testPlanSummaryService.getTestCaseDetailById(testId);

    }



    @ResponseBody
    @RequestMapping(value = "/listTestSuite.do")
    public GridView<TestSuite> getAllTestSuite(BaseSearchFilter baseSearchFilter, HttpServletRequest request,
                                                             HttpServletResponse response) {

        return testPlanSummaryService.getAllTestSuite(baseSearchFilter);

    }



}
