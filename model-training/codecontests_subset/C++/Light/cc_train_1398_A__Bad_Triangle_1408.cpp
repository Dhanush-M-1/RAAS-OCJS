#include <bits/stdc++.h>
using namespace std;
int main() {
  int t = 0;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    if (a[0] + a[1] <= a[n - 1]) {
      cout << 1 << " " << 2 << " " << n << "\n";
    } else
      cout << -1 << "\n";
  }
}
