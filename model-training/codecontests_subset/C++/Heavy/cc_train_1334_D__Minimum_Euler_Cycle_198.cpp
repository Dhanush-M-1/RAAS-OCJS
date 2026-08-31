#include <bits/stdc++.h>
using namespace std;
int ar[200002];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(nullptr);
  cout.tie(nullptr);
  ;
  long long t, n, l, r;
  cin >> t;
  while (t--) {
    cin >> n >> l >> r;
    if (l == n * (n - 1) + 1) {
      cout << "1\n";
      continue;
    }
    long long s = 0, j = 1;
    while (s + 2 * (n - j) < l) {
      s += 2 * (n - j);
      j++;
    }
    long long skipped = (l - s - 1) / 2;
    long long start = j, x = j + skipped + 1;
    ;
    long long end = n * (n - 1) + 1;
    for (long long a = l; a <= min(r, end - 1); a++) {
      if (a % 2) {
        cout << start << " ";
      } else {
        cout << x++ << " ";
      }
      if (x > n) {
        start++;
        x = start + 1;
      }
    }
    if (r == end) {
      cout << 1;
    }
    cout << "\n";
  }
  return 0;
}
