#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
using namespace std;
long long mod_exp(long long x, long long y, long long mm) {
  if (y == 0)
    return (1);
  else if (y % 2 == 0)
    return (mod_exp((x * x) % mm, y / 2, mm));
  else
    return ((x * mod_exp((x * x) % mm, (y - 1) / 2, mm)) % mm);
}
bool isPowerOfTwo(long long n) {
  if (n == 0) return false;
  return (ceil(log2(n)) == floor(log2(n)));
}
void solve() {
  long long n;
  cin >> n;
  vector<long long> v;
  for (long long i = 2; i <= sqrt(n); i++) {
    if (n % i == 0) {
      if (i == (n / i)) {
        v.push_back(i);
      } else {
        v.push_back(i);
        v.push_back(n / i);
      }
    }
  }
  sort(v.begin(), v.end());
  if (v.size() == 1) {
    cout << 2 << "\n";
  } else if (v.size() == 0) {
    cout << 1 << "\n";
    cout << 0 << "\n";
  } else {
    long long res = 1;
    if (v.size() == 2) {
      long long a = *v.begin();
      long long b = *(v.begin() + 1);
      long long x = min(a, b);
      long long y = max(a, b);
      if (y % x == 0) {
        cout << 1 << "\n";
        cout << y << "\n";
      } else
        cout << 2 << "\n";
    } else {
      long long a = *v.begin();
      vector<long long> p, q;
      for (long long j = 2; j <= sqrt(a); j++) {
        if (a % j == 0) {
          p.push_back(j);
          p.push_back(a / j);
        }
      }
      if (p.size() > 1) {
        cout << 1 << "\n";
        cout << a << "\n";
      } else {
        long long b = *(v.begin() + 1);
        for (long long j = 2; j <= sqrt(b); j++) {
          if (b % j == 0) {
            q.push_back(j);
            q.push_back(a / j);
          }
        }
        if (q.size() > 1) {
          cout << 1 << "\n";
          cout << b << "\n";
        } else {
          cout << 1 << "\n";
          cout << a * b << "\n";
        }
      }
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
