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

import org.slf4j.Logger;
import java.io.Serializable;
import java.math.BigDecimal;
import java.lang.reflect.Field;
import org.slf4j.LoggerFactory;

import com.cws.us.pws.Constants;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.processors.dto
 * File: Product.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
public class Product implements Serializable
{
    private String productId = null; // PRODUCT_ID
    private String shortDesc = null; // PRODUCT_SHORT_DESC
    private String productName = null; // PRODUCT_NAME
    private String productDesc = null; // PRODUCT_DESC
    private String searchTerms = null;
    private boolean isFeatured = false; // IS_FEATURED
    private BigDecimal productCost = null; // PRODUCT_PRICE

    private static final String CNAME = Product.class.getName();
    private static final long serialVersionUID = 1356041731091642819L;

    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();

    public final void setProductId(final String value)
    {
        final String methodName = Product.CNAME + "#setProductId(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.productId = value;
    }

    public final void setIsFeatured(final boolean value)
    {
        final String methodName = Product.CNAME + "#setIsFeatured(final boolean value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.isFeatured = value;
    }

    public final void setProductName(final String value)
    {
        final String methodName = Product.CNAME + "#setProductName(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.productName = value;
    }

    public final void setShortDesc(final String value)
    {
        final String methodName = Product.CNAME + "#setShortDesc(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.shortDesc = value;
    }

    public final void setProductDesc(final String value)
    {
        final String methodName = Product.CNAME + "#setProductDesc(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.productDesc = value;
    }

    public final void setProductCost(final BigDecimal value)
    {
        final String methodName = Product.CNAME + "#setProductCost(final BigDecimal value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.productCost = value;
    }

    public final void setSearchTerms(final String value)
    {
        final String methodName = Product.CNAME + "#setSearchTerms(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.searchTerms = value;
    }

    public final String getProductId()
    {
        final String methodName = Product.CNAME + "#getProductId()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.productId);
        }

        return this.productId;
    }

    public final boolean getIsFeatured()
    {
        final String methodName = Product.CNAME + "#getIsFeatured()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.isFeatured);
        }

        return this.isFeatured;
    }

    public final String getProductName()
    {
        final String methodName = Product.CNAME + "#getProductName()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.productName);
        }

        return this.productName;
    }

    public final String getShortDesc()
    {
        final String methodName = Product.CNAME + "#getShortDesc()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.shortDesc);
        }

        return this.shortDesc;
    }

    public final String getProductDesc()
    {
        final String methodName = Product.CNAME + "#getProductDesc()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.productDesc);
        }

        return this.productDesc;
    }

    public final BigDecimal getProductCost()
    {
        final String methodName = Product.CNAME + "#getProductCost()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.productCost);
        }

        return this.productCost;
    }

    public final String getSearchTerms()
    {
        final String methodName = Product.CNAME + "#getSearchTerms()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", this.searchTerms);
        }

        return this.searchTerms;
    }

    @Override
    public final String toString()
    {
        final String methodName = Product.CNAME + "#toString()";

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
