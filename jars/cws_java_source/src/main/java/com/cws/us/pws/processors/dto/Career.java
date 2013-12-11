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
package com.cws.us.pws.processors.dto;

import org.slf4j.Logger;
import java.io.Serializable;
import java.lang.reflect.Field;
import org.slf4j.LoggerFactory;

import com.cws.us.pws.Constants;
/**
 * eSolutionsCore
 * com.cws.esolutions.core.processors.dto
 * Career.java
 *
 * $Id$
 * $Author$
 * $Date$
 * $Revision$
 * @author 35033355
 * @version 1.0
 *
 * History
 * ----------------------------------------------------------------------------
 * 35033355 @ Apr 16, 2013 11:22:17 AM
 *     Created.
 */
public class Career implements Serializable
{
    private String jobTitle = null;
    private String jobReqId = null;
    private String jobShortDesc = null;
    private String jobDescription = null;

    private static final String CNAME = Career.class.getName();
    private static final long serialVersionUID = 6015843683692286034L;


    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();

    public final void setJobTitle(final String value)
    {
        final String methodName = Career.CNAME + "#setJobTitle(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.jobTitle = value;
    }

    public final void setJobReqId(final String value)
    {
        final String methodName = Career.CNAME + "#setJobReqId(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.jobReqId = value;
    }

    public final void setJobShortDesc(final String value)
    {
        final String methodName = Career.CNAME + "#setJobShortDesc(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.jobShortDesc = value;
    }

    public final void setJobDescription(final String value)
    {
        final String methodName = Career.CNAME + "#setJobDescription(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.jobDescription = value;
    }

    public final String getJobTitle()
    {
        final String methodName = Career.CNAME + "#getJobTitle()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.jobTitle);
        }

        return this.jobTitle;
    }

    public final String getJobReqId()
    {
        final String methodName = Career.CNAME + "#getJobReqId()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.jobReqId);
        }

        return this.jobReqId;
    }

    public final String getJobShortDesc()
    {
        final String methodName = Career.CNAME + "#getJobShortDesc()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.jobShortDesc);
        }

        return this.jobShortDesc;
    }

    public final String getJobDescription()
    {
        final String methodName = Career.CNAME + "#getJobDescription()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.jobDescription);
        }

        return this.jobDescription;
    }

    @Override
    public final String toString()
    {
        final String methodName = Career.CNAME + "#toString()";

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
                    // don't do anything with it
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
