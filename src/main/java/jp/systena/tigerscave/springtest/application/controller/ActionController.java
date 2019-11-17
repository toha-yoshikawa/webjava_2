package jp.systena.tigerscave.springtest.application.controller;


  import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.systena.tigerscave.springtest.application.model.JobForm;


  @Controller  // Viewあり。Viewを返却するアノテーション
  public class ActionController {

    @RequestMapping(value="/StartView", method = RequestMethod.GET)          // URLとのマッピング
    public ModelAndView Start(ModelAndView mav) {


      //List<Item> items = new ArrayList<>(list.getItemList().values());
      //mav.addObject("itemList", items);
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
      mav.addObject("JobForm",form);


      mav.setViewName("BattleView");
      return mav;

    }

    @RequestMapping(value="/BattleView", method = RequestMethod.POST)          // URLとのマッピング
    public ModelAndView Attack(ModelAndView mav,JobForm form ) {

      //if form
      if(form.getJob().equals("剣士")) {
        mav.addObject("message",form.getName() + "は剣で攻撃した！");
      }
      else {
        mav.addObject("message",form.getName() + "は魔法で攻撃した！");
      }
      mav.addObject("JobForm",form);


      mav.setViewName("ActionView");
      return mav;

    }
    

}
