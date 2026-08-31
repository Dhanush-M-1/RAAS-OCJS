#include<bits/stdc++.h>
using ll = int_fast64_t;
using P = std::pair<ll,ll>;

int main(){
	int n, m;
	scanf("%d %d", &n, &m);
	std::vector<ll> a(n), b(n), c(m), d(m);
	for(int i=0; i<n; i++) scanf("%ld %ld", &a[i], &b[i]);
	for(int i=0; i<m; i++) scanf("%ld %ld", &c[i], &d[i]);

	for(int i=0; i<n; i++){
		int mind = 0;
		for(int j=0; j<m; j++){
			ll ne = abs(a[i]-c[j]) + abs(b[i]-d[j]);
			if(abs(a[i]-c[mind])+abs(b[i]-d[mind]) > ne) mind = j;
		}
		printf("%d\n", mind+1);
	}
}
