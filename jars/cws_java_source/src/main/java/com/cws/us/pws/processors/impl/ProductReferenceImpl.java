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

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

import com.cws.us.pws.processors.dto.Product;
import com.cws.us.pws.processors.dto.ProductRequest;
import com.cws.us.pws.processors.dto.ProductResponse;
import com.cws.us.pws.dao.impl.ProductReferenceDAOImpl;
import com.cws.us.pws.processors.interfaces.IProductReference;
import com.cws.us.pws.processors.exception.ProductRequestException;
import com.cws.esolutions.core.processors.enums.CoreServicesStatus;
/*
 * Project: cws_java_source
 * Package: com.cws.us.pws.processors.impl
 * File: ProductReferenceImpl.java
 *
 * History
 * ----------------------------------------------------------------------------
 * kh05451 @ Jan 4, 2013 3:36:54 PM
 *     Created.
 */
/**
 * @see com.cws.us.pws.processors.interfaces.IProductReference
 */
public class ProductReferenceImpl implements IProductReference
{
    @Autowired private ProductReferenceDAOImpl dao = null;

    public final void setDao(final ProductReferenceDAOImpl value)
    {
        final String methodName = IProductReference.CNAME + "#setDao(final ProductReferenceDAOImpl value)";

        if (DEBUG)
        {
            DEBUGGER.debug(methodName);
            DEBUGGER.debug("Value: {}", value);
        }

        this.dao = value;
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

        try
        {
            List<Object[]> productList = this.dao.getProductList(request.getLang());

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
                    product.setProductId((String) array[0]); // PRODUCT_ID
                    product.setProductName((String) array[1]); // PRODUCT_NAME
                    product.setShortDesc((String) array[2]); // PRODUCT_SHORT_DESC
                    product.setProductDesc((String) array[3]); // PRODUCT_DESC
                    product.setProductCost((BigDecimal) array[4]); // PRODUCT_PRICE
                    product.setIsFeatured((Boolean) array[5]); // PRODUCT_LANG

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
        }
        catch (SQLException sqx)
        {
            ERROR_RECORDER.error(sqx.getMessage(), sqx);

            throw new ProductRequestException(sqx.getMessage(), sqx);
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

        try
        {
            List<Object[]> productList = this.dao.getFeaturedProducts(request.getLang());

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
                    product.setProductId((String) array[0]); // PRODUCT_ID
                    product.setProductName((String) array[1]); // PRODUCT_NAME
                    product.setShortDesc((String) array[2]); // PRODUCT_SHORT_DESC
                    product.setProductDesc((String) array[3]); // PRODUCT_DESC
                    product.setProductCost((BigDecimal) array[4]); // PRODUCT_PRICE
                    product.setIsFeatured((Boolean) array[5]); // PRODUCT_LANG
                    
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
        }
        catch (SQLException sqx)
        {
            ERROR_RECORDER.error(sqx.getMessage(), sqx);

            throw new ProductRequestException(sqx.getMessage(), sqx);
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
            try
            {
                List<Object> productList = this.dao.getProductData(reqProduct.getProductId(), request.getLang());

                if (DEBUG)
                {
                    DEBUGGER.debug("productList: {}", productList);
                }

                if ((productList != null) && (productList.size() != 0))
                {
                    Product product = new Product();
                    product.setProductId((String) productList.get(0)); // PRODUCT_ID
                    product.setProductName((String) productList.get(1)); // PRODUCT_NAME
                    product.setShortDesc((String) productList.get(2)); // PRODUCT_SHORT_DESC
                    product.setProductDesc((String) productList.get(3)); // PRODUCT_DESC
                    product.setProductCost((BigDecimal) productList.get(4)); // PRODUCT_PRICE
                    product.setIsFeatured((Boolean) productList.get(5)); // PRODUCT_LANG

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
            catch (SQLException sqx)
            {
                ERROR_RECORDER.error(sqx.getMessage(), sqx);

                throw new ProductRequestException(sqx.getMessage(), sqx);
            }
        }
        else
        {
            throw new ProductRequestException("No product data was provided. Unable to continue");
        }

        return response;
    }
}
