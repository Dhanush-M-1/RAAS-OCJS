#include <bits/stdc++.h>
using namespace std;
int mat[5210][5210], n, d[5210];
void get_input(int i, int jstart, int num) {
  mat[i][jstart] = num / 8;
  mat[i][jstart + 1] = (num % 8) / 4;
  mat[i][jstart + 2] = (num % 4) / 2;
  mat[i][jstart + 3] = num % 2;
}
int check(int baseline, int i, int j, int step) {
  for (int inneri = 0; inneri < step; inneri++)
    for (int innerj = 0; innerj < step; innerj++)
      if (mat[i + inneri][j + innerj] != baseline) return 0;
  return 1;
}
int checkdiv(int num) {
  int baseline;
  for (int i = 1; i <= n; i += d[num]) {
    for (int j = 1; j <= n; j += d[num]) {
      baseline = mat[i][j];
      if (!check(baseline, i, j, d[num])) return 0;
    }
  }
  return 1;
}
int main() {
  int divnum = 0;
  char ch;
  cin >> n;
  scanf("%c", &ch);
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n / 4; j++) {
      scanf("%c", &ch);
      if (ch >= 48 && ch <= 57) get_input(i, j * 4 - 3, ch - 48);
      if (ch >= 65 && ch <= 90) get_input(i, j * 4 - 3, ch - 55);
    }
    scanf("%c", &ch);
  }
  for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
      divnum++;
      d[divnum] = i;
    }
  }
  for (int num = divnum; num >= 1; num--) {
    if (checkdiv(num)) {
      cout << d[num] << endl;
      break;
    }
  }
}
