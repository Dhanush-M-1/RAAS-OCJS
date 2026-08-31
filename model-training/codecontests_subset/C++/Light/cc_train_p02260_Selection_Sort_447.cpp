#include<cstdio>
#include<iostream>
using namespace std;

int selectsort(int n,int a[]){
	int sw=0,minj;
	for(int i=0;i<n;i++){
		minj=i;
		for(int j=i;j<n;j++){
			if(a[minj]>a[j]){
				minj=j;
			}
		}
		swap(a[minj],a[i]);
		if(i != minj) sw++;
	}
	return sw;
}


int main(){
	int n,a[100];
	cin>>n;
	for(int i=0;i<n;i++) cin>>a[i];
	int sw=selectsort(n,a);
	for(int i=0;i<n;i++){
		if(i) printf(" ");
		printf("%d",a[i]);
	}
	printf("\n");
	printf("%d\n",sw);
	return 0;
}
