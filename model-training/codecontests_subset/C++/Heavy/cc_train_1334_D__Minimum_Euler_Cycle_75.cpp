#include <bits/stdc++.h>
using namespace std;
long long v[100010];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    for (int i = 1; i < n; ++i) v[i] = 2 * (n - i);
    v[n] = 1;
    for (int i = 1; i <= n; ++i) v[i] += v[i - 1];
    int a = 0, b = n + 1;
    while (b - a > 1) {
      int mid = (a + b) / 2;
      if (v[mid] >= l)
        b = mid;
      else
        a = mid;
    }
    long long current = v[a];
    long long pos = a + 1;
    while (current < l) {
      current += 2;
      pos++;
    }
    bool flag = current != l;
    long long lim = 1ll * n * (n - 1) + 1;
    for (long long i = l; i <= min(lim - 1, r); ++i) {
      if (flag)
        cout << a + 1 << " ";
      else
        cout << pos++ << " ";
      if (pos > n) {
        a++;
        pos = a + 2;
      }
      flag ^= 1;
    }
    if (lim == r) cout << "1";
    cout << "\n";
  }
  return 0;
}
