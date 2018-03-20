package com.mht.service.dao;

import com.mht.service.vo.BillDetailVO;

public interface BillDetailVOMapper {
    int insert(BillDetailVO record);

    int insertSelective(BillDetailVO record);
}