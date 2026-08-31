#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T qmin(const T &a, const T &b) {
  return a < b ? a : b;
}
template <typename T>
inline T qmax(const T &a, const T &b) {
  return a > b ? a : b;
}
template <typename T>
inline void getmin(T &a, const T &b) {
  if (a > b) a = b;
}
template <typename T>
inline void getmax(T &a, const T &b) {
  if (a < b) a = b;
}
inline void fileio(string s) {
  freopen((s + ".in").c_str(), "r", stdin);
  freopen((s + ".out").c_str(), "w", stdout);
}
const int inf = (int)1e9 + 7;
const long long linf = (long long)1e17 + 7;
const int N = 101;
int f[N][N * N];
int a[N], b[N], id[N], n, suma, sumb, tot;
inline bool cmp(const int &x, const int &y) { return b[x] > b[y]; }
int main() {
  scanf("%d", &n);
  for (register int i = (1); i <= (n); ++i) scanf("%d", a + i), suma += a[i];
  for (register int i = (1); i <= (n); ++i)
    scanf("%d", b + i), sumb += b[i], id[i] = i;
  sort(id + 1, id + n + 1, cmp);
  for (int rest = suma; rest > 0; rest -= b[id[++tot]])
    ;
  for (register int i = (0); i <= (tot); ++i)
    for (register int j = (0); j <= (sumb); ++j) f[i][j] = -inf;
  f[0][0] = 0;
  for (register int i = (1); i <= (n); ++i) {
    for (register int j = (tot); j >= (1); --j) {
      for (register int k = (b[i]); k <= (sumb); ++k) {
        getmax(f[j][k], f[j - 1][k - b[i]] + a[i]);
      }
    }
  }
  int ans = 0;
  for (register int k = (suma); k <= (sumb); ++k) getmax(ans, f[tot][k]);
  printf("%d %d\n", tot, suma - ans);
  return 0;
}
