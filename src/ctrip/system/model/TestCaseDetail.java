package ctrip.system.model;

/**
 * Created with IntelliJ IDEA.
 * User: flai
 * Date: 14-4-30
 * Time: 下午2:07
 * To change this template use File | Settings | File Templates.
 */
public class TestCaseDetail {
    private String request;
    private String response;
    private int id;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
