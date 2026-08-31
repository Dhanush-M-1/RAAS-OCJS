#include <bits/stdc++.h>
using namespace std;
int thuan(long a[], long n, long m) {
  int s = 0;
  for (int i = 0; i < m; i++) {
    s = s + n - a[i];
  }
  return s;
}
int main() {
  long max = 0, n;
  cin >> n;
  long a[n], s1 = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n; i++) {
    if (a[i] > max) {
      max = a[i];
    }
    s1 = s1 + a[i];
  }
  while (1) {
    if (thuan(a, max, n) <= s1) {
      max++;
    } else {
      break;
    }
  }
  cout << max;
  return 0;
}
