#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie();
  int T;
  cin >> T;
  while (T--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long e = 0, s = -1, f = -1;
    for (long long i = 1; i < n; i++) {
      e += 2 * (n - i);
      if (e >= l) {
        s = i;
        f = 2 * (n - i) - e + l;
        break;
      }
    }
    if (s == -1) {
      cout << 1 << '\n';
      continue;
    }
    for (long long i = l; i <= r; i++) {
      if (s == n)
        cout << 1 << ' ';
      else {
        if (f & 1)
          cout << s << ' ';
        else
          cout << s + f / 2 << ' ';
      }
      if (f == 2 * (n - s)) {
        s++;
        f = 1;
      } else
        f++;
    }
    cout << '\n';
  }
  return 0;
}
