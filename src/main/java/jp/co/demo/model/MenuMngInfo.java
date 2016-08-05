package jp.co.demo.model;



/**
 * メニュー管理 エンティティ。
 *
 * @author entity generator
 *
 */
public class MenuMngInfo {

	/** 機能ID */
	private String funcId;

	/** 機能名称 */
	private String funcNm;

	/** 機能パス */
	private String funcPath;

	/** ウェブメニュー種類ＩＤ */
	private String webMenuKindId;
	
	/**
	 * @return the webMenuKindId
	 */
	public String getWebMenuKindId() {
		return webMenuKindId;
	}

	/**
	 * @param webMenuKindId the webMenuKindId to set
	 */
	public void setWebMenuKindId(String webMenuKindId) {
		this.webMenuKindId = webMenuKindId;
	}

	/**
	 * @return the webMenuKindNm
	 */
	public String getWebMenuKindNm() {
		return webMenuKindNm;
	}

	/**
	 * @param webMenuKindNm the webMenuKindNm to set
	 */
	public void setWebMenuKindNm(String webMenuKindNm) {
		this.webMenuKindNm = webMenuKindNm;
	}

	/** ウェブメニュー種類名称 */
	private String webMenuKindNm;
	
	/**
	 * 機能IDを取得します。
	 * @return 機能ID
	 */
	public String getFuncId() {
		return funcId;
	}

	/**
	 * 機能IDを設定します。
	 * @param funcId 機能ID
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	/**
	 * 機能名称を取得します。
	 * @return 機能名称
	 */
	public String getFuncNm() {
		return funcNm;
	}

	/**
	 * 機能名称を設定します。
	 * @param funcNm 機能名称
	 */
	public void setFuncNm(String funcNm) {
		this.funcNm = funcNm;
	}

	/**
	 * 機能パスを取得します。
	 * @return 機能パス
	 */
	public String getFuncPath() {
		return funcPath;
	}

	/**
	 * 機能パスを設定します。
	 * @param funcPath 機能パス
	 */
	public void setFuncPath(String funcPath) {
		this.funcPath = funcPath;
	}

}