#include<iostream>
#define MAX 100
using namespace std;
int ans;
void BubbleSort(int *a, int n){
	if(n==1)return;
	for(int i=0;i<n;i++){
		for(int j=0;j<n-i-1;j++){
			if(a[j]>a[j+1]){
				swap(a[j], a[j+1]);
				++ans;
			}
		}
	}
}
int main(){
	while(true){
		int n;
		int a[MAX];
		scanf("%d", &n);
		if( n==0 ) break;
		for(int i=0;i<n;++i){
			int t;
			scanf("%d", &t);
			a[i]=t;
		}
		ans=0;
		BubbleSort(a,n);
		printf("%d\n", ans);
	}
	return 0;
}