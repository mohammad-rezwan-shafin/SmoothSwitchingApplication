/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.entity;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Rezwan
 */

@lombok.Data
@lombok.EqualsAndHashCode(callSuper = false)
@lombok.ToString
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
    
}
