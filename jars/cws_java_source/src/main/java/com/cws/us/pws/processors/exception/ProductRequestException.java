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
package com.cws.us.pws.processors.exception;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.processors.exception
 * File: ProductRequestException.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
/**
 * @see java.lang.Exception
 */
public class ProductRequestException extends Exception
{
    private static final long serialVersionUID = 6429307516068916511L;

    public ProductRequestException(final String message)
    {
        super(message);
    }

    public ProductRequestException(final Throwable throwable)
    {
        super(throwable);
    }

    public ProductRequestException(final String message, final Throwable throwable)
    {
        super(message, throwable);
    }
}
