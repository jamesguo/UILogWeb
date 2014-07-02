package ctrip.system.model;

/**
 * Created with IntelliJ IDEA.
 * User: flai
 * Date: 14-4-30
 * Time: 下午2:09
 * To change this template use File | Settings | File Templates.
 */
public class TestCaseAssertion {

    private String fileName;
    private String filePath;
    private String fileRealPath;

    public TestCaseAssertion()
    {
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getFileRealPath()
    {
        return fileRealPath;
    }

    public void setFileRealPath(String fileRealPath)
    {
        this.fileRealPath = fileRealPath;
    }
}
