<c:if test="${not empty featuredProduct}">
    <div class="middle-column-box-full-standard">
        <div class="middle-column-title-standard"><spring:message code="product.featured" /></div>

        <h1>${product.productName}</h1>
    </div>
</c:if>

<div class="middle-column-box-full-standard">
    <div class="middle-column-title-standard"><spring:message code="theme.search.button.text" /></div>
    <form:form name="siteSearchForm" method="post" action="${pageRequest.context.contextPath}/ui/corp/search.htm">
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
