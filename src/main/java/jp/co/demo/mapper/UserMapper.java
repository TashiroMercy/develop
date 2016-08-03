package jp.co.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import jp.co.demo.model.User;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO user (loginUserId, password) VALUES (#{loginUserId}, #{password})")
	void insert(User user);

	@Select("SELECT loginUserId, password  FROM user WHERE loginUserId = #{loginUserId}")
	User select(String loginUserId);
	
}
