#include <cstdio>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <queue>
#include <vector>
#include <map>
#include <set>
#define MAXN 200005
#define INF 0x3f3f3f3f
#define rint register int
#define LL long long
#define LD long double
using namespace std;

int n, d, a[MAXN], b[MAXN];
LL ans;

int main()
{
    scanf("%d%d", &n, &d);
    for(rint i=1; i<=n; ++i)
    {
	scanf("%d", &a[i]);
	b[i]=a[i];
	ans+=a[i];
    }
    for(rint i=2; i<=n; ++i) b[i]=min(b[i], b[i-1]+d);
    for(rint i=n-1; i>=1; --i) b[i]=min(b[i], b[i+1]+d);
    ans+=1LL*(n-1)*d;
    for(rint i=2; i<n; ++i) ans+=b[i];
    printf("%lld\n", ans);
    return 0;
}
