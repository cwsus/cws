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
package com.cws.us.pws.processors.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cws.us.pws.Constants;
import com.cws.us.pws.processors.dto.CareerRequest;
import com.cws.us.pws.processors.dto.CareerResponse;
import com.cws.us.pws.processors.exception.CareerRequestException;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.processors.interfaces
 * File: ICareersReference.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
public interface ICareerReference
{
    static final String CNAME = ICareerReference.class.getName();

    static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    static final boolean DEBUG = DEBUGGER.isDebugEnabled();
    static final Logger ERROR_RECORDER = LoggerFactory.getLogger(Constants.ERROR_LOGGER + CNAME);

    CareerResponse getCareerList(final CareerRequest request) throws CareerRequestException;

    CareerResponse getCareerData(final CareerRequest request) throws CareerRequestException;
}
