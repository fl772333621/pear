package com.mfanw.pear.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mfanw.pear.entity.UserEntity;

@Mapper
public interface IUserDao {
    /**
     * <b>插入操作</b>
     * <p>
     * 跳过null的属性，跳过的属性将设置为默认值
     * </p>
     * 
     * @param entity
     * @return
     */
    int insert(UserEntity entity);

    /**
     * <b>根据主键删除</b>
     * 
     * @param id
     */
    void delete(Integer id);

    /**
     * <b>根据实体更新</b>
     * 
     * @param user
     * @return
     */
    int update(UserEntity user);

    /**
     * <b>根据主键获取一条记录</b>
     * 
     * @param id
     * @return
     */
    UserEntity get(Integer id);

    /**
     * <b>根据查询条件获取List</b>
     * 
     * @param queryMap
     * @return
     */
    List<UserEntity> getList(Map<String, Object> queryMap);
}
