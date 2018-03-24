package com.mht.service.dao;

import java.util.List;

import com.mht.service.vo.BillDetailVO;

public interface BillDetailVOMapper {

	int insert(BillDetailVO record);

	int insertSelective(BillDetailVO record);

	List<BillDetailVO> queryBillDetailList(String id);
}