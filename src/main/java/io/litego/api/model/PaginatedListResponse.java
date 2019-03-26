package io.litego.api.model;

import java.util.List;

public class PaginatedListResponse<T> {
    public List<T> data;
    public int page;
    public int page_size;
    public int count;
    public String object;
}
