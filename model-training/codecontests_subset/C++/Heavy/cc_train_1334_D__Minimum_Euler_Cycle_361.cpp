#include <bits/stdc++.h>
const double PI =
    3.141592653589793238462643383279502884197169399375105820974944;
using namespace std;
long long ModExp(long long x, long long y, long long m) {
  long long res = 1;
  x = x % m;
  while (y > 0) {
    if (y & 1) res = (res * x) % m;
    y = y >> 1;
    x = (x * x) % m;
  }
  return res;
}
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  long long f = (n - 1) * 2;
  long long arr[((n - 1) * 2) + 1];
  for (long long i = 1; i < f + 1; i++) {
    if (i % 2 == 1) {
      arr[i] = 1;
    } else {
      arr[i] = (i / 2) + 1;
    }
  }
  if (!(f < l || 1 > r)) {
    long long i1 = max(l - 1, 0LL);
    long long i2 = min(r - 1, f - 1);
    for (long long i = i1; i < i2 + 1; i++) {
      cout << arr[i + 1] << " ";
    }
  }
  long long ind = f + 1;
  for (long long i = 2; i < n + 1; i++) {
    long long sz = (n - i) * 2;
    long long st = ind;
    long long en = st + sz - 1;
    if (en < l) {
    } else if (st > r) {
      break;
    } else {
      long long i1 = max(l - st, 0LL);
      long long i2 = min(r - st, en - st);
      while (i1 <= i2) {
        if (i1 % 2 == 0) {
          cout << i << " ";
        } else {
          cout << ((i1 + 1) / 2) + i << " ";
        }
        i1++;
      }
    }
    ind = en + 1;
  }
  if (r == ((n * (n - 1)) + 1)) {
    cout << "1";
  }
  cout << endl;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
}
