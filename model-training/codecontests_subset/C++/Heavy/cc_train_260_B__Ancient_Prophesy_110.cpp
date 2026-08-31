#include <bits/stdc++.h>
using namespace std;
char s[100005];
char tmp[11];
int yy, dd, mm;
int _map[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int num;
char result[100005][11];
int resultnum[100005];
int check_dd_mm() {
  if (_map[mm] >= dd) return 1;
  return 0;
}
int add(int point) {
  for (int i = 9; i >= 0; i--) tmp[i] = s[point + i - 9];
  tmp[10] = '\0';
  for (int i = 1; i <= num; i++)
    if (!strcmp(tmp, result[i])) {
      resultnum[i]++;
      return 0;
    }
  num++;
  resultnum[num] = 1;
  strcpy(result[num], tmp);
  return 0;
}
int check(int i) {
  int flag = 1;
  if (!(s[i] == '3' || s[i] == '4' || s[i] == '5')) flag = 0;
  if (!(s[i - 1] == '1' && s[i - 2] == '0' && s[i - 3] == '2' &&
        s[i - 4] == '-' && s[i - 7] == '-')) {
    flag = 0;
  }
  if (!(s[i - 5] >= '0' && s[i - 5] <= '9')) flag = 0;
  if (!(s[i - 6] >= '0' && s[i - 6] <= '9')) flag = 0;
  if (!(s[i - 8] >= '0' && s[i - 8] <= '9')) flag = 0;
  if (!(s[i - 9] >= '0' && s[i - 9] <= '9')) flag = 0;
  yy = (s[i] - '0') + 2010;
  mm = (s[i - 6] - '0') * 10 + (s[i - 5] - '0');
  if (mm <= 0 || mm >= 13) flag = 0;
  dd = (s[i - 9] - '0') * 10 + (s[i - 8] - '0');
  if (dd <= 0) flag = 0;
  if (!flag) return 0;
  if (!check_dd_mm()) return 0;
  return 1;
}
int main() {
  while (gets(s)) {
    num = 0;
    memset(resultnum, 0, sizeof(resultnum));
    int len = strlen(s);
    for (int i = 9; i < len; i++) {
      if (check(i)) {
        add(i);
      }
    }
    int _maxnum = -1;
    int _maxpoint;
    for (int i = 1; i <= num; i++) {
      if (_maxnum < resultnum[i]) {
        _maxnum = resultnum[i];
        _maxpoint = i;
      }
    }
    printf("%s\n", result[_maxpoint]);
  }
  return 0;
}
