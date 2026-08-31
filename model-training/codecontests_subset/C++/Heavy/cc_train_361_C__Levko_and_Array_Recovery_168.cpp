#include <bits/stdc++.h>
using namespace std;
int n, m;
long long ma[5005], add[5005], a[5005];
int t[5005], l[5005], r[5005], d[5005];
int check() {
  for (int i = 1; i <= n; i++) {
    a[i] = ma[i];
  }
  long long N = 0;
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) a[j] += d[i];
    } else {
      N = -1000000000;
      for (int j = l[i]; j <= r[i]; j++) {
        N = max(N, a[j]);
      }
      if (N != d[i]) return 0;
    }
  }
  return 1;
}
int main() {
  std::ios::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    ma[i] = 1000000000;
    add[i] = 0;
  }
  int yes = 1;
  for (int i = 1; i <= m; i++) {
    cin >> t[i] >> l[i] >> r[i] >> d[i];
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) {
        add[j] += d[i];
      }
    } else {
      for (int j = l[i]; j <= r[i]; j++) {
        ma[j] = min(ma[j], d[i] - add[j]);
      }
    }
    if (!yes) break;
  }
  if (!check()) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    for (int i = 1; i <= n; i++) {
      cout << ma[i];
      if (i == n)
        cout << endl;
      else
        cout << " ";
    }
  }
  return 0;
}
