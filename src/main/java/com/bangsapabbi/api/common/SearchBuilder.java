package com.bangsapabbi.api.common;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class SearchBuilder {

    private final Search search;

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private SearchBuilder() {
        search = new Search();
    }

    public static SearchBuilder newSearch() {
        return new SearchBuilder();
    }

    public SearchBuilder limit(final int value) {
        search.put("limit", String.valueOf(value));
        return this;
    }

    public SearchBuilder offset(final int value) {
        search.put("offset", String.valueOf(value));
        return this;
    }

    public SearchBuilder modifedBy(final String value) {
        search.put("modified_by", value);
        return this;
    }

    public SearchBuilder title(final String value) {
        search.put("title", value);
        return this;
    }

    public SearchBuilder titleStartsWith(final String value) {
        search.put("title__startswith", value);
        return this;
    }

    /**
     * This is the full name of the creator.
     *
     * @param value The full name of the creator.
     * @return TaskSearchBuilder to continue to build search query.
     */
    public SearchBuilder createdBy(final String value) {
        search.put("created_by", value);
        return this;
    }

    public SearchBuilder created(final Date date) {
        search.put("created", formatDate(date));
        return this;
    }

    public SearchBuilder createdGreaterThan(final Date date) {
        search.put("created__gt", formatDate(date));
        return this;
    }

    public SearchBuilder createdGreaterThenOrEqual(final Date date) {
        search.put("created__gte", formatDate(date));
        return this;
    }

    public SearchBuilder createdLessThan(final Date date) {
        search.put("created__lt", formatDate(date));
        return this;
    }

    public SearchBuilder createdLessThenOrEqual(final Date date) {
        search.put("created__lte", formatDate(date));
        return this;
    }

    public SearchBuilder modified(final Date date) {
        search.put("modified", formatDate(date));
        return this;
    }

    public SearchBuilder modifiedGreaterThan(final Date date) {
        search.put("modified__gt", formatDate(date));
        return this;
    }

    public SearchBuilder modifiedGreaterThenOrEqual(final Date date) {
        search.put("modified__gte", formatDate(date));
        return this;
    }

    public SearchBuilder modifiedLessThan(final Date date) {
        search.put("modified__lt", formatDate(date));
        return this;
    }

    public SearchBuilder modifiedLessThenOrEqual(final Date date) {
        search.put("modified__lte", formatDate(date));
        return this;
    }

    public Search create() {
        return this.search;
    }

    /**
     * 2012-02-18T18:25:37.456Z
     *
     * @param date
     * @return
     */
    private String formatDate(final Date date) {
        return new SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(date);
    }
}
