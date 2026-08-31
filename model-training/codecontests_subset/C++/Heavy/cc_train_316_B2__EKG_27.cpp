#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 1e4;
const long long INF = 1e9 + 1;
const long long MOD = 998244353;
const long double EPS = 1e-12;
const long double PI = acos(-1);
const unsigned long long PRIME = 31;
void bye() {
  cout << "\n";
  exit(0);
}
vector<vector<int>> g;
vector<bool> used;
vector<int> cnt;
bool f = 0;
int n, s;
void dfs(int v) {
  if (v == s) {
    f = 1;
  }
  used[v] = 1;
  cnt.back()++;
  for (auto to : g[v]) {
    if (!used[to]) {
      dfs(to);
    }
  }
}
int get_up(int s) {
  if (!(long long)(g[s]).size()) {
    return 1;
  }
  return 1 + get_up(g[s][0]);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> s;
  s--;
  g.resize(n);
  used.resize(n);
  vector<int> in(n);
  for (int i = 0; i < n; i++) {
    int p;
    cin >> p;
    if (!p) {
      continue;
    } else {
      p--;
      g[i].push_back(p);
      in[p]++;
    }
  }
  vector<int> q;
  for (int i = 0; i < n; i++) {
    if (!in[i]) {
      f = 0;
      cnt.push_back(0);
      dfs(i);
      if (!f) {
        q.push_back(cnt.back());
      }
    }
  }
  if (!(long long)(q).size()) {
    cout << get_up(s);
    bye();
  }
  vector<bitset<MAXN>> dp((long long)(q).size());
  dp[0][0] = 1;
  dp[0][q[0]] = 1;
  for (int i = 1; i < (long long)(q).size(); i++) {
    dp[i] = dp[i - 1];
    dp[i] |= (dp[i - 1] << q[i]);
  }
  for (int i = 0; i < MAXN; i++) {
    if (dp[(long long)(q).size() - 1][i]) {
      cout << i + get_up(s) << "\n";
    }
  }
  bye();
}
