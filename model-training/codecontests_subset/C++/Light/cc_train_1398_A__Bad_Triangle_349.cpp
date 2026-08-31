#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, x, a = 0, b = -1;
    cin >> n;
    for (int i = 0; i < n; i++) {
      cin >> x;
      if (i == 0 || i == 1) a += x;
      if (i == n - 1 && x >= a) b = i + 1;
    }
    if (b == -1)
      cout << -1 << "\n";
    else
      cout << 1 << " " << 2 << " " << b << "\n";
  }
  return 0;
}
