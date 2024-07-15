package com.iam57.akianime.common.result;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

/**
 * @author iam57
 * @since 2024/7/1 20:39
 */
@Data
@AllArgsConstructor
public class PageResult<T> {
    private Long total;
    private Integer pageNum;
    private Integer pageSize;
    private List<T> list;

    public PageResult(PageInfo<T> pageInfo) {
        total = pageInfo.getTotal();
        pageNum = pageInfo.getPageNum();
        pageSize = pageInfo.getPageSize();
        list = pageInfo.getList();
    }
}
