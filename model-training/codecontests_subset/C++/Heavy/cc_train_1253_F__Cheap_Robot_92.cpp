#include <bits/stdc++.h>
using namespace std;
struct UnionFind {
  vector<int> nxt;
  void init(int x) {
    nxt.clear();
    nxt.resize(x);
    for (int i = 0; i < x; i++) {
      nxt[i] = i;
    }
  }
  int find(int x) {
    if (nxt[x] == x) return x;
    return nxt[x] = find(nxt[x]);
  }
  inline void unite(int x, int y) { nxt[find(y)] = find(x); }
};
long long N, M, K, Q;
vector<pair<long long, long long>> uvt[101010], cnt[101010], subcnt[101010];
long long dps[101010];
pair<long long, long long> pc[101010][30];
long long i, j, k, ans;
void crecntg() {
  priority_queue<pair<long long, pair<long long, long long>>> pq;
  vector<pair<long long, long long>> mk(N + 2, {0, 0});
  long long ct = 0;
  for (i = 0; i < K; i++) {
    pq.push({0, {i + 1, i + 1}});
  }
  while (pq.size()) {
    auto qa = pq.top();
    pq.pop();
    long long c = qa.first;
    long long a = qa.second.first;
    long long p = qa.second.second;
    if (mk[a].second != 0) {
      if (mk[a].second == p) continue;
      subcnt[p].push_back({mk[a].second, mk[a].first - c});
      subcnt[mk[a].second].push_back({p, mk[a].first - c});
      continue;
    }
    mk[a] = {-c, p};
    for (i = 0; i < uvt[a].size(); i++) {
      auto b = uvt[a][i];
      if (mk[b.first].second == p) continue;
      pq.push({c - b.second, {b.first, p}});
    }
  }
}
void krus() {
  priority_queue<pair<long long, pair<long long, long long>>> pq;
  UnionFind uf;
  uf.init(K + 1);
  long long i, j;
  for (i = 0; i < K; i++) {
    for (j = 0; j < subcnt[i + 1].size(); j++) {
      pq.push({-subcnt[i + 1][j].second, {i + 1, subcnt[i + 1][j].first}});
    }
  }
  while (pq.size()) {
    auto qa = pq.top();
    pq.pop();
    long long a = qa.second.first;
    long long b = qa.second.second;
    if (uf.find(a) == uf.find(b)) continue;
    cnt[a].push_back({b, -qa.first});
    cnt[b].push_back({a, -qa.first});
    uf.unite(a, b);
  }
}
void dfs(long long a, long long p, long long c, long long d) {
  long long i = 0;
  dps[a] = d;
  pc[a][0] = {p, c};
  for (i = 0; i < cnt[a].size(); i++) {
    if (cnt[a][i].first != p) dfs(cnt[a][i].first, a, cnt[a][i].second, d + 1);
  }
}
void setpp() {
  long long i, j;
  for (i = 0; i < 20; i++) {
    for (j = 0; j < K; j++) {
      pair<long long, long long> b = pc[j + 1][i];
      pair<long long, long long> c = pc[b.first][i];
      pc[j + 1][i + 1] = {c.first, max(c.second, b.second)};
    }
  }
}
void solve() {
  long long a, b;
  scanf("%lld%lld", &a, &b);
  if (dps[a] > dps[b]) {
    swap(a, b);
  }
  long long acp = 0, bcp = 0;
  long long i;
  for (i = 20; i >= 0; i--) {
    if (dps[b] - (1 << i) >= dps[a]) {
      bcp = max(pc[b][i].second, bcp);
      b = pc[b][i].first;
    }
  }
  if (a == b) {
    printf("%lld\n", bcp);
    return;
  }
  for (i = 20; i >= 0; i--) {
    if (pc[a][i].first != pc[b][i].first) {
      acp = max(pc[a][i].second, acp);
      bcp = max(pc[b][i].second, bcp);
      a = pc[a][i].first;
      b = pc[b][i].first;
    }
  }
  acp = max(pc[a][0].second, acp);
  bcp = max(pc[b][0].second, bcp);
  printf("%lld\n", max(acp, bcp));
}
int main() {
  scanf("%lld%lld%lld%lld", &N, &M, &K, &Q);
  for (i = 0; i < M; i++) {
    long long u, v, w;
    scanf("%lld%lld%lld", &u, &v, &w);
    uvt[u].push_back({v, w});
    uvt[v].push_back({u, w});
  }
  crecntg();
  krus();
  dfs(1, 0, 0, 1);
  setpp();
  while (Q--) {
    solve();
  }
  return 0;
}
