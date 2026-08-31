#include <bits/stdc++.h>
using namespace std;
int num[5005], orgnum[5005];
bool vis[5005];
int op[5005], l[5005], r[5005], d[5005];
int main() {
  int n, opcnt;
  memset(vis, false, sizeof(vis));
  memset(num, 0, sizeof(num));
  cin >> n >> opcnt;
  for (int i = 0; i < opcnt; ++i) {
    cin >> op[i] >> l[i] >> r[i] >> d[i];
  }
  for (int i = opcnt - 1; i >= 0; --i) {
    if (op[i] == 2) {
      for (int j = l[i]; j <= r[i]; ++j) {
        if (!vis[j]) {
          vis[j] = true;
          num[j] = d[i];
        } else {
          num[j] = min(num[j], d[i]);
        }
      }
    } else {
      for (int j = l[i]; j <= r[i]; ++j) {
        if (vis[j]) {
          num[j] -= d[i];
        }
      }
    }
  }
  for (int i = 1; i <= n; ++i) orgnum[i] = num[i];
  bool ok = true;
  for (int i = 0; i < opcnt; ++i) {
    if (op[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) {
        num[j] += d[i];
      }
    }
    if (op[i] == 2) {
      int curmax = -1000000000;
      for (int j = l[i]; j <= r[i]; ++j) curmax = max(curmax, num[j]);
      if (curmax != d[i]) {
        ok = false;
        break;
      }
    }
  }
  if (!ok) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    for (int i = 1; i <= n; ++i) {
      if (i != 1) cout << " ";
      if (vis[i]) {
        cout << orgnum[i];
      } else {
        cout << 0;
      }
    }
    cout << endl;
  }
  return 0;
}
