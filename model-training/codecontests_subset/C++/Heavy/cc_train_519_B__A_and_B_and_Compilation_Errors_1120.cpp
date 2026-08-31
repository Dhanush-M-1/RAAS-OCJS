#include <bits/stdc++.h>
using namespace std;
const long long mod = (long long)1e9 + 7;
void solve() {
  int n;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; ++i) {
    cin >> b[i];
  }
  for (int i = 0; i < n - 2; ++i) {
    cin >> c[i];
  }
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  int ans = a[n - 1];
  for (int i = 0; i < n - 1; ++i) {
    if (a[i] == b[i]) {
      continue;
    } else {
      ans = a[i];
      break;
    }
  }
  cout << ans << '\n';
  ans = b[n - 2];
  for (int i = 0; i < n - 2; ++i) {
    if (c[i] == b[i]) {
      continue;
    } else {
      ans = b[i];
      break;
    }
  }
  cout << ans << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int test = 1;
  while (test--) {
    solve();
    cout << '\n';
  }
  return 0;
}
