package jp.co.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.demo.bean.SampleForm;


@Controller
@RequestMapping("/sample")
public class SampleController {

   @RequestMapping("/result")
   public String result(@ModelAttribute("sampleForm") SampleForm form) {
       /*
        *  ��ʂœ��͂��ꂽ�l��form.getName()�Ŏ擾�\�B
        *  ����͉������Ȃ��̂ŁA�r���[����Ԃ������B
        */
       return "output";
   }
}