package hr.stock;

import java.util.List;

public interface IStockDao {
	//제품정보 등록, 가격 & 수량 수정, 삭제(단종), 선택한제품 조회, 전제 조회
	//기능 구현을 위한 메서드 정의
	void insertProduct(StockVo info);
	void updatePrice(StockVo info);
	void updateQuantity(StockVo info);
	void deleteProduct(String name);
	StockVo selectProduct(String name);
	List<StockVo> selectAllProduct();
	
}