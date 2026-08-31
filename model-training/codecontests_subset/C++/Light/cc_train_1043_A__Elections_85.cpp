#include <bits/stdc++.h>
using namespace std;
int n, a, sum, mx;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a;
    if (mx < a) mx = a;
    sum += a;
  }
  for (int i = mx;; i++) {
    if (i * n - sum > sum) {
      cout << i;
      return 0;
    }
  }
}
