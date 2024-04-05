package hr;

import java.util.List;
import java.util.Scanner;

import hr.stock.StockDao;
import hr.stock.StockVo;
import hr.stock.IStockDao;

public class StockMain {

	public static void main(String[] args) {
		
		System.out.println("프로그램을 시작합니다.");
		
		IStockDao dao = new StockDao();
		Scanner sc1 = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n번호를 선택해 주세요: (1)제품 입력, (2)제품 가격 수정, (3)제품 수량 수정, (4)선택한 제품 조회, (5)전체 제품 조회, (6)제품 삭제, (0)프로그램 종료");
			System.out.print("번호: ");
			
			int selectNum = sc1.nextInt();
			Scanner sc2 = new Scanner(System.in);
			
			switch(selectNum) {
			case 1:
				//제품입력
				System.out.println("\n제품 정보를 입력해주세요.");
				System.out.println("제품 아이디, 제품명, 판매가, 제조사, 수량, 마진율 순으로 입력해주세요.");
				System.out.print("제품 아이디(int): ");
				int productId = new Scanner(System.in).nextInt();
				System.out.print("제품명(String): ");
				String name = new Scanner(System.in).nextLine();
				System.out.print("판매가(int): ");
				int price = new Scanner(System.in).nextInt();
				System.out.print("제조사(String): ");
				String company = new Scanner(System.in).nextLine();
				System.out.print("수량(int): ");
				int quantity = new Scanner(System.in).nextInt();
				System.out.print("마진율(Double): ");
				double marginRate = new Scanner(System.in).nextDouble();
				
				StockVo insertProduct = new StockVo(productId, name, price, company, quantity, marginRate);
				dao.insertProduct(insertProduct);
				System.out.println("정보가 등록되었습니다.");
				break;
				
			case 2:
				//제품 가격 수정
				System.out.println("\n수정할 제품 이름을 입력해주세요.: ");
				String updateNProduct = sc2.nextLine();
				
				try {
					StockVo updateProduct = dao.selectProduct(updateNProduct);
					System.out.printf("가격을 수정해주세요.(현재 가격 %d): ", updateProduct.getPrice());
					Scanner sc3 = new Scanner(System.in);
					int newPrice = sc3.nextInt();
					
					updateProduct.setPrice(newPrice);
					dao.updatePrice(updateProduct);
					System.out.println("가격이 수정되었습니다.");
				}
				catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				//제품 수량 수정
				System.out.println("\n수정할 제품 이름을 입력해주세요.: ");
				String updateQProduct = sc2.nextLine();
				
				try {
					StockVo updateProduct = dao.selectProduct(updateQProduct);
					System.out.printf("수량을 수정해주세요.(현재 수량 %d): ", updateProduct.getQuantity());
					Scanner sc3 = new Scanner(System.in);
					int newQuantity = sc3.nextInt();
					
					updateProduct.setQuantity(newQuantity);
					dao.updateQuantity(updateProduct);
					System.out.println("수량이 수정되었습니다.");
				}
				catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				//선택한 제품 조회
				System.out.println("\n조회할 제품 이름을 입력해주세요.: ");
				String pctName = sc2.nextLine();
				try {
					StockVo product4 = dao.selectProduct(pctName);
					System.out.printf("%s 정보를 출력합니다.\n", pctName);
					System.out.println(product4);
				}
				catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				//모든 정보 조회
				System.out.println("\n등록된 모든 제품을 출력합니다.");
				List<StockVo> productList = dao.selectAllProduct();
				if(productList.isEmpty()) {
					System.out.println("등록된 제품이 없습니다.");
				}
				else {
					for(StockVo emp3 : productList) {
						System.out.println(emp3+"\n");
					}
				}
				
				break;
				
			case 6:
				//제품 삭제
				System.out.println("\n삭제할 제품 이름을 입력해주세요.: ");
				String deleteName = sc2.nextLine();
				
				try {
					dao.deleteProduct(deleteName);
					System.out.println("해당 제품의 정보가 삭제되었습니다.");
					
				}
				catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 0:
				System.out.println("\n프로그램이 종료되었습니다.");
				System.exit(0);
				
			default:
				System.out.println("\n잘못된 번호입니다.");
				break;
			}
		}
		

	}

}
