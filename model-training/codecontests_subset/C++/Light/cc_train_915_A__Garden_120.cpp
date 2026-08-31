#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n];
  int ans = -1;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(&a[0], &a[n]);
  for (int i = n - 1; i >= 0; i--)
    if (k % a[i] == 0) {
      ans = k / a[i];
      break;
    }
  cout << ans << "\n";
  return 0;
}
