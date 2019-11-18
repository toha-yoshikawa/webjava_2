package jp.systena.tigerscave.springtest.application.service;

import java.util.Map;
import java.util.TreeMap;
import jp.systena.tigerscave.springtest.application.model.Job;
import jp.systena.tigerscave.springtest.application.model.Knight;
import jp.systena.tigerscave.springtest.application.model.Wizard;

public class JobService {


  private Map<String, Job> jobList = new TreeMap<>();
  public JobService() {

  Job knight = new Knight();
  jobList.put(knight.getJobName(),knight);
  Job wizard = new Wizard();
  jobList.put(wizard.getJobName(),wizard);


  }
public Map<String, Job> getJobList() {

  return jobList;
}



}