package com.mfanw.pear.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mfanw.pear.biz.IUserBiz;
import com.mfanw.pear.dao.IUserDao;
import com.mfanw.pear.dto.UserDto;
import com.mfanw.pear.entity.UserEntity;
import com.mfanw.pear.enums.EnumUserTypeFlag;

@Service
public class UserBizImpl implements IUserBiz {

    @Autowired
    private IUserDao userDao;

    @Override
    public int insert(UserDto dto) {
        return userDao.insert(dto2Entity(dto));
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public int update(UserDto dto) {
        return userDao.update(dto2Entity(dto));
    }

    @Override
    public UserDto get(Integer id) {
        return entity2Dto(userDao.get(id));
    }

    @Override
    public List<UserDto> getList(Map<String, Object> queryMap) {
        return entities2Dtos(userDao.getList(queryMap));
    }

    @Override
    public UserDto entity2Dto(UserEntity entity) {
        UserDto dto = new UserDto();
        if (entity == null) {
            return dto;
        }
        dto.setId(entity.getId());
        dto.setManager(entity.getManager());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setTypeFlag(EnumUserTypeFlag.getEnum(entity.getTypeFlag()));
        dto.setNickname(entity.getNickname());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setMoney(entity.getMoney());
        dto.setCreator(entity.getCreator());
        dto.setCreateTime(entity.getCreateTime());
        dto.setModifier(entity.getModifier());
        dto.setModifyTime(entity.getModifyTime());
        return dto;
    }

    @Override
    public List<UserDto> entities2Dtos(List<UserEntity> entities) {
        List<UserDto> results = Lists.newArrayList();
        if (entities == null || entities.isEmpty()) {
            return results;
        }
        for (UserEntity entity : entities) {
            results.add(entity2Dto(entity));
        }
        return results;
    }

    @Override
    public UserEntity dto2Entity(UserDto dto) {
        UserEntity entity = new UserEntity();
        if (dto == null) {
            return entity;
        }
        entity.setId(dto.getId());
        entity.setManager(dto.getManager());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setTypeFlag(dto.getTypeFlag().getCode());
        entity.setNickname(dto.getNickname());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setMoney(dto.getMoney());
        entity.setCreator(dto.getCreator());
        entity.setCreateTime(dto.getCreateTime());
        entity.setModifier(dto.getModifier());
        entity.setModifyTime(dto.getModifyTime());
        return entity;
    }

    @Override
    public List<UserEntity> dtos2Entities(List<UserDto> dtos) {
        List<UserEntity> results = Lists.newArrayList();
        if (dtos == null || dtos.isEmpty()) {
            return results;
        }
        for (UserDto dto : dtos) {
            results.add(dto2Entity(dto));
        }
        return results;
    }

}
