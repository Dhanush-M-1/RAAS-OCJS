#include <bits/stdc++.h>
using namespace std;
const int dx[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
const int dy[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
const int MAX = 2 * 1000 * 1000 + 10;
const long long INF = 1e18;
const int MOD = 1e9 + 7;
void sol() {
  int n;
  cin >> n;
  vector<int> v(n);
  for (int &i : v) cin >> i;
  int a = 0, b = 1;
  for (int i = 2; i < n; i++) {
    if (v[a] + v[b] <= v[i]) {
      cout << a + 1 << " " << b + 1 << " " << i + 1 << '\n';
      return;
    }
    if (v[i] < v[b]) {
      if (v[b] < v[a]) a = b;
      b = i;
    }
  }
  cout << -1 << '\n';
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t = 1;
  cin >> t;
  while (t--) {
    sol();
  }
}
