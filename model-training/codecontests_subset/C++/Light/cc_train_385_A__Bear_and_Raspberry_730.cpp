#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int d[n];
  for (int i = 0; i < n; i++) cin >> d[i];
  int a[n - 1];
  for (int i = 0; i < n - 1; i++) {
    if ((d[i] - d[i + 1] - c) > 0) {
      a[i] = (d[i] - d[i + 1] - c);
    } else
      a[i] = 0;
  }
  int max = a[0];
  for (int i = 0; i < n - 1; i++) {
    max = ((a[i]) > (max) ? (a[i]) : (max));
  }
  cout << max;
  return 0;
}
