#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll gcd(ll a,ll b)
{
	if(abs(a-b)==1) return (ll)1;
	if(a==0) return b;
	return gcd(b%a,a);
}
int main()
{
	int T;cin>>T;
	ll a,b,c,d;
	while(T--)
	{
		cin>>a>>b>>c>>d;
		if(b>d || b>a) 
		{
			cout<<"No"<<endl;
			continue;
		}
		ll x=(a-c)/b;
		if(x*b!=a-c) x++;
		a-=x*b;
		if(a<0) 
		{
			cout<<"No"<<endl;
			continue;
		}
		if(gcd(b,d)+c>=b) 
			cout<<"Yes"<<endl;
		else
			cout<<"No"<<endl;
	}
}