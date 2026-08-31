#include <bits/stdc++.h>
using namespace std;
int const N = 5e5 + 10;
int oo = 1e9;
int mod = oo + 7;
long long OO = 3e18;
void solve() {
  int a, b, c;
  cin >> a >> b >> c;
  int an = min(b, c / 2) * 3;
  b -= min(b, c / 2);
  an += min(a, b / 2) * 3;
  cout << an << '\n';
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
