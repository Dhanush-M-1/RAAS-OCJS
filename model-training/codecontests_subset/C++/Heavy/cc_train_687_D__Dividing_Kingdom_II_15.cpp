#include <bits/stdc++.h>
using namespace std;
long long int powm(long long int a, int b, int n) {
  long long int rm = 1;
  while (b) {
    if (b % 2) {
      rm = (rm * a) % n;
    }
    a = (a * a) % n;
    b /= 2;
  }
  return rm;
}
int p[int(1e3 + 10)], G[int(1e3 + 10)], sz[int(1e3 + 10)] = {0};
pair<pair<int, int>, pair<int, int> > E[int(1e3 + 10) * int(1e3 + 10)];
int vec[int(1e3 + 10)][int(1e3 + 10)], pt[int(1e3 + 10)];
int merge(int node) {
  if (p[node] == node) return node;
  p[node] = merge(p[node]);
  return p[node];
}
int f(int val) {
  if (val == 1) return 2;
  return 1;
}
int main() {
  int n, m, q, u, v, w, l, r;
  scanf("%d", &n);
  ;
  scanf("%d", &m);
  ;
  scanf("%d", &q);
  ;
  for (int i = int(1); i <= (int)m; i++) {
    scanf("%d", &u);
    ;
    scanf("%d", &v);
    ;
    scanf("%d", &w);
    ;
    E[i] = make_pair(make_pair(w, i), make_pair(u, v));
  }
  sort(E + 1, E + m + 1);
  while (q--) {
    int stop = 0, ans = 0;
    scanf("%d", &l);
    ;
    scanf("%d", &r);
    ;
    memset(G, 0, sizeof(G));
    ;
    for (int i = int(1); i <= (int)n; i++) p[i] = i, vec[i][1] = i, pt[i] = 1;
    E[m + 1].first.first = E[m].first.first + 1;
    for (int j = m; j >= 1; j--) {
      if (E[j].first.second < l || E[j].first.second > r) continue;
      u = E[j].second.first, v = E[j].second.second;
      if (!G[u] && !G[v]) {
        G[u] = 1;
        G[v] = 2;
        p[u] = p[v] = v;
        vec[v][++pt[v]] = u;
        pt[u] = 0;
      } else if (!G[u] && G[v]) {
        merge(v);
        if (G[v] == 1)
          G[u] = 2;
        else
          G[u] = 1;
        p[u] = p[v];
        vec[p[v]][++pt[p[v]]] = u;
        pt[u] = 0;
      } else if (G[u] && !G[v]) {
        merge(u);
        if (G[u] == 1)
          G[v] = 2;
        else
          G[v] = 1;
        p[v] = p[u];
        vec[p[u]][++pt[p[u]]] = v;
        pt[v] = 0;
      } else {
        merge(u);
        merge(v);
        if (p[u] == p[v]) {
          if (G[u] == G[v]) {
            stop = j;
            break;
          }
        } else {
          if (pt[p[u]] > pt[p[v]]) swap(u, v);
          if (G[u] == G[v]) {
            for (int i = 1; i <= pt[p[u]]; ++i)
              G[vec[p[u]][i]] = f(G[vec[p[u]][i]]);
          }
          for (int i = 1; i <= pt[p[u]]; ++i)
            vec[p[v]][++pt[p[v]]] = vec[p[u]][i];
          pt[p[u]] = 0;
          p[p[u]] = p[v];
        }
      }
    }
    if (stop == 0)
      ans = -1;
    else
      ans = E[stop].first.first;
    printf("%d\n", ans);
  }
  return 0;
}
