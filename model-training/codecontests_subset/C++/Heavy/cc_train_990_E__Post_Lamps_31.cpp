#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 1e2;
const long long int inf = 0x3f3f3f3f3f3f3f3fll;
int n, m, k, fail;
long long int ans = inf;
struct UnionFindSet {
  int fa[maxn];
  inline int findfa(int x) { return fa[x] == x ? x : fa[x] = findfa(fa[x]); }
  inline void ban(int t) { fa[t] = t - 1; }
  inline void init() {
    for (int i = 1; i <= n; i++) fa[i] = i;
  }
} ufs;
inline long long int calc(int pw, int cst) {
  int used = 0, cur = 0;
  while (cur < n) {
    int fil = ufs.findfa(cur);
    if (fil + pw <= cur) return inf;
    ++used, cur = fil + pw;
  }
  return (long long int)cst * used;
}
inline int getint() {
  int ret = 0, ch;
  while (!isdigit(ch = getchar()))
    ;
  do ret = ret * 10 + ch - '0';
  while (isdigit(ch = getchar()));
  return ret;
}
int main() {
  n = getint(), m = getint(), k = getint(), ufs.init();
  for (int i = 1, t; i <= m; i++) {
    ufs.ban(t = getint());
    if (!t) fail = 1;
  }
  if (fail) return puts("-1"), 0;
  for (int i = 1; i <= k; i++) ans = min(ans, calc(i, getint()));
  printf("%lld\n", ans == inf ? -1 : ans);
  return 0;
}
