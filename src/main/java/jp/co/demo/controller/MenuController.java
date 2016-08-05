package jp.co.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.demo.bean.SampleForm;
import jp.co.demo.model.MenuMngInfo;


@Controller
public class MenuController {

	@RequestMapping("/menu")
	public String result(@ModelAttribute("sampleForm") SampleForm form, Model model) {

		List<MenuMngInfo> list = new ArrayList<>();
		
		for (int i = 0 ; i < 10 ; i++) {
			MenuMngInfo menuMngInfo = new MenuMngInfo();
			menuMngInfo.setFuncId("FUNCID".concat(String.format("%02d", i)));
			menuMngInfo.setFuncNm("FUNCNM".concat(String.format("%02d", i)));
			menuMngInfo.setFuncPath("/".concat(String.format("%02d", i)));
			
			// ウェブメニュー種類ＩＤ
			menuMngInfo.setWebMenuKindId("MENU-KIND".concat(String.format("%02d", i%3)));
			// ウェブメニュー種類名称
			menuMngInfo.setWebMenuKindNm("MENU-KIND".concat(String.format("%02d", i%3)));
			list.add(menuMngInfo);
		}

		// カテゴリ最小単位を取得
		List<String> menuKindId = new ArrayList<String>(); // カテゴリID 一覧
		Map<String, String> mkindNm = new HashMap<String, String>(); // カテゴリ名称
		Map<String, List<MenuMngInfo>>mMenuKind = new HashMap<String, List<MenuMngInfo>>(); // カテゴリの機能一覧
		String key;
		for (MenuMngInfo entity : list) {
			key = StringUtils.defaultString(entity.getWebMenuKindId(), "uncategorized");
			if (!menuKindId.contains(key)) {
				menuKindId.add(key);
				mkindNm.put(key, StringUtils.defaultString(entity.getWebMenuKindNm(),"未分類"));
				mMenuKind.put(key, new ArrayList<MenuMngInfo>());
			}
		}

		// カテゴリ単位に機能を格納
		// カテゴリが無いものは未分類に代入
		List<MenuMngInfo> listwork;
		for (MenuMngInfo entity : list) {
			key = StringUtils.defaultString(entity.getWebMenuKindId(), "uncategorized");
			listwork = mMenuKind.get(key);
			listwork.add(entity);
			mMenuKind.put(key, listwork);
		}
		
		model.addAttribute("menuKindId", menuKindId); // カテゴリID 一覧
		model.addAttribute("mkindNm", mkindNm); // カテゴリ名称
		model.addAttribute("mMenuKind", mMenuKind); // カテゴリの機能一覧

		return "menu";
	}
}