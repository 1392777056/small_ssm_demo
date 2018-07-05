package it.heima.dao;

import it.heima.domain.Item;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 德哲
 * @date 2018/6/25 16:35.
 */
@Repository
public interface ItemDao {

    @Select("select * from items where id = #{id}")
    public Item getItemById(Integer id);

}
