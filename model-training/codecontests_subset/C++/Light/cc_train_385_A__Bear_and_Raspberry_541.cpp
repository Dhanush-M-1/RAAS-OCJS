#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, r, x;
  cin >> n >> r;
  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int ans = 0;
  for (int i = 1; i < n; i++) {
    ans = max(a[i - 1] - a[i] - r, ans);
  }
  cout << ans << endl;
  return 0;
}
