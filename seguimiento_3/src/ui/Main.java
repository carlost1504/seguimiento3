package ui;
import java.util.*;
public class Main {
	
	public Scanner Sc=new Scanner(System.in);
	public static Scanner Scc=new Scanner(System.in);
	public static void main(String[] args) {
		Main p=new Main();
		Integer[] array= p.create_arrays();
		Integer[] array1=p.sortBy(array);
		Integer num=Integer.valueOf(Scc.nextInt());
		System.out.println(num);
		List<Integer>[] muestra= p.binarySearch(array1, num);
		System.out.println("aqui voy");
		for (int i = 0; i < array.length; i++) { 
			for (int j = 0; j < muestra[i].size(); j++) { 
				System.out.print(muestra[i].get(j) + " "); 
			} 
		System.out.println(); 
		}
		p.lookbestbook(muestra);
		
	}
	
	public Integer[] create_arrays() {
		int num=Sc.nextInt();
		Integer[] price;
		price=null;
		if(num<10000 && num>2) {
			price=new Integer[num];
			for(int i=0;i<price.length;i++) {
				price[i]=Integer.valueOf(Sc.nextInt());		
			}
		}
		return price;
	}
	
	public Integer[] sortBy(Integer[] price) {
		//System.out.println(price.toString());
		System.out.println(Arrays.toString(price));
		List<Integer> a = new ArrayList<Integer>();
		a=Arrays.asList(price);
		System.out.println(a.toString());
		Collections.sort(a);
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		//price=null;
		//System.out.println(price.toString());
		for(int i=0;i<a.size();i++) {
			price[i]=a.get(i);
		}
		System.out.println(Arrays.toString(price));
		return price;
	}
	
	public List<Integer>[] binarySearch(Integer[] price,Integer num) {
		List<Integer>[] al = new ArrayList[price.length];
		for (int i = 0; i < al.length; i++) { 
            al[i] = new ArrayList<Integer>(); 
        } 
		for(int x=0;x<price.length;x++) {
			int pos=-1;
			int i=0;
			int j=price.length-1;
			int t=0;
			
			while (i<=j && pos<0) {
				int m=(i+j)/2;
				if(price[x]+price[m]==num) {
					pos=m;
					System.out.println(price[x]+"  "+price[m]);
					al[x].add(price[x]); 
					al[x].add(price[m]);
					t+=2;
				}else if (price[x]+price[m]>num) {
					j=m-1;
				}else {
					i=m+1;
				}
			}
		}
		return al;
	}
	/**
	  mayor = menor = array [0];
       
        for (int i = 0; i < array.length; i++) {
            if(array [i] > mayor) {
                mayor = array[i];
            }
            if(array[i]<menor) {
                menor = array[i];
            }
        }
	 */
	
	public void lookbestbook(List<Integer>[] al) {
		Integer[]mm=new Integer[al.length];
		for(int i=0;i<mm.length;i++) {
			mm[i]=al[i].get(0)-al[i].get(1);
		}
		Integer mayor,menor;
		mayor = menor = mm [0];
	       
        for (int i = 0; i < mm.length; i++) {
            if(mm [i] > mayor) {
                mayor = mm[i];
            }
            if(mm[i]<menor) {
                menor = mm[i];
            }
        }
		for(int i=0;i<mm.length;i++) {
			if(menor==mm[i]) {
				System.out.println(al[i].get(0));
				System.out.println(al[i].get(1));
			}
		}
		
		/**Integer[]lowerprice =new Integer[2];
		Integer mayor,menor;
		mayor=menor=al[0].get(0)-al[0].get(1);
		 for (int i = 0; i < al.length; i++) { 
			 if(al[i].get(0)-al[i].get(1) > mayor) {
	                mayor = al[i].get(0)-al[i].get(1);
	            }
	            if(al[i].get(0)-al[i].get(1)<menor) {
	                menor = al[i].get(0)-al[i].get(1);
	                lowerprice[0]=al[i].get(0);
	                lowerprice[1]=al[i].get(1);
	            }
		 }*/
		 //System.out.println(lowerprice.toString());
		 
	}

}
