#include <bits/stdc++.h>
using namespace std;
const int N = 110, M = 10010;
int n;
int a[N], b[N], c[N];
int f[M][N];
int main() {
  cin >> n;
  int sa = 0, sb = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    sa += a[i];
  }
  for (int i = 1; i <= n; i++) {
    cin >> b[i];
    c[i] = b[i];
    sb += b[i];
  }
  sort(c + 1, c + n + 1, greater<int>());
  int s = 0, cnt = 0;
  for (int i = 1; i <= n; i++) {
    s += c[i];
    cnt++;
    if (s >= sa) break;
  }
  memset(f, -0x3f, sizeof f);
  f[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sb; j >= b[i]; j--) {
      for (int k = cnt; k >= 1; k--)
        f[j][k] = max(f[j][k], f[j - b[i]][k - 1] + a[i]);
    }
  }
  int res = 0;
  for (int i = sa; i <= sb; i++) res = max(res, f[i][cnt]);
  res = sa - res;
  cout << cnt << " " << res << endl;
  return 0;
}
