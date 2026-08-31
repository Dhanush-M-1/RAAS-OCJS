#include <bits/stdc++.h>
using namespace std;
const int N = 200010;
int k, n, m, x, Rt;
int h[N], nx[N << 1], t[N << 1], num;
int A[N], B[N], C[N], l1, l2, l3;
int a[N], cnt;
bool f[N][2], fl;
bool g[2][N], d[N];
set<int> S;
void Add(int x, int y) {
  t[++num] = y;
  nx[num] = h[x];
  h[x] = num;
}
void Dfs(int x) {
  for (int i = h[x]; i; i = nx[i]) Dfs(t[i]);
  l1 = l2 = l3 = 0;
  for (int i = h[x]; i; i = nx[i]) {
    if (f[t[i]][0] && f[t[i]][1])
      A[++l1] = t[i];
    else if (f[t[i]][0])
      B[++l2] = t[i];
    else if (f[t[i]][1])
      C[++l3] = t[i];
  }
  if (!l1) {
    bool t = d[x] ^ (l2 & 1);
    f[x][t] = 1;
    for (int i = 1; i <= l3; i++) g[t][C[i]] = 1;
  } else {
    f[x][0] = f[x][1] = 1;
    for (int t = 0; t < 2; t++) {
      if (!(t ^ (l2 & 1) ^ d[x])) g[t][A[1]] = 1;
      for (int i = 2; i <= l1; i++) g[t][A[i]] = 1;
      for (int i = 1; i <= l3; i++) g[t][C[i]] = 1;
    }
  }
  if (!f[x][0] && !f[x][1]) fl = 1;
}
void Get(int x, bool d) {
  for (int i = h[x]; i; i = nx[i])
    if (!g[d][t[i]]) Get(t[i], 0);
  a[++cnt] = x;
  for (int i = h[x]; i; i = nx[i])
    if (g[d][t[i]]) Get(t[i], 1);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x)
      Add(x, i), d[x] ^= 1, d[i] ^= 1;
    else
      Rt = i;
  }
  Dfs(Rt);
  if (fl || !f[Rt][0])
    puts("NO");
  else {
    puts("YES");
    Get(Rt, 0);
    for (int i = 1; i <= n; i++) printf("%d\n", a[i]);
  }
  return 0;
}
