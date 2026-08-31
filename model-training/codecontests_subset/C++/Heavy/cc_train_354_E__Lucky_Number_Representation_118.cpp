#include <bits/stdc++.h>
using namespace std;
int dp[22][22];
int cnt[22][22][2];
int ans[22][2];
char s[22][22];
int num[22];
int n;
char str[22];
void getans(int i, int j) {
  if (i == 0) return;
  int a = j * 10 + num[i] - 4 * cnt[i][j][0] - 7 * cnt[i][j][1];
  ans[i][0] = cnt[i][j][0];
  ans[i][1] = cnt[i][j][1];
  getans(i - 1, a);
}
void deal() {
  memset(s, 0, sizeof(s));
  for (int i = 0; i <= 18; i++) {
    int z = ans[i + 1][0];
    for (int j = 0; j < ans[i + 1][0]; j++) s[j][i] = '4';
    for (int j = ans[i + 1][0]; j < ans[i + 1][0] + ans[i + 1][1]; j++)
      s[j][i] = '7';
    for (int j = ans[i + 1][0] + ans[i + 1][1]; j < 6; j++) s[j][i] = '0';
  }
}
int main() {
  scanf("%d", &n);
  while (n--) {
    scanf("%s", str);
    int len = strlen(str);
    memset(num, 0, sizeof(num));
    for (int i = 1; i <= len; i++) num[i] = str[len - i] - '0';
    memset(dp, 0, sizeof(dp));
    dp[0][0] = 1;
    for (int i = 0; i <= 18; i++)
      for (int j = 0; j < 10; j++) {
        if (dp[i][j] == 0) continue;
        for (int p = 0; p <= 6; p++)
          for (int q = 0; q + p <= 6; q++) {
            int t = p * 4 + q * 7;
            int b = (t + j) % 10;
            int a = (t + j) / 10;
            if (b == num[i + 1]) {
              dp[i + 1][a] = 1;
              cnt[i + 1][a][0] = p;
              cnt[i + 1][a][1] = q;
            }
          }
      }
    if (dp[19][0] == 0)
      printf("-1\n");
    else {
      getans(19, 0);
      deal();
      for (int j = 0; j < 6; j++)
        for (int i = 18; i >= 1; i--)
          if (s[j][i] == '0')
            s[j][i] = 0;
          else
            break;
      for (int i = 0; i < 6; i++) {
        int length = strlen(s[i]);
        for (int j = 0; j + j < length; j++)
          swap(s[i][j], s[i][length - 1 - j]);
      }
      for (int i = 0; i < 6; i++) {
        printf("%s", s[i]);
        if (i == 5)
          printf("\n");
        else
          printf(" ");
      }
    }
  }
  return 0;
}
