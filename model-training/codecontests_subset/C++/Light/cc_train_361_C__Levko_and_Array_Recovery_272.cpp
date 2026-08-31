#include <bits/stdc++.h>
using namespace std;
const int N = 5001;
long long n, m, a[N + 1], b[N + 1], type[N], l[N], r[N], x[N];
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) a[i] = 1e9;
  for (int j = 1; j <= m; j++) {
    cin >> type[j] >> l[j] >> r[j] >> x[j];
    if (type[j] == 1)
      for (int i = l[j]; i <= r[j]; i++) b[i] += x[j];
    else {
      bool ok = false;
      for (int i = l[j]; i <= r[j]; i++) {
        if (a[i] >= x[j] - b[i]) ok = true;
        a[i] = min(a[i], x[j] - b[i]);
      }
      if (!ok) {
        cout << "NO";
        return 0;
      }
    }
  }
  for (int i = 1; i <= n; i++) b[i] = a[i];
  bool ok = true;
  for (int i = 1; i <= m; i++) {
    if (type[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) a[j] += x[i];
    else {
      long long mx = a[l[i]];
      for (int j = l[i] + 1; j <= r[i]; j++) mx = max(mx, a[j]);
      if (mx != x[i]) {
        ok = false;
        break;
      }
    }
  }
  if (!ok)
    cout << "NO";
  else {
    cout << "YES" << endl;
    for (int i = 1; i <= n; i++) cout << b[i] << " ";
  }
  return 0;
}
