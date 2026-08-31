#include <bits/stdc++.h>
using namespace std;
int n, a[105], amax, s;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    s += a[i];
    amax = max(amax, a[i]);
  }
  for (int i = amax;; i++) {
    if (n * i - s > s) {
      cout << i;
      return 0;
    }
  }
  return 0;
}
