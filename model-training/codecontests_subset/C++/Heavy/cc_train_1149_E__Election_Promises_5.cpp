#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0, y = 0, c = getchar();
  while (!isdigit(c)) y = c, c = getchar();
  while (isdigit(c)) x = (x << 1) + (x << 3) + (c ^ '0'), c = getchar();
  return y == '-' ? -x : x;
}
inline void print(long long q) {
  if (q < 0) putchar('-'), q = -q;
  if (q >= 10) print(q / 10);
  putchar(q % 10 + '0');
}
long long s1 = 19260817, s2 = 23333333, s3 = 998244353, srd;
inline long long rd() { return srd = (srd * s1 + s2 + rand()) % s3; }
void file() {
  freopen(".in", "r", stdin);
  freopen(".out", "w", stdout);
}
int n, m, a[200010];
struct edge {
  int to, nxt;
} e[200010], ee[200010];
int cnt, fir[200010], ff[200010], ds[200010];
inline void ins(int u, int v) {
  e[++cnt].to = v;
  e[cnt].nxt = fir[u];
  fir[u] = cnt;
  ee[cnt].to = u;
  ee[cnt].nxt = ff[v];
  ff[v] = cnt;
  ++ds[u];
}
int jie[200010], vl[200010], mx;
bool tp[200010];
vector<int> b[200010];
int q[200010], h, t;
int main() {
  srand(time(0));
  rd();
  int i, j, k, u, v;
  n = read();
  m = read();
  for (i = 1; i <= n; ++i) a[i] = read();
  for (i = 1; i <= m; ++i) {
    u = read();
    v = read();
    ins(u, v);
  }
  for (i = 1; i <= n; ++i)
    if (!ds[i]) q[++t] = i;
  while (h < t) {
    j = q[++h];
    for (i = ff[j]; i; i = ee[i].nxt) {
      --ds[ee[i].to];
      if (!ds[ee[i].to]) q[++t] = ee[i].to;
    }
  }
  for (i = 1; i <= n; ++i) {
    for (j = fir[q[i]]; j; j = e[j].nxt) tp[jie[e[j].to]] = 1;
    for (j = 0;; ++j)
      if (!tp[j]) {
        jie[q[i]] = j;
        b[j].push_back(q[i]);
        mx = max(mx, j);
        vl[j] ^= a[q[i]];
        break;
      }
    for (j = fir[q[i]]; j; j = e[j].nxt) tp[jie[e[j].to]] = 0;
  }
  int mm = mx + 1;
  for (i = mx; i >= 0; --i)
    if (vl[i]) {
      mm = i;
      break;
    }
  if (mm == mx + 1) {
    puts("LOSE");
    return 0;
  }
  puts("WIN");
  for (i = 0; i < b[mm].size(); ++i) {
    j = b[mm][i];
    k = vl[mm] ^ a[j];
    if (k < a[j]) {
      a[j] = k;
      vl[mm] = 0;
      for (u = fir[j]; u; u = e[u].nxt) {
        a[e[u].to] ^= vl[jie[e[u].to]];
        vl[jie[e[u].to]] = 0;
      }
      break;
    }
  }
  for (i = 1; i <= n; ++i) print(a[i]), putchar(' ');
  return 0;
}
