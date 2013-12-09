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
 * TODO: Add class description
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

    public final void setJdbcTemplate(final JdbcTemplate template)
    {
        final String methodName = IProductReferenceDAO.CNAME + "#setJdbcTemplate(final JdbcTemplate template)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("JdbcTemplate: {}", template);
        }

        this.jdbcTemplate = template;
    }

    @Override
    public List<String[]> getProductList() throws SQLException
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getFeaturedProducts() throws SQLException";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        List<String[]> response = null;

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

                        PreparedStatement stmt = sqlConn.prepareCall("{CALL getProductList()}");

                        if (DEBUG)
                        {
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        return stmt;
                    }
                },
                new PreparedStatementCallback<List<String[]>>()
                {
                    public List<String[]> doInPreparedStatement(final PreparedStatement stmt) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#doInPreparedStatement(final PreparedStatement stmt) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        ResultSet resultSet = null;
                        List<String[]> results = null;

                        try
                        {
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
                                    results = new ArrayList<>();

                                    while (resultSet.next())
                                    {
                                        String[] data = new String[]
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

    @Override
    public List<String[]> getFeaturedProducts() throws SQLException
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getFeaturedProducts() throws SQLException";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        List<String[]> response = null;

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

                        PreparedStatement stmt = sqlConn.prepareCall("{CALL getFeaturedProducts()}");

                        if (DEBUG)
                        {
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        return stmt;
                    }
                },
                new PreparedStatementCallback<List<String[]>>()
                {
                    public List<String[]> doInPreparedStatement(final PreparedStatement stmt) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#doInPreparedStatement(final PreparedStatement stmt) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        ResultSet resultSet = null;
                        List<String[]> results = null;

                        try
                        {
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
                                    results = new ArrayList<>();

                                    while (resultSet.next())
                                    {
                                        String[] data = new String[]
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
     * TODO: Add in the method description/comments
     *
     * @param productId
     * @return
     * @see com.cws.us.pws.dao.interfaces.IProductReferenceDAO#getProductData(int)
     */
    @Override
    public List<String> getProductData(final String productId) throws SQLException
    {
        final String methodName = IProductReferenceDAO.CNAME + "#getProductData(final int productId) throws SQLException";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Product ID: {}", productId);
        }

        List<String> response = null;

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

                        PreparedStatement stmt = sqlConn.prepareCall("{CALL getProductData(?)}");
                        stmt.setString(1, productId);

                        if (DEBUG)
                        {
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        return stmt;
                    }
                },
                new PreparedStatementCallback<List<String>>()
                {
                    public List<String> doInPreparedStatement(final PreparedStatement stmt) throws SQLException
                    {
                        final String methodName = IProductReferenceDAO.CNAME + "#createPreparedStatement(final PreparedStatement stmt) throws SQLException";

                        if (DEBUG)
                        {
                            DEBUGGER.debug(methodName);
                            DEBUGGER.debug("PreparedStatement: {}", stmt);
                        }

                        ResultSet resultSet = null;
                        List<String> results = null;

                        try
                        {
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
                                    results = new ArrayList<>();

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
