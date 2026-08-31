#include <bits/stdc++.h>
const int Bs = 317, N = 2e5 + 10, mod = 998244353;
int ri() {
  char c = getchar();
  int x = 0, f = 1;
  for (; c < '0' || c > '9'; c = getchar())
    if (c == '-') f = -1;
  for (; c >= '0' && c <= '9'; c = getchar()) x = (x << 1) + (x << 3) - '0' + c;
  return x * f;
}
int pr[N], las[N], a[N], val[Bs][N], sum[N], f[N], tag[Bs], B, ans, k, n;
int belong(int x) { return (x - 1) / B + 1; }
void sub(int &a, int b, int P) {
  a -= b;
  if (a < 0) a += P;
}
void add(int &a, int b, int P) {
  a += b;
  if (a >= P) a -= P;
}
inline void insert(int u, int v) {
  int bu = belong(u);
  sum[u] -= tag[bu];
  add(ans, v, mod);
  add(val[bu][sum[u] + n], v, mod);
}
void change(int u, int v) {
  int bu = belong(u);
  if (sum[u] + tag[bu] <= k) sub(ans, f[u - 1], mod);
  sub(val[bu][sum[u] + n], f[u - 1], mod);
  sum[u] += v;
  if (sum[u] + tag[bu] <= k) add(ans, f[u - 1], mod);
  add(val[bu][sum[u] + n], f[u - 1], mod);
}
inline void modify(int l, int r, int v) {
  if (l > r) return;
  int bl = belong(l), br = belong(r);
  if (bl + 1 >= br) {
    for (int i = l; i <= r; i++) change(i, v);
  } else {
    for (int i = l; i <= B * bl; i++) change(i, v);
    for (int i = B * (br - 1) + 1; i <= r; i++) change(i, v);
    for (int i = bl + 1; i < br; i++) {
      if (~v)
        sub(ans, val[i][k - tag[i] + n], mod);
      else
        add(ans, val[i][k - tag[i] + 1 + n], mod);
      tag[i] += v;
    }
  }
}
int main() {
  n = ri();
  k = ri();
  for (int i = 1, a; i <= n; ++i) a = ri(), pr[i] = las[a], las[a] = i;
  B = sqrt(n);
  f[0] = 1;
  for (int i = 1; i <= n; ++i) {
    insert(i, f[i - 1]);
    modify(pr[i] + 1, i, 1);
    modify(pr[pr[i]] + 1, pr[i], -1);
    f[i] = ans;
  }
  printf("%d\n", f[n]);
  return 0;
}
