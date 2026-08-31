#include<cstdio>
#include<algorithm>
using namespace std;
long long gcd(long long a, long long b) {
    while(b){
    	a%=b;
    	swap(a,b);
	}
	return a;
}
long long t,a,b,c,d;
int main(){
	scanf("%lld",&t);
	for (int i=1;i<=t;i++) {
		scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
		int x=0;
		long long z=(a-c)%gcd(b,d);//Icannotunderstand
		if(z==0)z=gcd(b, d);
		if(b-c<=z)x=1;//Icanunderstand
		if(a<b||d<b)x=0;//Icanunderstand
		if(x==0)printf("No\n");
		else printf("Yes\n");
	}
}