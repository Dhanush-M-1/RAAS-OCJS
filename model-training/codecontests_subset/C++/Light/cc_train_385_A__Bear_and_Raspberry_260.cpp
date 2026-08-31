#include <bits/stdc++.h>
using namespace std;
int readint() {
  int t = 0;
  char c, ch = getchar();
  if (ch == '-')
    c = getchar();
  else
    c = ch;
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') {
    t = (t << 3) + (t << 1) + c - '0';
    c = getchar();
  }
  if (ch == '-')
    return -t;
  else
    return t;
}
int main() {
  std::ios_base::sync_with_stdio(false);
  int c, i, j, k, t, n, m, x, y, ans = 0, a[102];
  cin >> n >> c;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n - 1; i++) {
    if (a[i] - a[i + 1] > ans) ans = a[i] - a[i + 1];
  }
  if (ans >= c)
    ans = ans - c;
  else
    ans = 0;
  cout << ans << endl;
  ;
  return 0;
}
