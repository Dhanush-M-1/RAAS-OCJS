#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> x(n), v(n);
  for (int i = 0; i < n; ++i) cin >> x[i] >> v[i];
  int ans = min(n, 2);
  int pr = x[0];
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - v[i] > pr) {
      ans++;
      pr = x[i];
    } else {
      if (x[i] + v[i] < x[i + 1]) {
        pr = x[i] + v[i];
        ans++;
      } else
        pr = x[i];
    }
  }
  cout << ans;
}
