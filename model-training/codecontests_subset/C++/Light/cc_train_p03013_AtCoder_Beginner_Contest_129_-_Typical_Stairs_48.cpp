#include<bits/stdc++.h>
const int MOD = 1000000007;

int n, m, pr=-1, t, i, a[100000], fib[1000100];

int main(){
	fib[0] = 0;
	fib[1] = 1;
	for(i=2;i<100010;i++) fib[i] = (fib[i-1]+fib[i-2])%MOD;

	int_fast64_t ans = 1;
	scanf("%d %d", &n, &m);
	for(i=0; i<m; i++){
		scanf("%d", &t);
		ans = ans * fib[t-pr-1] % MOD;
		pr = t;
	}
	printf("%ld\n", ans * fib[n-pr] % MOD);
	return 0;
}
