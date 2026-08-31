#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int T;
  cin >> T;
  for (int t = 0; t < T; ++t) {
    long long n, l, r;
    cin >> n;
    cin >> l;
    cin >> r;
    long long curr_position = 0;
    for (long long i1 = 1; i1 < n; ++i1) {
      long long x = curr_position + 1;
      long long y = curr_position + 2 * (n - i1);
      curr_position += 2 * (n - i1);
      if (r < x || y < l) {
        continue;
      }
      for (long long i2 = 1; i2 <= y - x + 1; ++i2) {
        if (i2 + x - 1 < l || i2 + x - 1 > r) {
          continue;
        }
        if (i2 & 1)
          cout << i1 << " ";
        else
          cout << i2 / 2 + i1 << " ";
      }
    }
    if (r >= n * (n - 1) + 1) cout << 1 << " ";
    cout << "\n";
  }
  return 0;
}
