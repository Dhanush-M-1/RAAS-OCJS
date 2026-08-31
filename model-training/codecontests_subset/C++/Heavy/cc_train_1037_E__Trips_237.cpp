#include <bits/stdc++.h>
using namespace std;
int N, M, K;
int xList[200005], yList[200005];
int deg[200005], ans[200005];
set<int> Adj[200005];
set<pair<int, int> > s;
set<pair<int, int> >::iterator p;
void work(int u) {
  s.erase(make_pair(deg[u], u));
  int v;
  set<int>::iterator k;
  for (k = Adj[u].begin(); k != Adj[u].end(); k++) {
    v = (*k);
    if (!s.count(make_pair(deg[v], v))) {
      deg[v]--;
      continue;
    }
    s.erase(make_pair(deg[v], v));
    deg[v]--;
    if (deg[v] >= K)
      s.insert(make_pair(deg[v], v));
    else
      work(v);
  }
}
int main() {
  scanf("%d%d%d", &N, &M, &K);
  int u, v;
  for (int i = 1; i <= M; i++) {
    scanf("%d%d", &u, &v);
    Adj[u].insert(v);
    Adj[v].insert(u);
    deg[u]++;
    deg[v]++;
    xList[i] = u;
    yList[i] = v;
  }
  for (int i = 1; i <= N; i++) {
    s.insert(make_pair(deg[i], i));
  }
  while (!s.empty()) {
    p = s.begin();
    if (p->first < K)
      work(p->second);
    else
      break;
  }
  ans[M] = s.size();
  for (int i = M; i >= 1; i--) {
    u = xList[i];
    v = yList[i];
    ans[i - 1] = s.size();
    if (!s.count(make_pair(deg[u], u)) || !s.count(make_pair(deg[v], v)))
      continue;
    Adj[u].erase(v);
    Adj[v].erase(u);
    if (s.count(make_pair(deg[u], u))) {
      s.erase(make_pair(deg[u], u));
      deg[u]--;
      s.insert(make_pair(deg[u], u));
    }
    if (s.count(make_pair(deg[v], v))) {
      s.erase(make_pair(deg[v], v));
      deg[v]--;
      s.insert(make_pair(deg[v], v));
    }
    while (!s.empty()) {
      p = s.begin();
      if (p->first < K)
        work(p->second);
      else
        break;
    }
    ans[i - 1] = s.size();
  }
  for (int i = 1; i <= M; i++) printf("%d\n", ans[i]);
  getchar();
  return 0;
}
