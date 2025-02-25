package com.design_shinbi.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int totalPrice = 0;      // 価格 (税抜き)
		double totalPriceWithTax = 0.0;    // 税込み価格
		
		List<String> itemNames = new ArrayList<String>();
		itemNames.add("豆腐");		
		itemNames.add("玉子");
		itemNames.add("鉛筆");
		itemNames.add("USBメモリ");
		itemNames.add("あんぱん");
		itemNames.add("ノート");
		itemNames.add("蛍光灯");
		itemNames.add("トランプ");
		itemNames.add("スリッパ");
		itemNames.add("りんご");

		boolean loop = true;
		List<String> cart = new ArrayList<String>();
		while(loop) {
			System.out.println("商品を選んでください。(買い物終了時は Enter のみを押す)");
			for(int index = 0; index < itemNames.size(); index++) {
				System.out.print(
					String.format("[%d] %s   ", index, itemNames.get(index))
				);
			}
			System.out.println("");
			
			String input = scanner.nextLine();
			if(input.isEmpty()) {
				loop = false;
			}
			else {
				int index = -1;
				try {
					index = Integer.parseInt(input);
					if(index >= 0 && index < itemNames.size()) {
						String name = itemNames.get(index);
						cart.add(name);
						
						if(name.equals("豆腐")) {
							totalPrice += 150;
							totalPriceWithTax += 150.0 * 1.08;
						}
						else if(name.equals("玉子")) {
							totalPrice += 250;
							totalPriceWithTax += 250.0 * 1.08;
						}
						else if(name.equals("鉛筆")) {
							totalPrice += 80;
							totalPriceWithTax += 80.0 * 1.1;
						}
						else if(name.equals("USBメモリ")) {
							totalPrice += 2000;
							totalPriceWithTax += 2000.0 * 1.1;
						}
						else if(name.equals("あんぱん")) {
							totalPrice += 150;
							totalPriceWithTax += 150.0 * 1.08;
						}
						else if(name.equals("ノート")) {
							totalPrice += 200;
							totalPriceWithTax += 200.0 * 1.1;
						}
						else if(name.equals("蛍光灯")) {
							totalPrice += 1000;
							totalPriceWithTax += 1000.0 * 1.1;
						}
						else if(name.equals("トランプ")) {
							totalPrice += 700;
							totalPriceWithTax += 700.0 * 1.1;
						}
						else if(name.equals("スリッパ")) {
							totalPrice += 900;
							totalPriceWithTax += 900.0 * 1.1;
						}
						else if(name.equals("りんご")) {
							totalPrice += 190;
							totalPriceWithTax += 190 * 1.08;
						}
					}
					else {
						System.out.println("有効な数字ではありません。");
					}
				}
				catch(Exception e) {
					System.out.println("数字を入力してください。");
				}
			}

			String items = String.join(",", cart);
			System.out.println("購入商品: " + items);
		}

		int finalTotalPriceWithTax = (int)Math.floor(totalPriceWithTax);    // 小数点以下切り捨て

		System.out.println("税抜価格: " + totalPrice);
		System.out.println("税込価格: " + finalTotalPriceWithTax);

		scanner.close();
	}
}
