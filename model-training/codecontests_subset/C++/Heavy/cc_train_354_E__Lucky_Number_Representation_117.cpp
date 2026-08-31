#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-11;
#pragma comment(linker, "/STACK:102400000,102400000")
const int inf = 0x3f3f3f3f;
int mod = 1e9 + 7;
const int N = 3e5 + 111;
int a[22];
long long ten[22];
long long ans[6];
bool dp[22][7];
pair<int, int> st[22][7];
void work() {
  long long x;
  cin >> x;
  int i, j, r, t;
  memset(a, 0, sizeof(a));
  memset(dp, 0, sizeof(dp));
  int end = 0;
  for (i = 1; i <= 20; i++) {
    a[i] = x % 10;
    x /= 10;
    if (x == 0) {
      end = i;
      break;
    }
  }
  ten[0] = 1;
  for (i = 1; i <= 20; i++) ten[i] = ten[i - 1] * 10;
  dp[0][0] = 1;
  for (i = 1; i <= end; i++) {
    for (j = 0; j < 7; j++) {
      if (dp[i - 1][j]) {
        for (t = 0; t < 7; t++) {
          for (r = 0; r < 7 - t; r++) {
            int tmp = t * 7 + r * 4 + j;
            if (tmp % 10 == a[i]) {
              dp[i][tmp / 10] = 1;
              st[i][tmp / 10] = make_pair(t, r);
            }
          }
        }
      }
    }
  }
  if (!dp[end][0]) {
    puts("-1");
    return;
  }
  memset(ans, 0, sizeof(ans));
  int fk = 0;
  for (i = end; i >= 1; i--) {
    pair<int, int> tp = st[i][fk];
    int tmp = tp.first * 7 + tp.second * 4 - fk * 10;
    fk = a[i] - tmp;
    for (j = 0; j < tp.first; j++) {
      ans[j] += ten[i - 1] * 7;
    }
    for (j = tp.first; j < tp.first + tp.second; j++) {
      ans[j] += ten[i - 1] * 4;
    }
  }
  for (i = 0; i < 6; i++) printf("%I64d%c", ans[i], i == 5 ? '\n' : ' ');
}
int main() {
  int t;
  cin >> t;
  while (t--) work();
  return 0;
}
