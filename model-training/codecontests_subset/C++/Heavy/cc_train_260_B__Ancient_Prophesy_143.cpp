#include <bits/stdc++.h>
using namespace std;
const int d[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int o[31][12][3];
bool isDigit(char c) { return '0' <= c && c <= '9'; }
int toInt(char c) { return c - '0'; }
int main() {
  char t[100001];
  scanf("%s", t);
  int l = strlen(t);
  for (int i = 0; i <= l - 10; i++) {
    if (isDigit(t[i]) && isDigit(t[i + 1]) && isDigit(t[i + 3]) &&
        isDigit(t[i + 4]) && isDigit(t[i + 6]) && isDigit(t[i + 7]) &&
        isDigit(t[i + 8]) && isDigit(t[i + 9]))
      if (t[i + 2] == '-' && t[i + 5] == '-') {
        int a = 10 * toInt(t[i]) + toInt(t[i + 1]);
        int b = 10 * toInt(t[i + 3]) + toInt(t[i + 4]);
        int c = 1000 * toInt(t[i + 6]) + 100 * toInt(t[i + 7]) +
                10 * toInt(t[i + 8]) + toInt(t[i + 9]);
        if (1 <= b && b <= 12)
          if (1 <= a && a <= d[b - 1])
            if (2013 <= c && c <= 2015) o[a - 1][b - 1][c - 2013]++;
      }
  }
  int i = 0, j = 0, k = 0;
  for (int a = 0; a < 31; a++)
    for (int b = 0; b < 12; b++)
      for (int c = 0; c < 3; c++)
        if (o[a][b][c] > o[i][j][k]) {
          i = a;
          j = b;
          k = c;
        }
  printf("%s%d-%s%d-%d\n", i + 1 < 10 ? "0" : "", i + 1, j + 1 < 10 ? "0" : "",
         j + 1, k + 2013);
  return 0;
}
