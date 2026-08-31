#include <bits/stdc++.h>
using namespace std;
int a[10000], ans[10000];
bool mark[10000];
int t[10000], l[10000], r[10000], d[10000];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    cin >> t[i];
    if (t[i] == 1) {
      cin >> l[i] >> r[i] >> d[i];
      for (int j = l[i] - 1; j < r[i]; j++) a[j] += d[i];
    } else {
      cin >> l[i] >> r[i] >> d[i];
      for (int j = l[i] - 1; j < r[i]; j++)
        if (mark[j])
          ans[j] = min(ans[j], d[i] - a[j]);
        else {
          ans[j] = d[i] - a[j];
          mark[j] = true;
        }
      bool flag = false;
      for (int j = l[i] - 1; j < r[i]; j++)
        if (ans[j] == d[i] - a[j]) flag = true;
      if (!flag) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  for (int i = 0; i < n; i++) a[i] = 0;
  for (int i = 0; i < m; i++)
    if (t[i] == 1)
      for (int j = l[i] - 1; j < r[i]; j++) a[j] += d[i];
    else {
      bool flag = false;
      for (int j = l[i] - 1; j < r[i]; j++)
        if (ans[j] + a[j] == d[i]) flag = true;
      for (int j = l[i] - 1; j < r[i]; j++)
        if (ans[j] + a[j] > d[i]) flag = false;
      if (!flag) {
        cout << "NO" << endl;
        return 0;
      }
    }
  cout << "YES" << endl;
  for (int i = 0; i < n; i++) cout << ans[i] << " ";
  cout << endl;
  return 0;
}
