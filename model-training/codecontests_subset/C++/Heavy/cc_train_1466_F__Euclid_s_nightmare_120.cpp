#include <cstdio>
#include <iostream>

#define ll long long

using namespace std;

int n , m , cnt = 0;

const int N = 5e5 + 5;
const int mod = 1e9 + 7;

ll pow2[N];

int num[N] , fa[N];

int find(int x){
	if(fa[x] == x)
		return x;
	return fa[x] = find(fa[x]);
}

int main(){
	pow2[0] = 1;
	cin >> n >> m;
	for(int i = 1; i < N; i++)
		pow2[i] = 1ll * 2 * pow2[i - 1] % mod;
	for(int i = 1; i <= m + 1; i++)
		fa[i] = i;
	for(int i = 1; i <= n; i++){
		int k;
		int x , y;
		scanf("%d" , &k);
		if(k == 1){
			scanf("%d" , &x);
			y = m + 1;
		}
		else
			scanf("%d%d" , &x , &y);
		int fx , fy;
		fx = find(x);
		fy = find(y);
		if(fx == fy)
			continue;
		fa[fx] = fy;
		num[++cnt] = i;
	}
	ll ans = pow2[cnt] % mod;
	cout << ans << " " << cnt << endl;
	for(int i = 1; i <= cnt; i++)
		printf("%d " , num[i]);
	return 0;
}