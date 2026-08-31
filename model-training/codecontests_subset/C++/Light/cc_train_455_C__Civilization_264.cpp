#include <bits/stdc++.h>
using namespace std;
const int MX = 300007;
struct Star {
  int y, nx;
} E[MX << 1];
int H[MX], ecnt;
void add(int x, int y) {
  ecnt++, E[ecnt].y = y, E[ecnt].nx = H[x], H[x] = ecnt;
}
int N, M, Q;
int D, Dx;
void dfs(int x, int f, int d) {
  if (D < d) D = d, Dx = x;
  for (int i = H[x]; i; i = E[i].nx)
    if (E[i].y != f) dfs(E[i].y, x, d + 1);
}
void find(int x) {
  D = -1, dfs(x, 0, 0);
  D = -1, dfs(Dx, 0, 0);
}
struct Bcj {
  int f[MX], d[MX], sz[MX];
  void init() {
    for (int i = (1); i <= (N); i++) f[i] = i, sz[i] = 1;
  }
  int find(int x) { return x == f[x] ? x : f[x] = find(f[x]); }
  void uset(int x, int y) {
    x = find(x), y = find(y);
    if (x == y) return;
    if (sz[x] > sz[y]) swap(x, y);
    f[x] = y, sz[y] += sz[x];
    d[y] = max(max(d[x], d[y]), (d[x] + 1) / 2 + (d[y] + 1) / 2 + 1);
  }
} bcj;
int main() {
  scanf("%d%d%d", &N, &M, &Q);
  int a, b, c;
  bcj.init();
  for (int i = (1); i <= (M); i++) {
    scanf("%d%d", &a, &b);
    add(a, b), add(b, a), bcj.uset(a, b);
  }
  for (int i = (1); i <= (N); i++)
    if (bcj.f[i] == i) find(i), bcj.d[i] = D;
  for (int i = (1); i <= (Q); i++) {
    scanf("%d%d", &a, &b);
    if (a == 1)
      printf("%d\n", bcj.d[bcj.find(b)]);
    else
      scanf("%d", &c), bcj.uset(b, c);
  }
}
