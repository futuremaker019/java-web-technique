package com.myspring.bookShop.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.bookShop.goods.vo.GoodsVO;
import com.myspring.bookShop.goods.vo.ImageFileVO;

@Repository("goodsDAO")
public class GoodsDAOImpl implements GoodsDAO{
	
	@Autowired
	private SqlSession sqlSession;

//	메인 페이지 구현
	@Override
	public List<GoodsVO> selectGoodsList(String goodsStatus) throws DataAccessException {
		return sqlSession.selectList("mapper.goods.selectGoodsList", goodsStatus);
	}

//	상세 페이지 구현 
	@Override
	public GoodsVO selectGoodsDetail(String goods_id) throws DataAccessException {
		return sqlSession.selectOne("mapper.goods.selectGoodsDetail", goods_id);
	}
	@Override
	public List<ImageFileVO> selectGoodsDetailImage(String goods_id) throws DataAccessException {
		return sqlSession.selectList("mapper.goods.selectGoodsDetailImage", goods_id);
	}

//	31.5 Ajax 이용해 검색 자동 완성 기능 구현하기
	@Override
	public List<GoodsVO> selectGoodsBySearchWord(String searchWord) throws DataAccessException {
		return sqlSession.selectList("mapper.goods.selectGoodsBySearchWord", searchWord);
	}
	@Override
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
		return sqlSession.selectList("mapper.goods.selectKeywordSearch", keyword);
	}

	
}
