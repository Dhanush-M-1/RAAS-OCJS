#include <bits/stdc++.h>
using namespace std;
const int N = 300010;
int t, used[21][5], cur, len, a[N];
long long n, res[N], ten[N];
bool dp[21][5];
bool solve(int pos, int d) {
  if (used[pos][d] == cur) return dp[pos][d];
  used[pos][d] = cur;
  if (pos >= len) {
    if (d == 0)
      dp[pos][d] = true;
    else
      dp[pos][d] = false;
    return dp[pos][d];
  }
  dp[pos][d] = false;
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++)
      if ((4 * i + 7 * j + d) % 10 == a[pos]) {
        dp[pos][d] |= solve(pos + 1, (4 * i + 7 * j + d) / 10);
        if (dp[pos][d]) return true;
      }
  return false;
}
void solve1(int pos, int d) {
  if (pos >= len) return;
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++)
      if ((4 * i + 7 * j + d) % 10 == a[pos] &&
          dp[pos + 1][(4 * i + 7 * j + d) / 10]) {
        int r = 0;
        for (int k = 0; k < i; k++) res[r++] += 4ll * ten[pos];
        for (int k = 0; k < j; k++) res[r++] += 7ll * ten[pos];
        solve1(pos + 1, (4 * i + 7 * j + d) / 10);
        return;
      }
}
int main() {
  cin >> t;
  cur = 0;
  ten[0] = 1;
  for (int i = 1; i <= 19; i++) ten[i] = ten[i - 1] * 10;
  while (t--) {
    cur++;
    cin >> n;
    len = 0;
    long long t = n;
    while (t > 0) {
      a[len++] = t % 10;
      t /= 10;
    }
    for (int i = 0; i < 6; i++) res[i] = 0;
    if (!solve(0, 0))
      printf("%d\n", -1);
    else {
      solve1(0, 0);
      for (int i = 0; i < 6; i++) printf("%I64d ", res[i]);
      printf("\n");
    }
  }
  return 0;
}
