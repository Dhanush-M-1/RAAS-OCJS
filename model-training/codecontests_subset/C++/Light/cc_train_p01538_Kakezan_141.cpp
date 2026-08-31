#include<iostream>
#include<cstdio>
#include<algorithm>
#include<map>
using namespace std;
int N;
int R[100];
int solve(int m){
	int res=0;
	int mul=1;
	for(int i=0;i<6;i++){
		res=max(res,(m/mul)*(m%mul));
		mul*=10;
	}
	return res;
}
int main()
{
	scanf("%d",&N);
	for(int i=0;i<N;i++){
		map<int,int>M;
		scanf("%d",&R[i]);
		if(R[i]<10){
			printf("0\n");
			goto aaa;
		}
		M[R[i]]++;
		while(true){
			R[i]=solve(R[i]);
			if(R[i]<10){
				break;
			}
			M[R[i]]++;
			if(M[R[i]]==2){
				printf("-1\n");
				goto aaa;	
			}
		}
		printf("%d\n",M.size());
		aaa:;
	}
}