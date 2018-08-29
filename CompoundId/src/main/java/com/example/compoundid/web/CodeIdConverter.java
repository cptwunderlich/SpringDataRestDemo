package com.example.compoundid.web;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.example.compoundid.persistence.CodeId;
import com.example.compoundid.persistence.entities.PhoneConnection;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@Component
public class CodeIdConverter implements BackendIdConverter {

  /*
   * @see org.springframework.plugin.core.Plugin#supports(java.lang.Object)
   */
  @Override
  public boolean supports(Class<?> delimiter) {
      return PhoneConnection.class.isAssignableFrom(delimiter);
  }

  /*
   * @see org.springframework.data.rest.webmvc.spi.BackendIdConverter#fromRequestId(java.lang.String, java.lang.Class)
   */
  @Override
  public Serializable fromRequestId(String id, Class<?> entityType) {
    String[] parts = id.split("_", 2);
    
    if (parts != null && parts.length == 2) {
        return new CodeId(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
    } else {
        throw new IllegalArgumentException("Id must consist of two longs separated by '_'!");
    }
  }

  /*
   * @see org.springframework.data.rest.webmvc.spi.BackendIdConverter#toRequestId(java.io.Serializable, java.lang.Class)
   */
  @Override
  public String toRequestId(Serializable id, Class<?> entityType) {
      CodeId cid = (CodeId) id;
      return String.valueOf(cid.getCountryCode()) + "_" + String.valueOf(cid.getProviderCode());
  }

}
