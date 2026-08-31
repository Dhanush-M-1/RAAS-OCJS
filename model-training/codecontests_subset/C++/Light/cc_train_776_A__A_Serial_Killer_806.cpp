#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return a * (b / gcd(a, b)); }
long long Max(long long a, long long b) { return a > b ? a : b; }
long long Min(long long a, long long b) { return a < b ? a : b; }
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = ((res % p) * (x % p)) % p;
    y = y >> 1;
    x = ((x % p) * (x % p)) % p;
  }
  return res;
}
bool isprime(long long n) {
  long long z = sqrt(n);
  if (n == 2) return true;
  if (n % 2 == 0) return false;
  for (long long i = 3; i <= z; i += 2) {
    if (n % i == 0) return false;
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string a, b;
  cin >> a >> b;
  long long n;
  cin >> n;
  set<string> s;
  s.insert(a);
  s.insert(b);
  cout << a << " " << b << endl;
  for (long long i = 0; i < n; i++) {
    string x, y;
    cin >> x >> y;
    s.erase(x);
    s.insert(y);
    cout << *s.begin() << " " << *s.rbegin() << endl;
  }
  return 0;
}
