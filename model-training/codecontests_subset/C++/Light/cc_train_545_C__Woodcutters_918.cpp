#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  long long x[n], h[n];
  for (int i = 0; i < n; ++i) {
    cin >> x[i] >> h[i];
  }
  long long ans = min(2, n);
  for (int i = 1; i + 1 < n; ++i) {
    if (x[i] - h[i] > x[i - 1]) {
      ans++;
      continue;
    }
    if (x[i] + h[i] < x[i + 1]) {
      ans++;
      x[i] += h[i];
    }
  }
  cout << ans << endl;
}
