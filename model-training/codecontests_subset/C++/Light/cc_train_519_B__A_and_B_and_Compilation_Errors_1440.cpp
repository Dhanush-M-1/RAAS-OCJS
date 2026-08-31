#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  int ans = 0, res = 0;
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    ans ^= x;
  }
  for (int i = 0; i < n - 1; ++i) {
    int x;
    cin >> x;
    ans ^= x, res ^= x;
  }
  cout << ans << "\n";
  for (int i = 0; i < n - 2; ++i) {
    int x;
    cin >> x;
    res ^= x;
  }
  cout << res << "\n";
  return 0;
}
