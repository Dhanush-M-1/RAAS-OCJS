#include <bits/stdc++.h>
using namespace std;
const int N = 100002;
int t, n, lucky[] = {0, 4, 7};
char a[20];
bool dp[20][6], done;
long long tenPower[20], ans[7];
void solve(int i, int c) {
  if (done) return;
  if (i == -1) {
    done = !c;
    return;
  }
  if (dp[i][c]) return;
  dp[i][c] = true;
  for (int q = 0; q <= 2; ++q)
    for (int w = 0; w <= 2; ++w)
      for (int e = 0; e <= 2; ++e)
        for (int r = 0; r <= 2; ++r)
          for (int t = 0; t <= 2; ++t)
            for (int y = 0; y <= 2; ++y) {
              int x = lucky[q] + lucky[w] + lucky[e] + lucky[r] + lucky[t] +
                      lucky[y] + c;
              if (x % 10 == a[i] - '0') {
                ans[1] += lucky[q] * tenPower[n - i - 1];
                ans[2] += lucky[w] * tenPower[n - i - 1];
                ans[3] += lucky[e] * tenPower[n - i - 1];
                ans[4] += lucky[r] * tenPower[n - i - 1];
                ans[5] += lucky[t] * tenPower[n - i - 1];
                ans[6] += lucky[y] * tenPower[n - i - 1];
                solve(i - 1, x / 10);
                if (done) return;
                ans[1] -= lucky[q] * tenPower[n - i - 1];
                ans[2] -= lucky[w] * tenPower[n - i - 1];
                ans[3] -= lucky[e] * tenPower[n - i - 1];
                ans[4] -= lucky[r] * tenPower[n - i - 1];
                ans[5] -= lucky[t] * tenPower[n - i - 1];
                ans[6] -= lucky[y] * tenPower[n - i - 1];
              }
            }
}
int main() {
  tenPower[0] = 1;
  for (int i = 1; i <= 18; ++i) tenPower[i] = tenPower[i - 1] * 10;
  scanf("%d", &t);
  while (t--) {
    scanf("%s", a);
    n = strlen(a);
    memset(dp, 0, sizeof dp);
    memset(ans, 0, sizeof ans);
    done = false;
    solve(n - 1, 0);
    if (done)
      for (int i = 1; i <= 6; ++i) printf("%I64d ", ans[i]);
    else
      printf("-1");
    puts("");
  }
}
