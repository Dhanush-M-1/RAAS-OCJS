#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9 + 7;
long long modexp(long long x, long long n) {
  if (n == 0) return 1;
  if (n % 2 == 0) {
    long long y = modexp(x, n / 2) % mod;
    return (y * y) % mod;
  }
  return (x * modexp(x, n - 1) % mod) % mod;
}
int main() {
  int n;
  long long d;
  scanf("%d%lld", &n, &d);
  long long a[n];
  for (int i = 0; i < n; i++) {
    scanf("%lld", &a[i]);
  }
  long long curr = 0;
  long long sum = 0;
  for (int i = 0; i < n; i++) {
    sum += a[i];
    if (a[i] == 0) {
      if (sum < 0) sum = 0;
    }
    if (sum > d) {
      printf("-1\n");
      return 0;
    }
  }
  long long x = 0;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] > 0) {
      curr += a[i];
    } else if (a[i] < 0) {
      curr += a[i];
    } else {
      if (curr < 0) {
        if (abs(curr) <= x) {
          x = x - abs(curr);
        } else {
          ans++;
          x = d;
        }
        curr = 0;
      }
    }
    if (curr > d) {
      printf("-1\n");
      return 0;
    }
    x = min(x, d - curr);
  }
  cout << ans << endl;
  return 0;
}
