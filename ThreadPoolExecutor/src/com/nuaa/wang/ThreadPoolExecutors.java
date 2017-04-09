package com.nuaa.wang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutors {
	public static void main(){
		ExecutorService es = Executors.newFixedThreadPool(1);
	}

}
