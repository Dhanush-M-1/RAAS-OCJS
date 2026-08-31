#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    long long i;
    cin >> n;
    long long a[n];
    for (i = 0; i < n; i++) {
      cin >> a[i];
    }
    if (a[0] + a[1] <= a[n - 1])
      cout << 1 << " " << 2 << " " << n << "\n";
    else
      cout << -1 << "\n";
  }
  return 0;
}
