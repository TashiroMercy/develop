package jp.co.demo.security;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.co.demo.model.User;

public class LoginUser extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7910935926840934108L;

	/**
	 * ログインユーザー
	 */
	private final User user;

    /**
     * コンストラクタ
     * @param user
     */
    public LoginUser(User user) {
        // スーパークラスのユーザーID、パスワードに値をセットする
        // 実際の認証はスーパークラスのユーザーID、パスワードで行われる
        super(user.getLoginUserId(), user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }

    /**
    *
    * @return
    */
    public User getUser() {
        return user;
    }

}
