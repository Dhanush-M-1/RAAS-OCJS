#include <bits/stdc++.h>
using namespace std;
const long long mod = (long long)1e9 + 7;
int t;
long long n, L, R;
long long a[500500], p[500500];
void solve() {
  cin >> n >> L >> R;
  a[1] = 2 * n - 2;
  for (int i = 2; i <= n - 1; ++i) a[i] = a[i - 1] - 2;
  a[n] = 1;
  for (int i = 1; i <= n; ++i) p[i] = p[i - 1] + a[i];
  long long l = 0, r = n, res = -1;
  while (l <= r) {
    long long mid = (l + r) / 2;
    if (p[mid] >= L) {
      r = mid - 1;
      res = mid;
    } else {
      l = mid + 1;
    }
  }
  long long cnt = R - L + 1;
  bool done = false;
  long long start = L - p[res - 1];
  if (res == n) {
    cout << 1 << "\n";
    return;
  }
  for (long long i = start; i <= 2 * (n - res); ++i) {
    if (cnt == 0) {
      done = true;
      break;
    }
    if (i % 2 == 1)
      cout << res << " ";
    else
      cout << res + i / 2 << " ";
    --cnt;
  }
  if (done) {
    cout << "\n";
    return;
  }
  for (long long level = res + 1; level <= n; ++level) {
    if (level == n) {
      cout << 1 << " ";
      cout << "\n";
      return;
    }
    for (long long i = 1; i <= 2 * (n - level); ++i) {
      if (i % 2 == 1)
        cout << level << " ";
      else
        cout << level + i / 2 << " ";
      --cnt;
      if (cnt == 0) {
        cout << "\n";
        return;
      }
    }
  }
}
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  while (t--) solve();
  return 0;
}
