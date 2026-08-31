#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
const int N = 6000, M = 3e4;
struct edge {
  int to, nxt;
  int w, c;
} e[M];
int TT, n, m, x, y, k, a[80], b[80];
int ans, S, T, i, tot = 1, head[N], d[N], path[N];
queue<int> Q;
bool v[N];
void add(int x, int y, int w, int c) {
  e[++tot] = {y, head[x], w, c}, head[x] = tot;
  e[++tot] = {x, head[y], 0, -c}, head[y] = tot;
}
bool spfa() {
  for (int i = (0); i <= (N - 1); ++i) d[i] = INF;
  memset(v, 0, sizeof v);
  d[S] = 0, Q.push(S), v[S] = 1;
  while (!Q.empty()) {
    x = Q.front(), Q.pop(), v[x] = 0;
    for (i = head[x]; i; i = e[i].nxt)
      if (e[i].w && d[y = e[i].to] > d[x] + e[i].c) {
        d[y] = d[x] + e[i].c, path[y] = i;
        if (!v[y]) Q.push(y), v[y] = 1;
      }
  }
  if (d[T] == INF) return false;
  for (y = T; y != S; y = x) {
    i = path[y], x = e[i ^ 1].to;
    --e[i].w, ++e[i ^ 1].w;
  }
  ans += d[T];
  return true;
}
int main() {
  cin >> TT;
  while (TT--) {
    scanf("%d%d", &n, &k);
    for (int i = (1); i <= (n); ++i) scanf("%d%d", a + i, b + i);
    tot = 1, memset(head, 0, sizeof head);
    S = 0, T = (k + 2) * n + 1;
    add(S, 1, n - k, 0);
    for (int i = (1); i <= (n); ++i) add(1, n + i, 1, a[i]);
    for (int i = (2); i <= (k); ++i) {
      add(S, i, 1, 0);
      for (int j = (1); j <= (n); ++j) add(i, n + j, 1, (i - 1) * b[j]);
    }
    for (int j = (1); j <= (n); ++j) add(n + j, T, 1, 0);
    while (spfa())
      ;
    printf("%d\n", n * 2 - k);
    memset(v, 0, sizeof v);
    for (int q = (k); q >= (2); --q) {
      for (i = head[q]; i; i = e[i].nxt)
        if (e[i].to > n && !e[i].w) {
          x = e[i].to - n;
          printf("%d ", x), v[x] = true;
          break;
        }
    }
    for (i = head[1]; i; i = e[i].nxt)
      if (e[i].to > n && !e[i].w) {
        x = e[i].to - n;
        printf("%d -%d ", x, x), v[x] = true;
      }
    for (int i = (1); i <= (n); ++i)
      if (!v[i]) {
        printf("%d\n", i);
        break;
      }
  }
  return 0;
}
