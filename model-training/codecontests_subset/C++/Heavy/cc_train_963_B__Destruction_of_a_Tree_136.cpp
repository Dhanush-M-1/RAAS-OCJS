#include <bits/stdc++.h>
using namespace std;
int n;
vector<vector<int>> adj;
vector<vector<int>> dp;
vector<int> parells;
vector<bool> erased;
int calc_par(int a, int ib) {
  if (dp[a][ib] != -1) return dp[a][ib];
  int sum = 1;
  int ia;
  int b = adj[a][ib];
  for (int i = 0; i < adj[b].size(); ++i) {
    if (adj[b][i] == a) {
      ia = i;
      continue;
    }
    sum += calc_par(b, i);
  }
  int ret = sum % 2;
  dp[b][ia] = 1 - ret;
  dp[a][ib] = ret;
  return ret;
}
int main() {
  cin >> n;
  adj = vector<vector<int>>(n, vector<int>());
  dp = vector<vector<int>>(n, vector<int>());
  erased = vector<bool>(n, false);
  parells = vector<int>(n, 0);
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    if (a == 0) continue;
    a--;
    adj[i].push_back(a);
    adj[a].push_back(i);
    dp[i].push_back(-1);
    dp[a].push_back(-1);
  }
  if (n % 2 == 0)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    set<pair<int, int>> S;
    for (int i = 0; i < n; ++i) {
      int p = 0;
      for (int j = 0; j < adj[i].size(); ++j) {
        p += 1 - calc_par(i, j);
      }
      S.insert(pair<int, int>(p, i));
      parells[i] = p;
    }
    for (int ii = 0; ii < n; ++ii) {
      auto v = S.begin()->second;
      S.erase(S.begin());
      printf("%d\n", v + 1);
      for (int i = 0; i < adj[v].size(); ++i) {
        int v2 = adj[v][i];
        if (erased[v2]) continue;
        S.erase(pair<int, int>(parells[v2], v2));
        parells[v2]--;
        S.insert(pair<int, int>(parells[v2], v2));
      }
      erased[v] = true;
    }
  }
}
