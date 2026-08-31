#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  long long sum0 = 0, sum1 = 0, sum2 = 0, x;
  for (int i = 0; i < n; i++) {
    cin >> x;
    sum0 += x;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    sum1 += x;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    sum2 += x;
  }
  cout << sum0 - sum1 << '\n' << sum1 - sum2;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int test = 1;
  while (test--) {
    solve();
    cout << '\n';
  }
  return 0;
}
