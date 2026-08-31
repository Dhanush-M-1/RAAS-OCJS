#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, a[100000];
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    if (a[0] + a[1] <= a[n - 1]) {
      cout << 0 + 1 << " " << 1 + 1 << " " << n << "\n";
    } else
      cout << "-1\n";
  }
}
