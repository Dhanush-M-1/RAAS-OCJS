#include <bits/stdc++.h>
using namespace std;
long long n, k, a, b, q, u, v, w, ww, order[300000], orderr[300000], ans,
    fenic[300000], fenicc[300000];
void insertt(long long v, long long w) {
  long long vv = v;
  while (vv <= n) {
    fenic[vv] += w;
    vv += vv & -vv;
  }
}
void inserttt(long long v, long long w) {
  long long vv = v;
  while (vv <= n) {
    fenicc[vv] += w;
    vv += vv & -vv;
  }
}
long long fenicsum(long long x) {
  long long rlt = 0;
  while (x > 0) {
    rlt += fenic[x];
    x -= x & -x;
  }
  return rlt;
}
long long feniccsum(long long x) {
  long long rlt = 0;
  while (x > 0) {
    rlt += fenicc[x];
    x -= x & -x;
  }
  return rlt;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  while (q--) {
    scanf("%d", &u);
    if (u == 1) {
      scanf("%d%d", &v, &ww);
      long long wwww = min(order[v] + ww, a);
      w = wwww - order[v];
      order[v] = wwww;
      insertt(v, w);
      wwww = min(orderr[v] + ww, b);
      w = wwww - orderr[v];
      orderr[v] = wwww;
      inserttt(v, w);
    } else {
      scanf("%d", &v);
      ans = 0;
      ans += feniccsum(v - 1);
      ans += fenicsum(n) - fenicsum(v + k - 1);
      printf("%I64d\n", ans);
    }
  }
  return 0;
}
