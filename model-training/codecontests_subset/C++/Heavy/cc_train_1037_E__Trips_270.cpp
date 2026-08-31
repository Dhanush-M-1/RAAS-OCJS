#include <bits/stdc++.h>
using namespace std;
const int M = 1e9 + 7;
long long powmod(long long a, long long b, long long mod) {
  long long res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res % mod;
}
const int N = 2e5 + 10;
int degree[N];
vector<pair<int, int> > v[N];
bool mark[N];
set<pair<int, int> > s;
int main() {
  memset(mark, 1, sizeof mark);
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int> > edges(m);
  for (int i = 0; i < m; ++i) {
    int a, b;
    scanf("%d %d", &a, &b);
    a--, b--;
    edges[i].first = a;
    edges[i].second = b;
    degree[a]++;
    degree[b]++;
    v[a].push_back(make_pair(b, i));
    v[b].push_back(make_pair(a, i));
  }
  for (int i = 0; i < n; ++i) {
    s.insert(make_pair(degree[i], i));
  }
  while (!s.empty() && s.begin()->first < k) {
    int u = s.begin()->second;
    for (int i = 0; i < v[u].size(); ++i) {
      int ch = v[u][i].first;
      if (mark[ch]) {
        s.erase(make_pair(degree[ch], ch));
        degree[ch]--;
        s.insert(make_pair(degree[ch], ch));
      }
    }
    s.erase(make_pair(degree[u], u));
    mark[u] = 0;
  }
  vector<int> ans;
  for (int i = m - 1; i >= 0; --i) {
    ans.push_back(s.size());
    int a = edges[i].first, b = edges[i].second;
    if (mark[a] && mark[b]) {
      s.erase(make_pair(degree[a], a));
      degree[a]--;
      s.insert(make_pair(degree[a], a));
      s.erase(make_pair(degree[b], b));
      degree[b]--;
      s.insert(make_pair(degree[b], b));
      while (!s.empty() && (s.begin()->first < k)) {
        int u = s.begin()->second;
        for (int j = 0; j < v[u].size(); ++j) {
          int ch = v[u][j].first, id = v[u][j].second;
          if (id >= i) continue;
          if (mark[ch]) {
            s.erase(make_pair(degree[ch], ch));
            degree[ch]--;
            s.insert(make_pair(degree[ch], ch));
          }
        }
        s.erase(make_pair(degree[u], u));
        mark[u] = 0;
      }
    }
  }
  for (int i = ans.size() - 1; i >= 0; --i) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
