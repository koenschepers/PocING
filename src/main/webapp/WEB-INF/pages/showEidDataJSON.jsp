<!DOCTYPE html>
<html>
<head>
    <title>Test Autosubmit</title>
    <script src="resources/js/jquery-1.11.0.min.js" ></script>
    <script type="text/javascript">
        function submitEidData() {
            var data = $('#eidData').val();
            $('<input type="hidden" name="json"/>').val(data).appendTo('#eidForm');
            $("#eidForm").submit();
        }

        $(document).ready(function() {
            submitEidData();
        });
    </script>
</head>
<body>
<textarea id="eidData">${eidData}</textarea>
<form id="eidForm" method="POST" action="https://qfbam.cronos.be"></form>
</body>
</html>