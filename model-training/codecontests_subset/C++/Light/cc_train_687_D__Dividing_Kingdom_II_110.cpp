#include <bits/stdc++.h>
using namespace std;
const int N = 1010;
int read() {
  int MisakaMikoto;
  scanf("%d", &MisakaMikoto);
  return MisakaMikoto;
}
int fa[N * 2];
int find(int x) {
  if (fa[x] != x) return fa[x] = find(fa[x]);
  return x;
}
int cnt;
struct edge {
  int u, v, w, id;
  edge(){};
  edge(int U, int V, int W, int ID) {
    u = U;
    v = V;
    w = W;
    id = ID;
  }
} e[N * N];
bool cmp(edge a, edge b) { return a.w > b.w; }
int n, m, q;
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; ++i) {
    int u = read(), v = read(), w = read();
    e[++cnt] = edge(u, v, w, i);
  }
  sort(e + 1, e + 1 + cnt, cmp);
  while (q--) {
    int l = read(), r = read(), ans = -1;
    for (int i = 1; i <= n * 2; i++) fa[i] = i;
    for (int i = 1; i <= m; i++)
      if (e[i].id >= l && e[i].id <= r) {
        if (find(e[i].u) == find(e[i].v)) {
          ans = e[i].w;
          break;
        } else {
          fa[find(e[i].u + n)] = find(e[i].v);
          fa[find(e[i].u)] = find(e[i].v + n);
        }
      }
    cout << ans << endl;
  }
}
