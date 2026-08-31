#include <bits/stdc++.h>
using namespace std;
bool vis[1011], root[1011];
vector<int> g[1011];
int main() {
  int n, x;
  cin >> n >> x;
  int p[n + 1];
  for (int i = 0; i < n; i++) {
    cin >> p[i + 1];
    root[i + 1] = 1;
    if (p[i + 1]) {
      root[i + 1] = 0;
      g[p[i + 1]].emplace_back(i + 1);
    }
  }
  vector<int> v;
  int cur, sz, sp;
  bool found = 0;
  for (int i = 0; i < n; i++) {
    cur = i + 1;
    sz = 0;
    found = 0;
    if (vis[i + 1] or !root[i + 1]) continue;
    while (1) {
      if (cur == 0) break;
      vis[cur] = 1;
      if (cur == x) {
        sp = sz;
        found = 1;
      }
      if (g[cur].size())
        cur = g[cur][0];
      else
        cur = 0;
      sz++;
    }
    if (!found) v.emplace_back(sz);
  }
  set<int> s1, s2;
  for (auto x : v) {
    for (auto y : s1) {
      if (y + x <= n) s2.insert(y + x);
    }
    s2.insert(x);
    for (auto y : s2) {
      s1.insert(y);
    }
    s2.clear();
  }
  sp++;
  cout << sp << " ";
  for (auto x : s1) {
    cout << x + sp << " ";
  }
}
