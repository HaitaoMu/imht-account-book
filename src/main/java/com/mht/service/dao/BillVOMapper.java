package com.mht.service.dao;

import com.mht.service.vo.BillVO;

public interface BillVOMapper {

	int insert(BillVO record);

	int insertSelective(BillVO record);
}