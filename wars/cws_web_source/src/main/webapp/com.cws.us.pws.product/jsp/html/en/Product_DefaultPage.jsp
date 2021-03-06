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
 * com.cws.us.pws.product/jsp/html/en
 * Product_DefaultHandler.jsp
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

<script>
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
</script>

<c:if test="${not empty featuredProduct}">
    <div class="middle-column-box-full-standard">
        <div class="middle-column-title-standard"><spring:message code="product.featured" /></div>

        <h1>${product.productName}</h1>
    </div>
</c:if>

<div class="middle-column-box-full-standard">
    <div class="middle-column-title-standard"><spring:message code="theme.search.button.text" /></div>
    <form:form id="siteSearchForm" name="siteSearchForm" action="${pageRequest.context.contextPath}/ui/common/search" method="post">
        <div>
            <label id="searchTerms"><spring:message code="theme.search.terms" /></label>
            <br />
            <form:input path="searchTerms" />
            <form:errors path="searchTerms" cssclass="error" />
            <br /><br />
            <input type="button" name="execute" value="<spring:message code='theme.button.submit.text' />" id="execute" class="submit" onclick="disableButton(this); validateForm(this.form, event);" />
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
