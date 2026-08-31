#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e6 + 10;
int N, fa[MAXN], M, Q, siz[MAXN];
struct edge {
  int x, y, v, id;
  friend bool operator<(edge a, edge b) { return a.v > b.v; }
} E[MAXN];
void onion(int, int);
int find_(int);
int read() {
  int x = 0, f = 1;
  char s = getchar();
  for (; !isdigit(s); s = getchar())
    if (s == '-') f = -1;
  for (; isdigit(s); s = getchar()) x = 10 * x + (s - '0');
  return x * f;
}
int main() {
  N = read();
  M = read();
  Q = read();
  for (int i = 1; i <= M; i++) {
    E[i].x = read();
    E[i].y = read();
    E[i].v = read();
    E[i].id = i;
  }
  sort(E + 1, E + M + 1);
  while (Q--) {
    int l, r, ans = -1;
    l = read();
    r = read();
    for (int i = 1; i <= 2 * N; i++) fa[i] = i, siz[i] = 1;
    for (int i = 1; i <= M; i++) {
      if (l <= E[i].id && E[i].id <= r) {
        if (find_(E[i].x) == find_(E[i].y)) {
          ans = E[i].v;
          break;
        } else {
          onion(E[i].x + N, E[i].y);
          onion(E[i].x, E[i].y + N);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
void onion(int x, int y) {
  int fx = find_(x), fy = find_(y);
  if (fx != fy) {
    if (siz[fx] > siz[fy]) swap(fx, fy);
    fa[fx] = fy;
    siz[fy] += siz[fx];
  }
}
int find_(int x) { return fa[x] == x ? x : fa[x] = find_(fa[x]); }
