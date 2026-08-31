#include <bits/stdc++.h>
char str[100010];
int times[40][15][5];
int monthmaxdays[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool isdigt[11] = {1, 1, 0, 1, 1, 0, 1, 1, 1, 1};
void print(int dd, int mm, int yyyy) {
  if (dd < 10)
    printf("0%d-", dd);
  else
    printf("%d-", dd);
  if (mm < 10)
    printf("0%d-", mm);
  else
    printf("%d-", mm);
  printf("%d\n", yyyy + 2013);
}
int main() {
  while (scanf("%s", str) == 1) {
    memset(times, 0, sizeof(times));
    int len = strlen(str);
    for (int i = 0; i + 9 < len; i++) {
      bool bl = true;
      for (int j = 0; j <= 9; j++)
        if ((isdigit(str[i + j])) != isdigt[j]) {
          bl = false;
          break;
        }
      if (!bl) continue;
      int dd = (str[i] - '0') * 10 + str[i + 1] - '0',
          mm = (str[i + 3] - '0') * 10 + str[i + 4] - '0',
          yyyy = (str[i + 6] - '0') * 1000 + (str[i + 7] - '0') * 100 +
                 (str[i + 8] - '0') * 10 + str[i + 9] - '0';
      if (mm < 1 || mm > 12 || yyyy < 2013 || yyyy > 2015 || dd < 1 ||
          dd > monthmaxdays[mm])
        continue;
      times[dd][mm][yyyy - 2013]++;
    }
    int dd = 1, mm = 1, yyyy = 0;
    for (int y = 0; y <= 2; y++)
      for (int m = 1; m <= 12; m++)
        for (int d = 1; d <= monthmaxdays[m]; d++) {
          if (times[d][m][y] > times[dd][mm][yyyy]) dd = d, mm = m, yyyy = y;
        }
    print(dd, mm, yyyy);
  }
}
