#include <bits/stdc++.h>
using namespace std;
const long long MOD = 100000000LL;
const long long MAX = 100010LL;
template <class T>
T abs(T x) {
  return x > 0 ? x : -x;
}
template <typename T>
T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <typename T>
T power(T x, T y, long long m = MOD) {
  T ans = 1;
  while (y > 0) {
    if (y & 1LL) ans = (ans * x) % m;
    y >>= 1LL;
    x = (x * x) % m;
  }
  return ans % m;
}
int main() {
  long long q;
  cin >> q;
  int cnt = 0;
  long long start = q;
  long long rem = 1;
  for (long long i = 2; i * i <= q; ++i) {
    while (q % i == 0) {
      q /= i;
      ++cnt;
      if (cnt <= 2) rem *= i;
    }
  }
  if (q > 1) {
    ++cnt;
    if (cnt <= 2) rem *= q;
  }
  if (cnt == 2)
    cout << "2";
  else {
    cout << "1" << '\n';
    if (cnt <= 1)
      cout << "0";
    else
      cout << rem;
  }
  return 0;
}
