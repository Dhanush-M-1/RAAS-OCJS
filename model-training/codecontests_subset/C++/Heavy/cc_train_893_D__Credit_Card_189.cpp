#include <bits/stdc++.h>
using namespace std;
long long modpow(long long a, long long n, long long temp) {
  long long res = 1;
  while (n > 0) {
    if (n & 1) res = (res * a) % temp;
    a = (a * a) % temp;
    n >>= 1;
  }
  return res % temp;
}
int main() {
  ios_base::sync_with_stdio(false);
  cout.precision(10);
  cout << fixed;
  int n, d;
  cin >> n >> d;
  int i;
  vector<int> a(n), max1(n), c(n);
  for (i = 0; i < n; i++) cin >> a[i];
  c[0] = a[0];
  for (i = 1; i < n; i++) c[i] = c[i - 1] + a[i];
  max1[n - 1] = c[n - 1];
  for (i = n - 2; i >= 0; i--) max1[i] = max(c[i], max1[i + 1]);
  int add = 0;
  int cnt = 0;
  bool pos = 1;
  for (i = 0; i < n; i++) {
    if (c[i] + add > d) pos = 0;
    if (a[i] == 0 && c[i] + add < 0) {
      int canAdd = d - (max1[i] + add);
      if (c[i] + add + canAdd < 0 || canAdd < 0)
        pos = 0;
      else {
        add += canAdd;
        cnt++;
      }
    }
  }
  if (pos)
    cout << cnt << "\n";
  else
    cout << "-1\n";
  if (0) cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
  return 0;
}
