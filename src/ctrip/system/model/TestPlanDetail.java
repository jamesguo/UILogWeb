package ctrip.system.model;

/**
 * Created with IntelliJ IDEA.
 * User: flai
 * Date: 14-4-30
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
public class TestPlanDetail {
    private int id;
    private String caseNO;
    private String serviceName;
    private String rCode;
    private String passValidation;
    private Long processTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseNO() {
        return caseNO;
    }

    public void setCaseNO(String caseNO) {
        this.caseNO = caseNO;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Long processTime) {
        this.processTime = processTime;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public String getPassValidation() {
        return passValidation;
    }

    public void setPassValidation(String passValidation) {
        this.passValidation = passValidation;
    }
}
