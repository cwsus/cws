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

import com.cws.us.pws.Constants;
import com.cws.us.pws.validators.EmailAddressValidator;
import com.cws.us.pws.validators.EmailMessageValidator;
/**
 * CWSPWS_java_source
 * com.cws.us.pws
 * ApplicationConfig.java
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
    @Autowired private String siteMap = null;
    @Autowired private String homePage = null;
    @Autowired private String dateFormat = null;
    @Autowired private String contactPage = null;
    @Autowired private String fileEncoding = null;
    @Autowired private String serviceEmail = null;
    @Autowired private String applicationId = null;
    @Autowired private String applicationName = null;
    @Autowired private String unavailablePage = null;
    @Autowired private String errorResponsePage = null;
    @Autowired private String searchRequestPage = null;
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

    public final void setSiteMap(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setSiteMap(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.siteMap = value;
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

    public final void setContactPage(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setContactPage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.contactPage = value;
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

    public final void setServiceEmail(final String value)
    {
        final String methodName = ApplicationServiceBean.CNAME + "#setServiceEmail(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.serviceEmail = value;
    }

    public final String getSiteMap()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getSiteMap()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.siteMap);
        }

        return this.siteMap;
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

    public final String getContactPage()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getContactPage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.contactPage);
        }

        return this.contactPage;
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
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageEmailSentSuccess()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageEmailSentSuccess);
        }

        return this.messageEmailSentSuccess;
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
        final String methodName = ApplicationServiceBean.CNAME + "#getMessageValidator()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.messageValidator);
        }

        return this.messageValidator;
    }

    public final String getServiceEmail()
    {
        final String methodName = ApplicationServiceBean.CNAME + "#getServiceEmail()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.serviceEmail);
        }

        return this.serviceEmail;
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
