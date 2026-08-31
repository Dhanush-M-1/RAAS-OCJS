#include <bits/stdc++.h>
int YEAR[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int A[32][13][3];
int main(void) {
  char S[100005] = "";
  char* str;
  int l, max = 0, md, mm, my;
  memset(A, 0, 32 * 13 * 3 * sizeof(int));
  scanf("%s", S);
  l = strlen(S);
  str = S;
  while (str < S + l) {
    int m, d, y;
    while (str[0] < '0' && str[1] < '1' && str + 1 < S + l) str++;
    if (str[2] != '-' && str + 2 < S + l) {
      str++;
      continue;
    }
    if (str[3] < '0' || str[4] < '0' || str + 4 >= S + l) {
      str += 4;
      continue;
    }
    m = (str[3] - '0') * 10 + (str[4] - '0');
    if (m == 0 || m > 12) {
      str += 3;
      continue;
    }
    d = (str[0] - '0') * 10 + (str[1] - '0');
    if (d == 0 || d > YEAR[m]) {
      str += 3;
      continue;
    }
    if (str[5] != '-') {
      str += 4;
      continue;
    }
    if (str[6] < '0' || str[7] < '0' || str[8] < '0' || str[9] < '0' ||
        str + 9 >= S + l) {
      str += 3;
      continue;
    }
    y = (str[6] - '0') * 1000 + (str[7] - '0') * 100 + (str[8] - '0') * 10 +
        (str[9] - '0');
    if (y < 2013 || y > 2015) {
      str += 8;
      continue;
    }
    A[d][m][y - 2013]++;
    str += 8;
  }
  for (int i = 0; i < 32; i++) {
    for (int j = 0; j < 13; j++) {
      for (int k = 0; k < 3; k++) {
        int a = A[i][j][k];
        if (a > max) {
          max = a;
          md = i;
          mm = j;
          my = 2013 + k;
        }
      }
    }
  }
  printf("%02d-%02d-%d\n", md, mm, my);
  return 0;
}
