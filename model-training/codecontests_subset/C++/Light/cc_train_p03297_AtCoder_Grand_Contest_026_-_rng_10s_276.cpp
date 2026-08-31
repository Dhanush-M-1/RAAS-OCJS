#include <stdio.h>
typedef long long ll;
ll gcd(ll x,ll y){return y?gcd(y,x%y):x;}
int main(){
	int t;
	ll a,b,c,d,k;
	scanf("%d",&t);
	for(;t--;){
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		if(b>a||b>d){puts("No");continue;}
		if(a<c){
			if(b==d){puts("Yes");continue;}
			k=(c-a-1)/(d-b)+1;
			a+=k*(d-b);
		}
		k=(a-c+b-1)/b;
		if(a<k*b){puts("No");continue;}
		a-=k*b;
		d=gcd(d,b);
		k=(c-a)/d+1;
		puts(a+d*k<b?"No":"Yes");
	}
	return 0;
}
