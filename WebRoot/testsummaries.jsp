<%@ page language="java" pageEncoding="utf-8" %>


<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="script/miniui/themes/icons.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" charset="utf-8" src="script/jquery-1.8.2.js"></script>
    <link href="script/miniui/themes/default/miniui.css" rel="stylesheet" type="text/css"/>
    <link href="script/miniui/themes/blue/skin.css" rel="stylesheet" type="text/css"/>
    <script src="script/miniui/miniui.js" type="text/javascript"></script>
</head>
<body>
<table>

    <tr>
        <td>
            <div id="testSummariesGrid" class="mini-datagrid" style="width:600px;height:600px" allowResize="true"
                 pageSize="20"
                 url="system/listTestSummary.do" idField="testPlanName" onrowclick="onSelectionChanged">
                <div property="columns">
                    <div field="testPlanName" width="100" headerAlign="center" align="center">测试计划
                    </div>
                    <div field="passCaseNumber" width="70" headerAlign="center" align="center" >通过案例数

                    </div>
                    <div field="totalCaseNumber" width="60" headerAlign="center" align="center" >案例总数
                    </div>
                    <div field="passRate" width="60" headerAlign="center" align="center" >通过率
                    </div>
                    <div field="startDate" width="150" headerAlign="center" align="center" renderer="onDateRenderer">
                        开始时间
                    </div>
                    <div field="endDate" width="150" headerAlign="center" align="center" renderer="onDateRenderer">结束时间
                    </div>
                </div>
            </div>
        </td>
        <td>
            <div id="testDetailGrid" class="mini-datagrid" style="width:700px;height:600px"
                 allowResize="true" pageSize="20" url="system/listTestDetail.do" idField="id"
                 onrowdblclick="showTestDetail">
                <div property="columns">
                    <div field="caseNO" width="60" headerAlign="center" allowSort="true"align="center" >用例号</div>
                    <div field="serviceName" width="100" allowSort="true" align="center" headerAlign="center">设备</div>
                    <div field="rCode" width="60" allowSort="true" align="center" headerAlign="center">
                        服务正常
                    </div>
                    <div field="passValidation" width="60" allowSort="true" align="center" headerAlign="center" >日志路径
                    </div>
                    <div field="processTime" width="100" allowSort="true" align="center" headerAlign="center">服务时间（s）
                    </div>

                </div>
            </div>
        </td>
    </tr>
</table>


<div id="editWindow" class="mini-window" title="TestCase" style="width:1100px;"
     showModal="true" allowResize="true" allowDrag="true">
    <table>
        <tr>
            <td colspan="2" >
                <h3 align="center"><label id="testcaseNO"></label></h3>
            </td>
        </tr>
        <tr>
            <td>
                <div id="testAssertGrid" class="mini-datagrid" style="width:600px;height:395px"
                     allowResize="true" pageSize="20"
                     url="system/listTestAssert.do" idField="id">
                    <div property="columns">
                        <div field="fileName" width="60" headerAlign="center" allowSort="true">文件名</div>
                        <div field="filePath" width="200" allowSort="true" align="center" headerAlign="center" renderer="onActionRenderer" >路径
                        </div>
                    </div>

                </div>
            </td>
        </tr>
    </table>

  </div>
    <script type="text/javascript" charset="utf-8">
//        var testSuiteNO = '177385719';
        var testSuiteNO=<%=request.getParameter("testSuiteNO")%>;
        mini.parse();
        var caseNo;

        var grid = mini.get("testSummariesGrid");
        var testDetailGrid = mini.get("testDetailGrid");
        var editWindow = mini.get("editWindow");
        var testAssertGrid = mini.get("testAssertGrid");

        grid.load({
            testSuiteNO: testSuiteNO
        });

        function onActionRenderer(e) {
        	var record = e.record;
			var path=record.filePath;
			var s = "<a  href="+path+">"+path+"</a>&nbsp;&nbsp;&nbsp;";
			return s;
		}
        function onDateRenderer(e) {
            var l = e.value;
            var d = (new Date(l))
            return d.toLocaleString();

        }


        function onSelectionChanged(e) {

            var grid = e.sender;
            var record = grid.getSelected();
            if (record) {
                testDetailGrid.load({
                    testSuiteNO: testSuiteNO,
                    testPlanName: record.testPlanName,
                    case_number:record.case_number
                });
            }
        }


        function onBooleanRender(e) {
            var b = e.value;
            if (b) {
                return "Passed";
            } else {
                return "Failed";
            }

        }


        function showTestDetail(e) {
            var grid = e.sender;
            var row = grid.getSelected();

            if (row) {

                caseNo = row.caseNO;

                $("#testcaseNO").text("CaseNo:" + caseNo);
                editWindow.show();
                testAssertGrid.load({
                	path: row.passValidation

                });

            }
        }


    </script>
</body>
</html>