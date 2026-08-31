#include <bits/stdc++.h>
const int Bs = 317, N = 2e5 + 10, P = 998244353;
int ri() {
  char c = getchar();
  int x = 0, f = 1;
  for (; c < '0' || c > '9'; c = getchar())
    if (c == '-') f = -1;
  for (; c >= '0' && c <= '9'; c = getchar()) x = (x << 1) + (x << 3) - '0' + c;
  return x * f;
}
int pr[N], las[N], a[N], val[Bs][N], s[N], f[N], tag[Bs], B, Ans, z, k, n;
int belong(int x) { return (x - 1) / B + 1; }
void dec(int &a, int b) {
  a -= b;
  if (a < 0) a += P;
}
void inc(int &a, int b) {
  a += b;
  if (a >= P) a -= P;
}
void Ins(int u, int v) {
  int bu = belong(u);
  s[u] -= tag[bu];
  inc(Ans, v);
  inc(val[bu][s[u] + z], v);
}
void Mdfs(int u, int v) {
  int bu = belong(u);
  if (s[u] + tag[bu] <= k) dec(Ans, f[u - 1]);
  dec(val[bu][s[u] + z], f[u - 1]);
  s[u] += v;
  if (s[u] + tag[bu] <= k) inc(Ans, f[u - 1]);
  inc(val[bu][s[u] + z], f[u - 1]);
}
void Mdf(int L, int R, int v) {
  if (L > R) return;
  int bl = belong(L), br = belong(R);
  if (bl + 1 >= br) {
    for (int i = L; i <= R; ++i) Mdfs(i, v);
  } else {
    for (int i = L; i <= bl * B; ++i) Mdfs(i, v);
    for (int i = (br - 1) * B + 1; i <= R; ++i) Mdfs(i, v);
    for (int i = bl + 1; i < br; ++i) {
      if (~v)
        dec(Ans, val[i][k - tag[i] + z]);
      else
        inc(Ans, val[i][k - tag[i] + 1 + z]);
      tag[i] += v;
    }
  }
}
int main() {
  n = ri();
  k = ri();
  for (int i = 1, a; i <= n; ++i) a = ri(), pr[i] = las[a], las[a] = i;
  B = sqrt(n);
  z = n;
  f[0] = 1;
  Ins(1, 1);
  for (int i = 1; i <= n; ++i) {
    Mdf(pr[i] + 1, i, 1);
    Mdf(pr[pr[i]] + 1, pr[i], -1);
    Ins(i + 1, f[i] = Ans);
  }
  printf("%d\n", f[n]);
  return 0;
}
