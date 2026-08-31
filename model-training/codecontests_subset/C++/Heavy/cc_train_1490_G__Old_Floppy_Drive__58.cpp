#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll a[200010];
ll x[200010];
ll sa[200010];
ll sama[200010];
int psama[200010];
inline ll read(){
	ll f=1,x=0;char ch;
	do{ch=getchar();if(ch=='-')f=-1;}while(!isdigit(ch));
	do{x=x*10+ch-'0';ch=getchar();}while(isdigit(ch));
	return f*x;
} 
int main(){
	ll t;
	cin>>t;
	while(t--){
		ll n,m;cin>>n>>m;
		
		for(ll i=1;i<=n;i++)a[i]=read();
		for(ll i=0;i<m;i++)x[i]=read();
		for(ll i=1;i<=n;i++)sa[i]=sa[i-1]+a[i];
		for(int i=1;i<=n;i++){
			if(sama[i-1]<sa[i]){
				sama[i]=sa[i];
				psama[i]=i;
			}else{
				sama[i]=sama[i-1];
				psama[i]=psama[i-1];
			}
		}
		ll rd=sa[n];
		
		for(ll i=0;i<m;i++){
			if(rd<=0){
				if(sama[n]<x[i])cout<<-1<<' ';
				else {
					int lop=lower_bound(sama+1,sama+1+n,x[i])-sama;
					cout<<psama[lop]-1<<' ';
				}
			}else {
				if(sama[n]<x[i]){
					ll tmp=x[i]-sama[n];
					ll tcp;
					if(tmp%rd==0)tcp=tmp/rd;
					else tcp=tmp/rd+1;
					int lop=lower_bound(sama+1,sama+1+n,x[i]-tcp*rd)-sama;
					cout<<n*tcp+psama[lop]-1<<' ';
				}else{
					int lop=lower_bound(sama+1,sama+1+n,x[i])-sama;
					cout<<psama[lop]-1<<' ';
				}
			}
		}
		cout<<endl;
	} 
}
//author: caramel_pudding

