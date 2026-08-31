#include <bits/stdc++.h>
using namespace std;
const int maxn = 5000 + 10;
int n, m, q[maxn], l[maxn], r[maxn], val[maxn], a[maxn], cnt[maxn];
int main() {
  cin >> n >> m;
  for (int i = 0; i <= n; i++) a[i] = 1000 * 1000 * 1000;
  for (int i = 0; i < m; i++) {
    cin >> q[i] >> l[i] >> r[i] >> val[i];
    if (q[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) cnt[j] += val[i];
    else
      for (int j = l[i]; j <= r[i]; j++) a[j] = min(a[j], val[i] - cnt[j]);
  }
  bool mark = false;
  memset(cnt, 0, sizeof cnt);
  for (int i = 0; i < m; i++) {
    if (q[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) cnt[j] += val[i];
    else {
      int MAX = -(1 << 30);
      for (int j = l[i]; j <= r[i]; j++) MAX = max(MAX, a[j] + cnt[j]);
      if (MAX < val[i]) {
        mark = true;
        break;
      }
    }
  }
  if (mark)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    for (int i = 1; i <= n; i++) cout << a[i] << ' ';
    cout << endl;
  }
  return 0;
}
