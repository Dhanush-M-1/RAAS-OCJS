#include <bits/stdc++.h>
using namespace std;
vector<vector<long long> > g;
vector<bool> used1;
vector<long long> sorted;
vector<long long> d;
void dfs(long long v) {
  used1[v] = true;
  for (long long to : g[v]) dfs(to);
  sorted.push_back(v);
}
void dfs1(long long v, long long depth) {
  d[v] = depth;
  for (long long to : g[v]) dfs1(to, depth + 1);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  g.resize(n);
  used1.assign(n, false);
  vector<long long> cnt(n, 0);
  vector<pair<long long, long long> > edges;
  for (long long i = 0; i < n; i++) {
    long long p;
    cin >> p;
    if (p == 0) continue;
    p--;
    g[p].push_back(i);
    edges.push_back({i, p});
    cnt[p]++;
    cnt[i]++;
  }
  for (long long i = 0; i < n; i++)
    if (!used1[i]) dfs(i);
  d.resize(n);
  dfs1(sorted.back(), 0);
  vector<bool> used(n, false);
  vector<long long> ans;
  for (pair<long long, long long> x : edges) g[x.first].push_back(x.second);
  set<pair<long long, long long> > s;
  for (long long i = 0; i < n; i++) {
    if (cnt[i] % 2 == 0) s.insert(pair<long long, long long>(-d[i], i));
  }
  while ((long long)(s).size()) {
    long long v = s.begin()->second;
    s.erase(s.begin());
    used[v] = true;
    ans.push_back(v);
    for (long long to : g[v]) {
      if (used[to] || cnt[to] == 0) continue;
      if (cnt[to] % 2 == 0)
        s.erase(pair<long long, long long>(-d[to], to));
      else
        s.insert(pair<long long, long long>(-d[to], to));
      cnt[to]--;
    }
  }
  if ((long long)(ans).size() != n) {
    cout << "NO";
    return 0;
  }
  cout << "YES" << '\n';
  for (long long x : ans) cout << ++x << '\n';
  return 0;
}
