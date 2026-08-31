#include <cstdio>
#define ll long long
using namespace std;
ll gcd(ll a,ll b){
	if(b==0)return a;
	return gcd(b,a%b);
}
int main(){
	int T;
	scanf("%d",&T);
	while(T--){
		ll a,b,c,d;
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(a<b){puts("No");continue;}
		if(d<b){puts("No");continue;}
		if(a==c)a+=d;
		ll t=(a-c-1)/gcd(b,d);
		a=a-t*gcd(b,d);
		a-=b;
		if(a<0)puts("No");else puts("Yes");
	}
	return 0;
}