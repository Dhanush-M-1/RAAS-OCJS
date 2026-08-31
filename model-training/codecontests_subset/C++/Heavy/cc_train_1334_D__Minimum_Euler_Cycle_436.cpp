#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t, i, n, cnt, od, l, r, ev, g;
  cin >> t;
  while (t--) {
    cin >> n >> l >> r;
    g = 0;
    if (r == (n * (n - 1)) + 1) {
      g = 500;
    }
    i = 0;
    while (i <= n - 1) {
      if (2 * n * (i) - (i) * (i + 1) < l) {
        i++;
      } else {
        i--;
        break;
      }
    }
    cnt = 2 * n * i - (i) * (i + 1) + 1;
    od = i + 1;
    ev = i + 2;
    if (g) {
      r--;
    }
    while (cnt <= r) {
      if (cnt >= l) {
        if (cnt % 2 == 0) {
          cout << ev << " ";
          ev++;
        } else {
          cout << od << " ";
        }
        cnt++;
      } else {
        if (cnt % 2 == 0) {
          ev++;
        } else {
          ;
        }
        cnt++;
      }
      if (ev > n) {
        od++;
        ev = od + 1;
      }
    }
    if (g == 500) {
      cout << 1 << " ";
    }
    cout << "\n";
  }
  return 0;
}
