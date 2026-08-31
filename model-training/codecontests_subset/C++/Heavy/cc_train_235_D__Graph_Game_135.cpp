#include <bits/stdc++.h>
using namespace std;
inline int Get() {
  int res = 0, q = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') q = -1, ch = getchar();
  while (ch >= '0' && ch <= '9') res = res * 10 + ch - '0', ch = getchar();
  return res * q;
}
const double eps = 1e-12, pi = M_PI;
const int oo = (int)2e9, mod = (int)1e9 + 7;
const long long INF = (long long)1e17;
const int N = (int)3e3;
typedef int arr[N + 10];
typedef int arre[2 * N + 10];
int n, m, tot = 1, j, k, sc;
arr g, ft;
arre pt, nt, e;
bool v[N + 10], ic[N + 10];
double ans;
void Link(int x, int y) {
  pt[++tot] = y, nt[tot] = g[x], g[x] = tot;
  pt[++tot] = x, nt[tot] = g[y], g[y] = tot;
}
void Find(int x, int fa) {
  v[x] = 1;
  for (int i = g[x]; i; i = nt[i])
    if (pt[i] != fa) {
      if (v[pt[i]])
        j = x, k = pt[i], e[i] = e[i ^ 1] = 1;
      else
        Find(pt[i], x);
    }
}
void Dfs(int x, int fa) {
  ft[x] = fa;
  for (int i = g[x]; i; i = nt[i])
    if (pt[i] != fa && !e[i]) Dfs(pt[i], x);
}
void Dp(int x, int fa, int dp, int ds) {
  if (ds <= 1)
    ans += 1. / dp;
  else
    ans += 1. / dp + 1. / (dp - ds + sc - ds + 2) - 1. / (dp - ds + sc);
  for (int i = g[x]; i; i = nt[i])
    if (pt[i] != fa && !e[i]) Dp(pt[i], x, dp + 1, ds + ic[pt[i]]);
}
int main() {
  scanf(
      "%d"
      "\n",
      &n);
  for (int i = (1), end = (n); i <= end; ++i)
    scanf(
        "%d"
        "%d"
        "\n",
        &j, &k),
        ++j, ++k, Link(j, k);
  Find(1, 0);
  Dfs(j, 0);
  for (int now = k; now != j; now = ft[now]) ++sc, ic[now] = 1;
  ++sc, ic[j] = 1;
  for (int i = (1), end = (n); i <= end; ++i) Dp(i, 0, 1, ic[i]);
  printf(
      "%.10lf"
      "\n",
      ans);
  return 0;
}
