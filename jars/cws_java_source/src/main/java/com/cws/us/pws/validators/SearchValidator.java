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

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.cws.us.pws.Constants;
import com.cws.esolutions.core.processors.dto.EmailMessage;
import com.cws.esolutions.core.processors.dto.SearchRequest;
/**
 * CWSPWS_java_source
 * com.cws.us.pws.validators
 * ContactValidator.java
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
public class SearchValidator implements Validator
{
    private static final String CNAME = SearchValidator.class.getName();

    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();

    /**
     * TODO: Add in the method description/comments
     *
     * @param clazz
     * @return
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports(final Class<?> clazz)
    {
        final String methodName = SearchValidator.CNAME + "#supports(final Class clazz)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Class: {}", clazz);
        }

        return SearchRequest.class.isAssignableFrom(clazz);
    }

    /**
     * TODO: Add in the method description/comments
     *
     * @param target
     * @param errors
     * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
     */
    @Override
    public void validate(final Object target, final Errors errors)
    {
        final String methodName = SearchValidator.CNAME + "#validate(final <Class> request)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("target: {}", target);
            DEBUGGER.debug("errors: {}", errors);
        }

        final Pattern pattern = Pattern.compile("^[A-Za-z0-9]+(?:[\\s-][A-Za-z0-9]+)*$");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "email.first.name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "email.last.name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageTo", "email.source.addr.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageSubject", "email.message.subject.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageBody", "email.message.body.required");

        final SearchRequest request = (SearchRequest) target;

        if (DEBUG)
        {
        	DEBUGGER.debug("SearchRequest: {}", request);
        }

        if (!(pattern.matcher(request.getSearchTerms()).matches()))
        {
            errors.reject("searchTerms");
        }
    }
}
