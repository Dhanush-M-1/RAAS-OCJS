#include <bits/stdc++.h>
using namespace std;
int n;
pair<int, long long> par[100010];
vector<int> adj[100010];
long long need[100010];
long long cur[100010];
long long bad(long long a, long long b) {
  double x = (double)a * b;
  if (x < -2e17) {
    cout << "NO\n";
    exit(0);
  }
  return a * b;
}
long long dfs(int v) {
  for (int e : adj[v]) {
    cur[v] += dfs(e);
    bad(cur[v], 1);
  }
  long long diff = cur[v] - need[v];
  if (diff >= 0) {
    return bad(diff, 1);
  } else {
    return bad(diff, par[v].second);
  }
}
int main() {
  cin.tie(0)->sync_with_stdio(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> cur[i];
  }
  for (int i = 0; i < n; i++) {
    cin >> need[i];
  }
  for (int i = 1; i < n; i++) {
    cin >> par[i].first >> par[i].second;
    par[i].first--;
    adj[par[i].first].push_back(i);
  }
  par[0].second = 1;
  dfs(0);
  if (need[0] > cur[0]) {
    cout << "NO\n";
  } else {
    cout << "YES\n";
  }
  return 0;
}
