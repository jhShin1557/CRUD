package com.example.demo.service;

import com.example.demo.domain.Data;
import com.example.demo.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final DataMapper dataMapper;
    @Autowired
    public DataService(DataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }
    public List<Data> getListData() {
        return dataMapper.getListData();
    }
    public Data getDataInfo(Integer num) {
        return dataMapper.getDataInfo(num);
    }

    public void modifyDataInfo(Data data) {
        dataMapper.modifyDataInfo(data);
    }
}

