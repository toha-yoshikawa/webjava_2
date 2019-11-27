package jp.systena.tigerscave.springtest.application.controller;


  import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.systena.tigerscave.springtest.application.model.Job;
import jp.systena.tigerscave.springtest.application.model.JobForm;
import jp.systena.tigerscave.springtest.application.service.JobService;


  @Controller  // Viewあり。Viewを返却するアノテーション
  public class ActionController {

    @Autowired
    HttpSession session; // セッション管理

    JobService service = new JobService();
    Job player = null;

    @RequestMapping(value="/StartView", method = RequestMethod.GET)          // URLとのマッピング
    public ModelAndView Start(ModelAndView mav) {


      //JobService service = new JobService();
      mav.addObject("jobList", service.getJobList());
      // Viewに渡すデータを設定
      mav.addObject("JobForm", new JobForm());
      mav.setViewName("StartView");
      return mav;
      //model.addAttribute("message","みそ");
      // Viewのテンプレート名を返す
      //return "ListView";
    }


    @RequestMapping(value="/StartView", method = RequestMethod.POST)          // URLとのマッピング
    public ModelAndView Battle(ModelAndView mav,JobForm form ) {

      //if form

      Map<String, Job> jobList = service.getJobList();
      for (String key : jobList.keySet()) {
      	if (form.getJob().equals(key)){
      		player = jobList.get(key);
      		player.setName(form.getName());
      	}
      }

      session.setAttribute("player", player);
      mav.addObject("player", player);
      mav.setViewName("BattleView");
      return mav;

    }

    @RequestMapping(value="/BattleView", params = "attack", method = RequestMethod.POST)          // URLとのマッピング
    public ModelAndView Attack(ModelAndView mav,JobForm form ) {

      //if form
      player = (Job)session.getAttribute("player");

      mav.addObject("message", player.attack());

      /*
      if(answer.equals(form.getAction())) {
          mav.addObject("message", player.attack());

      }
      else {
          mav.addObject("message", player.heal());

      }
      */
      mav.setViewName("ActionView");
      return mav;

    }

    @RequestMapping(value="/BattleView", params = "heal", method = RequestMethod.POST)          // URLとのマッピング
    public ModelAndView Heal(ModelAndView mav,JobForm form ) {

      //if form
      player = (Job)session.getAttribute("player");
      mav.addObject("message", player.heal());
      /*
      if(answer.equals(form.getAction())) {
          mav.addObject("message", player.attack());

      }
      else {
          mav.addObject("message", player.heal());

      }
      */
      mav.setViewName("ActionView");
      return mav;

    }

}
