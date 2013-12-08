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
<%@page contentType="text/html" pageEncoding="UTF-8" isThreadSafe="true" isErrorPage="true" %>

<html>
    <head>
        <title>CaspersBox Web Services - Technical Difficulties</title>
        <link rel="stylesheet" type="text/css" href="/html/cws/css/cws.css" />
        <link rel="image/x-icon" href="/html/cws/img/favicon.ico" />
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <script type="text/javascript" src="/html/cws/js/FormHandler.js"></script>
        <meta http-equiv="Content-Script-Type" content="text/javascript" />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <meta http-equiv="Content-Language" content="en-US" />
        <meta http-equiv="pragma" content="no-cache" />
        <meta http-equiv="expires" content="-1" />
        <meta http-equiv="cache-control" content="no-store, no-cache, must-revalidate" />
        <meta http-equiv="max-age" content="0" />
        <meta name="robots" content="index,follow,noarchive" />
        <meta name="GoogleBot" content="noarchive" />
        <meta name="Author" content="admins@caspersbox.com" />
        <meta name="copyright" content="&copy; 2008 CaspersBox Web Services" />
        <meta name="description" content="CaspersBox Web Services is your full service provider for all your development and consulting needs." />
        <meta name="keywords" content="incident, change management, incident management, infinix, caspersbox, caspersbox web services" />
        <script type="text/javascript">
            <!--
            if (top != self)
            {
                top.location = self.location;
            }
            //-->
        </script>
    </head>


    <body>
        <div id="wrap">
			<div id="header-banner">
			    <div id="header-nav-top">
			        <ul>
			            <li>
			                <a href="${pageContext.request.contextPath}/ui/common/contact" title="<spring:message code="theme.top-nav.contact" />">
			                    <spring:message code="theme.top-nav.contact" />
			                </a>
			            </li>
			            <li>
			                <a href="${pageContext.request.contextPath}/ui/common/search" title="<spring:message code='theme.top-nav.search' />">
			                    <spring:message code="theme.top-nav.search" /></a>
			           	</li>
			            <li>
			                <a href="${pageContext.request.contextPath}/ui/common/sitemap" title="<spring:message code='theme.top-nav.sitemap' />">
			                    <spring:message code="theme.top-nav.sitemap" /></a>
			            </li>
			            <li><a href="?lang=en"><img class="img-flag" src="/html/cws/img/img_flag_england.gif" title="<spring:message code="theme.top-nav.switch.en" />" alt=""/></a></li>
			            <li><a href="?lang=es"><img class="img-flag" src="/html/cws/img/img_flag_spain.gif" title="<spring:message code="theme.top-nav.switch.es" />" alt=""/></a></li>
			            <li><a href="?lang=fr"><img class="img-flag" src="/html/cws/img/img_flag_france.gif" title="<spring:message code="theme.top-nav.switch.fr" />" alt=""/></a></li>
			        </ul>
			    </div>
			</div>
			
			<div id="header-nav-bottom">
			    <ul>
			        <li>
			            <a href="${pageContext.request.contextPath}/ui/common/default" title="<spring:message code="theme.top-nav.home" />">
			                <spring:message code="theme.top-nav.home" />
			            </a>
			        </li>
			        <li>
			            <a href="${pageContext.request.contextPath}/ui/products/default" title="<spring:message code="theme.top-nav.products" />">
			                <spring:message code="theme.top-nav.products" />
			            </a>
			        </li>
			        <li>
			            <a href="${pageContext.request.contextPath}/ui/services/default" title="<spring:message code="theme.top-nav.services" />">
			                <spring:message code="theme.top-nav.services" />
			            </a>
			        </li>
			        <li>
			            <a href="${pageContext.request.contextPath}/ui/corp/default" title="<spring:message code="theme.top-nav.corporate" />">
			                <spring:message code="theme.top-nav.corporate" />
			            </a>
			        </li>
			    </ul>
			</div>
			
			<div id="left-column-first">
			    <img class="img-left-nav" src="/html/cws/img/img_left_nav.jpg" alt="" />
</div>

            <div id="middle-column">
                <div class="middle-column-box-full-standard">
                    <div class="middle-column-title-standard"><spring:message code="theme.messaging.send.email.message" /></div>
                    <spring:message code="theme.system.service.failure" />
                </div>
            </div>

            <div id="right-column">
                <div class="right-column-box-standard">
                    <div class="right-column-title-blue"><spring:message code="theme.right-nav.news" /></div>
                    eSolutions entering beta - Contact us to join the test!
                </div>
                <div class="right-column-box-standard">
                    <div class="right-column-title-blue"><spring:message code="theme.right-nav.questions" /></div>
                    Please feel free to <a href="${pageContext.request.contextPath}/ui/common/contact" title="Contact Us"> contact us</a>!
                </div>
            </div>

            <div id="footer">
                <spring:message code="theme.footer.copyright" />
            </div>

        </div>
    </body>
</html>
