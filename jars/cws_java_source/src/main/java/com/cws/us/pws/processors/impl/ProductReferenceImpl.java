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
package com.cws.us.pws.processors.impl;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

import com.cws.us.pws.processors.dto.Product;
import com.cws.us.pws.processors.dto.ProductRequest;
import com.cws.us.pws.processors.dto.ProductResponse;
import com.cws.us.pws.dao.impl.ProductReferenceDAOImpl;
import com.cws.us.pws.processors.interfaces.IProductReference;
import com.cws.us.pws.processors.exception.ProductRequestException;
import com.cws.esolutions.core.processors.enums.CoreServicesStatus;
/**
 * CWSPWS_java_source
 * com.cws.us.pws.processors.impl
 * ProductReferenceImpl.java
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
 * 35033355 @ Apr 16, 2013 11:50:28 AM
 *     Created.
 */
public class ProductReferenceImpl implements IProductReference
{
    @Autowired private ProductReferenceDAOImpl productDAO = null;

    public final void setProductDAO(final ProductReferenceDAOImpl value)
    {
        final String methodName = IProductReference.CNAME + "#setProductDAO(final ProductReferenceDAOImpl value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.productDAO = value;
    }

    /**
     * @see com.cws.us.pws.processors.interfaces.IProductReference#getProductList(ProductRequest)
     */
    @Override
    public ProductResponse getProductList(final ProductRequest request) throws ProductRequestException
    {
        final String methodName = IProductReference.CNAME + "#getProductList(final ProductRequest request) throws ProductRequestException";
        
        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        ProductResponse response = new ProductResponse();

        List<Object[]> productList = this.productDAO.getProductList(request.getLang());

        if (DEBUG)
        {
            DEBUGGER.debug("productList: {}", productList);
        }

        if ((productList != null) && (productList.size() != 0))
        {
            List<Product> products = new ArrayList<>();

            for (Object[] array : productList)
            {
                Product product = new Product();
                product.setProductId((String) array[0]);
                product.setShortDesc((String) array[1]);
                product.setProductName((String) array[2]);
                product.setProductDesc((String) array[3]);
                product.setIsFeatured((boolean) array[4]);
                product.setProductCost((BigDecimal) array[5]);

                if (DEBUG)
                {
                    DEBUGGER.debug("Product: {}", product);
                }

                products.add(product);
            }

            if (DEBUG)
            {
                DEBUGGER.debug("List<Product>: {}", products);
            }

            response.setRequestStatus(CoreServicesStatus.SUCCESS);
            response.setResponse("Successfully loaded product list.");
            response.setProductList(products);
        }
        else
        {
            response.setRequestStatus(CoreServicesStatus.FAILURE);
            response.setResponse("Failed to load available products");
        }

        if (DEBUG)
        {
            DEBUGGER.debug("ProductResponse: {}", response);
        }

        return response;
    }

    /**
     * @see com.cws.us.pws.processors.interfaces.IProductReference#getFeaturedProducts(ProductRequest)
     */
    @Override
    public ProductResponse getFeaturedProducts(final ProductRequest request) throws ProductRequestException
    {
        final String methodName = IProductReference.CNAME + "#getFeaturedProducts(final ProductRequest request) throws ProductRequestException";
        
        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
        }

        ProductResponse response = new ProductResponse();

        List<Object[]> productList = this.productDAO.getFeaturedProducts(request.getLang());

        if (DEBUG)
        {
            DEBUGGER.debug("productList: {}", productList);
        }

        if ((productList != null) && (productList.size() != 0))
        {
            List<Product> products = new ArrayList<>();

            for (Object[] array : productList)
            {
                Product product = new Product();
                product.setProductId((String) array[0]);
                product.setShortDesc((String) array[1]);
                product.setProductName((String) array[2]);
                product.setProductDesc((String) array[3]);
                product.setIsFeatured((boolean) array[4]);
                product.setProductCost((BigDecimal) array[5]);

                if (DEBUG)
                {
                    DEBUGGER.debug("Product: {}", product);
                }

                products.add(product);
            }

            if (DEBUG)
            {
                DEBUGGER.debug("List<Product>: {}", products);
            }

            response.setRequestStatus(CoreServicesStatus.SUCCESS);
            response.setResponse("Successfully loaded product list.");
            response.setProductList(products);
        }
        else
        {
            response.setRequestStatus(CoreServicesStatus.FAILURE);
            response.setResponse("Failed to load available products");
        }

        if (DEBUG)
        {
            DEBUGGER.debug("ProductResponse: {}", response);
        }

        return response;
    }

    /**
     * @see com.cws.us.pws.processors.interfaces.IProductReference#getProductData(ProductRequest)
     */
    @Override
    public ProductResponse getProductData(final ProductRequest request) throws ProductRequestException
    {
        final String methodName = IProductReference.CNAME + "#getProductData(final ProductRequest request) throws ProductRequestException";
        
        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("request: {}", request);
        }

        ProductResponse response = new ProductResponse();

        final Product reqProduct = request.getProduct();

        if (DEBUG)
        {
            DEBUGGER.debug("reqProduct: {}", reqProduct);
        }

        if (reqProduct != null)
        {
            List<Object> productList = this.productDAO.getProductData(reqProduct.getProductId(), request.getLang());

            if (DEBUG)
            {
                DEBUGGER.debug("productList: {}", productList);
            }

            if ((productList != null) && (productList.size() != 0))
            {
                Product product = new Product();
                product.setProductId((String) productList.get(0));
                product.setShortDesc((String) productList.get(1));
                product.setProductName((String) productList.get(2));
                product.setProductDesc((String) productList.get(3));
                product.setIsFeatured((boolean) productList.get(4));
                product.setProductCost((BigDecimal) productList.get(5));

                if (DEBUG)
                {
                    DEBUGGER.debug("Product: {}", product);
                }

                response.setRequestStatus(CoreServicesStatus.SUCCESS);
                response.setResponse("Successfully loaded product " + reqProduct.getProductId());
                response.setProduct(product);
            }
            else
            {
                response.setRequestStatus(CoreServicesStatus.FAILURE);
                response.setResponse("Failed to load product with ID " + reqProduct.getProductId());
            }

            if (DEBUG)
            {
                DEBUGGER.debug("ProductResponse: {}", response);
            }
        }
        else
        {
            throw new ProductRequestException("No product data was provided. Unable to continue");
        }

        return response;
    }
}
