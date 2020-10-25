package com.myspring.bookShop.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.bookShop.goods.dao.GoodsDAO;
import com.myspring.bookShop.goods.vo.GoodsVO;
import com.myspring.bookShop.goods.vo.ImageFileVO;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDAO goodsDAO;

	@Override
	public Map<String, List<GoodsVO>> listGoods() throws Exception {
		Map<String, List<GoodsVO>> goodsMap = new HashMap<String, List<GoodsVO>>();
		
		List<GoodsVO> goodsList = goodsDAO.selectGoodsList("bestseller");
		goodsMap.put("bestseller", goodsList);
		
		goodsList = goodsDAO.selectGoodsList("newbook");
		goodsMap.put("newbook", goodsList);
		
		goodsList = goodsDAO.selectGoodsList("steadyseller");
		goodsMap.put("steadyseller", goodsList);
		
		return goodsMap;
	}

	@Override
	public Map goodsDetail(String goods_id) throws Exception {
		Map goodsMap = new HashMap();
		GoodsVO goodsVO = goodsDAO.selectGoodsDetail(goods_id);
		goodsMap.put("goodsVO", goodsVO);
		
		List<ImageFileVO> imageList = goodsDAO.selectGoodsDetailImage(goods_id);
		goodsMap.put("imageList", imageList);
		
		return goodsMap;
	}

	@Override
	public List<String> keywordSearch(String keyword) throws Exception {
		return goodsDAO.selectKeywordSearch(keyword);
	}

	@Override
	public List<GoodsVO> searchGoods(String searchWord) throws Exception {
		return goodsDAO.selectGoodsBySearchWord(searchWord);
	}
}
