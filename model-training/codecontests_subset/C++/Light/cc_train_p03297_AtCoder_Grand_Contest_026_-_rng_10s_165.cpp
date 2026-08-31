#include<bits/stdc++.h>

using namespace std;

int t;
long long a, b, c, d;

long long gcd(long long a, long long b){
	if(a < b) swap(a, b);
	while(b){
		a %= b;
		swap(a, b);
	}
	return a;
}

int main(){
	scanf("%d", &t);
	for (int i = 0; i < t; ++i){
		bool ans = true;
		scanf("%lld%lld%lld%lld", &a, &b, &c, &d);
		if(b > d || b > a) ans = false;
		else if(b > c + 1){
			long long e = gcd(d, b);
			if(a % e - e + b > c) ans = false;
		}
		printf("%s\n", ans ? "Yes" : "No");
	}
}