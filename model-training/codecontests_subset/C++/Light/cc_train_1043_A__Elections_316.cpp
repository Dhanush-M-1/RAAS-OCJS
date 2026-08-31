#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n + 1];
  int mx = INT_MIN;
  int s = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mx = max(a[i], mx);
    s += a[i];
  }
  int i = 0;
  for (i = mx;; i++) {
    if ((i * n) > 2 * s) {
      break;
    }
  }
  cout << i << "\n";
  return 0;
}
