#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<int> v1(n), v2(m);
    vector<int> v;
    for (auto &x : v1) cin >> x;
    for (auto &x : v2) cin >> x;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        if (v1[i] == v2[j]) v.push_back(v1[i]);
      }
    if (v.size()) {
      cout << "Yes" << '\n';
      cout << 1 << " " << v[0] << '\n';
    } else
      cout << "No" << '\n';
  }
  return 0;
}
