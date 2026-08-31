#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int inf = 1e9 + 10;
const ll inf_ll = 1e18 + 10;
vector<int> toposort(vector<vector<int>> adj) {
  vector<int> out, stk, in(adj.size(), 0);
  for (int i = 0; i < adj.size(); i++)
    for (int j : adj[i]) in[j]++;
  for (int i = 0; i < adj.size(); i++)
    if (!in[i]) stk.push_back(i);
  while (!stk.empty()) {
    out.push_back(stk.back());
    stk.pop_back();
    for (int j : adj[out.back()])
      if (!--in[j]) stk.push_back(j);
  }
  return out;
}
mt19937 randint(chrono::steady_clock::now().time_since_epoch().count());
inline int uniform_randint(const int a, const int b) {
  return uniform_int_distribution<int>(a, b)(randint);
}
inline double rand01() { return uniform_randint(0, INT_MAX) / double(INT_MAX); }
vector<int> random_sample(int k, int n) {
  vector<int> r(k);
  std::iota(r.begin(), r.end(), 0);
  double w = exp(log(rand01()) / k);
  int i = k - 1;
  while (i < n) {
    i += 1 + floor(log(rand01()) / log(1 - w));
    if (i < n) {
      r[uniform_randint(0, k - 1)] = i;
      w *= exp(log(rand01()) / k);
    }
  }
  return r;
}
vector<vector<int>> adj, tadj, badj;
vector<int> vin, vout, v, dp, p, d;
int tt;
void dfs(int i) {
  vin[i] = tt++;
  v[i] = 1;
  for (int j : adj[i]) {
    if (!v[j]) {
      tadj[i].push_back(j);
      d[j] = d[i] + 1;
      dfs(j);
      if (d[p[i]] > d[p[j]]) p[i] = p[j];
      dp[i] += dp[j];
    } else {
      dp[i]++, dp[j]--;
      badj[i].push_back(j);
      if (d[p[i]] > d[j]) p[i] = j;
    }
  }
  vout[i] = tt - 1;
}
void dfs3(int i) {
  dp[i] = dp[i] > 1;
  dp[i] = dp[i] || dp[p[i]];
  for (int j : tadj[i]) {
    dfs3(j);
  }
}
bool solve() {
  int n = adj.size();
  int r = uniform_randint(0, n - 1);
  v.assign(n, 0);
  dp.assign(n, 0);
  p.assign(n, -1);
  iota((p).begin(), (p).end(), 0);
  d.assign(n, 0);
  vin.assign(n, 0);
  vout.assign(n, 0);
  tadj.assign(n, {});
  badj.assign(n, {});
  tt = 0;
  dfs(r);
  for (int i = 0; i < n; i++)
    for (int j : badj[i]) {
      if (!(vin[j] <= vin[i] && vout[i] <= vout[j])) {
        return 0;
      }
    }
  0;
  0;
  dfs3(r);
  0;
  0;
  vector<int> ans;
  for (int i = 0; i < n; i++)
    if (!dp[i]) ans.push_back(i);
  0;
  if (ans.size() * 5 < n) {
    cout << "-1\n";
    return 1;
  } else {
    sort((ans).begin(), (ans).end());
    for (int i = 0; i < ans.size(); i++)
      cout << ans[i] + 1 << " \n"[i + 1 == ans.size()];
    return 1;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    adj.assign(n, {});
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;
      x--, y--;
      adj[x].push_back(y);
    }
    bool ok = 0;
    for (int i = 0; i < 60; i++) {
      ok = ok || solve();
      if (ok) break;
    }
    if (!ok) cout << "-1\n";
  }
}
