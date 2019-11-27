package jp.systena.tigerscave.springtest.application.model;

//import javax.validation.constraints.Size;

public class JobForm {
  //@Size(max=10)         // 入力最大長
  private String name;
  private String job;

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getJob() {
    return this.job;
  }
  public void setJob(String job) {
    this.job = job;
  }

}
