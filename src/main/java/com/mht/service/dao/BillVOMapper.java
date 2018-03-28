package com.mht.service.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mht.service.vo.BillVO;

public interface BillVOMapper {

	int insert(BillVO record);

	int update(BillVO record);

	int insertSelective(BillVO record);

	List<BillVO> queryBillList();

	/**
	 * @param billId
	 * @return
	 */
	Integer deleteBill(@Param("user") String user, @Param("deleteDate") Date deleteDate,
			@Param("billIds") List<String> billIds);
}