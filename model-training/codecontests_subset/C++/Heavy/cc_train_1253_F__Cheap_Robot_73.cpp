#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int n, m, k, Q, used[N], p[N];
vector<int> s[N];
long long d[N], ans[N * 3];
vector<pair<int, long long>> g[N];
map<pair<int, int>, vector<int>> ind;
vector<int> query[N];
priority_queue<pair<long long, int>> q;
vector<pair<long long, pair<int, int>>> add;
void dsu(int a, int b, long long x) {
  a = p[a];
  b = p[b];
  if (a == b) return;
  if (s[a].size() < s[b].size()) swap(a, b);
  while (!s[b].empty()) {
    p[s[b].back()] = a;
    s[a].push_back(s[b].back());
    for (int i = 0; i < query[s[b].back()].size(); i++) {
      int to = query[s[b].back()][i];
      if (p[to] == a) {
        vector<int> &c = ind[make_pair(s[b].back(), to)];
        while (!c.empty()) {
          if (ans[c.back()] == 0) ans[c.back()] = x;
          c.pop_back();
        }
      }
    }
    s[b].pop_back();
  }
}
int main() {
  cin >> n >> m >> k >> Q;
  while (m--) {
    int a, b;
    long long w;
    scanf("%d%d%lld", &a, &b, &w);
    g[a].push_back(make_pair(b, w));
    g[b].push_back(make_pair(a, w));
  }
  for (int i = 1; i <= Q; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    query[a].push_back(b);
    query[b].push_back(a);
    ind[make_pair(a, b)].push_back(i);
    ind[make_pair(b, a)].push_back(i);
  }
  for (int i = 1; i <= n; i++) d[i] = 1000000007ll * 1000000007ll;
  for (int i = 1; i <= k; i++) {
    d[i] = 0;
    q.push(make_pair(-d[i], i));
  }
  while (!q.empty()) {
    int v = -1;
    do {
      v = q.top().second;
      q.pop();
    } while (used[v] && !q.empty());
    if (used[v] || v == -1) break;
    used[v] = 1;
    for (int i = 0; i < g[v].size(); i++) {
      int to = g[v][i].first;
      long long w = g[v][i].second;
      if (d[v] + w < d[to]) {
        d[to] = d[v] + w;
        q.push(make_pair(-d[to], to));
      }
    }
  }
  for (int v = 1; v <= n; v++) {
    p[v] = v;
    s[v].push_back(v);
    for (int i = 0; i < g[v].size(); i++) {
      int to = g[v][i].first;
      long long w = g[v][i].second;
      if (to > v) add.push_back(make_pair(w + d[v] + d[to], make_pair(to, v)));
    }
  }
  sort(add.begin(), add.end());
  for (int i = 0; i < add.size(); i++)
    dsu(add[i].second.first, add[i].second.second, add[i].first);
  for (int i = 1; i <= Q; i++) printf("%lld\n", ans[i]);
  return 0;
}
