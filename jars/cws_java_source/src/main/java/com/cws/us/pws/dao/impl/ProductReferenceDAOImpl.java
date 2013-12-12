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
package com.cws.us.pws.dao.impl;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.cws.us.pws.dao.interfaces.IProductReferenceDAO;
/**
 * CWSPWS_java_source
 * com.cws.us.pws.dao.interfaces
 * ProductReferenceDAOImpl.java
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
 * 35033355 @ Apr 16, 2013 12:19:37 PM
 *     Created.
 */
public class ProductReferenceDAOImpl implements IProductReferenceDAO
{
    @Autowired private JdbcTemplate jdbcTemplate;

    public final void setJdbcTemplate(final DataSource value)
    {
        final String methodName = IProductReferenceDAO.CNAME + "#setJdbcTemplate(final DataSource value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.jdbcTemplate = new JdbcTemplate(value);
    }

    /**
     * @see com.cws.us.pws.dao.interfaces.IProductReferenceDAO#getProductList(String)
     */
    @Override
    public List<Object[]> getProductList(final String lang)
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getProductList(final String lang)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        List<Object[]> response = this.jdbcTemplate.execute(
                new PreparedStatementCreator()
                {
                    @Override
                    public PreparedStatement createPreparedStatement(final Connection sqlConn) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#createPreparedStatement(final Connection sqlConn) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("Connection: {}", sqlConn);
                        }

                        PreparedStatement stmt = null;

                        try
                        {
                            if (sqlConn.isClosed())
                            {
                                throw new SQLException("Unable to obtain audit datasource connection");
                            }
                            
                            stmt = sqlConn.prepareCall("{CALL getProductList(?)}");
                            stmt.setString(1, lang);

                            if (DEBUG)
                            {
                                DEBUGGER.debug("PreparedStatement: {}", stmt);
                            }
                        }
                        catch (SQLException sqx)
                        {
                            ERROR_RECORDER.error(sqx.getMessage(), sqx);

                            throw new SQLException(sqx.getMessage(), sqx);
                        }

                        return stmt;
                    }
                },
                new PreparedStatementCallback<List<Object[]>>()
                {
                    @Override
                    public List<Object[]> doInPreparedStatement(final PreparedStatement stmt) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#doInPreparedStatement(final PreparedStatement stmt) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        ResultSet resultSet = null;
                        List<Object[]> results = null;

                        try
                        {
                            if (stmt == null)
                            {
                                throw new SQLException("PreparedStatement is null. Cannot execute.");
                            }

                            if (stmt.execute())
                            {
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
                                            resultSet.getString(6), // PRODUCT_LANG
                                            resultSet.getBoolean(7) // IS_FEATURED
                                        };

                                        results.add(data);
                                    }

                                    if (DEBUG)
                                    {
                                        DEBUGGER.debug("results: {}", results);
                                    }
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
                        }

                        return results;
                    }
                });

        if (DEBUG)
        {
            DEBUGGER.debug("response: {}", response);
        }

        return response;
    }

    /**
     * @see com.cws.us.pws.dao.interfaces.IProductReferenceDAO#getFeaturedProducts(String)
     */
    @Override
    public List<Object[]> getFeaturedProducts(final String lang)
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getFeaturedProducts(final String lang)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        List<Object[]> response = this.jdbcTemplate.execute(
                new PreparedStatementCreator()
                {
                    @Override
                    public PreparedStatement createPreparedStatement(final Connection sqlConn) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#createPreparedStatement(final Connection sqlConn) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("Connection: {}", sqlConn);
                        }

                        PreparedStatement stmt = null;

                        try
                        {
                            if (sqlConn.isClosed())
                            {
                                throw new SQLException("Unable to obtain audit datasource connection");
                            }
                            
                            stmt = sqlConn.prepareCall("{CALL getFeaturedProducts(?)}");
                            stmt.setString(1, lang);

                            if (DEBUG)
                            {
                                DEBUGGER.debug("PreparedStatement: {}", stmt);
                            }
                        }
                        catch (SQLException sqx)
                        {
                            ERROR_RECORDER.error(sqx.getMessage(), sqx);

                            throw new SQLException(sqx.getMessage(), sqx);
                        }

                        return stmt;
                    }
                },
                new PreparedStatementCallback<List<Object[]>>()
                {
                    @Override
                    public List<Object[]> doInPreparedStatement(final PreparedStatement stmt) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#doInPreparedStatement(final PreparedStatement stmt) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        ResultSet resultSet = null;
                        List<Object[]> results = null;

                        try
                        {
                            if (stmt == null)
                            {
                                throw new SQLException("PreparedStatement is null. Cannot execute.");
                            }

                            if (stmt.execute())
                            {
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
                                            resultSet.getString(1),
                                            resultSet.getString(2),
                                            resultSet.getString(3),
                                            resultSet.getString(4),
                                            resultSet.getString(5),
                                            resultSet.getString(6)
                                        };

                                        results.add(data);
                                    }

                                    if (DEBUG)
                                    {
                                        DEBUGGER.debug("results: {}", results);
                                    }
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
                        }

                        return results;
                    }
                });

        if (DEBUG)
        {
            DEBUGGER.debug("response: {}", response);
        }

        return response;
    }

    /**
     * @see com.cws.us.pws.dao.interfaces.IProductReferenceDAO#getProductData(String, String)
     */
    @Override
    public List<Object> getProductData(final String productId, final String lang)
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getProductData(final int productId, final String lang) throws SQLException";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Product ID: {}", productId);
        }

        List<Object> response = null;

        this.jdbcTemplate.execute(
                new PreparedStatementCreator()
                {
                    public PreparedStatement createPreparedStatement(final Connection sqlConn) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#createPreparedStatement(final Connection sqlConn) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("Connection: {}", sqlConn);
                        }

                        PreparedStatement stmt = null;

                        try
                        {
                            if (sqlConn.isClosed())
                            {
                                throw new SQLException("Unable to obtain audit datasource connection");
                            }
                            
                            stmt = sqlConn.prepareCall("{CALL getProductData(?, ?)}");
                            stmt.setString(1, productId);
                            stmt.setString(2, lang);

                            if (DEBUG)
                            {
                                DEBUGGER.debug("PreparedStatement: {}", stmt);
                            }
                        }
                        catch (SQLException sqx)
                        {
                            ERROR_RECORDER.error(sqx.getMessage(), sqx);

                            throw new SQLException(sqx.getMessage(), sqx);
                        }

                        if (DEBUG)
                        {
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        return stmt;
                    }
                },
                new PreparedStatementCallback<List<Object>>()
                {
                    public List<Object> doInPreparedStatement(final PreparedStatement stmt) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#createPreparedStatement(final PreparedStatement stmt) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        ResultSet resultSet = null;
                        List<Object> results = null;

                        try
                        {
                            if (stmt == null)
                            {
                                throw new SQLException("PreparedStatement is null. Cannot continue.");
                            }

                            if (stmt.execute())
                            {
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
                                        results.add(resultSet.getString(1));
                                        results.add(resultSet.getString(2));
                                        results.add(resultSet.getString(3));
                                        results.add(resultSet.getString(4));
                                        results.add(resultSet.getString(5));
                                        results.add(resultSet.getString(6));
                                    }

                                    if (DEBUG)
                                    {
                                        DEBUGGER.debug("results: {}", results);
                                    }
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
                        }

                        return results;
                    }
                });

        if (DEBUG)
        {
            DEBUGGER.debug("response: {}", response);
        }

        return response;
    }
}
