#include <bits/stdc++.h>
using namespace std;
bool prime(long long n) {
  for (long long d = 2; d * d <= n; d++)
    if (n % d == 0) return false;
  return true;
}
int main() {
  long long n;
  cin >> n;
  if (prime(n)) {
    cout << 1 << endl << 0;
    return 0;
  }
  for (long long d = 2; d * d <= n; d++)
    if (n % d == 0) {
      for (long long j = 2; j * j <= d; j++)
        if (d % j == 0 && prime(j) && prime(d / j)) {
          cout << 1 << endl << d;
          return 0;
        }
      for (long long j = 2; j * j <= n / d; j++)
        if ((n / d) % j == 0 && prime(j) && prime((n / d) / j)) {
          cout << 1 << endl << n / d;
          return 0;
        }
    }
  cout << 2;
  return 0;
}
