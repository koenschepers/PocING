<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <script src="https://www.java.com/js/deployJava.js"></script>
    <script>
        var attributes = {
            code :'be.fedict.eid.applet.Applet.class',
            archive :'resources/jar/eid-applet-package-1.1.3.jar',
            width :1,
            height :1
        };

        var parameters = {
            //TargetPage :'http://contribute-eid-poc.apphb.com/',
            TargetPage :'showEidData',
            AppletService :'applet-service;jsessionid=<%=session.getId()%>',
            BackgroundColor :'#ffffff',
            Language : 'en',
            HideDetailsButton : true
        };
        var version = '1.6';
        deployJava.runApplet(attributes, parameters, version);
    </script>
</head>
<body>
<img src="<c:url value="/resources/img/ing.gif" />" alt="logo ING" height="47" width="185"/>
</body>
</html>