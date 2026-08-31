#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
int n;
vector<vector<int>> ed;
vector<int> subt, answer;
void init() {
  ed = vector<vector<int>>(n + 1);
  subt = vector<int>(n + 1);
  answer = vector<int>(n + 1);
}
int dfs(int fa, int u) {
  int val = 1;
  for (auto i : ed[u]) {
    if (i != fa) {
      val = val + dfs(u, i);
    }
  }
  subt[u] = val;
  return val;
}
void solve(int fa, int u) {
  for (auto i : ed[u]) {
    if (i != fa && subt[i] % 2 == 0) solve(u, i);
  }
  cout << u << "\n";
  for (auto i : ed[u]) {
    if (i != fa && subt[i] % 2) solve(u, i);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  init();
  vector<int> inp(n);
  for (int i = 0; i < n; i++) {
    cin >> inp[i];
  }
  for (int i = 0; i < n; i++) {
    if (inp[i]) {
      int u = i + 1, v = inp[i];
      ed[u].push_back(v);
      ed[v].push_back(u);
    }
  }
  if (n % 2 == 0) {
    cout << "NO\n";
    return 0;
  }
  dfs(0, 1);
  cout << "YES\n";
  solve(0, 1);
  return 0;
}
