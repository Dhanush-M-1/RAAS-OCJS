#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;
int main(){
	int a[100];
	int n;

	while(scanf("%d",&n) && n != 0){
		for(int i=0;i<n;i++){
			scanf("%d",&a[i]);
		}
		int swap = 0;
		for(int i=n-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swap++;
				}
			}
		}
		cout<<swap<<endl;
	}
	return 0;
}