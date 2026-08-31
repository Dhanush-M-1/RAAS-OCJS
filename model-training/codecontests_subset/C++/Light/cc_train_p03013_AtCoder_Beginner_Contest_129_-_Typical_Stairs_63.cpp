#include <iostream>
#include <cstdio>
using namespace std;
int n, m, a, d[100005]={1,1}, v[100005], M = 1e9+7;
int main() {
	int i;
	cin>>n>>m;
	while(m--) {
		scanf("%d", &a);
		v[a] = 1;
		d[a] = 0;
	}
	for(i=2; i<=n; i++) {
		if(!v[i]) d[i] = (d[i-1] + d[i-2]) % M;
	}
	cout<<d[n];
	return 0;
}