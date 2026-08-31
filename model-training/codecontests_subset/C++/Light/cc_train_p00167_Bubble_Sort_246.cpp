#include<stdio.h>
#include<algorithm>
#include<string.h>
#define rep(i,j) for(int i=0;i<(j);i++)
#define reps(i,j,k) for(int i=j;i<=k;i++)

using namespace std;

int main(){
	int n,v[100],cnt;
	for(;;){
		scanf("%d",&n);
		if(n==0)break;
		rep(i,n)scanf("%d",v+i);
		cnt=0;
		for(int i=n-1;i>0;i--)reps(j,1,i)if(v[j]<v[j-1]){
			swap(v[j],v[j-1]);
			cnt++;
		}
		printf("%d\n",cnt);
	}
	return 0;
}