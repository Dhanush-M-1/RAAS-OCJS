#include <bits/stdc++.h>
using namespace std;
int n, m, i, j, w[505], v, h, b[1005], mark[505], ans, size;
pair<int, int> a[505];
int max(int a, int b) {
  if (a > b) return a;
  return b;
}
int min(int a, int b) {
  if (b < a) return b;
  return a;
}
int main() {
  cin >> n >> m;
  for (i = 1; i <= n; i++) cin >> w[i];
  for (i = 1; i <= m; i++) {
    cin >> b[i];
    if (size < n && mark[b[i]] == 0) {
      mark[b[i]] = 1;
      a[++size] = make_pair(b[i], w[b[i]]);
    }
  }
  for (i = 1; i <= m; i++) {
    for (j = 1; j <= n; j++) {
      if (a[j].first == b[i]) {
        h = j;
        break;
      }
      ans += a[j].second;
    }
    for (j = h; j >= 2; j--) a[j] = a[j - 1];
    a[1] = make_pair(b[i], w[b[i]]);
  }
  cout << ans << endl;
  return 0;
}
