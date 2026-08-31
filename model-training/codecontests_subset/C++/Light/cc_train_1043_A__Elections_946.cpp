#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  int sm = 0, mx = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    sm += x;
    mx = max(mx, x);
  }
  cout << max(mx, (2 * sm + n) / n);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int tst = 1;
  while (tst--) solve();
  return 0;
}
