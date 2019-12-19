
import java.util.ArrayList;
import java.util.Scanner;

public class Supermarket {
	int ID;        //商品编号 상품번호
	String name;   //商品名    명칭
	double price;  //单价        단가
	int number;    //数量        수량
	double money;  //总金额     총금액

	
	
	
	
/**
 * 主方法
 * @param args
 */
public static void main(String[] args) {
	ArrayList<Supermarket> array = new ArrayList<Supermarket>();
	init(array);
	while(true) {
		mainMenu();
		int choose = chooseFunction();
		switch (choose) {
		case 1:
			showFruitList(array);
			break;
			
		case 2:
			addFruit(array);
			break;
		
		case 3:
			deleteFruit(array);
			break;
			
		case 4:
			updateFruit(array);
			break;
			
		case 5:
			return;
			
		default:
			System.out.println("입력한 일련 번호가 없습니다");
			break;
		}
	}
}




/**
 * 商品初始化方法
 * @param array
 */
public static void init(ArrayList<Supermarket> array) {
Supermarket f1 = new Supermarket();
f1.ID = 9527;
f1.name = "콜라";
f1.price = 3;
f1.number = 4;
f1.money = f1.price * f1.number;

Supermarket f2 = new Supermarket();
f2.ID = 9008;
f2.name = "찐빵";
f2.price = 0.5;
f2.number = 6;
f2.money = f2.price * f2.number;

Supermarket f3 = new Supermarket();
f3.ID = 9879;
f3.name = "빵";
f3.price = 4;
f3.number = 8;
f3.money = f3.price * f3.number;

array.add(f1);
array.add(f2);
array.add(f3);
}



/**
 * 菜单显示方法
 */
public static void mainMenu(){
System.out.println();
System.out.println("============슈퍼마켓에 오신 것을 환영합니다============");
System.out.println("1:모든상품    2:상품을 첨가    3:상품 삭제   4:상품을 수정하다   5:퇴출");
System.out.println("조작할 기능 번호를 입력해 주십시오:");
}


/**
 * 序号选择方法
 */
public static int chooseFunction() {
Scanner sc = new Scanner(System.in);
return sc.nextInt();
}


/**
 * 库存货物查询
 * @param array
 */
public static void showFruitList(ArrayList<Supermarket> array) {
System.out.println();
System.out.println("-----------상품재고-----------");
//System.out.println("商品编号          商品名称          商品单价");
for(int i =0 ; i < array.size(); i++) {
	Supermarket item = array.get(i);
	System.out.println("--상품번호:" + item.ID+"   "+"--상품명:"+ item.name+"   "+"--상품단가:"+ item.price +"  " +  "--상품 수량:"+ item.number + "  " + "--상품총금액:" + item.money);
	}
}


/**
 * 添加新货物
 * @param array
 */
public static void addFruit(ArrayList<Supermarket> array){
System.out.println("선택한 것은 상품을 추가하는 기능입니다:");

	Scanner sc = new Scanner(System.in);
	System.out.println("상품의 번호를 입력해 주세요:");
	int ID = sc.nextInt();
	System.out.println("상품의 이름을 입력해 주세요:");
	String name = sc.next();
	System.out.println("상품의 단가를 입력하다:");
	double price = sc.nextDouble();
	System.out.println("상품의 수량을 입력해 주세요:");
	int number = sc.nextInt();
	//double money = sc.nextDouble();
	double money = price * number;
	Supermarket item = new Supermarket();
	item.ID = ID;
	item.name = name;
	item.price = price;
	item.number = number;
	item.money = money;
	array.add(item);
	System.out.println("상품 추가 성공");
}


/**
 * 删除货物
 * @param array
 */
public static void deleteFruit(ArrayList<Supermarket> array){
System.out.println("선택한 것은 삭제 기능입니다");
System.out.println("상품의 번호를 입력해 주세요:");
Scanner sc = new Scanner(System.in);

int ID = sc.nextInt();
for(int i = 0 ; i < array.size(); i++){
	Supermarket item = array.get(i);
	
	if( item.ID == ID){
		array.remove(i);
		System.out.println("삭제 성공");
		return;
	}
}
System.out.println("당신이 입력한 번호가 없습니다");
}



/**
 * 修改货物
 * @param array
 */
public static void updateFruit(ArrayList<Supermarket> array) {
System.out.println("선택한 것은 수정 기능입니다");
System.out.println("상품의 번호를 입력해 주세요");

Scanner sc = new Scanner(System.in);
int ID = sc.nextInt();

for(int i = 0 ; i < array.size(); i++) {
	Supermarket item = array.get(i);
	
	if(item.ID == ID) {
//		System.out.println("输入新的商品编号");
//		item.ID = sc.nextInt();
//		
//		System.out.println("输入新的商品名字");
//		item.name = sc.next();
		System.out.println("기능 1:제품 속성 수정 2:당일의 영업 상황");
		Scanner xx = new Scanner(System.in);
		int input = xx.nextInt();
		if(input == 1 ) {
		System.out.println("새 상품 가격 입력:");
		item.price = sc.nextDouble();
		
		System.out.println("상품의 수량을 입력해 주세요:");
		item.number = sc.nextInt();
		}
		if(input == 2) {
			System.out.println("기능 1:상품을 증가 2:상품을 감소");
			Scanner ww = new Scanner(System.in);
			int xuanze = ww.nextInt();
			if(xuanze == 1) {
				System.out.println("얼마나 증가되었는가");
				item.number = sc.nextInt() + item.number;
			}
			if(xuanze == 2) {
				System.out.println("얼마나 감소되었는가");
				item.number = item.number- sc.nextInt();
			}
			
		}

		System.out.println("상품 수정에 성공하다");
		item.money = item.number * item.price; //
		return ;
	}
}
System.out.println("입력한 번호가 존재하지 않음");
	}
}
