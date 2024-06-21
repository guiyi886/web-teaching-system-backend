package teaching.system.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import teaching.system.backend.domain.po.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select allow from authority where name = 'register'")
    Integer getRegisterAllow();

    @Update("update authority set allow = #{allow} where name = 'register'")
    void changeRegisterAllow(Integer allow);
}




