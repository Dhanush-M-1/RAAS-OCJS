#include <bits/stdc++.h>
using namespace std;
int n, r, c, a[1000011], sum[1000011], nxt[1000011][21];
string s[5000011];
int main() {
  scanf("%d%d%d", &n, &r, &c);
  for (int i = 1; i <= n; ++i) {
    cin >> s[i];
    a[i] = s[i].length();
    sum[i] = sum[i - 1] + a[i];
  }
  int cur = 1;
  for (int i = 0; i <= 20; ++i) nxt[n + 1][i] = n + 1;
  for (int i = 1; i <= n; ++i) {
    while (cur <= n && sum[cur] - sum[i - 1] + cur - i <= c) ++cur;
    nxt[i][0] = cur;
  }
  for (int i = 1; i <= 20; ++i)
    for (int j = 1; j <= n; ++j) nxt[j][i] = nxt[nxt[j][i - 1]][i - 1];
  int id = -1, ans = 0;
  for (int i = 1; i <= n; ++i) {
    int x = i;
    for (int j = 20; ~j; --j) {
      if (r >> j & 1) x = nxt[x][j];
    }
    if (x - i > ans) ans = x - i, id = i;
  }
  int cnt = -1;
  for (int i = 1; i <= ans; ++i) {
    if (i > 1)
      if (cnt + 1 + a[id + i - 1] > c)
        putchar(10), cnt = -1;
      else
        putchar(32);
    cnt += 1 + a[id + i - 1];
    cout << s[id + i - 1];
  }
  return 0;
}
