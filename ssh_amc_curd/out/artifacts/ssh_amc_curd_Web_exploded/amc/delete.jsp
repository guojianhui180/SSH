<%--
  Created by IntelliJ IDEA.
  User: 305029953
  Date: 2018/6/27
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <script src="../scripts/jquery-1.9.1.min.js"></script>
    <script src="../scripts/Ajax.js"></script>
    <script src="../scripts/jquery.blockUI.js"></script>
    <script src="../scripts/php_server_valiate.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#amc_del").click(function () {
                var org = $(":input[name=org]").val();
                org = $.trim(org);
                var end_jog_num = $(":input[name=endJobNumber]").val();
                end_jog_num = $.trim(end_jog_num);
                if (end_jog_num == "") {
                    alert("End_Job_Number不能为空");
                    return;
                }
                url = "doamcaction-delete";
                $.post(url, {"org": org, "endJobNumber": end_jog_num}, function (data) {
                    if(data.indexOf("权限")!=-1 || data.indexOf("登陆")!=-1 )
                    {
                        $("#content").empty().append(data);
                    }else {
                        alert(data);
                    }

                });
            });
            $("#amc_query").click(function () {
                var org = $(":input[name=org]").val();
                org = $.trim(org);
                var end_jog_num = $(":input[name=endJobNumber]").val();
                end_jog_num = $.trim(end_jog_num);
                if (end_jog_num == "") {
                    alert("End_Job_Number不能为空");
                    return;
                }
                url = "doamcaction-list";
                $.post(url, {"org": org, "endJobNumber": end_jog_num}, function (data) {
                    $("#content").empty().append(data);
                    $("a").click(function () {
                        var url = this.href;
                        var flag = confirm("确定要删除该条记录吗?");
                        var tr= $(this).parent().parent();

                        //用jquery的这个也可以($(this).attr("href"));
                        if (flag) {
                            $.post(url, function (data) {
                                if (data == "你要删除的记录不存在") {
                                    alert(data);
                                } else {
                                    tr.remove();
                                    alert(data);
                                }
                            });
                        }
                        //取消默认的链接点击行为
                        return false;
                    });
                })

            });


        })

    </script>
    <title>修改AMC</title>
</head>
<body>
<div id="query">
    <table>
        <tr>
            <td align="right">ORG:<input type="text" name="org"></td>
            <td align="right">End_Job_Number:<input type="text" name="endJobNumber"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="button" value="查询" id="amc_query">
                <input type="button" value="删除" id="amc_del">
            </td>
        </tr>
    </table>
</div>
<div id="content">

</div>
</body>
</html>
