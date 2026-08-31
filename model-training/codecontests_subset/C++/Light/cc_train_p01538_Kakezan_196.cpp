#include <bits/stdc++.h>
#define rep(i,n) for(int i=0;i<n;i++)
using namespace std;
const int INF=1<<29,MOD=1e9+7;

int main(){
	int q; cin>>q;
	rep(i,q){
		int n; cin>>n;
		int cnt=0;
		while(n>=10){
			int div=10,tmp=0;
			while(div<n){
				if((n/div)*(n%div)>tmp) tmp=(n/div)*(n%div);
				div*=10;
			}
			n=tmp; cnt++;
		}
		cout<<cnt<<endl;
	}
	return 0;
}

