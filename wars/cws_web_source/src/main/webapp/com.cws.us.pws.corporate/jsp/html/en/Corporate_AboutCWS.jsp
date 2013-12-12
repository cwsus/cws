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
 * com.cws.us.pws.corporate/jsp/html/en
 * Corporate_AboutCWS.jsp
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
    <spring:message code="corporate.about.text" />
    <br /><br />
    <spring:message code="corporate.exp.text" />

    <div class="middle-column-title-standard"><spring:message code="corporate.locations.text" /></div>
    <spring:message code="corporate.text.addr" />
    <br /><br />
    <spring:message code="corporate.street.addr.1" /><br />
    <spring:message code="corporate.street.addr.2" /><br />
    <spring:message code="corporate.city.addr" />

    <c:if test="${not empty fn:trim(doCareersExist) and doCareersExist eq true}">
        <div class="middle-column-box-left-standard">
            <div class="middle-column-title-standard"><spring:message code="careers.title" /></div>
            <spring:message code="careers.open.positions" />
        </div>
    </c:if>
        
    <%--
    <div class="middle-column-title-standard"><a href="../Docs/KevinHuntly.pdf" title="Resume">Kevin Huntly - Lead Developer</a></div>
    A computing professional for nearly ten years, Kevin is the founder and driving force behind
    CaspersBox Web Services. With experience supporting almost every operating system, designing
    and implementing networks, and developing software solutions for Fortune 500 companies, he
    brings with him a vast array of experience that can help your business in any way needed.
    --%>
</div>
