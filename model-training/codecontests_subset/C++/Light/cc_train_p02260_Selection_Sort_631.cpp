//By Vlgd
#include<bits/stdc++.h>
using namespace std;
int A[100];
int main(){
	int n,cnt=0;scanf("%d",&n);
	for (int i=0;i<n;i++) scanf("%d",&A[i]);
	for (int i=0;i<n;i++){
		int minj=i;
		for (int j=i;j<n;j++) if (A[minj]>A[j]) minj=j;
		if (minj!=i){
			swap(A[i],A[minj]);
			cnt++;	
		}
	}
	for (int i=0;i<n;i++){
		printf("%d",A[i]);
		if (i==n-1) printf("\n");
		else printf(" ");
	}
	printf("%d\n",cnt);
}
