#include <bits/stdc++.h>
using namespace std;
#define int long long
void read (int &x) {
    char ch = getchar(); x = 0; while (!isdigit(ch)) ch = getchar();
    while (isdigit(ch)) x = x * 10 + ch - 48, ch = getchar();
} const int N = 5e4 + 5, M = 5;
int C (int x, int y) {
    if (x < 1) return (y == 0);
    if (x < y) return 0; int s = 1;
    for (int i = 0; i < y; ++i) s *= (x - i);
    for (int i = 2; i <= y; ++i) s /= i;
    return s;
}
int ways (int len, int c) {
    int s = 0;
    for (int i = 0; i <= c; ++i)
        s += C (len - 1, i); return s;
}
int n, c, Q, a[N], L[5], R[5], ll[5][N], rr[5][N], s[5][N * M * 2];
struct node {
    int l, r, w;
    void set (int L, int R, int p) {
        l = L, r = R, w = ways (n - r, p - (r - l));
    }
} q[5][N * M * 2];
int o[10]; int tp;
bool cmp (int x, int y) { return a[x] < a[y]; }
void prework () {
    for (int i = 1; i <= c; ++i)
        L[i] = n * c, R[i] = L[i], q[i][R[i]] = {n, n, 1};
    L[0] = R[0] = 1, q[0][1] = {n, n, 1};
    for (int i = n; i >= 1; --i) {
        ll[0][i] = rr[0][i] = 1;
        for (int j = 1; j <= c; ++j) {
            tp = 0;
            for (int k = 1; k <= j && i + k <= n; ++k) o[++tp] = i + k;
            sort (o + 1, o + tp + 1, cmp);
            for (int k = tp, l = i, r; k >= 1; --k)
                if (a[r = o[k]] < a[l]) --L[j], q[j][L[j]].set (l, r, j);
            for (int k = 1, l = i, r; k <= tp; ++k)
                if (a[r = o[k]] > a[l]) ++R[j], q[j][R[j]].set (l, r, j);
            ll[j][i] = L[j], rr[j][i] = R[j];
        }
    }
    for (int i = 1; i <= c; ++i)
        for (int j = L[i]; j <= R[i]; ++j)
            s[i][j] = s[i][j - 1] + q[i][j].w;
}
int sum (int c, int l, int r) {
    return s[c][r] - s[c][l - 1];
}
node get (int x, int c, int k) {
    int l = ll[c][x], r = rr[c][x], mid, res;
    while (l <= r) {
        mid = l + r >> 1;
        if (sum (c, ll[c][x], mid) >= k) res = mid, r = mid - 1;
        else l = mid + 1;
    }
    return {q[c][res].l, q[c][res].r, sum (c, ll[c][x], res - 1)};
}
signed main() {
    int T; read (T);
    while (T--) {
        read (n), read (c), read (Q);
        for (int i = 1; i <= n; ++i) read (a[i]);
        int x = 0, y = 0, now, cnt, res; prework ();
        while (Q--) {
            read (y), read (x); now = 1, cnt = c, res = a[y];
            if (ways (n, c) < x) { puts ("-1"); continue; }
            while (x && cnt && now <= n) {
                node tmp = get (now, cnt, x);
                if (tmp.l <= y && tmp.r >= y) {
                    res = a[tmp.l + tmp.r - y]; break;
                }
                now = tmp.r + 1, cnt -= (tmp.r - tmp.l), x -= tmp.w;
            }
            printf ("%lld\n", res);
        }
    }
    return 0;
}
