#include <bits/stdc++.h>
using namespace std;
int a[5005], b[5005], add[5005];
int t[5005], l[5005], r[5005], d[5005];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; ++i) {
    cin >> t[i] >> l[i] >> r[i] >> d[i];
    --l[i];
    --r[i];
  }
  for (int i = 0; i < n; ++i) a[i] = (1e8), add[i] = 0;
  for (int i = 0; i < m; ++i) {
    int lm = l[i], rm = r[i], val = d[i];
    if (t[i] == 1) {
      for (int j = lm; j <= rm; ++j) add[j] += val;
    } else {
      for (int j = lm; j <= rm; ++j) a[j] = min(a[j], val - add[j]);
    }
  }
  for (int i = 0; i < n; ++i) b[i] = a[i];
  bool ok = true;
  for (int i = 0; i < m; ++i) {
    int lm = l[i], rm = r[i], val = d[i];
    if (t[i] == 1) {
      for (int j = lm; j <= rm; ++j) a[j] += val;
    } else {
      int mmax = -(1e8);
      for (int j = lm; j <= rm; ++j) mmax = max(mmax, a[j]);
      if (mmax != val) ok = false;
    }
  }
  if (!ok)
    cout << "NO";
  else {
    cout << "YES" << endl;
    for (int i = 0; i < n; ++i) cout << b[i] << " ";
  }
  return 0;
}
