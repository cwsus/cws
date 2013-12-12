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
package com.cws.us.pws.dao.impl;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.CallableStatement;
import org.springframework.beans.factory.annotation.Autowired;

import com.cws.us.pws.dao.interfaces.IProductReferenceDAO;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.dao.impl
 * File: CareersReferenceDAOImpl.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
/**
 * @see com.cws.us.pws.dao.interfaces.IProductReferenceDAO
 */
public class ProductReferenceDAOImpl implements IProductReferenceDAO
{
    @Autowired private DataSource dataSource;

    public final void setDataSource(final DataSource value)
    {
        final String methodName = IProductReferenceDAO.CNAME + "#setDataSource(final DataSource value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.dataSource = value;
    }

    /**
     * @see com.cws.us.pws.dao.interfaces.IProductReferenceDAO#getProductList(String) throws SQLException
     */
    @Override
    public List<Object[]> getProductList(final String lang) throws SQLException
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getProductList(final String lang) throws SQLException";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", lang);
        }

        Connection sqlConn = null;
        ResultSet resultSet = null;
        CallableStatement stmt = null;
        List<Object[]> results = null;

        try
        {
            sqlConn = this.dataSource.getConnection();

            if (DEBUG)
            {
                DEBUGGER.debug("Connection: {}", sqlConn);
            }

            if (sqlConn.isClosed())
            {
                throw new SQLException("Unable to obtain connection to application datasource");
            }

            stmt = sqlConn.prepareCall("{ CALL getProductList(?) }");
            stmt.setString(1, lang);

            if (DEBUG)
            {
                DEBUGGER.debug("CallableStatement: {}", stmt);
            }

            if (!(stmt.execute()))
            {
                throw new SQLException("PreparedStatement is null. Cannot execute.");
            }

            resultSet = stmt.getResultSet();

            if (DEBUG)
            {
                DEBUGGER.debug("ResultSet: {}", resultSet);
            }

            if (resultSet.next())
            {
                resultSet.beforeFirst();
                results = new ArrayList<Object[]>();

                while (resultSet.next())
                {
                    Object[] data = new Object[]
                    {
                        resultSet.getString(1), // PRODUCT_ID
                        resultSet.getString(2), // PRODUCT_NAME
                        resultSet.getString(3), // PRODUCT_SHORT_DESC
                        resultSet.getString(4), // PRODUCT_DESC
                        resultSet.getBigDecimal(5), // PRODUCT_PRICE
                        resultSet.getBoolean(6) // IS_FEATURED
                    };

                    results.add(data);
                }

                if (DEBUG)
                {
                    DEBUGGER.debug("results: {}", results);
                }
            }
        }
        catch (SQLException sqx)
        {
            ERROR_RECORDER.error(sqx.getMessage(), sqx);

            throw new SQLException(sqx.getMessage(), sqx);
        }
        finally
        {
            if (resultSet != null)
            {
                resultSet.close();
            }

            if (stmt != null)
            {
                stmt.close();
            }

            if ((sqlConn != null) && (!(sqlConn.isClosed())))
            {
                sqlConn.close();
            }
        }

        if (DEBUG)
        {
            DEBUGGER.debug("results: {}", results);
        }

        return results;
    }

    /**
     * @see com.cws.us.pws.dao.interfaces.IProductReferenceDAO#getFeaturedProducts(String) throws SQLException
     */
    @Override
    public List<Object[]> getFeaturedProducts(final String lang) throws SQLException
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getFeaturedProducts(final String lang) throws SQLException";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", lang);
        }

        Connection sqlConn = null;
        ResultSet resultSet = null;
        CallableStatement stmt = null;
        List<Object[]> results = null;

        try
        {
            sqlConn = this.dataSource.getConnection();

            if (DEBUG)
            {
                DEBUGGER.debug("Connection: {}", sqlConn);
            }

            if (sqlConn.isClosed())
            {
                throw new SQLException("Unable to obtain connection to application datasource");
            }

            stmt = sqlConn.prepareCall("{ CALL getFeaturedProducts(?) }");
            stmt.setString(1, lang);

            if (DEBUG)
            {
                DEBUGGER.debug("CallableStatement: {}", stmt);
            }

            if (!(stmt.execute()))
            {
                throw new SQLException("PreparedStatement is null. Cannot execute.");
            }

            resultSet = stmt.getResultSet();

            if (DEBUG)
            {
                DEBUGGER.debug("ResultSet: {}", resultSet);
            }

            if (resultSet.next())
            {
                resultSet.beforeFirst();
                results = new ArrayList<Object[]>();

                while (resultSet.next())
                {
                    Object[] data = new Object[]
                    {
                        resultSet.getString(1), // PRODUCT_ID
                        resultSet.getString(2), // PRODUCT_NAME
                        resultSet.getString(3), // PRODUCT_SHORT_DESC
                        resultSet.getString(4), // PRODUCT_DESC
                        resultSet.getBigDecimal(5), // PRODUCT_PRICE
                        resultSet.getBoolean(6) // IS_FEATURED
                    };

                    results.add(data);
                }

                if (DEBUG)
                {
                    DEBUGGER.debug("results: {}", results);
                }
            }
        }
        catch (SQLException sqx)
        {
            ERROR_RECORDER.error(sqx.getMessage(), sqx);

            throw new SQLException(sqx.getMessage(), sqx);
        }
        finally
        {
            if (resultSet != null)
            {
                resultSet.close();
            }

            if (stmt != null)
            {
                stmt.close();
            }

            if ((sqlConn != null) && (!(sqlConn.isClosed())))
            {
                sqlConn.close();
            }
        }

        if (DEBUG)
        {
            DEBUGGER.debug("results: {}", results);
        }

        return results;
    }

    /**
     * @see com.cws.us.pws.dao.interfaces.IProductReferenceDAO#getProductData(String, String) throws SQLException
     */
    @Override
    public List<Object> getProductData(final String productId, final String lang) throws SQLException
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getProductData(final int productId, final String lang) throws SQLException";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", productId);
            DEBUGGER.debug("Value: {}", lang);
        }

        Connection sqlConn = null;
        ResultSet resultSet = null;
        List<Object> results = null;
        CallableStatement stmt = null;

        try
        {
            sqlConn = this.dataSource.getConnection();

            if (DEBUG)
            {
                DEBUGGER.debug("Connection: {}", sqlConn);
            }

            if (sqlConn.isClosed())
            {
                throw new SQLException("Unable to obtain connection to application datasource");
            }

            stmt = sqlConn.prepareCall("{ CALL getProductData(?, ?) }");
            stmt.setString(1, productId);
            stmt.setString(2, lang);

            if (DEBUG)
            {
                DEBUGGER.debug("CallableStatement: {}", stmt);
            }

            if (!(stmt.execute()))
            {
                throw new SQLException("PreparedStatement is null. Cannot execute.");
            }

            resultSet = stmt.getResultSet();

            if (DEBUG)
            {
                DEBUGGER.debug("ResultSet: {}", resultSet);
            }

            if (resultSet.next())
            {
                resultSet.beforeFirst();
                results = new ArrayList<Object>();

                while (resultSet.next())
                {
                    results.add(resultSet.getString(1)); // PRODUCT_ID
                    results.add(resultSet.getString(2)); // PRODUCT_NAME
                    results.add(resultSet.getString(3)); // PRODUCT_SHORT_DESC
                    results.add(resultSet.getString(4)); // PRODUCT_DESC
                    results.add(resultSet.getBigDecimal(5)); // PRODUCT_PRICE
                    results.add(resultSet.getBoolean(6)); // IS_FEATURED
                }

                if (DEBUG)
                {
                    DEBUGGER.debug("results: {}", results);
                }
            }
        }
        catch (SQLException sqx)
        {
            ERROR_RECORDER.error(sqx.getMessage(), sqx);

            throw new SQLException(sqx.getMessage(), sqx);
        }
        finally
        {
            if (resultSet != null)
            {
                resultSet.close();
            }

            if (stmt != null)
            {
                stmt.close();
            }

            if ((sqlConn != null) && (!(sqlConn.isClosed())))
            {
                sqlConn.close();
            }
        }

        if (DEBUG)
        {
            DEBUGGER.debug("results: {}", results);
        }

        return results;
    }
}
