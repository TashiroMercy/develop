package jp.co.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.demo.bean.SampleForm;


@Controller
public class MenuController {

   @RequestMapping("/memu")
   public String result(@ModelAttribute("sampleForm") SampleForm form) {
       /*
        *  画面で入力された値はform.getName()で取得可能。
        *  今回は何もしないので、ビュー名を返すだけ。
        */
       return "admin";
   }
}