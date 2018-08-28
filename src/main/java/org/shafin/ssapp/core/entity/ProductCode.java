/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rezwan
 */

@lombok.Data
@lombok.EqualsAndHashCode
@lombok.ToString
@Entity
@NamedQueries(
        @NamedQuery(
                name = ProductCode.PRODUCT_CODE_FIND_ALL, 
                query = ProductCode.PRODUCT_CODE_FIND_ALL_QUERY
        )
)
@Table(name = "PRODUCT_CODE")
public class ProductCode extends BaseEntity implements Serializable {
    public static final String PRODUCT_CODE_FIND_ALL = "ProductCode.findAll";
    public static final String PRODUCT_CODE_FIND_ALL_QUERY = "SELECT p FROM ProductCode p";
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PROD_CODE", nullable = false, length = 2)
    private String prodCode;
    
    @Basic(optional = false)
    @Column(name = "DISCOUNT_CODE", nullable = false, length = 2)
    private String discountCode;

    
    @Column(name = "DESCRIPTION", length = 50)
    private String description;
    
    public ProductCode(){
        
    }
}
