#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, i, max;
  max = 0;
  cin >> n;
  int a[n];
  int f = 0;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    f += a[i];
    if (a[i] > max) max = a[i];
  }
  int k = max;
  while (k * n - 2 * f <= 0) ++k;
  cout << k << "\n";
  return 0;
}
