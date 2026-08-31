#include <bits/stdc++.h>
using namespace std;
int dp[35][15][5];
int month[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
char s[100005];
int main() {
  int d, m, y;
  int ad, am, ay, mx = 0;
  scanf("%s", s);
  int len = strlen(s);
  for (int i = 0; i + 9 < len; i++) {
    if (s[i + 2] != '-' || s[i + 5] != '-') continue;
    if (s[i + 6] != '2' || s[i + 7] != '0' || s[i + 8] != '1') continue;
    bool flag = true;
    for (int j = 0; j <= 9; j++) {
      if (j == 2 || j == 5) continue;
      if (s[i + j] < '0' || s[i + j] > '9') {
        flag = false;
        break;
      }
    }
    if (flag == false) continue;
    d = (s[i] - '0') * 10 + s[i + 1] - '0';
    m = (s[i + 3] - '0') * 10 + s[i + 4] - '0';
    if (m < 1 || m > 12 || d < 1 || d > month[m]) continue;
    y = s[i + 9] - '0';
    if (y < 3 || y > 5) continue;
    dp[d][m][y]++;
    if (dp[d][m][y] > mx) {
      mx = dp[d][m][y];
      ad = d, am = m, ay = y;
    }
  }
  printf("%02d-%02d-201%d\n", ad, am, ay);
  return 0;
}
