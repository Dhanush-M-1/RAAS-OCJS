#include <bits/stdc++.h>
using namespace std;
const int MX = 3500;
int N;
struct Edge {
  int y, nx;
} E[MX << 1];
int H[MX], ec;
void Add(int x, int y) { E[++ec].y = y, E[ec].nx = H[x], H[x] = ec; }
int B[MX], dfn[MX], low[MX], dc;
int Cr[MX], Ic[MX], cc, stk[MX], tp;
void Tarjan(int x, int f) {
  B[x] = 1, dfn[x] = low[x] = ++dc, stk[++tp] = x;
  for (int i = H[x]; i; i = E[i].nx) {
    if (B[E[i].y] == 0)
      Tarjan(E[i].y, x), low[x] = min(low[x], low[E[i].y]);
    else if (E[i].y != f)
      low[x] = min(low[x], dfn[E[i].y]);
  }
  if (dfn[x] == low[x]) {
    if (stk[tp] != x) {
      int z = 0;
      while (z != x) z = stk[tp--], Cr[++cc] = z, Ic[z] = 1;
    } else
      tp--;
  }
}
int C[MX], Ds[MX][MX];
void dfs1(int x, int f, int c) {
  C[x] = c;
  for (int i = H[x]; i; i = E[i].nx)
    if (E[i].y != f && !Ic[E[i].y]) dfs1(E[i].y, x, c);
}
void dfs2(int x, int f, int rt, int d) {
  Ds[rt][x] = d;
  for (int i = H[x]; i; i = E[i].nx)
    if (E[i].y != f && C[x] == C[E[i].y]) dfs2(E[i].y, x, rt, d + 1);
}
double Calc(int x, int y) {
  if (C[x] == C[y]) return 1.0 / Ds[x][y];
  int rx = Cr[C[x]], ry = Cr[C[y]];
  int a = Ds[x][rx] + Ds[y][ry] + (C[x] - C[y] + cc) % cc - 1;
  int b = Ds[x][rx] + Ds[y][ry] + (C[y] - C[x] + cc) % cc - 1;
  int c = Ds[x][rx] + Ds[y][ry] + cc - 2;
  return 1.0 / a + 1.0 / b - 1.0 / c;
}
int main() {
  scanf("%d", &N);
  for (int i = (1); i <= (N); ++i) {
    int x, y;
    scanf("%d%d", &x, &y), ++x, ++y;
    Add(x, y), Add(y, x);
  }
  Tarjan(1, 0);
  for (int i = (1); i <= (cc); ++i) dfs1(Cr[i], 0, i);
  for (int i = (1); i <= (N); ++i) dfs2(i, 0, i, 1);
  double ans = 0;
  for (int i = (1); i <= (N); ++i)
    for (int j = (1); j <= (N); ++j) ans += Calc(i, j);
  printf("%.10f\n", ans);
  return 0;
}
