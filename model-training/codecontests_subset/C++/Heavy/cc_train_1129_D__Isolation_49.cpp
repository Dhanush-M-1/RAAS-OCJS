#include <bits/stdc++.h>
using namespace std;
const int B = 320;
const int N = 100000;
const int P = 998244353;
inline int add(int x, int y) {
  x += y;
  return x >= P ? x - P : x;
}
inline int sub(int x, int y) {
  x -= y;
  return x < 0 ? x + P : x;
}
inline int mul(int x, int y) { return (int)(1LL * x * y % P); }
int n, k;
int le[N + 5], ri[N + 5], id[N + 5], bcnt;
void build() {
  for (int i = 1; i <= n; i++) {
    if ((i - 1) % B == 0) le[++bcnt] = i;
    ri[bcnt] = i, id[i] = bcnt;
  }
}
int c[N + 5], dp[N + 5];
int s[B + 5][B + 5], tg[B + 5], lb[B + 5];
void pushtag(int x) {
  if (!tg[x]) return;
  for (int i = le[x]; i <= ri[x]; i++) c[i] += tg[x];
  tg[x] = 0;
}
void rebuild(int x) {
  lb[x] = 10 * N + 5;
  for (int i = 0; i <= B; i++) s[x][i] = 0;
  for (int i = le[x]; i <= ri[x]; i++) lb[x] = min(lb[x], c[i]);
  for (int i = le[x]; i <= ri[x]; i++)
    s[x][c[i] - lb[x]] = add(s[x][c[i] - lb[x]], dp[i - 1]);
  for (int i = 1; i <= B; i++) s[x][i] = add(s[x][i], s[x][i - 1]);
}
void add(int l, int r, int d) {
  int p = id[l], q = id[r];
  if (p == q) {
    pushtag(p);
    for (int i = l; i <= r; i++) c[i] += d;
    rebuild(p);
  } else {
    pushtag(p);
    for (int i = l; i <= ri[p]; i++) c[i] += d;
    rebuild(p);
    for (int i = p + 1; i <= q - 1; i++) tg[i] += d;
    pushtag(q);
    for (int i = le[q]; i <= r; i++) c[i] += d;
    rebuild(q);
  }
}
int query() {
  int ret = 0;
  for (int i = 1; i <= bcnt; i++) {
    if (lb[i] + tg[i] <= k) {
      if (lb[i] + tg[i] + B <= k)
        ret = add(ret, s[i][B]);
      else
        ret = add(ret, s[i][k - lb[i] - tg[i]]);
    }
  }
  return ret;
}
int a[N + 5], b[N + 5], lst[N + 5];
int main() {
  scanf("%d%d", &n, &k), build();
  for (int i = 1; i <= n; i++)
    scanf("%d", &a[i]), lst[i] = b[a[i]], b[a[i]] = i;
  dp[0] = 1, rebuild(1);
  for (int i = 1; i <= n; i++) {
    add(lst[i] + 1, i, 1);
    if (lst[i]) add(lst[lst[i]] + 1, lst[i], -1);
    dp[i] = query(), rebuild(id[i + 1]);
  }
  printf("%d\n", dp[n]);
}
