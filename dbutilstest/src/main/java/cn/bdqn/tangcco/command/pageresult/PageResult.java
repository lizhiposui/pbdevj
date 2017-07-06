package cn.bdqn.tangcco.command.pageresult;

/**
 * Created by Administrator on 2017/6/27.
 */
public class PageResult {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPosts;
    private Integer totalPages;

    public PageResult(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public PageResult(Integer pageNumber, Integer pageSize, Integer totalPosts, Integer totalPages) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPosts = totalPosts;
        this.totalPages = totalPages;
    }

    public PageResult() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(Integer totalPosts) {
        this.totalPosts = totalPosts;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
