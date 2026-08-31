#include <cstdio>
#include <cstring>
#include <cmath>
#include <algorithm>
#define N 5010

using namespace std;

int T, n, t[N];
typedef long long ll;
ll f[N], ans, s[N];

int main(){
//	freopen("funny.in", "r", stdin);
	scanf("%d", &T);
	while (T--){
		scanf("%d", &n);
		for (int i=1; i<=n; i++) scanf("%d", &t[i]);
		for (int i=1; i<=n; i++) scanf("%lld", &s[i]);
		ans=0;
		for (int i=1; i<=n; i++){
			f[i]=0;
			for (int j=i-1; j; j--){
				if (t[i]!=t[j]){
					ll ls=f[j]+abs(s[i]-s[j]);
					f[j]=max(f[j], f[i]+abs(s[i]-s[j]));
					ans=max(ans, f[j]);
					f[i]=max(f[i], ls);
				}
			}
			ans=max(ans, f[i]);
		}
		printf("%lld\n", ans);
	}
	
	return 0;
}
