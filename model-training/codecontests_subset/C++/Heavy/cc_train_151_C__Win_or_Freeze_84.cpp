#include <bits/stdc++.h>
using namespace std;
bool isprime(long long n) {
  long long i;
  for (i = 2; i <= sqrt(n); i++)
    if (n % i == 0) return false;
  return true;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  if (fopen("inp.txt", "r")) {
    freopen("inp.txt", "r", stdin);
    freopen("outp.txt", "w", stdout);
  }
  long long n, i;
  cin >> n;
  if (n == 1 || isprime(n)) {
    cout << 1 << endl << 0;
    return 0;
  } else {
    long long g = 0, h = 0;
    for (i = 2; i <= sqrt(n); i++)
      if (n % i == 0 && isprime(i)) {
        if (!g)
          g = i;
        else
          h = i;
      }
    long long ans, x = g * g, y = h * h, z = g * h;
    if (((ans = x) && n % x == 0 && n != x) ||
        ((ans = y) && n % y == 0 && n != y) || ((ans = z) && n != z))
      cout << 1 << endl << ans;
    else
      cout << 2;
  }
  return 0;
}
