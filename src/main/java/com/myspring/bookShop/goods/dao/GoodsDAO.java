package com.myspring.bookShop.goods.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.bookShop.goods.vo.GoodsVO;

public interface GoodsDAO {
	public List<GoodsVO> selectGoodsList(String goodsStatus) throws DataAccessException;
}
