#include<bits/stdc++.h>
#define N 200000
typedef long long LL;
using namespace std;
int r[N], X, k, Q;

int calc(LL x) {
    if (x > X) x = X;
    if (x < 0) x = 0;
    return x;
}

int main() {
    cin >> X >> k;
    for(int i = 1; i <= k; i++) scanf("%d", &r[i]);
    cin >> Q;
    int p = 1, L = 0, R = X, ty = -1;
    LL now = 0;
    while (Q--) {
        int t, a;scanf("%d%d", &t, &a);
        while (p <= k && r[p] <= t) {
            int tmp = (r[p] - r[p - 1]) * ty;
            L = calc((LL)L + tmp), R = calc((LL)R + tmp), now = now + tmp;
            p++, ty *= -1;
        }
        int det = t - r[p - 1], ret = now + a;
        if (ret > R) ret = R;
        if (ret < L) ret = L;
        ret = calc((LL)ret + det * ty);
        printf("%d\n", ret);
    }
}
