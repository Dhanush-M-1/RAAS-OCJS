#include<bits/stdc++.h>
using namespace std;
#define LL long long
const int N = 200010;
int n, m;
LL a[N], s[N];
//
int cnt;
LL val[N];
int id[N];
//
LL ans[N];
void solve()
{
    //printf("one Test\n");
    //input
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i)
        scanf("%lld", &a[i]), s[i] = s[i - 1] + a[i];
    //pre
    cnt = 0;
    for (int i = 1; i <= n; ++i)
        if (s[i] > val[cnt])
            id[++cnt] = i, val[cnt] = s[i];
    //debug1
    /*
    printf("cnt=%d\nval : ", cnt);
    for (int i = 1; i <= cnt; ++i)
        printf("%lld ", val[i]);
    printf("\n");
    */
    //solve
    for (int i = 1; i <= m; ++i) {
        ans[i] = -1;
        LL x;
        scanf("%lld", &x);
        if (cnt == 0) continue;
        if (x <= val[cnt]) {
            int k = lower_bound(val + 1, val + cnt + 1, x) - val;
            ans[i] += id[k];
            continue;
        }
        if (s[n] <= 0) continue;
        LL tmp = (x - val[cnt] + s[n] - 1) / s[n];
        ans[i] += n * tmp, x -= s[n] * tmp;
        //while (x > val[cnt]) ans[i] += n, x -= s[n];
        int k = lower_bound(val + 1, val + cnt + 1, x) - val;
        ans[i] += id[k];
    }
    //output
    //printf("ans:");
    for (int i = 1; i < m; ++i)
        printf("%lld ", ans[i]);
    printf("%lld\n", ans[m]);
}

int main()
{
    int T;
    scanf("%d", &T);
    while (T--) {
        solve();
    }
    return 0;
}