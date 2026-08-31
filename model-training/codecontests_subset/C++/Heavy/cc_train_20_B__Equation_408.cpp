#include <bits/stdc++.h>
using namespace std;
void SieveOfEratosthenes(long long n) {
  bool prime[n + 1];
  memset(prime, true, sizeof(prime));
  for (long long p = 2; p * p <= n; p++) {
    if (prime[p] == true) {
      for (long long i = p * p; i <= n; i += p) prime[i] = false;
    }
  }
}
long long power(long long x, long long y, long long m) {
  if (y == 0) return 1;
  long long p = power(x, y / 2, m) % m;
  p = (p * p) % m;
  return (y % 2 == 0) ? p : (x * p) % m;
}
void print(vector<long long> a) {
  for (long long i = 0; i < a.size(); i++) cout << a[i] << " ";
  cout << "\n";
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long lcm(long long a, long long b) { return (a / gcd(a, b)) * b; }
bool cmp(long long a, long long b) { return a > b; }
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long a, b, c;
  cin >> a >> b >> c;
  if (a) {
    if (b) {
      long long d = b * b - 4 * a * c;
      if (d >= 0) {
        double f = sqrt(d);
        double r1 = -b + f;
        r1 = double(r1) / double(2 * a);
        double r2 = -b - f;
        r2 = double(r2) / double(2 * a);
        if (r1 != r2) {
          if (r2 > r1) swap(r1, r2);
          cout << 2 << "\n" << fixed << setprecision(8) << r2 << "\n" << r1;
        } else
          cout << 1 << "\n" << fixed << setprecision(8) << r2;
      } else {
        cout << 0;
      }
    } else {
      double d = -c;
      d = d / double(a);
      if (d >= 0) {
        cout << 1 << "\n" << fixed << setprecision(8) << sqrt(d);
      } else {
        cout << 0;
      }
    }
  } else {
    if (b) {
      double d = double(-c) / double(b);
      cout << 1 << "\n" << fixed << setprecision(8) << d;
    } else {
      if (c)
        cout << 0;
      else
        cout << -1;
    }
  }
}
