#include <bits/stdc++.h>
#pragma warning(disable : 4786)
using namespace std;
long long flag[222222], l[222222], r[222222], answer[222222], ans2[222222],
    ans[222222];
int main() {
  ios_base::sync_with_stdio(0);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= m; i++) cin >> flag[i] >> l[i] >> r[i] >> answer[i];
  for (int i = 1; i <= n; i++) ans[i] = round(1e18);
  for (int i = m; i >= 1; i--) {
    if (flag[i] == 1) {
      for (long long j = l[i]; j <= r[i]; j++) ans[j] = ans[j] - answer[i];
    } else {
      for (long long j = l[i]; j <= r[i]; j++)
        if (ans[j] > answer[i]) ans[j] = answer[i];
    }
  }
  for (int i = 1; i <= n; i++)
    if (ans[i] > 1000000000) ans[i] = 1000000000;
  for (int i = 1; i <= n; i++) ans2[i] = ans[i];
  for (int i = 1; i <= m; i++) {
    if (flag[i] == 1) {
      for (long long j = l[i]; j <= r[i]; j++) ans2[j] = ans2[j] + answer[i];
    } else {
      long long max = -round(1e18);
      for (long long j = l[i]; j <= r[i]; j++)
        if (ans2[j] > max) max = ans2[j];
      if (answer[i] != max) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
  cout << endl;
  return 0;
}
