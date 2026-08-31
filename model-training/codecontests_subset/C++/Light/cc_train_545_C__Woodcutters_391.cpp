#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e6 + 7;
const int MOD = 1e6 + 9;
void solve() {
  long long n;
  cin >> n;
  long long x[n + 100], h[n + 100];
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  if (n == 1) {
    cout << 1 << endl;
    return;
  }
  long long ans = 2;
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > x[i - 1]) {
      ans++;
    } else if (x[i] + h[i] < x[i + 1]) {
      ans++;
      x[i] += h[i];
    }
  }
  cout << ans << endl;
}
int main() {
  long long t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
