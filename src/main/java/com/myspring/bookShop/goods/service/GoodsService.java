package com.myspring.bookShop.goods.service;

import java.util.List;
import java.util.Map;

import com.myspring.bookShop.goods.vo.GoodsVO;

public interface GoodsService {
	public Map<String, List<GoodsVO>> listGoods() throws Exception;
}
