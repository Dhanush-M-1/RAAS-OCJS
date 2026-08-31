#include <bits/stdc++.h>
using namespace std;

long long gcd(long long x, long long y){
	return y == 0 ? x : gcd(y, x % y);
}

int main(){
	int T;
	scanf("%d",&T);
	long long a, b, c, d, gcdbd;
	while (T--){
		scanf("%lld %lld %lld %lld",&a,&b,&c,&d);
		if (a < b || d < b) printf("No\n");
		else if (c >= b) printf("Yes\n");
		else{
			gcdbd = gcd(b, d);
			if (b - gcdbd + a % gcdbd > c) printf("No\n");
			else printf("Yes\n");
		}
	}
	return 0;
} 