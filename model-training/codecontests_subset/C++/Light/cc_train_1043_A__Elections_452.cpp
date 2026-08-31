#include <bits/stdc++.h>
using namespace std;
long long i, j, k, n, x, sum, mx, a[100009];
int main() {
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    mx = max(mx, a[i]);
  }
  while (1) {
    long long sum1 = 0;
    for (i = 0; i < n; i++) sum1 += mx - a[i];
    if (sum1 > sum) {
      cout << mx << endl;
      return 0;
    }
    mx++;
  }
}
