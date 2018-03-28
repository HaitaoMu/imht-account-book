package com.mht.service.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mht.service.service.BillService;
import com.mht.service.vo.BillDetailVO;
import com.mht.service.vo.BillVO;

/***
 * @Author: Mu Haitao
 * @Description:
 * @Date:Created in 下午 12:05 2018/3/17
 */
@RestController
public class BillController {

	@Autowired
	private BillService billService;

	@GetMapping("/addBill")
	public boolean addBill(BillVO vo) {
		vo.setBillId(UUID.randomUUID().toString());
		vo.setCreateUser("muhaitao");
		vo.setCreateTime(new Date());
		return billService.saveBill(vo);
	}

	@PostMapping("/deleteBill")
	public Integer deleteBill(@RequestParam("billIds") List<String> billIds) {
		return billService.deleteBill("chenyan", new Date(), billIds);
	}

	@PostMapping("/updateBill")
	public boolean updateBill(BillVO vo) {
		return billService.updateBill(vo);
	}

	@PostMapping("/saveDetailBill")
	public boolean saveDetailBill(BillDetailVO vo) {
		return billService.saveDetailBill(vo);
	}

	@GetMapping("/queryBillList")
	public List<BillVO> queryBillList() {
		return billService.queryBillList();
	}

	@GetMapping("/queryBillDetailList")
	public List<BillDetailVO> queryBillDetailList(String billDetailId) {
		List<BillDetailVO> list = billService.queryBillDetailList(billDetailId);
		return list;
	}
}
