/*
 * Copyright 2014 Azazo
 *
 */
package com.bangsapabbi.api.common;

import com.bangsapabbi.api.common.validation.Validateable;

/**
 * Interface for DTO that can we sent to the API (POST or PUT)
 */
public interface Insertable<T> extends Validateable<T>, ApiDTO {
    String getParentUUID();

    String getUUID();
}
