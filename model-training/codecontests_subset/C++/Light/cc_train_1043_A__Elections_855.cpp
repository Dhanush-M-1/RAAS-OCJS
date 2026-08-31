#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, k, max = 0, sum = 0;
  cin >> n;
  int a[n];
  for (i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    if (a[i] > max) {
      max = a[i];
    }
  }
  for (k = max;; k++) {
    if ((n * k) - sum > sum) {
      cout << k;
      break;
    }
  }
  return 0;
}
