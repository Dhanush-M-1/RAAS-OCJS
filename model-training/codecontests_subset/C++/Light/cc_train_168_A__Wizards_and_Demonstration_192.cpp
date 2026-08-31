#include <bits/stdc++.h>
using namespace std;
void show(vector<int> v) {
  for (auto it = v.begin(); it != v.end(); ++it) {
    cout << *it << " ";
  }
  cout << "\n";
}
void solve() {
  int n, x, y;
  cin >> n >> x >> y;
  int tmp = ceil(double(y * n) / 100) - x;
  cout << max(0, tmp);
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int T;
  solve();
  return 0;
}
