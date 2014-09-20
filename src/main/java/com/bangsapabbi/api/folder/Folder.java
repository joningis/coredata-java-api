package com.bangsapabbi.api.folder;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.bangsapabbi.api.common.AbstractInsertableDTO;
import com.bangsapabbi.api.common.Insertable;
import com.bangsapabbi.api.common.validation.Validateable;
import com.bangsapabbi.api.project.Project;
import com.google.gson.annotations.SerializedName;

/**
 * DTO for Folder.
 * At the moment a lot of stuff related to folders is done using api v1
 */
public class Folder extends AbstractInsertableDTO<Folder> {

    @NotNull
    private String title;

    @NotNull
    private String filename;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(final String filename) {
        this.filename = filename;
    }

    @Override
    public Set<ConstraintViolation<Folder>> getConstraintViolations() {
        return this.getConstraintViolations(this);
    }
}
