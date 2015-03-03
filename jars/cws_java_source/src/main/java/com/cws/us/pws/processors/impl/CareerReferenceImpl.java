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
package com.cws.us.pws.processors.impl;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

import com.cws.us.pws.processors.dto.Career;
import com.cws.us.pws.processors.dto.CareerRequest;
import com.cws.us.pws.processors.dto.CareerResponse;
import com.cws.us.pws.dao.impl.CareersReferenceDAOImpl;
import com.cws.us.pws.processors.interfaces.ICareerReference;
import com.cws.us.pws.processors.exception.CareerRequestException;
import com.cws.esolutions.core.processors.enums.CoreServicesStatus;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.processors.impl
 * File: CareersReferenceImpl.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
/**
 * @see com.cws.us.pws.processors.interfaces.ICareerReference
 */
public class CareerReferenceImpl implements ICareerReference
{
    @Autowired private CareersReferenceDAOImpl dao = null;

    public final void setDao(final CareersReferenceDAOImpl value)
    {
        final String methodName = ICareerReference.CNAME + "#setDao(final ProductReferenceDAOImpl value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.dao = value;
    }

    /**
     * @see com.cws.us.pws.processors.interfaces.ICareerReference#getCareerList(CareerRequest)
     */
    @Override
    public CareerResponse getCareerList(final CareerRequest request) throws CareerRequestException
    {
        final String methodName = ICareerReference.CNAME + "#getCareerList(final CareerRequest request) throws CareerRequestException";
        
        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        CareerResponse response = new CareerResponse();

        try
        {
            List<Object[]> careerList = this.dao.getCareerList(request.getLang());

            if (DEBUG)
            {
                DEBUGGER.debug("careerList: {}", careerList);
            }

            if ((careerList != null) && (careerList.size() != 0))
            {
                List<Career> careers= new ArrayList<>();

                for (Object[] array : careerList)
                {
                    Career career = new Career();
                    career.setJobReqId((String) array[0]);
                    career.setPostDate((Date) array[1]);
                    career.setUnpostDate((Date) array[2]);
                    career.setJobTitle((String) array[3]);
                    career.setJobShortDesc((String) array[4]);
                    career.setJobDescription((String) array[5]);

                    if (DEBUG)
                    {
                        DEBUGGER.debug("Career: {}", career);
                    }

                    careers.add(career);
                }

                if (DEBUG)
                {
                    DEBUGGER.debug("List<careers>: {}", careers);
                }

                response.setRequestStatus(CoreServicesStatus.SUCCESS);
                response.setResponse("Successfully loaded product list.");
                response.setCareerList(careers);
            }
            else
            {
                response.setRequestStatus(CoreServicesStatus.FAILURE);
                response.setResponse("Failed to load available products");
            }
        }
        catch (SQLException sqx)
        {
            ERROR_RECORDER.error(sqx.getMessage(), sqx);

            throw new CareerRequestException(sqx.getMessage(), sqx);
        }

        if (DEBUG)
        {
            DEBUGGER.debug("CareerResponse: {}", response);
        }

        return response;
    }

    /**
     * @see com.cws.us.pws.processors.interfaces.ICareerReference#getProductData(CareerRequest)
     */
    @Override
    public CareerResponse getCareerData(final CareerRequest request) throws CareerRequestException
    {
        final String methodName = ICareerReference.CNAME + "#getCareerData(final CareerRequest request) throws CareerRequestException";
        
        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("request: {}", request);
        }

        CareerResponse response = new CareerResponse();

        final Career reqCareer = request.getCareer();

        if (DEBUG)
        {
            DEBUGGER.debug("Career: {}", reqCareer);
        }

        if (reqCareer != null)
        {
            try
            {
                List<Object> careerData = this.dao.getCareerData(reqCareer.getJobReqId(), request.getLang());

                if (DEBUG)
                {
                    DEBUGGER.debug("careerData: {}", careerData);
                }

                if ((careerData != null) && (careerData.size() != 0))
                {
                    Career career = new Career();
                    career.setJobReqId((String) careerData.get(0));
                    career.setPostDate((Date) careerData.get(1));
                    career.setUnpostDate((Date) careerData.get(2));
                    career.setJobTitle((String) careerData.get(3));
                    career.setJobShortDesc((String) careerData.get(4));
                    career.setJobDescription((String) careerData.get(5));

                    if (DEBUG)
                    {
                        DEBUGGER.debug("Career: {}", career);
                    }

                    response.setRequestStatus(CoreServicesStatus.SUCCESS);
                    response.setResponse("Successfully loaded product " + reqCareer.getJobReqId());
                    response.setCareer(career);
                }
                else
                {
                    response.setRequestStatus(CoreServicesStatus.FAILURE);
                    response.setResponse("Failed to load career with ID " + reqCareer.getJobReqId());
                }

                if (DEBUG)
                {
                    DEBUGGER.debug("CareerResponse: {}", response);
                }
            }
            catch (SQLException sqx)
            {
                ERROR_RECORDER.error(sqx.getMessage(), sqx);

                throw new CareerRequestException(sqx.getMessage(), sqx);
            }
        }
        else
        {
            throw new CareerRequestException("No product data was provided. Unable to continue");
        }

        return response;
    }
}
