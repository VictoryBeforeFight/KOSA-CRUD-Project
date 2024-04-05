package hr.stock;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StockVo {
	private int productId; //제품 아이디
	private String name; //제품명
	private int price; //판매가
	private String company; //제조사
	private int quantity; //수량
	private double marginRate; //마진율
}
