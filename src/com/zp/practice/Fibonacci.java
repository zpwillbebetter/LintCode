package com.zp.practice;

/**
 * @function 斐波那契数列算法查找斐波纳契数列中第 N个数
 *	所谓的斐波纳契数列是指：
 *	前2个数是 0 和 1 
 *	第 i 个数是第 i-1 个数和第i-2 个数的和。
 *	斐波纳契数列的前10个数字是：
 *	0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * @author zhongpeng
 * @date 2017年10月20日
 * @mail zpwillbebetter@qq.com
 */
public class Fibonacci {
	
	/**
	 * @function 判断传入参数是否正确
	 * @author zhongpeng
	 * @date 2017年10月20日
	 * @param index
	 * @return
	 */
	public Boolean illegalState(int index) {
		if (index <= 0) {
			return true;
		}
		
		if (index > Integer.MAX_VALUE) {
			return true;
		}
		return false;
	}

	/**
	 * @function 用回掉函数的方式查找斐波纳契数列中第 N个数
	 * @author zhongpeng
	 * @date 2017年10月20日
	 * @param index
	 * @return
	 */
	public int callback(int index) {
		Boolean illegalState = illegalState(index);
		
		if (!illegalState) {
			if(index == 1) {
				return 0;
			}else if(index == 2) {
				return 1;
			}else {
				int result = callback(index-1) + callback(index-2);
				return result;
			}
		}else {
			return -1;
		}
	}
	
	public int array(int index){
		Boolean illegalState = illegalState(index);
		
		if  (!illegalState) {
			int[] array = new int[index+1];
			array[1] = 0;
			array[2] = 1;
			
			if (index == 1) {
				return array[1];
			}else if (index == 2) {
				return array[2];
			}else {
				for (int i = 3; i<=index; i++) {
					array[i] = array[i-1] + array[i-2];
				}
				return array[index];
			}
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		Fibonacci obj = new Fibonacci();
		
		long startTime = System.nanoTime();
		int callback = obj.callback(10);
		long endTime = System.nanoTime();
		System.out.println("callbackFunction:"+callback);
		System.out.println("runtime:"+(endTime-startTime)+"ns");
		
		System.out.println("------------------------------------------");
		
		long startTime2 = System.nanoTime();
		int array = obj.array(10);
		long endTime2 = System.nanoTime();
		System.out.println("arrayFunction:"+array);
		System.out.println("runtime:"+(endTime2-startTime2)+"ns");
		
		
	}
	
}
