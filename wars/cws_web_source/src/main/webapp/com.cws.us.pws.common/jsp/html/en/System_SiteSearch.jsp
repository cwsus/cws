<%--
/**
 * Copyright (c) 2009 - 2013 By: CWS, Inc.
 * 
 * All rights reserved. These materials are confidential and
 * proprietary to CaspersBox Web Services N.A and no part of
 * these materials should be reproduced, published in any form
 * by any means, electronic or mechanical, including photocopy
 * or any information storage or retrieval system not should
 * the materials be disclosed to third parties without the
 * express written authorization of CaspersBox Web Services, N.A.
 *
 * eSolutions_web_source
 * com.cws.us.pws.common/jsp/html/en
 * System_SiteSearch.jsp
 *
 * $Id$
 * $Author$
 * $Date$
 * $Revision$
 * @author kh05451
 * @version 1.0
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 16, 2013 11:53:26 AM
 *     Created.
 */
--%>

<!--
function validateForm(theForm)
{
    if (theForm.searchTerms.value = '')
    {
        clearText(theForm);

        document.getElementById('validationError').innerHTML = 'Search terms must be provided.';
        document.getElementById('txtSearchTerms').style.color = '#FF0000';
        document.getElementById('execute').disabled = false;
        document.getElementById('searchTerms').focus();
    }
    else
    {
        theForm.submit();
    }
}
//-->

<div class="middle-column-box-full-standard">
    <div class="middle-column-title-standard"><spring:message code="site.search.header" /></div>

    <div id="error"></div>

    <c:if test="${not empty fn:trim(messageResponse)}">
        <p id="info">${messageResponse}</p>
    </c:if>
    <c:if test="${not empty fn:trim(errorResponse)}">
        <p id="error">${errorResponse}</p>
    </c:if>
    <c:if test="${not empty fn:trim(responseMessage)}">
        <p id="info"><spring:message code="${responseMessage}" /></p>
    </c:if>
    <c:if test="${not empty fn:trim(errorMessage)}">
        <p id="error"><spring:message code="${errorMessage}" /></p>
    </c:if>
    <c:if test="${not empty fn:trim(param.responseMessage)}">
        <p id="info"><spring:message code="${param.responseMessage}" /></p>
    </c:if>
    <c:if test="${not empty fn:trim(param.errorMessage)}">
        <p id="error"><spring:message code="${param.errorMessage}" /></p>
    </c:if>

    <form:form name="siteSearchForm" method="post" action="${pageRequest.context.contextPath}/ui/common/search">
        <div>
            <label id="searchTerms"><spring:message code="theme.search.terms" /></label>
            <input type="button" name="execute" value="<spring:message code='theme.button.submit.text' />" id="execute" class="submit" onclick="disableButton(this); validateForm(this.form);" />
        </div>
    </form:form>

    <c:if test="${not empty fn:trim(requestScope.searchResults)}">
        <hr />
        <spring:message code="theme.search.results" />
        <br />
        <table id="searchResults">
            <tr>
                <td><spring:message code="site.search.results" /></td>
            </tr>
            <c:forEach var="searchResult" items="${requestScope.searchResults}">
                <tr>
                    <td>
                        <a href="${searchResult.path}" title="${searchResult.title}">${searchResult.title}</a>
                    </td>
                    <td>${userResult.displayName}</td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${pages gt 1}">
            <br />
            <hr />
            <br />
            <table>
                <tr>
                    <c:forEach begin="1" end="${pages}" var="i">
                        <c:choose>
                            <c:when test="${page eq i}">
                                <td>${i}</td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ui/common/search/${searchTerms}/page/${i}" title="{i}">${i}</a>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </table>
        </c:if>
    </c:if>
</div>
