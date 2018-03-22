package com.mht.service.dao;

import java.util.List;

import com.mht.service.vo.BillVO;

public interface BillVOMapper {

	int insert(BillVO record);

	int insertSelective(BillVO record);

	List<BillVO> queryBillList();
}