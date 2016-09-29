package corejava;


import java.util.ArrayList;
import java.util.List;

public class 大批量分批处理 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> strList = new ArrayList<>();
		
		for(int i=0;i<5020;i++){
			strList.add("item"+i);
		}
		//计算总量
		int totalNum = strList.size();
		//每批个数
		int batchNum = 100;
		//总批数
		int forNum = (int)Math.ceil((double)totalNum/batchNum);
		for(int i=0;i<forNum;i++){
			System.out.println("-----批次"+i+"----开始");
			//计算每批的起始
			int startIndex = i*batchNum;
			int endIndex = (i+1)*batchNum;
			if(endIndex>=totalNum){
				endIndex = totalNum;
			}
			//截取集合
			List<String> tempList = strList.subList(startIndex, endIndex);
			//批量操作逻辑
			doJob(tempList);
			System.out.println("-----批次"+i+"----结束");
		}
	}

	
	private static void doJob(List<String> strList){
		for(int i=0;i<strList.size();i++){
			System.out.println(strList.get(i));
		}
	}
	
}
