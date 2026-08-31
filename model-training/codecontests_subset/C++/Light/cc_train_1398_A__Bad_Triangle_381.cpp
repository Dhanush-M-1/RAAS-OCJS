#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long int n;
    cin >> n;
    long long int ar[n + 1];
    for (long long int i = 1; i <= n; i++) cin >> ar[i];
    long long int x = ar[1], y = ar[2], z = ar[n];
    if ((x + y) <= z || (y + z) <= x || (z + x) <= y)
      cout << 1 << " " << 2 << " " << n << endl;
    else
      cout << -1 << endl;
  }
  return 0;
}
