#include <bits/stdc++.h>
using namespace std;
long long int gcd(long long int a, long long int b) {
  return b == 0 ? a : gcd(b, a % b);
}
long long int lcm(long long int a, long long int b) {
  return (a * b) / gcd(a, b);
}
bool isprime(long long int x) {
  for (long long int i = 2; i <= sqrt(x); i++) {
    if (x % i == 0) return false;
  }
  return true;
}
long long int modpow(long long int x, long long int y) {
  x %= 1000000007;
  long long int res = 1;
  while (y > 0) {
    if (y & 1) res *= x % 1000000007;
    y = y >> 1;
    x = x * x % 1000000007;
  }
  return res % 1000000007;
}
long long int ncr(long long int n, long long int k) {
  long long int res = 1;
  if (k > n - k) k = n - k;
  for (long long int i = 0; i < (long long int)k; i++) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
long long int bintodec(long long int n) {
  long long int decimal = 0, i = 0, rem;
  while (n != 0) {
    rem = n % 10;
    n /= 10;
    decimal += rem * pow(2, i);
    ++i;
  }
  return decimal;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long int i = 0, n, aa, t;
  vector<long long int> a;
  cin >> t;
  while (t--) {
    cin >> n;
    for (long long int i = 0; i < (long long int)n; i++) {
      cin >> aa;
      a.push_back(aa);
    }
    i = 0;
    bool f = false;
    if ((a[0] + a[1]) <= a[a.size() - 1]) {
      cout << i + 1 << " " << i + 2 << " " << n << '\n';
      f = true;
    }
    if (f == false) cout << -1 << '\n';
    a.clear();
  }
  return 0;
}
