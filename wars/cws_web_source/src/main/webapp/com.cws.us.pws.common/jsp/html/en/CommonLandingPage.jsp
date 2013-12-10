<div class="middle-column-box-full-standard">
    <div class="middle-column-title-standard"><spring:message code="theme.page.title" /></div>
            
    <spring:message code="common.landing.text" />
</div>

<c:if test="${not empty featuredProducts}">
    <c:forEach var="product" items="${featuredProducts}">
        <div class="middle-column-box-left-standard">
            <div class="middle-column-title-standard">${product.productName}</div>
            ${product.shortDesc}
        </div>
    </c:forEach>
</c:if>
