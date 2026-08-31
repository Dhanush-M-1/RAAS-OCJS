#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<int> a;
  a.resize(n);
  for (int i = 0; i < (n); i++) cin >> a[i];
  int ans = INT_MAX;
  ans = min(ans, a[n - 1] - 1);
  ans = min(ans, 1000000 - a[0]);
  for (int i = 0; i < n - 1; i++) {
    ans = min(ans, max(a[i] - 1, 1000000 - a[i + 1]));
  }
  cout << ans;
}
