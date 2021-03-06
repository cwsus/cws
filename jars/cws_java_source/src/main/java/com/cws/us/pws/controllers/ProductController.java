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
package com.cws.us.pws.controllers;

import java.util.List;
import org.slf4j.Logger;
import java.util.Enumeration;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cws.us.pws.Constants;
import com.cws.us.pws.ApplicationServiceBean;
import com.cws.us.pws.processors.dto.Product;
import com.cws.us.pws.processors.dto.ProductRequest;
import com.cws.us.pws.processors.dto.ProductResponse;
import com.cws.us.pws.processors.impl.ProductReferenceImpl;
import com.cws.esolutions.core.processors.enums.CoreServicesStatus;
import com.cws.us.pws.processors.exception.ProductRequestException;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.controllers
 * File: ProductController.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
@Controller
@RequestMapping("/products")
public class ProductController
{
    private String showProduct = null;
    private String defaultPage = null;
    private ApplicationServiceBean appConfig = null;
    private ProductReferenceImpl productRefSvc = null;

    private static final String CNAME = ProductController.class.getName();

    private static final Logger DEBUGGER = LoggerFactory.getLogger(Constants.DEBUGGER);
    private static final boolean DEBUG = DEBUGGER.isDebugEnabled();
    private static final Logger ERROR_RECORDER = LoggerFactory.getLogger(Constants.ERROR_LOGGER + CNAME);

    public final void setAppConfig(final ApplicationServiceBean value)
    {
        final String methodName = ProductController.CNAME + "#setProductRefSvc(final ApplicationServiceBean value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.appConfig = value;
    }

    public final void setDefaultPage(final String value)
    {
        final String methodName = ProductController.CNAME + "#setDefaultPage(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.defaultPage = value;
    }

    public final void setProductRefSvc(final ProductReferenceImpl value)
    {
        final String methodName = ProductController.CNAME + "#setProductRefSvc(final ProductReferenceImpl value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.productRefSvc = value;
    }

    public final void setShowProduct(final String value)
    {
        final String methodName = ProductController.CNAME + "#setShowProduct(final String value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.showProduct = value;
    }

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public final ModelAndView showDefaultPage()
    {
        final String methodName = ProductController.CNAME + "#showDefaultPage()";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        ModelAndView mView = new ModelAndView();

        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        final HttpServletRequest hRequest = requestAttributes.getRequest();
        final HttpSession hSession = hRequest.getSession();
        final String lang = hRequest.getParameter(Constants.PARAMETER_LANG);

        if (DEBUG)
        {
            DEBUGGER.debug("ServletRequestAttributes: {}", requestAttributes);
            DEBUGGER.debug("HttpServletRequest: {}", hRequest);
            DEBUGGER.debug("HttpSession: {}", hSession);
            DEBUGGER.debug("lang: {}", lang);

            DEBUGGER.debug("Dumping session content:");
            @SuppressWarnings("unchecked") Enumeration<String> sessionEnumeration = hSession.getAttributeNames();

            while (sessionEnumeration.hasMoreElements())
            {
                String sessionElement = sessionEnumeration.nextElement();
                Object sessionValue = hSession.getAttribute(sessionElement);

                DEBUGGER.debug("Attribute: " + sessionElement + "; Value: " + sessionValue);
            }

            DEBUGGER.debug("Dumping request content:");
            @SuppressWarnings("unchecked") Enumeration<String> requestEnumeration = hRequest.getAttributeNames();

            while (requestEnumeration.hasMoreElements())
            {
                String requestElement = requestEnumeration.nextElement();
                Object requestValue = hRequest.getAttribute(requestElement);

                DEBUGGER.debug("Attribute: " + requestElement + "; Value: " + requestValue);
            }

            DEBUGGER.debug("Dumping request parameters:");
            @SuppressWarnings("unchecked") Enumeration<String> paramsEnumeration = hRequest.getParameterNames();

            while (paramsEnumeration.hasMoreElements())
            {
                String requestElement = paramsEnumeration.nextElement();
                Object requestValue = hRequest.getParameter(requestElement);

                DEBUGGER.debug("Parameter: " + requestElement + "; Value: " + requestValue);
            }
        }

        try
        {
            ProductRequest productRequest = new ProductRequest();
            productRequest.setIsFeatured(true);
            productRequest.setLang((StringUtils.isBlank(lang)) ? "en" : lang);

            if (DEBUG)
            {
                DEBUGGER.debug("ProductRequest: {}", productRequest);
            }

            ProductResponse productResponse = this.productRefSvc.getFeaturedProducts(productRequest);

            if (DEBUG)
            {
                DEBUGGER.debug("ProductResponse: {}", productResponse);
            }

            if (productResponse.getRequestStatus() == CoreServicesStatus.SUCCESS)
            {
                List<Product> featuredProducts = productResponse.getProductList();

                if (DEBUG)
                {
                    DEBUGGER.debug("List<Product>: {}", featuredProducts);
                }

                mView.addObject("featuredProducts", featuredProducts);
            }

            mView.addObject("command", new Product());
            mView.setViewName(this.defaultPage);
        }
        catch (ProductRequestException prx)
        {
            ERROR_RECORDER.error(prx.getMessage(), prx);

            mView = new ModelAndView(new RedirectView());
            mView.setViewName(this.appConfig.getErrorResponsePage());
        }

        if (DEBUG)
        {
            DEBUGGER.debug("ModelAndView: {}", mView);
        }

        return mView;
    }

    @RequestMapping(value = "/product/{product}", method = RequestMethod.GET)
    public final ModelAndView getProductInfo(@PathVariable("product") final String product)
    {
        final String methodName = ProductController.CNAME + "#getProductInfo(@PathVariable(\"product\") final String product)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Product: {}", product);
        }

        ModelAndView mView = new ModelAndView();

        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        final HttpServletRequest hRequest = requestAttributes.getRequest();
        final HttpSession hSession = hRequest.getSession();
        final String lang = hRequest.getParameter(Constants.PARAMETER_LANG);

        if (DEBUG)
        {
            DEBUGGER.debug("ServletRequestAttributes: {}", requestAttributes);
            DEBUGGER.debug("HttpServletRequest: {}", hRequest);
            DEBUGGER.debug("HttpSession: {}", hSession);
            DEBUGGER.debug("lang: {}", lang);

            DEBUGGER.debug("Dumping session content:");
            @SuppressWarnings("unchecked") Enumeration<String> sessionEnumeration = hSession.getAttributeNames();

            while (sessionEnumeration.hasMoreElements())
            {
                String sessionElement = sessionEnumeration.nextElement();
                Object sessionValue = hSession.getAttribute(sessionElement);

                DEBUGGER.debug("Attribute: " + sessionElement + "; Value: " + sessionValue);
            }

            DEBUGGER.debug("Dumping request content:");
            @SuppressWarnings("unchecked") Enumeration<String> requestEnumeration = hRequest.getAttributeNames();

            while (requestEnumeration.hasMoreElements())
            {
                String requestElement = requestEnumeration.nextElement();
                Object requestValue = hRequest.getAttribute(requestElement);

                DEBUGGER.debug("Attribute: " + requestElement + "; Value: " + requestValue);
            }

            DEBUGGER.debug("Dumping request parameters:");
            @SuppressWarnings("unchecked") Enumeration<String> paramsEnumeration = hRequest.getParameterNames();

            while (paramsEnumeration.hasMoreElements())
            {
                String requestElement = paramsEnumeration.nextElement();
                Object requestValue = hRequest.getParameter(requestElement);

                DEBUGGER.debug("Parameter: " + requestElement + "; Value: " + requestValue);
            }
        }

        try
        {
            Product reqProduct = new Product();
            reqProduct.setProductId(product);

            if (DEBUG)
            {
                DEBUGGER.debug("Product: {}", reqProduct);
            }

            ProductRequest productRequest = new ProductRequest();
            productRequest.setProduct(reqProduct);
            productRequest.setLang((StringUtils.isBlank(lang)) ? "en" : lang);

            if (DEBUG)
            {
                DEBUGGER.debug("ProductRequest: {}", productRequest);
            }

            ProductResponse productResponse = this.productRefSvc.getProductData(productRequest);

            if (DEBUG)
            {
                DEBUGGER.debug("ProductResponse: {}", productResponse);
            }

            if (productResponse.getRequestStatus() == CoreServicesStatus.SUCCESS)
            {
                Product resProduct = productResponse.getProduct();

                if (DEBUG)
                {
                    DEBUGGER.debug("Product: {}", resProduct);
                }

                mView.addObject("product", resProduct);
                mView.setViewName(this.showProduct);
            }
            else
            {
                mView = new ModelAndView(new RedirectView());
                mView.addObject(Constants.ERROR_MESSAGE, productResponse.getResponse());
                mView.setViewName(this.defaultPage);
            }
        }
        catch (ProductRequestException prx)
        {
            ERROR_RECORDER.error(prx.getMessage(), prx);

            mView.setViewName(this.appConfig.getErrorResponsePage());
        }

        if (DEBUG)
        {
            DEBUGGER.debug("ModelAndView: {}", mView);
        }

        return mView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public final ModelAndView searchProducts(@ModelAttribute("request") final Product request, final BindingResult binding)
    {
        final String methodName = ProductController.CNAME + "#searchProducts(@ModelAttribute(\"request\") final Product request, final BindingResult binding)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Product: {}", request);
        }

        // String viewName = null;
        ProductResponse productResponse = null;
        ModelAndView mView = new ModelAndView();

        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        final HttpServletRequest hRequest = requestAttributes.getRequest();
        final HttpSession hSession = hRequest.getSession();
        final String lang = hRequest.getParameter(Constants.PARAMETER_LANG);

        if (DEBUG)
        {
            DEBUGGER.debug("ServletRequestAttributes: {}", requestAttributes);
            DEBUGGER.debug("HttpServletRequest: {}", hRequest);
            DEBUGGER.debug("HttpSession: {}", hSession);
            DEBUGGER.debug("lang: {}", lang);

            DEBUGGER.debug("Dumping session content:");
            @SuppressWarnings("unchecked") Enumeration<String> sessionEnumeration = hSession.getAttributeNames();

            while (sessionEnumeration.hasMoreElements())
            {
                String sessionElement = sessionEnumeration.nextElement();
                Object sessionValue = hSession.getAttribute(sessionElement);

                DEBUGGER.debug("Attribute: " + sessionElement + "; Value: " + sessionValue);
            }

            DEBUGGER.debug("Dumping request content:");
            @SuppressWarnings("unchecked") Enumeration<String> requestEnumeration = hRequest.getAttributeNames();

            while (requestEnumeration.hasMoreElements())
            {
                String requestElement = requestEnumeration.nextElement();
                Object requestValue = hRequest.getAttribute(requestElement);

                DEBUGGER.debug("Attribute: " + requestElement + "; Value: " + requestValue);
            }

            DEBUGGER.debug("Dumping request parameters:");
            @SuppressWarnings("unchecked") Enumeration<String> paramsEnumeration = hRequest.getParameterNames();

            while (paramsEnumeration.hasMoreElements())
            {
                String requestElement = paramsEnumeration.nextElement();
                Object requestValue = hRequest.getParameter(requestElement);

                DEBUGGER.debug("Parameter: " + requestElement + "; Value: " + requestValue);
            }
        }

        try
        {
            ProductRequest productRequest = new ProductRequest();
            productRequest.setProduct(request);
            productRequest.setLang((StringUtils.isBlank(lang)) ? "en" : lang);

            if (DEBUG)
            {
                DEBUGGER.debug("ProductRequest: {}", productRequest);
            }

            productResponse = this.productRefSvc.getProductData(productRequest);

            if (DEBUG)
            {
                DEBUGGER.debug("ProductResponse: {}", productResponse);
            }

            if (productResponse.getRequestStatus() == CoreServicesStatus.FAILURE)
            {
                mView.setViewName(this.appConfig.getErrorResponsePage());
            }
        }
        catch (ProductRequestException prx)
        {
            ERROR_RECORDER.error(prx.getMessage(), prx);

            mView.setViewName(this.appConfig.getErrorResponsePage());
        }

        if (DEBUG)
        {
            DEBUGGER.debug("ModelAndView: {}", mView);
        }

        return mView;
    }
}
