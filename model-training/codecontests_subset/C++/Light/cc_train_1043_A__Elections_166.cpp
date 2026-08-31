#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, t = 0, i, sum = 0;
  while (cin >> n) {
    int a[1005];
    for (i = 1; i <= n; i++) {
      cin >> a[i];
      if (a[i] >= t) t = a[i];
      sum += a[i];
    }
    for (i = t;; i++)
      if (i * n - sum > sum) {
        cout << i << endl;
        break;
      }
  }
  return 0;
}
