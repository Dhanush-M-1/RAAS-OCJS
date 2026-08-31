#include <bits/stdc++.h>
using namespace std;
int inf = 1000000007;
int k;
int dp[1000000 + 50];
vector<int> adj[1000000 + 50];
int h[1000000 + 50];
pair<int, int> p[1000000 + 50];
void hei(int v, int par, int curh) {
  h[v] = curh;
  for (auto bc : adj[v]) {
    if (bc == par) continue;
    hei(bc, v, curh + 1);
  }
}
void pre(int v, int par) {
  p[v] = make_pair(inf, 0);
  for (auto bc : adj[v]) {
    if (bc == par) continue;
    h[bc] = h[v] + 1;
    pre(bc, v);
    if (p[bc].first <= h[v]) {
      p[v].second += p[bc].second;
      p[v].first = min(p[v].first, p[bc].first);
    }
  }
  if (adj[v].size() == 1 && v != 1) {
    p[v] = make_pair(h[v] - k, 1);
  }
}
void calc(int v, int par) {
  dp[v] = (v >= 1 && adj[v].size() == 1);
  for (auto bc : adj[v]) {
    if (bc == par) continue;
    calc(bc, v);
    int tmp = p[v].second;
    if (p[bc].first <= h[v]) tmp -= p[bc].second;
    dp[v] = max(dp[v], tmp + dp[bc]);
  }
}
int main() {
  int n, x;
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    cin >> x;
    adj[i].push_back(x);
    adj[x].push_back(i);
  }
  pre(1, 0);
  calc(1, 0);
  cout << dp[1];
}
