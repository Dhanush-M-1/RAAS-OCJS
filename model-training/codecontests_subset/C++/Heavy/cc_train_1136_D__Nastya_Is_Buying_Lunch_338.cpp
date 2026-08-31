#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(nullptr);
  ios::sync_with_stdio(false);
  cout.precision(12);
  cout.setf(ios_base::fixed, ios_base::floatfield);
  int n, m, p[300000];
  multimap<int, int> q;
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> p[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    q.emplace(u - 1, v - 1);
  }
  unordered_set<int> rm;
  rm.insert(p[n - 1] - 1);
  int rmc = 1, ans = 0;
  for (int i = n - 2; i >= 0; i--) {
    auto er = q.equal_range(p[i] - 1);
    int ht = rmc;
    for (auto it = er.first; it != er.second; ++it) {
      if (rm.count(it->second)) ht--;
    }
    if (ht == 0) {
      ans++;
    } else {
      rmc++;
      rm.insert(p[i] - 1);
    }
  }
  cout << ans << endl;
  return 0;
}
