package com.mht.service.service;

import com.mht.service.vo.BillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mht.service.dao.BillVOMapper;

/***
 *@Author: Mu Haitao
 *@Description:
 *@Date:Created in 下午 12:04 2018/3/17
 */
@Service
public class BillService {

    @Autowired
    private BillVOMapper billVOMapper;

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

}
