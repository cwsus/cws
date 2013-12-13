<div id="right-column">
    <div class="right-column-box-standard">
        <div class="right-column-title-blue"><spring:message code="theme.right-nav.questions" /></div>
        <spring:message code="theme.questions.anchor" arguments="${pageContext.request.contextPath}/ui/common/contact" />
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
