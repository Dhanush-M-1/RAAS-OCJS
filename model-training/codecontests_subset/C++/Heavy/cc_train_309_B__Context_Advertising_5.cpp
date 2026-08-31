#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void smin(T &a, U b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, U b) {
  if (a < b) a = b;
}
char s[5 * 1000100];
int a[1000100], sum[1000100], nxt[1000100][20], dp[1000100];
int main() {
  int n, r, c;
  cin >> n >> r >> c;
  int cur = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%s", s + cur);
    a[i] = strlen(s + cur);
    cur += a[i];
    sum[i] = sum[i - 1] + a[i];
  }
  for (int i = 1; i <= n; i++) {
    int p = max(i, nxt[i - 1][0]);
    while (p <= n && sum[p] - sum[i - 1] + p - i <= c) p++;
    nxt[i][0] = p;
  }
  for (int j = 0; j < 20; j++) nxt[n + 1][j] = n + 1;
  for (int j = 1; j < 20; j++) {
    for (int i = 1; i <= n; i++) {
      nxt[i][j] = nxt[nxt[i][j - 1]][j - 1];
    }
  }
  int ans = 0, id;
  for (int i = 1; i <= n; i++) {
    int p = i;
    for (int j = 20; j--;) {
      if (r & (1 << j)) p = nxt[p][j];
    }
    dp[i] = p - i;
    if (ans < dp[i]) ans = dp[i], id = i;
  }
  if (!ans) return 0;
  cur = 0;
  int pos = -1;
  for (int i = id; i <= n && cur < r; i++) {
    if (pos + a[i] >= c) {
      cur++;
      puts("");
      if (cur == r) return 0;
      pos = -1;
    }
    if (pos + a[i] >= c) return 0;
    if (pos >= 0) putchar(' ');
    for (int j = sum[i - 1]; j < sum[i]; j++) putchar(s[j]);
    pos += a[i] + 1;
  }
  return 0;
}
