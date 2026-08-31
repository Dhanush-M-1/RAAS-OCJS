#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  int ans = 0;
  for (int i = n - 1; i >= 0; i--) {
    if (k % a[i] == 0) {
      ans = k / a[i];
      break;
    }
  }
  cout << ans << endl;
}
