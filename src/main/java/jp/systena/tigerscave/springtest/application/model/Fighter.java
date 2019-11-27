package jp.systena.tigerscave.springtest.application.model;

public class Fighter implements Job {

	  private String name;
	  private String jobName = "格闘家";

	  /**
	   * 名前を返却します.
	   * @return 名前
	   */
	  @Override
	  public String getName() {
	      return this.name;
	  }

	  /**
	   * 名前を設定します.
	   * @param name 名前
	   */
	  @Override
	  public void setName(String name) {
	      this.name = name;
	  }

	  /**
	   * 職業名を返却します.
	   * @return 職業名
	   */
	  @Override
	  public String getJobName() {
	      return this.jobName;
	  }

	  /**
	   * 職業名を設定します.
	   * @param jobName 職業名
	   */
	  @Override
	  public void setJobName(String jobName) {
	      this.name = jobName;
	  }

	  @Override
	  public String attack() {
	    return this.name + "は拳で攻撃した。" ;

	  }

	  @Override
	  public String heal() {
	    return this.name + "はやくそうで回復した。" ;

	  }
}
