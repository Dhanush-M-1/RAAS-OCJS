#include <bits/stdc++.h>
using namespace std;
long long z = 998244353;
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long power(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1) {
      res = (res * a) % z;
      b--;
    } else {
      a = (a * a) % z;
      b = b >> 1;
    }
  }
  return res;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  t = 1;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long s = 1, i = 1;
    long long len = r - l + 1;
    while (i < n) {
      if (l - 2 * (n - i) >= 0) {
        l -= 2 * (n - i);
        i++;
        s++;
      } else {
        break;
      }
    }
    vector<long long> v;
    len += l;
    long long p = 0;
    v.push_back(n);
    for (long long i = s; i <= n; i++) {
      for (long long j = i + 1; j <= n; j++) {
        v.push_back(i);
        p++;
        if (p == len) break;
        v.push_back(j);
        p++;
        if (p == len) break;
      }
      if (p == len) break;
    }
    v.push_back(1);
    for (long long i = l; i < len; i++) cout << v[i] << " ";
    cout << "\n";
  }
}
