#include <bits/stdc++.h>
using namespace std;
int a[35], b[35], diff[35];
int main() {
  std::ios::sync_with_stdio(false);
  int t;
  t = 1;
  while (t--) {
    long long x, x1, val, val1, i, j, res = 0;
    cout << "? 0 0" << endl;
    cin >> x;
    x1 = x;
    if (x == 0) {
      for (i = 0; i < 30; i++) {
        val = (1 << i);
        cout << "? " << val << " " << 0 << endl;
        cin >> x;
        if (x == -1) {
          res += (1 << i);
        }
      }
      cout << "! " << res << " " << res << endl;
    } else {
      {
        x1 = x;
        i = 29;
        val = 0;
        val1 = 0;
        for (i = 29; i >= 0; i--) {
          val += (1 << i);
          val1 += (1 << i);
          cout << "? " << val << " " << val1 << endl;
          cin >> x;
          if (x != x1) {
            diff[i] = 1;
            val -= (1 << i);
            if (x == -1) {
              a[i] = 1;
              b[i] = 0;
            } else {
              a[i] = 0;
              b[i] = 1;
            }
            cout << "? " << val << " " << val1 << endl;
            cin >> x;
            x1 = x;
          } else {
            diff[i] = 0;
          }
        }
        for (i = 29; i >= 0; i--) {
          val = 0;
          val1 = 0;
          if (diff[i]) {
            continue;
          }
          for (j = 0; j < 30; j++) {
            if (j == i) {
              continue;
            }
            if (diff[j]) {
              val += (1 << j);
            }
          }
          {
            val += (1 << i);
            cout << "? " << val << " " << val1 << endl;
            cin >> x;
            if (x == -1) {
              a[i] = 1;
              b[i] = 1;
            } else {
              a[i] = 0;
              b[i] = 0;
            }
          }
        }
        val = 0;
        val1 = 0;
        for (i = 0; i < 30; i++) {
          if (a[i]) {
            val += (1 << i);
          }
          if (b[i]) {
            val1 += (1 << i);
          }
        }
        cout << "! " << val << " " << val1 << endl;
      }
    }
  }
}
