#include <bits/stdc++.h>
using namespace std;
bool can[100];
int use[20][10];
void get(int x, int d) {
  if (d > 6) return;
  can[x] = 1;
  get(x + 4, d + 1);
  get(x + 7, d + 1);
}
int s[20], dp[20][10], rec[20][10], pre[20][10];
void undo(int p, int x) {
  for (int i = 0; i <= 6 && x >= i * 4; i++) {
    if ((x - i * 4) % 7 == 0) {
      use[p][4] = i;
      use[p][7] = (x - i * 4) / 7;
      break;
    }
  }
}
void prt(int i, int j) {
  if (i < 0) return;
  undo(i, rec[i][j]);
  prt(i - 1, pre[i][j]);
}
long long ans[10];
int main() {
  get(0, 0);
  long long n;
  int cas, tmp, t;
  scanf("%d", &cas);
  while (cas--) {
    scanf("%I64d", &n);
    int len = 0;
    while (n) {
      s[len++] = n % 10;
      n /= 10;
    }
    memset(dp, 0, sizeof(dp));
    memset(use, 0, sizeof(use));
    dp[0][0] = 1;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < 10; j++) {
        if (!dp[i][j]) continue;
        tmp = s[i] - j;
        if (tmp < 0) {
          t = 1;
          tmp += 10;
        } else
          t = 0;
        for (int x = 0; x < 100; x++) {
          if (x % 10 != tmp || !can[x]) continue;
          dp[i + 1][x / 10 + t] = 1;
          rec[i + 1][x / 10 + t] = x;
          pre[i + 1][x / 10 + t] = j;
        }
      }
    }
    if (!dp[len][0])
      printf("-1\n");
    else {
      prt(len, 0);
      for (int i = 0; i < 10; i++) ans[i] = 0;
      for (int i = 19; i >= 1; i--) {
        for (int j = 0; j < use[i][4]; j++) {
          ans[j] = ans[j] * 10 + 4;
        }
        for (int j = use[i][4]; j < use[i][4] + use[i][7]; j++) {
          ans[j] = ans[j] * 10 + 7;
        }
        for (int j = use[i][4] + use[i][7]; j < 6; j++) {
          ans[j] = ans[j] * 10;
        }
      }
      for (int i = 0; i < 6; i++) printf("%I64d ", ans[i]);
      printf("\n");
    }
  }
  return 0;
}
