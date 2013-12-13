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
 * CommonLandingPage.jsp
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

<div class="middle-column-box-full-standard">
    <div class="middle-column-title-standard"><spring:message code="theme.page.title" /></div>
            
    <spring:message code="common.landing.text" />
</div>

<c:if test="${not empty featuredProducts}">
    <c:forEach var="product" items="${featuredProducts}">
        <div class="middle-column-box-full-standard">
            <div class="middle-column-title-standard">
                <a href="${pageContext.request.contextPath}/ui/products/product/${product.productId}"
                    title="${product.productName}">${product.productName}</a>
            </div>
            ${product.shortDesc}
        </div>
    </c:forEach>
</c:if>
