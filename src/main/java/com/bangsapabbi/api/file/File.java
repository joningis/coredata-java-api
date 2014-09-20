package com.bangsapabbi.api.file;

import com.bangsapabbi.api.common.ApiDTO;
import com.bangsapabbi.api.project.Project;
import com.bangsapabbi.api.space.Space;
import com.google.gson.annotations.SerializedName;

public class File implements ApiDTO {

    private String filename;

    private String title;

    @SerializedName("id")
    private String uuid;

    private Project project;

    private String parent;

    /**
     * This does not seem to be used in the v2 api.
     */
    private String folder;

    private Space space;

    @SerializedName("mime_type")
    private String mimeType;
    private String localPath;

    public String getFilename() {
        return filename;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getUUID() {
        return uuid;
    }

    public void setUUID(final String uuid) {
        this.uuid = uuid;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(final Project project) {
        this.project = project;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(final String parent) {
        this.parent = parent;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(final Space space) {
        this.space = space;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(final String mimeType) {
        this.mimeType = mimeType;
    }


    @Override
    public String toString() {
        return "File{" +
                "filename='" + filename + '\'' +
                ", uuid='" + uuid + '\'' +
                ", project=" + project +
                ", parent='" + parent + '\'' +
                ", folder='" + folder + '\'' +
                ", space=" + space +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(final String localPath) {
        this.localPath = localPath;
    }

   /*
    "aspects": {},
      "category": "main",
      "created": "2014-04-06T16:55:09",
      "created_by": "Administrator Administrator",
      "description": "",
      "digest": "",
      "dynatype": {
        "caption_plural": "dynatypes_labels:File_plural:",
        "caption_singular": "dynatypes_labels:File_singular:",
        "id": "4f59e726-bdab-11e3-a0fa-6003088b5c52"
      },
      "filename": "proxylab.pdf",
      "folder": null,
      "id": "362327bc-bdac-11e3-a17a-6003088b5c52",
      "mime_type": "application/pdf",
      "modified": "2014-04-06T16:55:09",
      "modified_by": null,
      "owner": null,
      "parent": "21772f2a-bdac-11e3-a9b9-6003088b5c52",
      "project": {
        "id": "215de344-bdac-11e3-af12-6003088b5c52",
        "identifier": "2014-1",
        "title": "Project JIS"
      },
      "resource_uri": "/api/v2/files/362327bc-bdac-11e3-a17a-6003088b5c52/",
      "size": 0,
      "space": {
        "id": "0818f41e-bdac-11e3-9029-6003088b5c52",
        "title": "Space JIS"
      },
      "tags": [],
      "title": "proxylab",
      "type": "File",
      "version": "None.0"
     */
}
