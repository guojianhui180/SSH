<%--
  Created by IntelliJ IDEA.
  User: 305029953
  Date: 2018/6/29
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    table tr td{
        margin: 12px;
        padding: 12px;
    }
</style>
<script src="../scripts/jquery-1.9.1.min.js"></script>
<script src="../scripts/Ajax.js"></script>
<script src="../scripts/jquery.blockUI.js"></script>
<script src="../scripts/php_server_valiate.js"></script>
<script type="text/javascript">
    $(function () {
        $(":button").click(function () {
            var org=$(":input[name=org]").val();
            org=$.trim(org)
            var end_jog_num=$(":input[name=endJobNumber]").val();
            end_jog_num=$.trim(end_jog_num)
            if(end_jog_num=="")
            {
                alert("End_Job_Number不能为空");
                return;
            }
            var endJobLot=$(":input[name=endJobLot]").val();
            endJobLot=$.trim(endJobLot)
            if(endJobLot=="")
            {
                alert("End_Job_Lot不能为空");
                return;
            }
            url="doamcaction-update";
            $.post(url,{"org":org,"endJobNumber":end_jog_num,"endJobLot":endJobLot},function (data) {
                if(data.indexOf("登陆失效")!=-1)
                {
                    alert("登陆已失效,请尝试刷新页面或重新登陆!");
                }else if(data.indexOf("没有权限访问")!=-1){
                    alert("你没有此操作的权限!");
                }else{
                    alert(data);
                }
            })
        });

    })

</script>
<html>
<head>
    <title>更正End_Job_Lot</title>
</head>
<body>
    <DIV>
        <table>
            <tr>
                <td align="right">ORG:<input type="text" name="org"></td>
                <td align="right">End_Job_Number:<input type="text" name="endJobNumber"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    更新后的End_Job_Lot:<input type="text" name="endJobLot">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="更新End_Job_Lot"　id="amc_update">
                </td>
            </tr>
        </table>
    </DIV>
</body>
</html>
