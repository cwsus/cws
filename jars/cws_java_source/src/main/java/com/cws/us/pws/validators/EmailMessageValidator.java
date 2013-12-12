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
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.cws.us.pws.Constants;
import com.cws.esolutions.core.utils.dto.EmailMessage;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.validators
 * File: EmailMessageValidator.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
public class EmailMessageValidator implements Validator
{
    private String messageBodyRequired = null;
    private String messageFromRequired = null;
    private String messageSubjectRequired = null;

    private static final String CNAME = EmailMessageValidator.class.getName();

    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();

    public final void setMessageBodyRequired(final String value)
    {
        final String methodName = EmailMessageValidator.CNAME + "#setMessageBodyRequired(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageBodyRequired = value;
    }

    public final void setMessageFromRequired(final String value)
    {
        final String methodName = EmailMessageValidator.CNAME + "#setMessageFromRequired(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageFromRequired = value;
    }

    public final void setMessageSubjectRequired(final String value)
    {
        final String methodName = EmailMessageValidator.CNAME + "#setMessageSubjectRequired(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.messageSubjectRequired = value;
    }

    @Override
    public final boolean supports(final Class<?> target)
    {
        final String methodName = EmailMessageValidator.CNAME + "#supports(final Class<?> target)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Class: ", target);
        }

        final boolean isSupported = EmailMessage.class.isAssignableFrom(target);

        if (DEBUG)
        {
            DEBUGGER.debug("isSupported: {}", isSupported);
        }

        return isSupported;
    }

    @Override
    public final void validate(final Object target, final Errors errors)
    {
        final String methodName = EmailMessageValidator.CNAME + "#validate(final Object target, final Errors errors)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Object: {}", target);
            DEBUGGER.debug("Errors: {}", errors);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageBody", this.messageBodyRequired);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddr", this.messageFromRequired);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messageSubject", this.messageSubjectRequired);
    }
}
