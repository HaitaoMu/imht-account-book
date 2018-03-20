package com.mht.service.controller;

import com.mht.service.service.BillService;
import com.mht.service.vo.BillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
