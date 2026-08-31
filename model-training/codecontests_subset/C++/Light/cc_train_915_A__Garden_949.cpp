#include <bits/stdc++.h>
using namespace std;
int n, k, a[100 + 5], ans = 100000000;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  sort(a, a + n);
  if (k == a[n - 1]) {
    cout << 1 << endl;
    return 0;
  }
  for (int i = 0; i < n; ++i) {
    if (k % a[i] == 0) {
      ans = min(ans, k / a[i]);
    }
  }
  cout << ans << endl;
  return 0;
}
