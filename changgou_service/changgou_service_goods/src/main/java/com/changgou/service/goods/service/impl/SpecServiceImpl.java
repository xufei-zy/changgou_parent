package com.changgou.service.goods.service.impl;

import com.changgou.service.goods.dao.SpecMapper;
import com.changgou.service.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    private SpecMapper specMapper;

    @Override
    public List<Map> findListByCategoryName(String categoryName) {
        List<Map> specList = specMapper.findListByCategoryName(categoryName);
        for (Map spec : specList) {
            String[] options = ((String) spec.get("options")).split(",");
            spec.put("options",options);
        }
        return specList;
    }
}
