#include <bits/stdc++.h>
using namespace std;
int main() {
  int val[5002];
  int orig[5002];
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) val[i] = 1500000000;
  int t[5002];
  int l[5002];
  int r[5002];
  int d[5002];
  for (int op = 0; op < m; op++) {
    cin >> t[op] >> l[op] >> r[op] >> d[op];
  }
  for (int op = m - 1; op >= 0; op--) {
    if (t[op] == 1) {
      for (int i = l[op]; i <= r[op]; i++) {
        val[i] -= d[op];
      }
    } else if (t[op] == 2) {
      for (int i = l[op]; i <= r[op]; i++) {
        val[i] = min(val[i], d[op]);
      }
    }
  }
  for (int i = 0; i <= n; i++) {
    val[i] = min(val[i], 1000000000);
    orig[i] = val[i];
    if (val[i] < -1000000000) {
      cout << "NO" << endl;
      return 0;
    }
  }
  for (int op = 0; op < m; op++) {
    if (t[op] == 1) {
      for (int i = l[op]; i <= r[op]; i++) {
        val[i] += d[op];
      }
    } else {
      bool reachmax = false;
      for (int i = l[op]; i <= r[op]; i++) {
        if (val[i] == d[op]) reachmax = true;
      }
      if (!reachmax) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  cout << orig[1];
  for (int i = 2; i <= n; i++) {
    cout << " " << orig[i];
  }
  cout << endl;
  return 0;
}
