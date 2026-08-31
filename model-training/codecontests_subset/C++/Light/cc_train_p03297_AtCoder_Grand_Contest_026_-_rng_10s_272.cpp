#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
ll t,a,b,c,d;

ll gcd(ll a,ll b){
	return b?gcd(b,a%b):a;
}

int main(){
	cin>>t;
	while(t--){
		cin>>a>>b>>c>>d;
		{
			ll g=gcd(b,d);
			bool flag=a%g>c%g;
			a/=g;
			b/=g;
			c/=g;
			d/=g;
			if(flag)
				--c;
		}
		if(b>d||a<b||c+1<b)
			puts("No");
		else
			puts("Yes");
	}
	return 0;
}