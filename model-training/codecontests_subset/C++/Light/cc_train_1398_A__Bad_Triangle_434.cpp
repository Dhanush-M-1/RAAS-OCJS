#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, a[100000];
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n;
    for (int j = 0; j < n; j++) {
      cin >> a[j];
    }
    if (a[0] + a[1] <= a[n - 1])
      cout << 1 << ' ' << 2 << ' ' << n << endl;
    else
      cout << -1 << endl;
  }
  return 0;
}
