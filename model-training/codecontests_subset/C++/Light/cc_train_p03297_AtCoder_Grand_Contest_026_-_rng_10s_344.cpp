#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll gcd(ll a,ll b){
	if(a%b==0)	return b;
	return gcd(b,a%b);
}

int main(){
	int t;	cin>>t;
	while(t--){
		ll a,b,c,d;	cin>>a>>b>>c>>d;
		if(a<b){
			cout<<"No\n";	continue;
		}
		if(d<b){
			cout<<"No\n";	continue;
		}
		ll t1=gcd(b,d);
		ll t2=(a-b)/t1;	t2++;
		if(t2*t1 < (a-c))	cout<<"No\n";
		else	cout<<"Yes\n";
	}
	return 0;
}