package com.mfanw.pear.biz;

import java.util.List;
import java.util.Map;

import com.mfanw.pear.dto.UserDto;
import com.mfanw.pear.entity.UserEntity;

public interface IUserBiz {
    /**
     * <b>插入操作</b>
     * <p>
     * 跳过null的属性，跳过的属性将设置为默认值
     * </p>
     * 
     * @param entity
     * @return
     */
    int insert(UserDto entity);

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
    int update(UserDto user);

    /**
     * <b>根据主键获取一条记录</b>
     * 
     * @param id
     * @return
     */
    UserDto get(Integer id);

    /**
     * <b>根据查询条件获取List</b>
     * 
     * @param queryMap
     * @return
     */
    List<UserDto> getList(Map<String, Object> queryMap);

    UserDto entity2Dto(UserEntity entity);

    List<UserDto> entities2Dtos(List<UserEntity> entities);

    UserEntity dto2Entity(UserDto entity);

    List<UserEntity> dtos2Entities(List<UserDto> entities);
}
