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
package com.cws.us.pws.processors.dto;

import java.util.Date;
import org.slf4j.Logger;
import java.io.Serializable;
import java.lang.reflect.Field;
import org.slf4j.LoggerFactory;

import com.cws.us.pws.Constants;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.processors.dto
 * File: Career.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
public class Career implements Serializable
{
    private Date postDate = null;
    private Date unpostDate = null;
    private String jobTitle = null;
    private String jobReqId = null;
    private String jobShortDesc = null;
    private String jobDescription = null;

    private static final String CNAME = Career.class.getName();
    private static final long serialVersionUID = 6015843683692286034L;

    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();

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

    public final void setPostDate(final Date value)
    {
        final String methodName = Career.CNAME + "#setPostDate(final Date value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.postDate = value;
    }

    public final void setUnpostDate(final Date value)
    {
        final String methodName = Career.CNAME + "#setUnpostDate(final Date value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.unpostDate = value;
    }

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

    public final Date getPostDate()
    {
        final String methodName = Career.CNAME + "#getPostDate()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.postDate);
        }

        return this.postDate;
    }

    public final Date getUnpostDate()
    {
        final String methodName = Career.CNAME + "#getUnpostDate()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.unpostDate);
        }

        return this.unpostDate;
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
