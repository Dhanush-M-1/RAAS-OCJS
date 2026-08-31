#include<cstdio>
#include<algorithm>
#include<iostream>
typedef long long ll;
using namespace std;

ll T,a,b,c,d,g;
ll gcd(ll a,ll b){ return b ? gcd(b,a%b) : a; }

int main(){
	for (cin>>T; T--; ){
		cin>>a>>b>>c>>d; g=gcd(d,b);
		if (a<b || d<b || (a-(a-c-1)/g*g)-b<0) cout<<"No\n"; else cout<<"Yes\n";
	}
	return 0;
}