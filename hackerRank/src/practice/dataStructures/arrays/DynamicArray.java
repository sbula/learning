package practice.dataStructures.arrays;

import java.util.Scanner;

public class DynamicArray {
	int lastAns=0;
	private int N;
	int[][] seqList;
	int[] seqListCount;
	
	public DynamicArray(int N){
		this.N = N;
		seqList=new int[N][2];
		seqListCount=new int[N];
		for(int i=0;i<N;i++)
			seqListCount[i]=0;
	}
	
	public void resizeArray(int max,int index){
		int[] temp=new int[max];
		for(int i=0; i<seqListCount[index]; i++){
			temp[i]=seqList[index][i];
		}
		seqList[index]=temp;
	}
	
	public void queryOne(int x,int y){
		int index=(x^lastAns)%N;
		seqList[index][seqListCount[index]]=y;
		seqListCount[index]++;
		if(seqListCount[index]==(seqList[index].length/2))
			resizeArray(seqList[index].length*2,index);

	}
	
	public void queryTwo(int x,int y){
		int index=(x^lastAns)%N;
		int indexQuery=y%seqListCount[index];
		lastAns=seqList[index][indexQuery];
		System.out.println(lastAns);
		
	}
	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N=in.nextInt();
    	int Q=in.nextInt();
    	DynamicArray solution=new DynamicArray(N);
    	for(int i=1; i<=Q; i++){
    		int flag=in.nextInt();
    		int x=in.nextInt();
    		int y=in.nextInt();
    		if(flag==1){
    			solution.queryOne(x,y);
    		}else{
    			solution.queryTwo(x,y);
    		}
    	}
    	in.close();
    }
}
