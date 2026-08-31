#include <bits/stdc++.h>
using namespace std;
void InputSetup() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
}
void solve() {
  int n, m;
  cin >> n >> m;
  int p[n];
  for (int i = 0; i < n; ++i) {
    cin >> p[i];
    --p[i];
  }
  vector<vector<int>> move(n);
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    move[--u].push_back(--v);
  }
  set<int> youShallNotPass;
  for (int i = n - 2; i >= 0; --i) {
    int ct = 0;
    for (auto x : move[p[i]]) {
      ++ct;
      if (x == p[n - 1]) continue;
      if (youShallNotPass.find(x) != youShallNotPass.end()) continue;
      --ct;
    }
    if ((int)youShallNotPass.size() + 1 == ct) continue;
    youShallNotPass.insert(p[i]);
  }
  cout << n - 1 - youShallNotPass.size();
}
int main(void) {
  auto start = chrono::high_resolution_clock::now();
  InputSetup();
  solve();
  auto finish = chrono::high_resolution_clock::now();
  cerr << "Time elapsed: "
       << (chrono::duration<long double>(finish - start)).count() << "s\n";
}
