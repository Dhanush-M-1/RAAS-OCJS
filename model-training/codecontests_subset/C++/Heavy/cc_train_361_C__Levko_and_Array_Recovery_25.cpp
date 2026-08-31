#include <bits/stdc++.h>
using namespace std;
int n, m, l[100001], r[100001], maxi, lim[100001], val[100001], type[100001], i,
    j, x, y, ans[100001], diff[100001];
int main() {
  cin >> n >> m;
  for (i = 1; i <= n; i++) lim[i] = 1e9;
  for (i = 1; i <= m; i++) {
    cin >> type[i] >> l[i] >> r[i] >> val[i];
    if (type[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) diff[j] += val[i];
    } else {
      for (j = l[i]; j <= r[i]; j++) lim[j] = min(lim[j], val[i] - diff[j]);
    }
  }
  for (i = 1; i <= n; i++) ans[i] = lim[i];
  for (i = 1; i <= m; i++) {
    if (type[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) ans[j] += val[i];
    } else {
      maxi = -1;
      for (j = l[i]; j <= r[i]; j++) {
        if (ans[j] == val[i]) {
          maxi = 0;
          break;
        }
      }
      if (maxi == -1) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (i = 1; i <= n; i++) cout << lim[i] << " ";
  return 0;
}
