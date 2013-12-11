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
package com.cws.us.pws.validators;

import org.slf4j.Logger;
import java.util.regex.Pattern;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.cws.us.pws.Constants;
import com.cws.esolutions.core.utils.dto.EmailMessage;
/**
 * CWSPWS_java_source
 * com.cws.us.pws.validators
 * EmailAddressValidator.java
 *
 * $Id: $
 * $Author: $
 * $Date: $
 * $Revision: $
 * @author khuntly
 * @version 1.0
 *
 * History
 * ----------------------------------------------------------------------------
 * khuntly @ Apr 14, 2013 9:10:28 AM
 *     Created.
 */
public class EmailAddressValidator implements Validator
{
    private String messageEmailAddressRequired = null;

    private static final String CNAME = EmailAddressValidator.class.getName();

    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();

    public final void setMessageEmailAddressRequired(final String value)
    {
        final String methodName = EmailAddressValidator.CNAME + "#setMessageEmailAddressRequired(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageEmailAddressRequired = value;
    }

    @Override
    public final boolean supports(final Class<?> value)
    {
        final String methodName = EmailAddressValidator.CNAME + "#supports(final Class value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        final boolean isSupported = String.class.isAssignableFrom(value);

        if (DEBUG)
        {
            DEBUGGER.debug("isSupported: {}", isSupported);
        }

        return isSupported;
    }

    @Override
    public final void validate(final Object target, final Errors errors)
    {
        final String methodName = EmailAddressValidator.CNAME + "#validate(final <Class> request)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("target: {}", target);
            DEBUGGER.debug("errors: {}", errors);
        }

        final EmailMessage message = (EmailMessage) target;
        final Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

        if (DEBUG)
        {
            DEBUGGER.debug("EmailMessage: {}", message);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddr", this.messageEmailAddressRequired);

        for (String str : message.emailAddr())
        {
        	if (DEBUG)
        	{
        		DEBUGGER.debug("Address: {}", str);
        	}

            if (!(pattern.matcher(str).matches()))
            {
                errors.reject("emailAddr", this.messageEmailAddressRequired);
            }
        }
    }
}
