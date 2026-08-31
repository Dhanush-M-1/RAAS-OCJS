#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y);
bool isPrime(long long n);
long long modInv(long long a, long long b);
long long gcdExtended(long long a, long long b, long long *x, long long *y);
long long mpower(long long a, long long b, long long p);
const long long inf = (long long)1e17;
const long long N = (long long)3e5 + 5;
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long n;
  cin >> n;
  vector<long long> a(n), b(n - 1), c(n - 2);
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (long long i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  for (long long i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  long long fnd = -1;
  for (long long i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      fnd = a[i];
      break;
    }
  }
  if (fnd == -1) {
    cout << a[n - 1];
  } else
    cout << fnd;
  cout << "\n";
  fnd = -1;
  for (long long i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      fnd = b[i];
      break;
    }
  }
  if (fnd == -1) {
    cout << b[n - 2];
  } else
    cout << fnd << "\n";
  return 0;
}
long long modInv(long long a, long long m) {
  long long x, y;
  long long g = gcdExtended(a, m, &x, &y);
  long long res = (x % m + m) % m;
  return res;
}
long long gcdExtended(long long a, long long b, long long *x, long long *y) {
  if (a == 0) {
    *x = 0, *y = 1;
    return b;
  }
  long long x1, y1;
  long long gcd = gcdExtended(b % a, a, &x1, &y1);
  *x = y1 - (b / a) * x1;
  *y = x1;
  return gcd;
}
long long mpower(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long power(long long x, long long y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = res * x;
    y = y >> 1;
    x = x * x;
  }
  return res;
}
bool isPrime(long long n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  long long p = sqrt(n);
  for (long long i = 5; i <= p; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
