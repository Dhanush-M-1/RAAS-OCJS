#include <bits/stdc++.h>
using namespace std;
bool vis[5001];
int arr[5001], ans[5001];
int t[5001], l[5001], r[5001], d[5001];
int main() {
  int cnt = 0;
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) ans[i] = 1000000001;
  for (int i = 0; i < m; ++i) {
    cin >> t[i] >> l[i] >> r[i] >> d[i];
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) arr[j] += d[i];
    } else {
      for (int j = l[i]; j <= r[i]; ++j) {
        ans[j] = min(ans[j], d[i] - arr[j]);
        vis[j] = 1;
      }
    }
  }
  bool flag = 0;
  for (int i = 1; i <= n; ++i) arr[i] = 0;
  for (int i = 0; i < m; ++i) {
    if (t[i] == 2) {
      int maxx = ans[l[i]] + arr[l[i]];
      for (int j = l[i] + 1; j <= r[i]; ++j)
        if (ans[j] + arr[j] > maxx) maxx = ans[j] + arr[j];
      if (maxx ^ d[i]) {
        cout << "NO" << endl;
        return 0;
      }
    } else {
      for (int j = l[i]; j <= r[i]; ++j) arr[j] += d[i];
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; ++i) {
    if (vis[i])
      cout << ans[i] << " ";
    else
      cout << "0"
           << " ";
  }
  cout << endl;
  return 0;
}
