#include<bits/stdc++.h>
using namespace std;

const int N=100100;
int a[N],X,n,q,sum;
int main(){
	ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
	cin>>X>>n;
	for(int i=1;i<=n;++i)cin>>a[i];
	int L=0,R=X,tag=-1,i=1; 
	for(cin>>q;q --> 0;){
		int x,y;cin>>x>>y;
		for(;i<=n&&a[i]<x;++i){
			int tmp=tag*(a[i]-a[i-1]);
			L+=tmp;L=max(0,min(X,L));
			R+=tmp;R=max(0,min(X,R));
			sum+=tmp;tag=-tag;
		}
		int tmp=max(L,min(R,y+sum))+tag*(x-a[i-1]);
		cout<<max(0,min(X,tmp))<<'\n';
	}
	return 0;
}
