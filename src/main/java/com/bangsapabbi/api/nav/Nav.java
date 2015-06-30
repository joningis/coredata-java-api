/*
 * Copyright 2015 Azazo
 *
 */
package com.bangsapabbi.api.nav;

import javax.print.DocFlavor;

import com.bangsapabbi.api.common.ApiDTO;

public class Nav implements ApiDTO {


    private String type;

    private String snapshotId;

    private String id;

    private String name;

    private String path;

    private String parentId;


    public String getType() {
        return type;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getParentId() {
        return parentId;
    }

    @Override
    public void setUUID(final String uuid) {

    }
}
