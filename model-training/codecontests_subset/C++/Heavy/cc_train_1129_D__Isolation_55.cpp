#include <bits/stdc++.h>
const int Bs = 317, N = 2e5 + 10, mod = 998244353;
template <typename T>
void chkmax(T &x, T y) {
  x = x > y ? x : y;
}
template <typename T>
void chkmin(T &x, T y) {
  x = x > y ? y : x;
}
template <typename T>
void add(T &x, T y, T mod) {
  x = x + y > mod ? x + y - mod : x + y;
}
template <typename T>
void sub(T &x, T y, T mod) {
  x = x - y < 0 ? x - y + mod : x - y;
}
template <typename T>
void multi(T &x, T y, T mod) {
  x = 1ll * x * y % mod;
}
const int INF = (1ll << 30);
template <typename T>
void read(T &x) {
  x = 0;
  bool f = 1;
  char ch;
  do {
    ch = getchar();
    if (ch == '-') f = 0;
  } while (ch > '9' || ch < '0');
  do {
    x = x * 10 + ch - '0';
    ch = getchar();
  } while (ch >= '0' && ch <= '9');
  x = f ? x : -x;
}
template <typename T>
void write(T x) {
  if (x < 0) x = ~x + 1, putchar('-');
  if (x > 9) write(x / 10);
  putchar(x % 10 + '0');
}
int pr[N], las[N], a[N], val[Bs][N], sum[N], f[N], tag[Bs], B, ans, k, n;
int belong(int x) { return (x - 1) / B + 1; }
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
  read(n);
  read(k);
  for (int i = 1, a; i <= n; ++i) read(a), pr[i] = las[a], las[a] = i;
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
