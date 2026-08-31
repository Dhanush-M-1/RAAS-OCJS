#include <bits/stdc++.h>
#pragma optimize("O3")
using namespace std;
const long long MOD = 1e9 + 7;
const long long INF = 2 * 1e12 + 7;
const int base = 2e5 + 1;
const int MAX = 1e4 + 2;
const double EPS = 1e-9;
const double PI = acos(-1.);
const int MAXN = 2 * 1e6 + 1;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    vector<vector<int> > g(n + 1), from(n + 1);
    vector<int> was(n + 1, 0), can(n + 1, 1), was2(n + 1, 0), p(n + 1),
        used(n + 1, 0);
    for (long long i = (0); i < (m); ++i) {
      int v, u;
      cin >> v >> u;
      g[v].push_back(u);
      g[u].push_back(v);
    }
    queue<int> q;
    q.push(a);
    was[a] = 1;
    while (!q.empty()) {
      int v = q.front();
      q.pop();
      if (v == b) continue;
      for (auto u : g[v]) {
        if (!was[u]) {
          was[u] = 1;
          q.push(u);
          p[u] = v;
        }
        from[u].push_back(v);
      }
    }
    stack<int> s;
    s.push(b);
    was2[b] = 1;
    while (!s.empty()) {
      int v = s.top();
      s.pop();
      if (v == a) continue;
      can[v] = 0;
      for (auto u : from[v]) {
        if (!was2[u]) {
          was2[u] = 1;
          s.push(u);
        }
      }
    }
    can[a] = 1;
    can[b] = 1;
    long long c1 = -1, c2 = -1;
    s.push(a);
    used[a] = 1;
    while (!s.empty()) {
      int v = s.top();
      s.pop();
      c1++;
      for (auto u : g[v]) {
        if (!can[u] || u == b) continue;
        if (!used[u]) {
          used[u] = 1;
          s.push(u);
        }
      }
    }
    s.push(b);
    used[b] = 1;
    while (!s.empty()) {
      int v = s.top();
      s.pop();
      c2++;
      for (auto u : g[v]) {
        if (!can[u] || u == a) continue;
        if (!used[u]) {
          used[u] = 1;
          s.push(u);
        }
      }
    }
    cout << c1 * c2 << '\n';
  }
  return 0;
}
