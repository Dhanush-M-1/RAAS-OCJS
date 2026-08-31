#include <bits/stdc++.h>
using namespace std;
int main() {
  char str[100005], res[15], Max[15];
  char temp[15] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  int len, i, j, t, max, day, mon, year;
  while (gets(str)) {
    map<string, int> num;
    len = strlen(str);
    for (i = 0, max = 0; i < len - 9; i++) {
      if (str[i + 2] == '-' && str[i + 5] == '-') {
        memset(res, 0, sizeof(res));
        for (j = 0; j < 10; j++) {
          if (j != 2 && j != 5 && str[j + i] == '-') break;
          res[j] = str[i + j];
        }
        if (j >= 10) {
          res[10] = '\0';
          year = (((str[i + 6] - '0') * 10 + str[i + 7] - '0') * 10 +
                  str[i + 8] - '0') *
                     10 +
                 str[i + 9] - '0';
          if (year > 2015 || year < 2013) continue;
          mon = (str[i + 3] - '0') * 10 + str[i + 4] - '0';
          if (mon > 12 || mon < 1) continue;
          day = (str[i] - '0') * 10 + str[i + 1] - '0';
          if (day > temp[mon - 1] || day < 1) continue;
          num[res]++;
          if (max < num[res]) {
            max = num[res];
            strcpy(Max, res);
          }
        }
      }
    }
    printf("%s\n", Max);
  }
  return 0;
}
