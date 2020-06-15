package com.myspring.bookShop.goods.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface GoodsController {
	public ModelAndView goodsDetail(@RequestParam("goods_id") String goods_id,
			HttpServletRequest request, HttpServletResponse response) throws Exception; 
}