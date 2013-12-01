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
 */
package com.cws.us.pws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import org.springframework.beans.factory.annotation.Autowired;

import com.cws.esolutions.core.Constants;
/**
 * CWSPWS_java_source
 * com.cws.us.pws
 * ApplicationConfig.java
 *
 * TODO: Add class description
 *
 * $Id: cws-codetemplates.xml 2286 2013-01-03 20:50:12Z kmhuntly@gmail.com $
 * $Author: kmhuntly@gmail.com $
 * $Date: 2013-01-03 15:50:12 -0500 (Thu, 03 Jan 2013) $
 * $Revision: 2286 $
 * @author khuntly
 * @version 1.0
 *
 * History
 * ----------------------------------------------------------------------------
 * khuntly @ Apr 18, 2013 7:42:45 PM
 *     Created.
 */
public class ApplicationServiceBean
{
    @Autowired private String homePage = null;
    @Autowired private String dateFormat = null;
    @Autowired private String fileEncoding = null;
    @Autowired private String homeRedirect = null;
    @Autowired private String applicationId = null;
    @Autowired private String applicationName = null;
    @Autowired private String unavailablePage = null;
    @Autowired private String contactAdminsPage = null;
    @Autowired private String errorResponsePage = null;
    @Autowired private String searchRequestPage = null;
    @Autowired private String themeMessageSource = null;
    @Autowired private String requestCompletePage = null;
    @Autowired private String messageNoSearchResults = null;
    @Autowired private String messageEmailSendFailed = null;
    @Autowired private String messageRequestCanceled = null;
    @Autowired private String messageValidationFailed = null;
    @Autowired private String messageEmailSentSuccess = null;
    @Autowired private EmailAddressValidator emailValidator = null;
    @Autowired private EmailMessageValidator messageValidator = null;
    @Autowired private String messageRequestProcessingFailure = null;

    private static final String CNAME = ApplicationServiceBean.class.getName();

    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();
    private static final Logger ERROR_RECORDER = LoggerFactory.getLogger(Constants.ERROR_LOGGER);

    public final void setFileEncoding(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setFileEncoding(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.fileEncoding = value;
    }

    public final void setLogonType(final LogonType value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setLogonType(final LogonType value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.logonType = value;
    }

    public final void setLogonRedirect(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setLogonRedirect(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.logonRedirect = value;
    }

    public final void setExpiredRedirect(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setExpiredRedirect(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.expiredRedirect = value;
    }

    public final void setHomeRedirect(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setHomeRedirect(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.homeRedirect = value;
    }

    public final void setHomePage(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setHomePage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.homePage = value;
    }

    public final void setUnavailablePage(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setUnavailablePage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.unavailablePage = value;
    }

    public final void setUnauthorizedPage(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setUnauthorizedPage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.unauthorizedPage = value;
    }

    public final void setContactAdminsPage(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setContactAdminsPage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.contactAdminsPage = value;
    }

    public final void setErrorResponsePage(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setErrorResponsePage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.errorResponsePage = value;
    }

    public final void setSearchRequestPage(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setSearchRequestPage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.searchRequestPage = value;
    }

    public final void setRequestCompletePage(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setRequestCompletePage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.requestCompletePage = value;
    }

    public final void setRequestTimeout(final int value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setRequestTimeout(final int value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.requestTimeout = value;
    }

    public final void setDateFormat(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setDateFormat(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.dateFormat = value;
    }

    public final void setSecEmailAddr(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setSecEmailAddr(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.secEmailAddr = value;
    }

    public final void setTimeoutWarning(final int value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setTimeoutWarning(final int value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.timeoutWarning = value;
    }

    public final void setApplicationName(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setApplicationName(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.applicationName = value;
    }

    public final void setApplicationId(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setApplicationId(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.applicationId = value;
    }

    public final void setServices(final Map<String, Boolean> value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setServices(final Map<String, Boolean> value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.services = value;
    }

    public final void setUploadDirectory(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setUploadDirectory(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.uploadDirectory = value;
    }

    public final void setAllowedAppFileExtensions(final List<String> value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setAllowedAppFileExtensions(final List<String> value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.allowedAppFileExtensions = value;
    }

    public final void setAllowedWebFileExtensions(final List<String> value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setAllowedWebFileExtensions(final List<String> value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.allowedWebFileExtensions = value;
    }

    public final void setMessageRequestCanceled(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessageRequestCanceled(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageRequestCanceled = value;
    }

    public final void setMessageEmailSendFailed(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessageEmailSendFailed(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageEmailSendFailed = value;
    }

    public final void setMessagePasswordExpired(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessagePasswordExpired(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messagePasswordExpired = value;
    }

    public final void setMessageUserNotLoggedIn(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessageUserNotLoggedIn(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageUserNotLoggedIn = value;
    }

    public final void setMessageRequestProcessingFailure(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessageRequestProcessingFailure(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageRequestProcessingFailure = value;
    }

    public final void setMessageValidationFailed(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessageValidationFailed(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageValidationFailed = value;
    }

    public final void setMessageNoSearchResults(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessageNoSearchResults(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageNoSearchResults = value;
    }

    public final void setMessageEmailSentSuccess(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessageEmailSentSuccess(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageEmailSentSuccess = value;
    }

    public final void setSecurityConfig(final SecurityConfig value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setSecConfig(final SecurityConfig value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.securityConfig = value;
    }

    public final void setEmailValidator(final EmailAddressValidator value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setEmailValidator(final EmailAddressValidator value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.emailValidator = value;
    }

    public final void setMessageValidator(final EmailMessageValidator value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setMessageValidator(final EmailMessageValidator value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageValidator = value;
    }

    public final void setThemeMessageSource(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setThemeMessageSource(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.themeMessageSource = value;
    }

    public final String getFileEncoding()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getFileEncoding()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.fileEncoding);
        }

        return this.fileEncoding;
    }

    public final LogonType getLogonType()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getLogonType()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.logonType);
        }

        return this.logonType;
    }

    public final String getLogonRedirect()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getLogonRedirect()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.logonRedirect);
        }

        return this.logonRedirect;
    }

    public final String getExpiredRedirect()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getExpiredRedirect()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.expiredRedirect);
        }

        return this.expiredRedirect;
    }

    public final String getHomeRedirect()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getHomeRedirect()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.homeRedirect);
        }

        return this.homeRedirect;
    }

    public final int getRequestTimeout()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getRequestTimeout()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.requestTimeout);
        }

        return this.requestTimeout;
    }

    public final String getDateFormat()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getDateFormat()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.dateFormat);
        }

        return this.dateFormat;
    }

    public final String getSecEmailAddr()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getSecEmailAddr()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.secEmailAddr);
        }

        return this.secEmailAddr;
    }

    public final long getTimeoutWarning()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getTimeoutWarning()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.timeoutWarning);
        }

        return this.timeoutWarning;
    }

    public final String getApplicationName()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getApplicationName()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.applicationName);
        }

        return this.applicationName;
    }

    public final String getApplicationId()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getApplicationId()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.applicationId);
        }

        return this.applicationId;
    }

    public final Map<String, Boolean> getServices()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getServices()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.services);
        }

        return this.services;
    }

    public final String getUploadDirectory()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getUploadDirectory()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.uploadDirectory);
        }

        return this.uploadDirectory;
    }

    public final String getHomePage()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getHomePage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.homePage);
        }

        return this.homePage;
    }

    public final String getUnavailablePage()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getUnavailablePage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.unavailablePage);
        }

        return this.unavailablePage;
    }

    public final String getUnauthorizedPage()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getUnauthorizedPage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.unauthorizedPage);
        }

        return this.unauthorizedPage;
    }

    public final String getContactAdminsPage()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getContactAdminsPage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.contactAdminsPage);
        }

        return this.contactAdminsPage;
    }

    public final String getErrorResponsePage()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getErrorResponsePage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.errorResponsePage);
        }

        return this.errorResponsePage;
    }

    public final String getSearchRequestPage()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getSearchRequestPage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.searchRequestPage);
        }

        return this.searchRequestPage;
    }

    public final String getRequestCompletePage()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getRequestCompletePage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.requestCompletePage);
        }

        return this.requestCompletePage;
    }

    public final List<String> getAllowedAppFileExtensions()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getAllowedAppFileExtensions()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.allowedAppFileExtensions);
        }

        return this.allowedAppFileExtensions;
    }

    public final List<String> getAllowedWebFileExtensions()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getAllowedWebFileExtensions()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.allowedWebFileExtensions);
        }

        return this.allowedWebFileExtensions;
    }

    public final String getMessageRequestCanceled()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageRequestCanceled()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageRequestCanceled);
        }

        return this.messageRequestCanceled;
    }

    public final String getMessageEmailSendFailed()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageEmailSendFailed()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageEmailSendFailed);
        }

        return this.messageEmailSendFailed;
    }

    public final String getMessagePasswordExpired()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getMessagePasswordExpired()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messagePasswordExpired);
        }

        return this.messagePasswordExpired;
    }

    public final String getMessageUserNotLoggedIn()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageUserNotLoggedIn()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageUserNotLoggedIn);
        }

        return this.messageUserNotLoggedIn;
    }

    public final String getMessageRequestProcessingFailure()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageRequestProcessingFailure()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageRequestProcessingFailure);
        }

        return this.messageRequestProcessingFailure;
    }

    public final String getMessageValidationFailed()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageValidationFailed()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageValidationFailed);
        }

        return this.messageValidationFailed;
    }

    public final String getMessageNoSearchResults()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageNoSearchResults()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageNoSearchResults);
        }

        return this.messageNoSearchResults;
    }

    public final String getMessageEmailSentSuccess()
    {
        final String methodName = ApplicationServiceBean.CNAME + "# getMessageEmailSentSuccess()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageEmailSentSuccess);
        }

        return this.messageEmailSentSuccess;
    }

    public final SecurityConfig getSecurityConfig()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getSecurityConfig()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.securityConfig);
        }

        return this.securityConfig;
    }

    public final EmailAddressValidator getEmailValidator()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getEmailValidator()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.emailValidator);
        }

        return this.emailValidator;
    }

    public final EmailMessageValidator getMessageValidator()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageValidator(final EmailMessageValidator value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageValidator);
        }

        return this.messageValidator ;
    }

    public final String getThemeMessageSource()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getThemeMessageSource()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.themeMessageSource);
        }

        return this.themeMessageSource;
    }

    @Override
    public final String toString()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#toString()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        StringBuilder sBuilder = new StringBuilder()
            .append("[" + this.getClass().getName() + "]" + Constants.LINE_BREAK + "{" + Constants.LINE_BREAK);

        for (Field field : this.getClass().getDeclaredFields())
        {
            if (DEBUG)
            {
                DEBUGGER.debug("field: {}", field);
            }

            if (!(field.getName().equals("methodName")) &&
				(!(field.getName().equals("CNAME"))) &&
				(!(field.getName().equals("DEBUGGER"))) &&
				(!(field.getName().equals("DEBUG"))) &&
				(!(field.getName().equals("ERROR_RECORDER"))) &&
				(!(field.getName().equals("serialVersionUID"))))
            {
                try
                {
                    if (field.get(this) != null)
                    {
                        sBuilder.append("\t" + field.getName() + " --> " + field.get(this) + Constants.LINE_BREAK);
                    }
                }
                catch (IllegalAccessException iax)
                {
                    ERROR_RECORDER.error(iax.getMessage(), iax);
                }
            }
        }

        sBuilder.append('}');

        if (DEBUG)
        {
            DEBUGGER.debug("sBuilder: {}", sBuilder);
        }

        return sBuilder.toString();
    }
}
