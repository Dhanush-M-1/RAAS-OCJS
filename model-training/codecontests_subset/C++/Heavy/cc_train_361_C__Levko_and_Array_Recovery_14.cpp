#include <bits/stdc++.h>
using namespace std;
const double EPS = 1E-9;
int a[10000 + 13], c[10000 + 13], l[10000 + 13], r[10000 + 13], d[10000 + 13];
bool used[10000 + 13];
int main() {
  int n, m;
  bool ok;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    cin >> c[i] >> l[i] >> r[i] >> d[i];
    if (c[i] == 1) {
      for (int j = l[i]; j < r[i] + 1; j++)
        if (used[j]) a[j] += d[i];
    } else {
      ok = false;
      for (int j = l[i]; j < r[i] + 1; j++) {
        if (!used[j])
          used[j] = true, a[j] = d[i], ok = true;
        else if (used[j] && a[j] >= d[i])
          a[j] = d[i], ok = true;
      }
      if (!ok) {
        cout << "NO";
        return 0;
      }
    }
  }
  int maxi;
  for (int i = m - 1; i >= 0; i--)
    if (c[i] == 1)
      for (int j = l[i]; j < r[i] + 1; j++) a[j] -= d[i];
    else {
      ok = false;
      for (int j = l[i]; j < r[i] + 1; j++)
        if (!ok || maxi < a[j]) maxi = a[j], ok = true;
      if (maxi != d[i]) {
        cout << "NO";
        return 0;
      }
    }
  cout << "YES\n";
  for (int i = 1; i <= n; i++)
    if (!used[i])
      cout << 0 << " ";
    else
      cout << a[i] << " ";
  return 0;
}
