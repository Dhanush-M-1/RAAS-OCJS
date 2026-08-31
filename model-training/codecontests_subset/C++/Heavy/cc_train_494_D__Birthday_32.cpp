#include <bits/stdc++.h>
using namespace std;
typedef struct {
  int f, t;
  long long int w;
} edge;
vector<edge> e[100514];
int n;
int q[100514], qs, qe;
int inq[100514];
edge* dad[100514];
long long int mod = 1000000007;
long long int ds0[100514];
long long int ds1[100514];
long long int ds2[100514];
long long int us0[100514];
long long int us1[100514];
long long int us2[100514];
int up[20][100514];
int dpt[100514];
long long int dpl[100514];
int flca(int x, int y) {
  if (dpt[x] > dpt[y]) return flca(y, x);
  for (int j = 19; j >= 0; j--) {
    if (dpt[y] - (1 << j) >= dpt[x]) {
      y = up[j][y];
    }
  }
  if (x == y) return x;
  for (int j = 19; j >= 0; j--) {
    if (up[j][x] != up[j][y]) {
      x = up[j][x];
      y = up[j][y];
    }
  }
  return up[0][x];
}
void sol() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int a, b;
    long long int w;
    scanf("%d %d %I64d", &a, &b, &w);
    e[a].push_back((edge){a, b, w});
    e[b].push_back((edge){b, a, w});
  }
  qs = qe = 0;
  q[qe++] = 1;
  inq[1] = 1;
  dad[1] = 0;
  up[0][1] = 0;
  dpt[1] = 1;
  dpl[1] = 0;
  for (; qs != qe;) {
    int w = q[qs++];
    for (int i = 0; i < (int)e[w].size(); i++) {
      int t = e[w][i].t;
      if (inq[t]) continue;
      q[qe++] = t;
      inq[t] = 1;
      dad[t] = &e[w][i];
      up[0][t] = w;
      dpt[t] = dpt[w] + 1;
      dpl[t] = (dpl[w] + e[w][i].w) % mod;
    }
  }
  for (int i = 1; i <= n; i++) inq[i] = 0;
  for (int j = qe - 1; j >= 0; j--) {
    int w = q[j];
    ds0[w] = 1;
    ds1[w] = 0;
    ds2[w] = 0;
    for (int i = 0; i < (int)e[w].size(); i++) {
      int t = e[w][i].t;
      long long int tw = e[w][i].w;
      ds0[w] = (ds0[w] + ds0[t]) % mod;
      ds1[w] = (ds1[w] + ds1[t] + ds0[t] * tw) % mod;
      ds2[w] =
          (ds2[w] + ds2[t] + ds1[t] * tw % mod * 2 + ds0[t] * tw % mod * tw) %
          mod;
    }
  }
  us0[1] = 0;
  us1[1] = 0;
  us2[1] = 0;
  for (int j = 1; j < qe; j++) {
    int w = q[j];
    int d = dad[w]->f;
    long long int tw = dad[w]->w;
    us0[w] = n - ds0[w];
    long long int up1 = ds1[d] + (mod - (ds1[w] + ds0[w] * tw) % mod) + us1[d];
    up1 %= mod;
    us1[w] = (up1 + us0[w] * tw) % mod;
    us1[w] %= mod;
    long long int up2 =
        ds2[d] +
        (mod -
         (ds2[w] + ds1[w] * tw % mod * 2 + ds0[w] * tw % mod * tw) % mod) +
        us2[d];
    up2 %= mod;
    us2[w] = (up2 + up1 * tw % mod * 2 + us0[w] * tw % mod * tw) % mod;
  }
  for (int j = 1; j < 20; j++) {
    for (int i = 1; i <= n; i++) {
      up[j][i] = up[j - 1][up[j - 1][i]];
    }
  }
  int Q;
  scanf("%d", &Q);
  for (int s = 0; s < Q; s++) {
    int x, y;
    scanf("%d %d", &x, &y);
    int lca = flca(x, y);
    if (lca != y) {
      long long int dxy = (dpl[x] + dpl[y] + (mod - dpl[lca]) * 2) % mod;
      long long int pa = dxy * dxy % mod * ds0[y] % mod;
      pa += 2 * dxy % mod * ds1[y] % mod;
      pa += ds2[y] % mod;
      pa %= mod;
      long long int pb = (ds2[x] + us2[x] + (mod - pa)) % mod;
      printf("%I64d\n", (pa + mod - pb) % mod);
    } else {
      long long int dxy = (dpl[x] + dpl[y] + (mod - dpl[lca]) * 2) % mod;
      long long int pa = dxy * dxy % mod * us0[y] % mod;
      pa += 2 * dxy % mod * us1[y] % mod;
      pa += us2[y];
      pa %= mod;
      long long int pb = (ds2[x] + us2[x] + (mod - pa)) % mod;
      printf("%I64d\n", (pb + mod - pa) % mod);
    }
  }
}
int main() {
  while (1) {
    sol();
    break;
  }
  return 0;
}
