package pojo;

import java.util.List;

public class Pager {
    private Integer pageSize;
    private Integer pageCount;
    private Integer totalCount;
    private Integer pageIndex;
    private Integer firstData;
    private List list;
    private  String id;


    public void count(){

        if(totalCount==null){
            totalCount=0;
        }
        if (pageIndex==null || pageIndex<=0){
            pageIndex=1;
        }
        pageCount=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;

        if (pageIndex>pageCount && pageCount!=0){
            pageIndex=pageCount;
        }else if(pageCount==0){
            pageSize=0;
        }
        firstData=(pageIndex-1)*pageSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFirstData() {
        return firstData;
    }

    public void setFirstData(Integer firstData) {
        this.firstData = firstData;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }



    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
