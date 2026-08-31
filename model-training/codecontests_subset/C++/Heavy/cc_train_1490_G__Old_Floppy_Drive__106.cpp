#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
typedef pair<int, int> PII;
typedef pair<LL,LL> PLL;
const int INF = 0x3f3f3f3f, N = 2e5 + 10;
inline int lc(int u) {return u << 1;}
inline int rc(int u) {return u << 1 | 1;}
inline int lowbit(int x) {return x & (-x);}
LL a[N], s[N];
LL mm[N];
struct node {
    LL val;
    int idx;
    bool operator < (const node &B) const {
        if (val != B.val) return val < B.val;
        return idx < B.idx;
    }
} p[N];
inline void solve() {
    int n, m;
    scanf("%d%d", &n, &m);
    for (int i = 0; i <= n; i ++ ) mm[i] = -1e9 - 1;
    LL ma = -1e9 - 1, mi = 1e9 + 1;
    for (int i = 1; i <= n; i ++ ) {
        int x;
        scanf("%d", &x);
        s[i] = s[i - 1] + (LL)x;
        ma = max(ma, s[i]);
        mi = min(mi, s[i]);
        p[i] = {s[i], i};
        mm[i] = max(mm[i - 1], s[i]);
    }
    LL T = s[n];
    while (m -- ) {
        int x;
        scanf("%d", &x);
        if (ma < x && T <= 0) printf("-1 ");
        else {
            if (ma < x) {
                LL round = (x - ma + T - 1) / T;
                int l = 1, r = n;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (round * T + mm[mid] >= x) r = mid;
                    else l = mid + 1;
                }
                printf("%lld ", round * n + l - 1);
            } else {
                int l = 1, r = n;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (mm[mid] >= x) r = mid;
                    else l = mid + 1;
                }
                printf("%d ", l - 1);
            }
        }
    }
    puts("");
}
int main() {
//    ios::sync_with_stdio(false), cin.tie(nullptr);
    int t;
    scanf("%d", &t);
    while (t -- )
        solve();
    return 0;
}