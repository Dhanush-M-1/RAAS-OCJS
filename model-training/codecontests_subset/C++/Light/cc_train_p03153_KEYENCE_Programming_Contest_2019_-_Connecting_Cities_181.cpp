#include<bits/stdc++.h>

using namespace std;

#define FOR(i, x, y) for(int i = (x); i < (y); ++i)
#define REP(i, x, y) for(int i = (x); i <= (y); ++i)
#define MP make_pair
#define PB push_back
#define PH push
#define fst first
#define snd second
typedef long long ll;
typedef unsigned long long ull;
typedef double db;
typedef long double ldb;
typedef pair<int, int> pii;

const int INF = 1e9 + 7;
const int maxn = 2e5 + 5;

int n, d;
int a[maxn];
ll ans;

int main(){
	scanf("%d%d", &n, &d);
	FOR(i, 0, n){
		scanf("%d", a + i);
		ans += a[i];
	}
	FOR(i, 1, n)
		a[i] = min(a[i], a[i - 1] + d);
	for(int i = n - 2; i >= 0; --i)
		a[i] = min(a[i], a[i + 1] + d);
	FOR(i, 1, n - 1)
		ans += a[i];
	ans += 1ll * d * (n - 1);
	printf("%lld\n", ans);
	return 0;
}
