#include <bits/stdc++.h>
using namespace std;
long long a, b, c, k, z, mod, m, h, n, x;
vector<int> vec;
string s;
int dp[100005] = {};
void solve() {
  int l, r, d;
  cin >> l >> r >> d;
  if (d > r || d < l) {
    cout << d;
    return;
  }
  cout << d * (r / d + 1);
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cout << setprecision(10);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
    cout << '\n';
  }
  return 0;
}
