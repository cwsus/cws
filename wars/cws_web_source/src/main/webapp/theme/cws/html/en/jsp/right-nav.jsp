<div id="right-column">
    <div class="right-column-box-standard">
        <div class="right-column-title-blue">
            <a href="${pageContext.request.contextPath}/ui/common/contact" title="<spring:message code="theme.top-nav.contact" />">
                <spring:message code="theme.right-nav.questions" /></a>
        </div>
        <spring:message code="theme.questions.anchor" />
    </div>

    <c:if test="${not empty newsItems}">
        <c:forEach var="newsItem" items="${newsItems}">
            <div class="right-column-box-standard">
                <div class="right-column-title-blue">${newsItem.title}</div>
                ${newsItem.content}
            </div>
        </c:forEach>
    </c:if>
</div>
