#include <cstdio>
#include <algorithm>
using namespace std;
#define rep(i,n) for(int i=0;i<n;i++)
int main(){
	int q;
	scanf("%d",&q);
	rep(tt,q){
		int n,cnt=0;
		scanf("%d",&n);
		while(true){
			int d[7]={},tmp=n,i,mx=-1;
			for(i=0;tmp>0;i++){
				d[i]=tmp%10;
				tmp/=10;
			}
			if(i<=1) break;
			for(int j=1;j<i;j++){
				int l=0,r=0;
				rep(k,j) l=10*l+d[j-1-k];
				rep(k,i-j) r=10*r+d[i-1-k];
				mx=max(mx,l*r);
			}
			n=mx;
			cnt++;
		}
		printf("%d\n",cnt);
	}
}