#include <bits/stdc++.h>
char str[100005];
int cnt[40][20][4];
bool format[10] = {0, 0, 1, 0, 0, 1, 0, 0, 0, 0};
int dayofmonth[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  scanf("%s", str);
  int n = strlen(str);
  for (int i = 2; i <= n - 8; i++) {
    int st = i - 2;
    bool flag = 0;
    for (int j = 0; j < 10; j++) {
      if ((str[st + j] == '-') != format[j]) {
        flag = 1;
        break;
      }
    }
    if (flag == 1) continue;
    int day = (str[st] - '0') * 10 + (str[st + 1] - '0');
    st += 3;
    int month = (str[st] - '0') * 10 + (str[st + 1] - '0');
    st += 3;
    int year = (str[st] - '0') * 1000 + (str[st + 1] - '0') * 100 +
               (str[st + 2] - '0') * 10 + (str[st + 3] - '0');
    if (year < 2013 || year > 2015 || month < 1 || month > 12 || day < 1 ||
        day > dayofmonth[month])
      continue;
    cnt[day][month][year - 2013]++;
  }
  int maxcnt = 0;
  int d, m, y;
  for (int i = 1; i <= 31; i++) {
    for (int j = 1; j <= 12; j++) {
      for (int k = 0; k < 3; k++) {
        if (maxcnt < cnt[i][j][k]) {
          maxcnt = cnt[i][j][k];
          d = i;
          m = j;
          y = 2013 + k;
        }
      }
    }
  }
  printf("%02d-%02d-%4d", d, m, y);
  return 0;
}
