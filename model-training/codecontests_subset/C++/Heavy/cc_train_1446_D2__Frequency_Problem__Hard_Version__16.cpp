#include <bits/stdc++.h>
using namespace std;
const int N = 1000005, M = 200005;
int n, a[N], cn[N], c[N], c0[N], ans, maxn, p[N];
template <class I>
void Max(I& p, int q) {
  p = (p > q ? p : q);
}
void ins(int x) { --c0[c[x]], ++c[x], ++c0[c[x]], Max(maxn, c[x]); }
void del(int x) { --c0[c[x]], --c[x], ++c0[c[x]], maxn -= (c0[maxn] == 0); }
int main() {
  scanf("%d", &n);
  int mx = 0;
  for (int i = 1; i <= n; i++)
    scanf("%d", &a[i]), ++cn[a[i]], cn[a[i]] > cn[mx] ? mx = a[i] : 0;
  if (cn[mx] == n) return putchar('0'), 0;
  int lim = (cn[mx] < 512 ? cn[mx] : 512);
  for (int i = 1; i <= n; i++)
    if (i != mx && cn[i] >= 512) {
      for (int j = -n; j <= n; j++) p[j + M] = -1;
      for (int sum = p[M] = 0, j = 1; j <= n; j++)
        sum += (a[j] == mx), sum -= (a[j] == i),
            ~p[sum + M] ? Max(ans, j - p[sum + M]), 0 : p[sum + M] = j;
    }
  for (int i = 1; i <= lim; i++) {
    for (int j = 1; j <= n; j++) c[j] = c0[j] = 0;
    c0[maxn = 0] = n;
    for (int j = 1, k = 1, x = 0; j <= n; j++) {
      while (k <= n && x + (a[k] == mx) <= i) ins(a[k]), x += (a[k] == mx), ++k;
      c0[maxn] >= 2 ? Max(ans, k - j), 0 : 0, del(a[j]), x -= (a[j] == mx);
    }
  }
  printf("%d", ans);
}
