#include<stdio.h>
typedef long long ll;
ll gcd(ll a,ll b){return a%b==0?b:gcd(b,a%b);}
ll adj(ll a,ll b,ll m){
	if((a%m+m)%m>b)b+=m;
	return a+b-(a%m+m)%m;
}
bool work(){
	ll a,b,c,d,g;
	scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
	if(b>a||b>d)return 0;
	g=gcd(b,d);
	return adj(c-b+1,a%g,g)>=0;
}
int main(){
	int T;
	scanf("%d",&T);
	while(T--)puts(work()?"Yes":"No");
}