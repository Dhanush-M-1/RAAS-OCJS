#include <bits/stdc++.h>
using namespace std;
int n, m;
int d[5001];
int t[5001];
int l[5001];
int r[5001];
int x[5001];
vector<int> cl, cr, num, cx;
int eksi[5001];
int ek[5001][5001];
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) d[i] = 1000000000;
  for (int ad = 1; ad <= m; ad++) {
    cin >> t[ad] >> l[ad] >> r[ad] >> x[ad];
    if (t[ad] == 1)
      for (int i = l[ad]; i <= r[ad]; i++) eksi[i] += x[ad];
    else {
      int ma = -1000000000;
      for (int i = l[ad]; i <= r[ad]; i++) ma = max(ma, d[i] + eksi[i]);
      if (ma < x[ad]) {
        cout << "NO" << endl;
        return 0;
      } else
        for (int i = l[ad]; i <= r[ad]; i++)
          if (d[i] > x[ad] - eksi[i]) d[i] = x[ad] - eksi[i];
    }
  }
  for (int i = 1; i <= n; i++) eksi[i] = d[i];
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) eksi[j] += x[i];
    } else if (t[i] == 2) {
      int ma = -1000000000;
      for (int j = l[i]; j <= r[i]; j++) ma = max(ma, eksi[j]);
      if (x[i] != ma) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << d[i] << " ";
  cout << endl;
  return 0;
}
