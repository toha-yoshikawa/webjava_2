package jp.systena.tigerscave.springtest.application.model;

public interface Job {

  public String attack();
  public String heal();
  public String getName();
  public void setName(String jobName);
  public String getJobName();
  public void setJobName(String jobName);
}
