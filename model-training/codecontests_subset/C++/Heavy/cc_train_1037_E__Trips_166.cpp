#include <bits/stdc++.h>
using namespace std;
const int max_n = 200005;
struct edge {
  int u, v, next;
} G[max_n * 2];
int head[max_n];
int total;
bool visit[max_n * 2];
int in[max_n];
set<pair<int, int> > s;
int n, m, k;
int u, v;
int ans[max_n];
void add_edge(int u, int v) {
  G[total].u = u;
  G[total].v = v;
  G[total].next = head[u];
  head[u] = total++;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  total = 0;
  memset(head, -1, sizeof(head));
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &u, &v);
    add_edge(u, v);
    add_edge(v, u);
    in[u]++;
    in[v]++;
  }
  for (int i = 1; i <= n; i++) s.insert(pair<int, int>(in[i], i));
  pair<int, int> p;
  for (int i = 2 * m - 1; i >= 0; i -= 2) {
    while (!s.empty()) {
      p = *s.begin();
      if (p.first < k) {
        s.erase(p);
        for (int j = head[p.second]; ~j; j = G[j].next) {
          if (!visit[j]) {
            v = G[j].v;
            s.erase(pair<int, int>(in[v], v));
            in[v]--;
            s.insert(pair<int, int>(in[v], v));
            visit[j] = visit[j ^ 1] = true;
          }
        }
      } else
        break;
    }
    ans[i / 2] = s.size();
    if (!visit[i]) {
      u = G[i].u;
      v = G[i].v;
      s.erase(pair<int, int>(in[u], u));
      in[u]--;
      s.insert(pair<int, int>(in[u], u));
      s.erase(pair<int, int>(in[v], v));
      in[v]--;
      s.insert(pair<int, int>(in[v], v));
      visit[i] = visit[i ^ 1] = true;
    }
  }
  for (int i = 0; i < m; i++) printf("%d\n", ans[i]);
  return 0;
}
