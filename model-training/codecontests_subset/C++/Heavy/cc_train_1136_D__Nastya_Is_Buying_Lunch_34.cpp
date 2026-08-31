#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const int mod = 1e9 + 7;
const double eps = 1e-8;
int n, m;
int p[maxn];
set<int> to[maxn];
void solve() {
  vector<int> sk;
  int nb = p[n];
  for (int i = n - 1; i >= 1; i--) {
    bool flag = false;
    flag |= !to[nb].count(p[i]);
    for (auto iter = sk.begin(); iter != sk.end() && !flag; iter++) {
      flag |= !to[*iter].count(p[i]);
    }
    if (flag) sk.push_back(p[i]);
  }
  cout << n - 1 - sk.size() << endl;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> p[i];
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    to[v].insert(u);
  }
  solve();
  return 0;
}
