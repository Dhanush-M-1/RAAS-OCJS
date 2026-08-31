#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("-ffloat-store")
#pragma GCC optimize("-fno-defer-pop")
long long int power(long long int a, long long int b, long long int m) {
  if (b == 0) return 1;
  if (b == 1) return a % m;
  long long int t = power(a, b / 2, m) % m;
  t = (t * t) % m;
  if (b & 1) t = ((t % m) * (a % m)) % m;
  return t;
}
long long int modInverse(long long int a, long long int m) {
  return power(a, m - 2, m);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int i, j, k, l, n;
  cin >> n;
  long long int ar[n + 1], mx = 0;
  for (i = 1; i <= n; i++) {
    cin >> ar[i];
    mx = max(mx, ar[i]);
  }
  long long int a, b, mid, an;
  a = mx;
  b = 1e10;
  while (b >= a) {
    mid = (a + b) / 2;
    long long int v = 0, c = 0;
    for (i = 1; i <= n; i++) {
      v += ar[i];
      c += (mid - ar[i]);
    }
    if (c > v) {
      an = mid;
      b = mid - 1;
    } else {
      a = mid + 1;
    }
  }
  cout << an;
  return 0;
}
