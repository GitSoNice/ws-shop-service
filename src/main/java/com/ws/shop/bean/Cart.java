package com.ws.shop.bean;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车bean
 * @Author lqh
 * @Date 2018年4月2日 21:03:36
 */
public class Cart {

	/**
	 * 购物项集合，key为pid，value为购物项
	 */
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();

	/**
	 * 购物总计
	 */
	private float total;
	
	//Cart对象中有一个cartItems属性
	public Collection<CartItem> getCartItems(){
		return map.values();
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * 将商品添加到购物车（若存在数量相加，购物总计增加；反之，添加到购物车）
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem) {

		Integer pid = cartItem.getProduct().getPid();

		//购物车中是否已经存在该商品
		if(map.containsKey(pid)){

			//获得原来在购物车中的购物项
			CartItem cartItem1 = map.get(pid);

			//将原来的数量和现在的数量相加
			cartItem1.setCount(cartItem1.getCount()+cartItem.getCount());
		}else {
			map.put(pid, cartItem);
		}
		// 总金额
		total += cartItem.getSubtotal();
	}

	/**
	 * 删除购物项
	 * @param pid
	 */
	public void removeCart(Integer pid) {

		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}

	/**
	 * 清空购物车
	 */
	public void clearCart() {
		map.clear();
		total = 0;
	}
}
