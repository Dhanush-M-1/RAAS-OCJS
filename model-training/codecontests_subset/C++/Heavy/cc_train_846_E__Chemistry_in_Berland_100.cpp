#include <bits/stdc++.h>
using namespace std;
long long a[1000009], b[1000009], x[1000009], k[1000009];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n + 1; i++) scanf("%lld", &a[i]);
  for (int i = 1; i < n + 1; i++) scanf("%lld", &b[i]);
  for (int i = 2; i < n + 1; i++) scanf("%lld %lld", &x[i], &k[i]);
  bool f = 1;
  double L = 1e18;
  for (int i = n + 1 - 1; i >= 2; i--) {
    long long p = max(0LL, a[i] - b[i]);
    a[i] -= p;
    a[x[i]] += p;
    p = max(0LL, b[i] - a[i]);
    double q = double(p) * k[i];
    if (q > L)
      f = 0;
    else {
      a[x[i]] -= p * k[i];
      if (a[x[i]] < -L) f = 0;
      a[i] += p;
    }
  }
  f = (a[1] >= b[1]) && f;
  cout << (f ? "YES" : "NO") << endl;
}
