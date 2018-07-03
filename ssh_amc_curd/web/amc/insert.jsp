<%--
  Created by IntelliJ IDEA.
  User: 305029953
  Date: 2018/6/29
  Time: 15:26
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
    <title>新增AMC</title>
</head>
<body>
<a href="download-module.action">模板下载</a>
<s:form action="doamcaction-upload.action" enctype="multipart/form-data" method="POST">
    <s:token></s:token>
    <s:file name="upfile" label="新增的AMC文件"></s:file>
    <s:submit value="submit"></s:submit>
</s:form>
</body>
</html>
