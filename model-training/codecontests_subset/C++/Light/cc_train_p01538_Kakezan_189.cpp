#include <iostream>
#include <math.h>
using namespace std;
int main(){
	int q;
	int inp;
	cin >>q;
	for(int i =0;i<q;i++){
		cin >>inp;
		int counter =0;
		int a[5]={0};
		while(inp>9){
			int max = 0;
			for(int i = 1;i<6;i++){
				int num=1;
				for(int j= 0; j<i ; j++){
					num *=10;
				}
				a[i-1] =(inp/num)*(inp%num);
				if(max<a[i-1]) max = a[i-1];
			}
			counter++;
			inp = max;
		}
		cout << counter <<endl;
	}

	return 0;
}