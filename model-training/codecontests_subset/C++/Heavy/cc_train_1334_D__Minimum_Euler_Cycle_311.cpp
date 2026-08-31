#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long idx = 1;
    bool p = false;
    bool end = false;
    for (long long i = 1; i <= n - 1; i++) {
      if (idx + 2 * (n - i) < l) {
        idx += 2 * (n - i);
        continue;
      }
      long long start = 0;
      if (!p) {
        start = l - idx;
        idx += start;
        p = true;
      }
      for (long long j = start; j < 2 * (n - i); j++) {
        if (idx <= r) {
          if (j % 2 == 0)
            cout << i << " ";
          else
            cout << i + j / 2 + 1 << " ";
          cout << endl;
        } else {
          end = true;
          break;
        }
        idx++;
      }
      if (end) break;
    }
    if (r == n * (n - 1) + 1) cout << "1";
    cout << endl;
  }
  return 0;
}
