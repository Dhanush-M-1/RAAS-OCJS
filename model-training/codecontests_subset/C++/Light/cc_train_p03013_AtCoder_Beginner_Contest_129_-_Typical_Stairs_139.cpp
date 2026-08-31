#include <bits/stdc++.h>
#define N 1000005
#define mod 1000000007

using namespace std;

int n,m;
int f[N];
bool vis[N];

int main(){
	cin >> n >> m;f[0] = 1;
	for(int i = 1; i <= m; ++i){
		int a;cin >> a;
		vis[a] = true;
	}
	for(int i = 0; i <= n; ++i){
		if(!vis[i + 1]) (f[i + 1] += f[i]) %= mod;
		if(!vis[i + 2]) (f[i + 2] += f[i]) %= mod;
	}
	cout << f[n];
	return 0;
}