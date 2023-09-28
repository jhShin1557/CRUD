package com.example.demo.mapper;

import com.example.demo.domain.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataMapper {
    List<Data> getListData();

    Data getDataInfo(Integer num);

    void modifyDataInfo(Data data);
}
