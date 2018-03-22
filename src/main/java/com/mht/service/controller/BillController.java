package com.mht.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mht.service.service.BillService;
import com.mht.service.vo.BillVO;

/***
 *@Author: Mu Haitao
 *@Description:
 *@Date:Created in 下午 12:05 2018/3/17
 */
@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/saveBill")
    public boolean saveBill(BillVO vo) {
        return billService.saveBill(vo);
    }
    
    @GetMapping("/queryBillList")
    public List<BillVO> queryBillList() {
        return billService.queryBillList();
    }
}
