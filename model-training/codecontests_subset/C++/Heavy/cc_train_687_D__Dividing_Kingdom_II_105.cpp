#include <bits/stdc++.h>
using namespace std;
const int NMAX = 1111;
int p[NMAX << 1];
int rnk[NMAX << 1];
int find(int u) { return p[u] == u ? u : p[u] = find(p[u]); }
void uni(int u, int v) {
  u = find(u), v = find(v);
  if (u == v) return;
  if (rnk[v] < rnk[u]) swap(v, u);
  p[u] = v;
  rnk[v] = max(rnk[v], rnk[u] + 1);
}
struct edge {
  int w, a, b, x;
  const bool operator<(const edge& other) const { return w > other.w; }
};
int main() {
  int N, M, Q;
  scanf("%d%d%d", &N, &M, &Q);
  vector<edge> v;
  for (int i = 1; i <= M; i++) {
    int a, b, w;
    scanf("%d%d%d", &a, &b, &w);
    v.push_back({w, a, b, i});
  }
  sort(v.begin(), v.end());
  while (Q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    for (int i = 1; i <= 2 * N; i++) p[i] = i, rnk[i] = 0;
    bool ok = false;
    for (int i = 0; i < M; i++) {
      const auto& e = v[i];
      if (l <= e.x && e.x <= r) {
        if (find(e.a) == find(e.b)) {
          printf("%d\n", e.w);
          ok = true;
          break;
        }
        uni(e.a, e.b + N);
        uni(e.b, e.a + N);
      }
    }
    if (!ok) printf("-1\n");
  }
}
