#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  long long n;
  cin >> n;
  bool prime = 1;
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      prime = 0;
      break;
    }
  }
  if (prime) {
    cout << 1 << "\n";
    cout << 0 << "\n";
    return 0;
  }
  long long ctr = 0;
  long long res = 1;
  long long ncp = n;
  long long bolen = 0;
  while (n > 1) {
    bool prime = 1;
    for (long long i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        prime = 0;
        break;
      }
    }
    if (prime) {
      bolen++;
      break;
    }
    for (long long i = 2; i <= n; i++) {
      if (n % i == 0) {
        bolen++;
        n /= i;
        if (ctr < 2) {
          res *= i;
          ctr++;
        }
        break;
      }
    }
  }
  if (bolen < 2) {
    cout << 1 << "\n";
    cout << 0 << "\n";
    return 0;
  }
  if (bolen == 2) {
    cout << 2 << "\n";
    return 0;
  }
  cout << 1 << "\n";
  cout << res << "\n";
  return 0;
}
