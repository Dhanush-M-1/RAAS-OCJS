#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T min(T &a, T &b) {
  return a < b ? a : b;
}
template <class T>
inline T max(T &a, T &b) {
  return a > b ? a : b;
}
template <class T>
void read(T &x) {
  char ch;
  while ((ch = getchar()) && !isdigit(ch))
    ;
  x = ch - '0';
  while ((ch = getchar()) && isdigit(ch)) x = x * 10 + ch - '0';
}
struct point {
  int x, y;
  point() {}
  point(int _x, int _y) : x(_x), y(_y) {}
};
long long Pow(long long a, long long b, long long mod) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long Pow(long long a, long long b) {
  long long res = 1;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a;
    a = a * a;
  }
  return res;
}
const long long Mod = 1000000007;
const int N = 120000;
vector<int> E[N];
vector<long long> F[N];
int f[N][22], n, Dep[N];
long long dep[N], sum[N], sum2[N], size[N], upsize[N], upsum[N], upsum2[N];
void dfs(int w, int Fa, int c) {
  f[w][0] = Fa;
  dep[w] = sum[w] = (dep[Fa] + (long long)c) % Mod;
  Dep[w] = Dep[Fa] + 1;
  sum2[w] = dep[w] * dep[w] % Mod;
  size[w] = 1;
  for (int i = 0; i < E[w].size(); i++)
    if (E[w][i] != Fa) {
      dfs(E[w][i], w, F[w][i]);
      size[w] = size[w] + size[E[w][i]];
      sum[w] = (sum[w] + sum[E[w][i]]) % Mod;
      sum2[w] = (sum2[w] + sum2[E[w][i]]) % Mod;
    }
}
void dp() {
  for (int j = 1; j <= 20; j++)
    for (int i = 1; i <= n; i++) f[i][j] = f[f[i][j - 1]][j - 1];
}
int lca(int x, int y) {
  if (Dep[x] < Dep[y]) swap(x, y);
  for (int i = 20; i >= 0; i--)
    if (Dep[f[x][i]] >= Dep[y]) x = f[x][i];
  if (x == y) return x;
  for (int i = 20; i >= 0; i--)
    if (f[x][i] != f[y][i]) x = f[x][i], y = f[y][i];
  return f[x][0];
}
void dfs2(int w, int Fa, int c) {
  for (int i = 0; i < E[w].size(); i++)
    if (E[w][i] != Fa) {
      upsize[E[w][i]] = (upsize[w] + size[w] - size[E[w][i]]) % Mod;
      upsum[E[w][i]] =
          ((upsum[w] + upsize[w] * F[w][i]) % Mod + sum[w] - sum[E[w][i]] +
           (dep[E[w][i]] - 2LL * dep[w]) * (size[w] - size[E[w][i]])) %
          Mod;
      upsum2[E[w][i]] = (upsum2[w] + (2LL * upsum[w] * F[w][i]) % Mod +
                         (F[w][i] * F[w][i]) % Mod * upsize[w] % Mod) %
                        Mod;
      long long c;
      c = (sum2[w] - sum2[E[w][i]] +
           (2LL * (sum[w] - sum[E[w][i]]) * (dep[E[w][i]] - 2LL * dep[w])) %
               Mod +
           (dep[E[w][i]] - 2LL * dep[w]) * (dep[E[w][i]] - 2LL * dep[w]) % Mod *
               (size[w] - size[E[w][i]])) %
          Mod;
      upsum2[E[w][i]] = (upsum2[E[w][i]] + c) % Mod;
      dfs2(E[w][i], w, F[w][i]);
    }
}
long long solve(int x, int y) {
  int z = lca(x, y);
  long long ans = 0;
  if (x == y || z != y) {
    ans = (sum2[y] + (2LL * sum[y] * (dep[x] - 2LL * dep[z])) % Mod +
           (dep[x] - 2LL * dep[z]) * (dep[x] - 2LL * dep[z]) % Mod * size[y] %
               Mod) %
          Mod;
  } else {
    ans = (sum2[x] + (2LL * sum[x] * (dep[x] - 2LL * dep[x])) % Mod +
           (dep[x] - 2LL * dep[x]) * (dep[x] - 2LL * dep[x]) % Mod * size[x] %
               Mod) %
          Mod;
    ans = (ans + upsum2[x]) % Mod;
    ans =
        (ans - (upsum2[y] + 2LL * upsum[y] * (dep[x] - dep[y]) +
                (dep[x] - dep[y]) * (dep[x] - dep[y]) % Mod * upsize[y] % Mod) %
                   Mod) %
        Mod;
  }
  ans %= Mod;
  return (ans + Mod) % Mod;
}
int main() {
  scanf("%d", &n);
  int x, y, m;
  long long z;
  for (int i = 1; i <= n - 1; i++)
    scanf("%d%d%lld", &x, &y, &z), E[x].push_back(y), E[y].push_back(x),
        F[x].push_back(z), F[y].push_back(z);
  dfs(1, 0, 0);
  dp();
  dfs2(1, 0, 0);
  scanf("%d", &m);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &x, &y);
    long long ans = (solve(x, y) * 2LL - solve(x, 1)) % Mod;
    printf("%lld\n", (ans + Mod) % Mod);
  }
}
