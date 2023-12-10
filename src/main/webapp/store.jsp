<%@ page contentType="text/html;charset=UTF-8" language="java" %>\
<%@ taglib prefix = "cp" uri = "WEB-INF/components.tld"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Store</title>
</head>
<body>
    <cp:Menu items="${items}" />
    <cp:Table table="${table}" />
    <h1>Store</h1>
</body>
</html>