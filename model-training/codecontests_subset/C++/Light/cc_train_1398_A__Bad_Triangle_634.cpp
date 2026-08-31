#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  vector<int> v(n);
  for (int i = 0; i < n; i++) cin >> v[i];
  if (v[0] + v[1] <= v.back())
    cout << "1 2 " << n << "\n";
  else
    cout << "-1\n";
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tst;
  cin >> tst;
  while (tst--) {
    solve();
  }
}
