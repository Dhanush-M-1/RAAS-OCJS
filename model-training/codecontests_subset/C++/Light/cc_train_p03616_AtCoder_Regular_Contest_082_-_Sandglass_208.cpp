#include<bits/stdc++.h>
using namespace std;

int r[100001],t[100001],a[100001],now,ans,tmp,dir=-1;

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int X,K;
	cin>>X>>K;
	for(int i=1;i<=K;i++)
		cin>>r[i];
	int q;
	cin>>q;
	for(int i=1;i<=q;i++)
		cin>>t[i]>>a[i];
	int M=X,m=0,t1=0,t2=1;
	while(t2<=q){
		if(t1!=K&&t[t2]>r[t1+1]){
			t1++;
			now=dir*(r[t1]-r[t1-1]);
			M=max(0,min(M+now,X));
			m=max(0,min(m+now,X));
			tmp+=now;dir*=-1;
		}
		else{
			ans=max(m,min(M,a[t2]+tmp));
			ans=max(0,min(X,ans+dir*(t[t2]-r[t1])));
			cout<<ans<<'\n';
			t2++;
		}
	}

}
