#include <bits/stdc++.h>
using namespace std;
bool cmp(int x, int y) { return x > y; }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  int ma = INT_MIN;
  int mi = INT_MAX;
  for (int i = 0; i < n; i++) {
    if (a[i] <= 500000) {
      ma = max(ma, a[i]);
    }
  }
  for (int i = 0; i < n; i++) {
    if (a[i] > 500000) {
      mi = min(mi, a[i]);
    }
  }
  int ans = 0;
  if (ma != INT_MIN) {
    ans += (ma - 1);
  }
  if (mi != INT_MAX) {
    ans = max(ans, 1000000 - mi);
  }
  cout << ans;
  return 0;
}
