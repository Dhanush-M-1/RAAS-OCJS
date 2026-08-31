#include <bits/stdc++.h>
using namespace std;
const long double Pi = 3.14159265359;
const long long MOD = (long long)1e9 + 7;
const long long MAXN = (long long)2e5 + 10;
const long long INF = (long long)9223372036854775;
const long double EPS = (long double)1e-8;
set<long long> ans;
set<long long> g[MAXN];
vector<pair<long long, long long> > q;
vector<long long> anss;
queue<long long> bfsq;
long long vis[MAXN];
int main() {
  long long n, m, k, u, v;
  scanf("%lld", &n);
  scanf("%lld", &m);
  scanf("%lld", &k);
  long long an = n;
  for (int i = 0; i < m; i++) {
    scanf("%lld", &u);
    scanf("%lld", &v);
    u--;
    v--;
    g[u].insert(v);
    g[v].insert(u);
    q.push_back(make_pair(u, v));
  }
  for (int i = 0; i < n; i++) ans.insert(i);
  for (int i = 0; i < n; i++) {
    if (g[i].size() < k) {
      bfsq.push(i);
      vis[i] = 1;
    }
  }
  while (bfsq.size() != 0) {
    for (auto adj : g[bfsq.front()]) {
      g[adj].erase(bfsq.front());
      if (g[adj].size() < k) {
        if (vis[adj] == 0) bfsq.push(adj);
        vis[adj] = 1;
      }
    }
    ans.erase(bfsq.front());
    bfsq.pop();
    an--;
  }
  anss.push_back(an);
  for (int i = 0; i < m; i++) {
    u = q.back().first;
    v = q.back().second;
    if ((vis[u] == 1) or (vis[v] == 1)) {
      anss.push_back(an);
      q.pop_back();
      continue;
    }
    g[u].erase(v);
    g[v].erase(u);
    if (g[u].size() < k) {
      bfsq.push(u);
      vis[u] = 1;
    }
    if (g[v].size() < k) {
      bfsq.push(v);
      vis[v] = 1;
    }
    while (bfsq.size() != 0) {
      for (auto adj : g[bfsq.front()]) {
        g[adj].erase(bfsq.front());
        if (g[adj].size() < k) {
          if (vis[adj] == 0) bfsq.push(adj);
          vis[adj] = 1;
        }
      }
      ans.erase(bfsq.front());
      bfsq.pop();
      an--;
    }
    anss.push_back(an);
    q.pop_back();
  }
  anss.pop_back();
  for (int i = 0; i < m; i++) {
    printf("%lld\n", anss.back());
    anss.pop_back();
  }
  return 0;
}
