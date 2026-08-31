#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
void solve() {
  int n;
  cin >> n;
  vector<int> v(n), h(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i] >> h[i];
  }
  int ans = 0;
  for (int i = 1; i < n - 1; i++) {
    if (v[i] - v[i - 1] > h[i]) {
      ans++;
    } else if (v[i + 1] - v[i] > h[i]) {
      v[i] += h[i];
      ans++;
    }
  }
  cout << (n > 2 ? ans + 2 : ans + n) << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int t;
  solve();
}
