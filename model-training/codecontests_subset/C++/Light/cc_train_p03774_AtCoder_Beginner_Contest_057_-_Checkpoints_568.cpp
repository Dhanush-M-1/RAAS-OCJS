#include "bits/stdc++.h"
using namespace std;
int a[50],b[50];
int c[50],d[50];
int dist(int x1,int y1,int x2,int y2) {
	return abs(x1-x2)+abs(y1-y2);
}
int main() {
	int N,M;
	scanf("%d %d",&N,&M);
	for(int i=0;i<N;i++) {
		scanf("%d %d",&a[i],&b[i]);
	}
	for(int i=0;i<M;i++) {
		scanf("%d %d",&c[i],&d[i]);
	}
	for(int i=0;i<N;i++) {
		int idx=M-1;
		for(int j=M-1;j>=0;j--) {
			if(dist(a[i],b[i],c[idx],d[idx])>=dist(a[i],b[i],c[j],d[j])) idx=j;
		}
		printf("%d\n",idx+1);
	}
}