#include<iostream>
using namespace std;

typedef long long ll;

ll gcd(ll x,ll y){
	if(y == 0)return x;
	return gcd(y,x%y);
}

int main(){
	int T;
	scanf("%d",&T);
	for(;T>0;T--){
		ll A,B,C,D;
		scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
		if(B > D || A < B){
			puts("No");
			continue;
		}
		ll g = gcd(B,D);
		if(A%g > C%g)C -= g;
		if(C < 0)C = -1;
		else C /= g;
		B /= g;
		if(C+1 >= B)puts("Yes");
		else puts("No");
	}
}

