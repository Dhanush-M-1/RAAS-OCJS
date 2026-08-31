#include <bits/stdc++.h>
using namespace std;
const int maxn = 5200 + 11;
int n, w;
bool row[maxn][maxn];
bool col[maxn][maxn];
char x;
bool check(bool *row, int l) {
  bool ret = 1;
  for (int i = 0, j = 0; i < n;) {
    while (j < i + l) ret &= row[i] == row[j++];
    i = j;
  }
  return ret;
}
int32_t main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n / 4; j++) {
      cin >> x;
      if (x >= '0' and x <= '9')
        w = x - '0';
      else
        w = x - 'A' + 10;
      for (int k = 0; k < 4; k++) {
        row[i][4 * j + k] = (w >> (3 - k)) & 1;
        col[4 * j + k][i] = row[i][4 * j + k];
      }
    }
  }
  int ans = 1;
  for (int i = 2; i <= n; i++) {
    if (n % i) continue;
    bool ok = true;
    for (int j = 0; j < n; j++) ok &= check(row[j], i);
    for (int j = 0; j < n; j++) ok &= check(col[j], i);
    if (ok) ans = i;
  }
  cout << ans << '\n';
  return 0;
}
