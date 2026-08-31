#include <bits/stdc++.h>
using namespace std;
string Next() {
  string S;
  cin >> S;
  return S;
}
int NextInt() {
  int n;
  scanf("%d", &n);
  return n;
}
long long NextLong() {
  long long n;
  scanf("%lld", &n);
  return n;
}
struct Edge {
  int u, v, w, i;
  bool operator<(const Edge &d) const { return w > d.w; }
};
const int N = (int)1e3 + 10;
const int M = (int)1e6 + 10;
int n, m, q, p[N], d[N];
Edge E[M];
int Root(int u) {
  if (p[u] < 0) return u;
  int x = Root(p[u]);
  d[u] ^= d[p[u]];
  return p[u] = x;
}
int Height(int u) {
  Root(u);
  return d[u];
}
void Merge(int u, int v) {
  int x = Root(u), y = Root(v);
  if (p[x] > p[y]) {
    swap(x, y);
    swap(u, v);
  }
  p[x] += p[y];
  p[y] = x;
  d[y] ^= d[u] ^ d[v] ^ 1;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; ++i)
    scanf("%d%d%d", &E[i].u, &E[i].v, &E[i].w), E[i].i = i;
  sort(E + 1, E + 1 + m);
  while (q--) {
    int l = NextInt(), r = NextInt();
    for (int i = 1; i <= n; ++i) p[i] = -1, d[i] = 0;
    int ans = -1;
    for (int i = 1; i <= m; ++i)
      if (l <= E[i].i && E[i].i <= r) {
        int u = E[i].u, v = E[i].v;
        if (Root(u) != Root(v))
          Merge(u, v);
        else {
          if (Height(u) == Height(v)) {
            ans = E[i].w;
            break;
          }
        }
      }
    printf("%d\n", ans);
  }
  return 0;
}
