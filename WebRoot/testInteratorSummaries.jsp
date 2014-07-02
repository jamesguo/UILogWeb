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

<div id="testInteratorsGrid" class="mini-datagrid" style="width:600px;height:600px" allowResize="true"
     pageSize="20"
     url="system/listTestSuite.do" idField="testSuiteNo" onrowclick="onSelectionChanged">
    <div property="columns">
        <div field="testSuiteNo" width="100" headerAlign="center" align="center">测试组号
        </div>
        <div field="user" width="150" headerAlign="center" align="center" >
          用户
        </div>
        <div field="testDate" width="150" headerAlign="center" align="center" allowSort="true" renderer="onDateRenderer">
            时间
        </div>

    </div>
</div>


<script type="text/javascript" charset="utf-8">
    //        var testSuiteNO = '177385719';

    mini.parse();


    var grid = mini.get("testInteratorsGrid");


    grid.load();
    grid.sortBy("testDate", "desc");

    function onDateRenderer(e) {
        var l = e.value;
        var d = (new Date(l))
        return d.toLocaleString();

    }


    function onSelectionChanged(e) {

        var grid = e.sender;
        var record = grid.getSelected();
        if (record) {
          var href=location.href.substring(0,location.href.lastIndexOf("/")+1)+ "testsummaries.jsp?testSuiteNO="+record.testSuiteNo;
//          alert(href);
            location.href= href;
        }
    }


</script>
</body>
</html>