#include <bits/stdc++.h>
using namespace std;
int N, rt;
vector<int> Adj[200005];
bool dp[200005];
void dfs0(int u) {
  for (int k = 0; k < Adj[u].size(); k++) {
    int v = Adj[u][k];
    dfs0(v);
    if (dp[v] == 0) dp[u] = !dp[u];
  }
}
vector<int> od;
void dfs1(int u) {
  for (int k = 0; k < Adj[u].size(); k++) {
    int v = Adj[u][k];
    if (dp[v] == 1) dfs1(v);
  }
  od.push_back(u);
  for (int k = 0; k < Adj[u].size(); k++) {
    int v = Adj[u][k];
    if (dp[v] == 0) dfs1(v);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin >> N;
  int u, v;
  for (int i = 1; i <= N; i++) {
    cin >> v;
    if (v == 0)
      rt = i;
    else
      Adj[v].push_back(i);
  }
  dfs0(rt);
  if (dp[rt]) {
    cout << "NO";
    return 0;
  }
  cout << "YES" << endl;
  dfs1(rt);
  for (int k = 0; k < od.size(); k++) cout << od[k] << endl;
  return 0;
}
