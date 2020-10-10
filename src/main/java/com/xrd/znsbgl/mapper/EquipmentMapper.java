package com.xrd.znsbgl.mapper;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface EquipmentMapper {

    public int addEquipment(Equipment equipment);

    public ArrayList<Equipment> getAllEquipment();

    public Equipment getEquipmentById(Integer id);

    public int updateEquipmentById(Equipment equipment);

    public int deleteEquipmentById(Integer id);
}
