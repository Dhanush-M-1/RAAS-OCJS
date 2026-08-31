#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
void solve() {
  int n, x, y;
  cin >> n >> x >> y;
  int r1, res;
  r1 = y * n;
  res = (r1 + 99) / 100 - x;
  cout << (res > 0 ? res : 0) << endl;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
