package com.mht.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mht.service.dao.BillDetailVOMapper;
import com.mht.service.dao.BillVOMapper;
import com.mht.service.vo.BillDetailVO;
import com.mht.service.vo.BillVO;

/***
 * @Author: Mu Haitao
 * @Description:
 * @Date:Created in 下午 12:04 2018/3/17
 */
@Service
public class BillService {

	@Autowired
	private BillVOMapper billVOMapper;

	@Autowired
	private BillDetailVOMapper billDetailVOMapper;

	/**
	 * @Author: Mu Haitao
	 * @Description:
	 * @Date: 下午 09:58 2018/3/18
	 */
	public boolean saveBill(BillVO billVO) {
		try {
			billVOMapper.insert(billVO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean saveDetailBill(BillDetailVO billVO) {
		try {
			billDetailVOMapper.insert(billVO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @return
	 */
	public List<BillVO> queryBillList() {
		return billVOMapper.queryBillList();
	}

	/**
	 * @return
	 */
	public List<BillDetailVO> queryBillDetailList(String id) {
		return billDetailVOMapper.queryBillDetailList(id);
	}

	/**
	 * @param vo
	 * @return
	 */
	public boolean updateBill(BillVO vo) {
		try {
			billVOMapper.update(vo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
