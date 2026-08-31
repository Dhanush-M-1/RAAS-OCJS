#include <bits/stdc++.h>
using namespace std;
struct keycompare {
  bool operator()(const pair<long long, long long>& v, const long long& k) {
    return (v.first < k);
  }
  bool operator()(const long long& k, const pair<long long, long long>& v) {
    return (k < v.first);
  }
};
long long mod1 = 998244353, mod2 = 1000000007, limit = 9223372036854775807;
long double pi = 3.1415926535897932;
long long modpow(long long x, long long n, long long m) {
  if (x > m) {
    x %= m;
  }
  if (n == 0) return 1 % m;
  long long u = modpow(x, n / 2, m);
  u = (u * u) % m;
  if (n % 2 == 1) u = (u * x) % m;
  return u;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
bool isprime(long long n) {
  if (n == 2) return true;
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) return false;
  }
  return true;
}
long long power(long long x, long long n) {
  long long x_n = 1;
  for (long long i = 0; i < n; i++) {
    x_n *= x;
  }
  return x_n;
}
long long ask(long long c, long long d) {
  cout << "? " << c << ' ' << d << endl;
  long long ans;
  cin >> ans;
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long temp = ask(0, 0);
  string larger = "aa";
  if (temp == -1) {
    larger = "bb";
  }
  long long a = 0, b = 0;
  for (long long i = 0; i < 30; i++) {
    long long temp1 = ask((a + (power(2, 29 - i))), b);
    long long temp2 = ask(a, (b + (power(2, 29 - i))));
    if (temp1 == temp2) {
      if (larger == "aa") {
        a += power(2, 29 - i);
        if (temp1 == -1) {
          larger = "bb";
        }
      } else {
        b += power(2, 29 - i);
        if (temp1 == 1) {
          larger = "aa";
        }
      }
    } else {
      if (temp1 == -1) {
        a += power(2, 29 - i);
        b += power(2, 29 - i);
      }
    }
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
