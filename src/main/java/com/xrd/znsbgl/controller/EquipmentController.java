package com.xrd.znsbgl.controller;


import com.xrd.znsbgl.entity.Equipment;
import com.xrd.znsbgl.mapper.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class EquipmentController {

    @Autowired
    EquipmentMapper equipmentMapper;


    @GetMapping("/addEquipment")
    public HashMap<String, Object> addEquipment(Equipment equipment) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int i = equipmentMapper.addEquipment(equipment);
        hashMap.put("code",1);
        hashMap.put("msg","插入成功");
        return hashMap;

    }

    @GetMapping("/getAllEquipment")
    public HashMap<String, Object> getAllEquipment() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        ArrayList<Equipment> al = equipmentMapper.getAllEquipment();
        hashMap.put("code",1);
        hashMap.put("msg","查询成功");
        hashMap.put("data",al);
        return hashMap;

    }
    @GetMapping("/getEquipmentById")
    public HashMap<String, Object> getEquipmentById(Integer id) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Equipment equipment = equipmentMapper.getEquipmentById(id);
        hashMap.put("code",1);
        hashMap.put("msg","查询成功");
        hashMap.put("data",equipment);
        return hashMap;

    }
    @GetMapping("/updateEquipmentById")
    public HashMap<String, Object> updateEquipmentById(Equipment equipment) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int i = equipmentMapper.updateEquipmentById(equipment);
        hashMap.put("code",i);
        hashMap.put("msg","修改成功");
        return hashMap;

    }
    @GetMapping("/deleteEquipmentById")
    public HashMap<String, Object> deleteEquipmentById(Integer id) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int i = equipmentMapper.deleteEquipmentById(id);
        hashMap.put("code",i);
        hashMap.put("msg","删除成功");
        return hashMap;

    }
}
