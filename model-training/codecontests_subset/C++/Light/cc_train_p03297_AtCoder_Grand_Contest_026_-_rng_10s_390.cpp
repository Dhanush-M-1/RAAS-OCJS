#include<stdio.h>
typedef long long ll;
template<class T>T gcd(T x,T y){return y?gcd(y,x%y):x;}
int T;ll a,b,c,d,g;
int main(){
	for(scanf("%d",&T);T;--T){
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(a<b||d<b)puts("No");
		else if(b-c<=1)puts("Yes");
		else if(b-c-1>=(g=gcd(b,d)))puts("No");
		else if(((c-a)%g+g)%g>((b-2-a)%g+g)%g)puts("No");
		else puts("Yes");
	}
}