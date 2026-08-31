#include <bits/stdc++.h>
using namespace std;
const long long inf = (long long)(1e9);
const long double eps = 1e-6;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
signed main() {
  long long n, k;
  cin >> n >> k;
  long long mx = -1;
  for (long long i = 0; i < n; i++) {
    long long x;
    cin >> x;
    if ((k % x == 0) && (x > mx)) mx = x;
  }
  cout << k / mx << endl;
  return 0;
}
