<%--
/**
 * Copyright 2008 - 2009 CaspersBox Web Services
 * All rights reserved.
 */
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
/*
 * Default.jsp
 * Default theme file for application display. Only used when the
 * doGet() method is invoked on the ServiceRequestServlet.
 *
 * History
 *
 * Author               Date                           Comments
 * ----------------------------------------------------------------------------
 * Kevin Huntly         11/23/2008 22:39:20            Created.
 * Kevin Huntly         12/22/2009 14:58:03            Added escape chars
 */
 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isThreadSafe="true" %>

<html>
    <tiles:insertAttribute name="head" />

    <body>
        <div id="wrap">
            <tiles:insertAttribute name="top-nav" />

            <div id="middle-column">
                <c:if test="${not empty alertMessages}">
                    <c:forEach var="message" items="${alertMessages}">
                        <div class="middle-column-box-full-standard">
                            <div class="middle-column-title-standard-error"><spring:message code="theme.important.message" /></div>
                            ${message.messageText}
                        </div>
                    </c:forEach>
                </c:if>

                <tiles:insertAttribute name="body" />
            </div>

            <tiles:insertAttribute name="right-nav" />
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>

