<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $("#countrySelect").change(function(){
            if($(this).children("option:selected").text() == "한국(KRW)"){
                $("#exchangeRate").text(commaFn($("#krw").val()) + " KRW/USD");
            } else if($(this).children("option:selected").text() == "일본(JPY)") {
                $("#exchangeRate").text(commaFn($("#jpy").val()) + " JPY/USD");
            } else if($(this).children("option:selected").text() == "필리핀(PHP)") {
                $("#exchangeRate").text(commaFn($("#php").val()) + " PHP/USD");
            } else {
                $("#exchangeRate").text("");
            }
        });
    });

    function receivedAmount(){
        if($("#remittance").val() == "" || $("#remittance").val() == 0 || $("#remittance").val() > 10000){
            alert("송금액이 바르지 않습니다.");
        } else if($("#countrySelect").children("option:selected").text()  == "한국(KRW)") {
            $("#result").text(receivedAmount_commaFn($("#krw").val() * $("#remittance").val()));
        } else if($("#countrySelect").children("option:selected").text()  == "일본(JPY)") {
            $("#result").text(receivedAmount_commaFn($("#jpy").val() * $("#remittance").val()));
        } else if($("#countrySelect").children("option:selected").text()  == "필리핀(PHP)") {
            $("#result").text(receivedAmount_commaFn($("#php").val() * $("#remittance").val()));
        }
    };

    function commaFn(value) {
        return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }

    function receivedAmount_commaFn(value) {
        value = String(value);
        console.log(value);
        var result;
        if(value.indexOf(".") == -1) {
            result = "수취금액은 " + commaFn(value) + ".00" + " 입니다.";
            return result;
        } else {
            var strArray = value.split(".");
            result = "수취금액은 " + commaFn(strArray[0]) +"."+strArray[1].substring(0,2) + " 입니다.";
            return result;

        }
    }

</script>
<body>
<input type="hidden" id="krw" value="${result.quotes.USDKRW}">
<input type="hidden" id="php" value="${result.quotes.USDPHP}">
<input type="hidden" id="jpy" value="${result.quotes.USDJPY}">
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div class="page-header">
                <h1>환율 계산</h1>
            </div>
            <form>
                <div class="form-group">
                    <div>송금국가: 미국(USD)</div>
                </div>
                <div class="form-group">
                    <div>수취국가</div>
                    <select class="form-control" id="countrySelect">
                        <option>default</option>
                        <option>한국(KRW)</option>
                        <option>일본(JPY)</option>
                        <option>필리핀(PHP)</option>
                    </select>
                </div>
                <div class="form-group">
                    <div>환율: </div>
                    <div id="exchangeRate"></div>
                </div>
                <div class="form-group">
                    <div>송금액 : </div>
                    <input type="text" class="form-control"id="remittance">
                </div>
                <div class="form-group"><input type="button" onclick="javascript:receivedAmount();" class="btn" value="Submit"></div>
            </form>

            <div id="result"></div>
        </div>
    </div>
</div>
</body>
</html>