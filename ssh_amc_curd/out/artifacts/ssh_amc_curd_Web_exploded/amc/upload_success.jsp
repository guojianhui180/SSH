<%--
  Created by IntelliJ IDEA.
  User: 305029953
  Date: 2018/6/30
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>上传成功</title>
</head>
<body>
    <s:if test="#request.amc_row_num_upload">
        <h2>上传成功，成功上传<s:property value="#request.amc_row_num_upload"></s:property>条数据</h2>
    </s:if>
    <s:else>
        Excel无数据
    </s:else>

</body>
</html>
