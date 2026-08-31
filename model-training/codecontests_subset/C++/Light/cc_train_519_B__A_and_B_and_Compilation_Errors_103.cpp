#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long t = 1;
  while (t--) {
    long long n;
    cin >> n;
    long long a = 0, b = 0, c = 0;
    for (long long i = 0; i < n; i++) {
      long long u;
      cin >> u;
      a += u;
    }
    for (long long i = 0; i < n - 1; i++) {
      long long u;
      cin >> u;
      b += u;
    }
    cout << a - b << endl;
    for (long long i = 0; i < n - 2; i++) {
      long long u;
      cin >> u;
      c += u;
    }
    cout << b - c << endl;
  }
}
