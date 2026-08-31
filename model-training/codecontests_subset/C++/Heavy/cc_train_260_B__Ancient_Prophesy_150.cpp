#include <bits/stdc++.h>
char str[100001];
int cou[32][13][2020];
int months[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool isnum(char c) {
  if (c >= '0' && c <= '9') return true;
  return false;
}
bool isleap(int year) {
  if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) return true;
  return false;
}
int main() {
  while (scanf("%s", str) != EOF) {
    memset(cou, 0, sizeof(cou));
    int month, year, day, dcount = 0;
    month = 0, year = 0, day = 0;
    int len = strlen(str), ans = 0, y = 0, m = 0, d = 0;
    for (int i = 0; i < len; i++) {
      if (isnum(str[i]) && (i + 9) < len) {
        if (isnum(str[i + 1]) && !isnum(str[i + 2]) && isnum(str[i + 3]) &&
            isnum(str[i + 4]) && !isnum(str[i + 5]) && isnum(str[i + 6]) &&
            isnum(str[i + 7]) && isnum(str[i + 8]) && isnum(str[i + 9])) {
          day = (str[i] - '0') * 10 + str[i + 1] - '0';
          if (day > 31 || day == 0) continue;
          month = (str[i + 3] - '0') * 10 + str[i + 4] - '0';
          if (month > 12) continue;
          year = (str[i + 6] - '0') * 1000 + (str[i + 7] - '0') * 100 +
                 (str[i + 8] - '0') * 10 + str[i + 9] - '0';
          if (year < 2013 || year > 2015) continue;
          if (day > months[month]) continue;
          cou[day][month][year]++;
          if (ans < cou[day][month][year]) {
            d = day;
            m = month;
            y = year;
            ans = cou[day][month][year];
          }
        }
      }
    }
    printf("%02d-%02d-%d\n", d, m, y);
  }
  return 0;
}
