#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  int k = 0;
  int sum = 0;
  int sum2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (k == 0) {
      k = a[i];
    }
    if (k > 0) {
      k = max(k, a[i]);
    }
    sum = sum + a[i];
  }
  for (int i = 0; i < n; i++) {
    sum2 = sum2 + (k - a[i]);
  }
  while (sum > sum2) {
    k += 1;
    sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum2 = sum2 + (k - a[i]);
    }
  }
  if (sum == sum2) {
    k += 1;
  }
  cout << k << '\n';
  return 0;
}
