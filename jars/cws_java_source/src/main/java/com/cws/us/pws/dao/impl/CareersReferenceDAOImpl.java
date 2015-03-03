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

import com.cws.us.pws.dao.interfaces.ICareersReferenceDAO;
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
 * @see com.cws.us.pws.dao.interfaces.ICareersReferenceDAO
 */
public class CareersReferenceDAOImpl implements ICareersReferenceDAO
{
    @Autowired private DataSource dataSource;

    public final void setDataSource(final DataSource value)
    {
        final String methodName = ICareersReferenceDAO.CNAME + "#setDataSource(final DataSource value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.dataSource = value;
    }

    /**
     * @see com.cws.us.pws.dao.interfaces.ICareersReferenceDAO#getCareerList(String) throws SQLException
     */
    @Override
    public List<Object[]> getCareerList(final String lang) throws SQLException
    {
        final String methodName = ICareersReferenceDAO.CNAME + "#getCareerList(final String lang) throws SQLException";

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

            stmt = sqlConn.prepareCall("{ CALL getCareersList(?) }");
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
                        resultSet.getString(1), // REQ_ID
                        resultSet.getString(2), // POST_DATE
                        resultSet.getString(3), // UNPOST_DATE
                        resultSet.getString(4), // JOB_TITLE
                        resultSet.getBigDecimal(5), // JOB_SHORT_DESC
                        resultSet.getString(6), // JOB_DESCRIPTION
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
     * @see com.cws.us.pws.dao.interfaces.ICareersReferenceDAO#getCareerData(String, String) throws SQLException
     */
    @Override
    public List<Object> getCareerData(final String reqId, final String lang) throws SQLException
    {
        final String methodName = ICareersReferenceDAO.CNAME + "#getCareerData(final int reqId, final String lang) throws SQLException";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", reqId);
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

            stmt = sqlConn.prepareCall("{ CALL getCareerData(?, ?) }");
            stmt.setString(1, reqId);
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
                    results.add(resultSet.getString(1)); // REQ_ID
                    results.add(resultSet.getDate(2)); // POST_DATE
                    results.add(resultSet.getDate(3)); // UNPOST_DATE
                    results.add(resultSet.getString(4)); // JOB_TITLE
                    results.add(resultSet.getString(5)); // JOB_SHORT_DESC
                    results.add(resultSet.getString(6)); // JOB_DESCRIPTION
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
