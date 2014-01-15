<%--
  Created by IntelliJ IDEA.
  User: kschepers
  Date: 1/13/14
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
</div>
<fieldset>
    <legend>Data van de e-ID</legend>

    <br class="clear" />

    <p class="formRowWithBorder">
        <label for="">Achternaam</label>
        <input name="AchternaamTextBox" type="text" id="AchternaamTextBox" value="${eid.identity.name}"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Voornaam</label>
        <input name="VoornaamTextBox" type="text" id="VoornaamTextBox" value="${eid.identity.firstName}"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Rijksregisternummer</label>
        <input name="RijksregisternummerTextBox" type="text" id="RijksregisternummerTextBox" value="${eid.identity.nationalNumber}"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Adres</label>
        <input name="AdresTextBox" type="text" id="AdresTextBox" value="${eid.address.streetAndNumber}"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Postcode</label>
        <input name="PostcodeTextBox" type="text" id="PostcodeTextBox" value="${eid.address.zip}"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Gemeente</label>
        <input name="GemeenteTextBox" type="text" id="GemeenteTextBox" value="${eid.address.municipality}"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Nationaliteit</label>
        <input name="NationaliteitTextBox" type="text" id="NationaliteitTextBox" value="${eid.identity.nationality}"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Geboorteplaats</label>
        <input name="GeboorteplaatsTextBox" type="text" id="GeboorteplaatsTextBox" value="${eid.identity.placeOfBirth}"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Geboortedatum (dd/mm/jjjj)</label>
        <input name="GeboortedatumTextBox" type="text" id="GeboortedatumTextBox" value="<fmt:formatDate value="${eid.identity.dateOfBirth.time}" pattern="dd/MM/YYYY" />"/>
    </p>

    <p class="formRowWithBorder">
        <label for="">Geslacht</label>
        <input name="GeslachtTextBox" type="text" id="GeslachtTextBox" value="${eid.identity.gender}"/>
    </p>
</fieldset>

<p class="buttontoolbar">
    <a href="readEid">Uitlezen e-ID</a>
    <a href="readEidPin">Uitlezen e-ID (JSON)</a>
</p>
</form>
</body>
</html>
