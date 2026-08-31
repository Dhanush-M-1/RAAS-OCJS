#include <bits/stdc++.h>
using namespace std;
const int N = (int)5e5 + 4;
const int inf = (int)1e9 + 7;
const long double eps = 1e-7;
const int K = 12;
const int M = 1001;
struct edge {
  int a, b, w, n;
  edge() { a = 0, b = 0, w = 0, n = 0; }
  edge(int a, int b, int w, int n) : a(a), b(b), w(w), n(n) {}
  bool operator<(const edge &a) const { return w > a.w; }
};
edge e[N];
pair<int, int> p[M];
int sz[M];
void make_set(int v) {
  p[v] = make_pair(v, 0);
  sz[v] = 1;
}
inline pair<int, int> find(int v) {
  if (p[v].first == v) {
    return make_pair(v, 0);
  }
  int s = p[v].second;
  p[v] = find(p[v].first);
  p[v].second ^= s;
  return p[v];
}
bool unite(int v, int u) {
  int a = find(v).first;
  int b = find(u).first;
  if (a == b) {
    return p[v].second ^ p[u].second;
  }
  if (sz[a] > sz[b]) {
    swap(a, b);
  }
  sz[b] += sz[a];
  p[a] = make_pair(b, p[v].second ^ p[u].second ^ 1);
  return true;
}
int main() {
  int n, m, q;
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d%d", &e[i].a, &e[i].b, &e[i].w);
    --e[i].a, --e[i].b;
    e[i].n = i + 1;
  }
  sort(e, e + m);
  for (int i = 0; i < q; ++i) {
    int l, r;
    scanf("%d%d", &l, &r);
    bool f = 0;
    for (int j = 0; j < n; ++j) {
      make_set(j);
    }
    for (int j = 0; j < m; ++j) {
      if (e[j].n >= l && e[j].n <= r) {
        if (!unite(e[j].a, e[j].b)) {
          printf("%d\n", e[j].w);
          f = 1;
          break;
        }
      }
    }
    if (!f) {
      printf("-1\n");
    }
  }
  return 0;
}
