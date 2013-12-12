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
package com.cws.us.pws.dao.interfaces;

import java.util.List;
import org.slf4j.Logger;
import java.sql.SQLException;
import org.slf4j.LoggerFactory;

import com.cws.us.pws.Constants;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.dao.interfaces
 * File: IProductReferenceDAO.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
public interface IProductReferenceDAO
{
    static final String CNAME = IProductReferenceDAO.class.getName();

    static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    static final boolean DEBUG = DEBUGGER.isDebugEnabled();
    static final Logger ERROR_RECORDER = LoggerFactory.getLogger(Constants.ERROR_LOGGER + CNAME);

    /**
     * 
     * TODO: Add in the method description/comments
     *
     * @param lang
     * @return
     * @throws SQLException
     */
    List<Object[]> getProductList(final String lang) throws SQLException;

    /**
     * 
     * TODO: Add in the method description/comments
     *
     * @param lang
     * @return
     * @throws SQLException
     */
    List<Object[]> getFeaturedProducts(final String lang) throws SQLException;

    /**
     * 
     * TODO: Add in the method description/comments
     *
     * @param productId
     * @param lang
     * @return
     * @throws SQLException
     */
    List<Object> getProductData(final String productId, final String lang) throws SQLException;
}
