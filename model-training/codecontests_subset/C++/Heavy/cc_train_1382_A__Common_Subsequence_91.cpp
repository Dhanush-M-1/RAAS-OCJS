#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
unsigned long long factorial[1000004];
unsigned long long power(unsigned long long x, int y, int p) {
  unsigned long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
unsigned long long modInverse(unsigned long long n, int p) {
  return power(n, p - 2, p);
}
unsigned long long nc(unsigned long long n, int r, int p) {
  if (r == 0) return 1;
  return (factorial[n] * modInverse(factorial[r], p) % p *
          modInverse(factorial[n - r], p) % p) %
         p;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<int> a1(1001, 0);
    vector<int> b1(1001, 0);
    vector<int> a(1001), b(1001);
    for (long long i = 0; i < n; i++) {
      cin >> a[i + 1];
      a1[a[i + 1]] = 1;
    }
    for (long long i = 0; i < m; i++) {
      cin >> b[i + 1];
      b1[b[i + 1]] = 1;
    }
    int j = 0;
    int f = 0;
    for (long long i = 0; i < 1000; i++) {
      if ((a1[i + 1] != 0) && (b1[i + 1] != 0)) {
        f = 1;
        j = i + 1;
        break;
      }
    }
    if (f) {
      cout << "YES\n";
      cout << "1 " << j << "\n";
    } else {
      cout << "NO\n";
    }
  }
  return 0;
}
