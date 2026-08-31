#include <bits/stdc++.h>
using namespace std;
int T;
int fours[100];
int sevens[100];
bool ok[100];
int dp[100][10];
int pc[100][10];
int main() {
  for (int f = 0; f <= 6; ++f) {
    for (int s = 0; s + f <= 6; ++s) {
      int val = f * 4 + s * 7;
      ok[val] = true;
      fours[val] = f;
      sevens[val] = s;
    }
  }
  scanf("%d", &T);
  for (int i = 0; i < T; ++i) {
    long long num;
    scanf("%I64d", &num);
    for (int i = 0; i < 5; ++i) {
      dp[0][i] = -1;
    }
    dp[0][0] = 0;
    int d = 1;
    while (num != 0) {
      int dig = num % 10;
      num /= 10;
      for (int i = 0; i < 5; ++i) {
        dp[d][i] = -1;
      }
      for (int oldcarry = 0; oldcarry < 5; ++oldcarry) {
        if (dp[d - 1][oldcarry] != -1) {
          for (int newcarry = 0; newcarry < 5; ++newcarry) {
            int needed = dig + 10 * newcarry - oldcarry;
            if (needed >= 0 && ok[needed]) {
              dp[d][newcarry] = needed;
              pc[d][newcarry] = oldcarry;
            }
          }
        }
      }
      ++d;
    }
    --d;
    if (dp[d][0] != -1) {
      long long results[6] = {0, 0, 0, 0, 0, 0};
      for (int cc = 0; d > 0; --d) {
        int current = dp[d][cc];
        for (int i = 0; i < 6; ++i) results[i] *= 10;
        for (int i = 0; i < fours[current]; ++i) results[i] += 4;
        for (int i = 0; i < sevens[current]; ++i)
          results[i + fours[current]] += 7;
        cc = pc[d][cc];
      }
      printf("%I64d %I64d %I64d %I64d %I64d %I64d\n", results[0], results[1],
             results[2], results[3], results[4], results[5]);
    } else {
      printf("-1\n");
    }
  }
}
