package com.common.viewmodel;

/**
 * Created with IntelliJ IDEA.
 * User: flai
 * Date: 14-4-30
 * Time: 下午2:17
 * To change this template use File | Settings | File Templates.
 */
public class TestAssertionSearchFilter extends BaseSearchFilter {
    private String path;

    public TestAssertionSearchFilter()
    {
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
}
