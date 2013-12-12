/*
 * Copyright (c) 2009 - 2013 By: CWS, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cws.us.pws.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.cws.us.pws.Constants;
import com.cws.esolutions.core.processors.dto.SearchRequest;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.validators
 * File: SearchValidator.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
public class SearchValidator implements Validator
{
    private static final String CNAME = SearchValidator.class.getName();

    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();

    /**
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
