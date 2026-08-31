#include <bits/stdc++.h>
using namespace std;
int i, j, k, ii, jj, cnt = 0;
int ar[5250];
char mtx[5250][5250];
vector<int> v;
char* getBin(char c) {
  switch (c) {
    case '0':
      return "0000";
    case '1':
      return "0001";
    case '2':
      return "0010";
    case '3':
      return "0011";
    case '4':
      return "0100";
    case '5':
      return "0101";
    case '6':
      return "0110";
    case '7':
      return "0111";
    case '8':
      return "1000";
    case '9':
      return "1001";
    case 'A':
      return "1010";
    case 'B':
      return "1011";
    case 'C':
      return "1100";
    case 'D':
      return "1101";
    case 'E':
      return "1110";
    case 'F':
      return "1111";
  }
}
int main() {
  int n;
  scanf("%d", &n);
  getchar();
  for (i = 1; i * i < n; i++)
    if (n % i == 0) v.push_back(i), v.push_back(n / i);
  if (i * i == n) v.push_back(i);
  sort(v.rbegin(), v.rend());
  char c;
  for (i = 1; i < n + 1; i++) {
    for (j = 1; j < n / 4 + 1; j++) {
      c = getchar();
      string tps = getBin(c);
      for (k = (j - 1) * 4 + 1; k < (j - 1) * 4 + 5; k++)
        mtx[i][k] = tps[(k + 3) % 4];
    }
    getchar();
  }
  int pos = 0x3f3f3f3f;
  for (i = 1; i < n + 1; i++) {
    cnt = 0;
    char ini = mtx[i][1];
    for (j = 1; j < n + 1; j++) {
      if (mtx[i][j] == ini)
        cnt++;
      else
        pos = min(cnt, pos), cnt = 1, ini = mtx[i][j];
    }
    pos = min(cnt, pos);
  }
  for (k = 0; k < v.size(); k++) {
    if (v[k] > pos) continue;
    int div = n / v[k];
    for (i = 0; i < div; i++)
      for (j = 0; j < div; j++) {
        char x = mtx[i * v[k] + 1][j * v[k] + 1];
        for (ii = i * v[k] + 1; ii < i * v[k] + v[k] + 1; ii++)
          for (jj = j * v[k] + 1; jj < j * v[k] + 1 + v[k]; jj++) {
            if (mtx[ii][jj] != x)
              i = div + 1, j = div + 1, ii = 0x3f3f3f3f, jj = 0x3f3f3f3f;
          }
      }
    if (i == div && j == div) printf("%d\n", v[k]), exit(0);
  }
  return ~~(0 ^ 0 ^ 0);
}
