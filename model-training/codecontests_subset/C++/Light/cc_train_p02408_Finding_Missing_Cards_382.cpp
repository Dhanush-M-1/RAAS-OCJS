#include<bits/stdc++.h>

#define ll long long

using namespace std;

int main(){
	ll i,n,y;
	char x;
	
	cin>>n;
	
	ll s[14]={0},h[14]={0},c[14]={0},d[14]={0};
	
	for(i=1;i<=n;i++){
		cin>>x>>y;
		if(x=='S') s[y]=1;
		  else if(x=='H') h[y]=1;
		    else if(x=='C') c[y]=1;
		      else d[y]=1;
	}
	
	for(i=1;i<=13;i++){
		if(s[i]==0) cout<<"S "<<i<<"\n";
	}
	for(i=1;i<=13;i++){
		if(h[i]==0) cout<<"H "<<i<<"\n";
	}
	for(i=1;i<=13;i++){
		if(c[i]==0) cout<<"C "<<i<<"\n";
	}
	for(i=1;i<=13;i++){
		if(d[i]==0) cout<<"D "<<i<<"\n";
	}
}
