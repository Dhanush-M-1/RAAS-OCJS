#include<bits/stdc++.h>
#define ll long long
using namespace std;
ll gcd(ll x,ll y){
	if(!y)return x;
	return gcd(y,x%y);
}
int main(){
	ll t1,A,B,C,D,hh,x,y;
	scanf("%lld",&t1);
	while(t1--){
		scanf("%lld%lld%lld%lld",&A,&B,&C,&D);C++;
		if(B>D){
			puts("No");continue;
		}
		   if(A<C){
		   	if(A<B){
		   		puts("No");continue;
			   }
			 A=C+D-B-(A-C)%(D-B);
		   }
			x=(A-C)%B;y=D-B;
			hh=gcd(y,B);x=x%hh;
			if(x+C>=B)puts("Yes");
			 else puts("No");
	}
}
/*
B>D 不行 
*/