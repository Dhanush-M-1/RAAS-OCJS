#include<iostream>
#include<cstdio>
using namespace std;
int n,e,s[14],h[14],c[14],d[14];
char m;
int main(){
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf(" %c%d",&m,&e);
		if(m=='S') s[e]++;
		else if(m=='H') h[e]++;
		else if(m=='C') c[e]++;
		else if(m=='D') d[e]++;
	}
	for(int i=1;i<=13;i++){
		if(s[i]==0) printf("S %d\n",i);
	}
	for(int i=1;i<=13;i++){
		if(h[i]==0) printf("H %d\n",i);
	}
	for(int i=1;i<=13;i++){
		if(c[i]==0) printf("C %d\n",i);
	}
	for(int i=1;i<=13;i++){
		if(d[i]==0) printf("D %d\n",i);
	}
	return 0;
}
