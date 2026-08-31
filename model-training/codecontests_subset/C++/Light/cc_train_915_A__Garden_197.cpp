#include <bits/stdc++.h>
#pragma comment(linker, "/stack:20000000")
#pragma GCC optimize("Ofast,unroll-loops,no-stack-protector")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
inline bool isPrime(long long int n) {
  if (n <= 1) {
    return false;
  }
  if (n <= 3) {
    return true;
  }
  if (n % 2 == 0 || n % 3 == 0) {
    return false;
  }
  for (int i = 5; i * i <= n; i = i + 6) {
    if (n % i == 0 || n % (i + 2) == 0) {
      return false;
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(0);
  long long int t, n, a, b, c, d, e, f, x, y;
  cin >> a >> b;
  c = INT_MAX;
  for (int i = 0; i < a; i++) {
    cin >> x;
    if (b % x == 0) {
      c = min(c, b / x);
    }
  }
  cout << c << '\n';
  return 0;
}
