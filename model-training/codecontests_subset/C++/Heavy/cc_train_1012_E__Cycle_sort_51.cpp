#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
vector<bool> vis;
vector<pair<long long, long long>> eulerWalk(
    vector<vector<pair<long long, long long>>>& gr, vector<long long>& eu,
    int src, vector<long long>& D, vector<long long>& its) {
  vector<pair<long long, long long>> ret, s = {{src, -1}};
  D[src]++;
  while (!s.empty()) {
    auto [x, id] = s.back();
    int y, e;
    long long& it = its[x];
    int end = (int)gr[x].size();
    vis[x] = 1;
    if (it == end) {
      ret.emplace_back(x, id);
      s.pop_back();
      continue;
    }
    tie(y, e) = gr[x][it++];
    if (!eu[e]) {
      D[x]--, D[y]++;
      eu[e] = 1;
      s.emplace_back(y, e);
    }
  }
  return {ret.rbegin(), ret.rend()};
}
int main() {
  cin.tie(0);
  cin.sync_with_stdio(0);
  (cout << fixed).precision(15);
  int n;
  int s;
  cin >> n >> s;
  vector<long long> v(n);
  for (auto& i : (v)) cin >> i;
  vector<long long> o = v;
  sort(begin(o), end(o));
  map<int, int> conv;
  int k = 0;
  auto get_E = [&]() {
    conv.clear();
    vector<vector<pair<long long, long long>>> E;
    auto get = [&](int u) {
      if (conv.count(u) == 0) {
        conv[u] = conv.size();
        E.emplace_back();
      }
      return conv[u];
    };
    for (int i = (0); i < int(n); ++i)
      if (o[i] != v[i]) {
        ++k;
        int a = get(o[i]);
        int b = get(v[i]);
        E[a].emplace_back(b, i);
      }
    return E;
  };
  vector<vector<long long>> ans = {{}};
  auto E = get_E();
  set<int> seen;
  for (int i = (0); i < int(n); ++i)
    if (v[i] != o[i] && !seen.count(conv[v[i]])) {
      ans[0].push_back(i);
      queue<int> q;
      q.push(conv[v[i]]);
      seen.insert(conv[v[i]]);
      while (q.size()) {
        int u = q.front();
        q.pop();
        for (auto& w : (E[u]))
          if (!seen.count(w.first)) {
            q.push(w.first);
            seen.insert(w.first);
          }
      }
    }
  while (ans[0].size() && (int)ans[0].size() + k > s) ans[0].pop_back();
  if (ans[0].size() > 2) {
    for (int i = (1); i < int(ans[0].size()); ++i)
      swap(v[ans[0][i - 1]], v[ans[0][i]]);
    reverse(begin(ans[0]), end(ans[0]));
    s -= ans[0].size();
  } else {
    ans = {};
  }
  E = get_E();
  vis.assign(E.size(), 0);
  vector<long long> used(n);
  int m = E.size();
  vector<long long> D(m), its(m);
  for (int i = (0); i < int(E.size()); ++i)
    if (!vis[i]) {
      auto t = eulerWalk(E, used, i, D, its);
      t.erase(t.begin());
      s -= t.size();
      ans.emplace_back();
      for (auto& i : (t)) ans.back().push_back(i.second);
    }
  if (s < 0) {
    cout << -1 << endl;
  } else {
    cout << ans.size() << endl;
    for (auto& i : (ans)) {
      cout << i.size() << endl;
      for (auto& j : (i)) cout << j + 1 << " ";
      cout << endl;
    }
  }
}
