#include <bits/stdc++.h>
using namespace std;
bool matrix[5205][5205];
char inp[1305];
vector<int> divivi;
int func(char c) {
  if (c >= '0' && c <= '9')
    return c - '0';
  else
    return c - 'A' + 10;
}
bool check(int x, int n) {
  int i, j, r, c, ini;
  for (r = 0; r < n / x; r++) {
    for (c = 0; c < n / x; c++) {
      ini = matrix[r * x][c * x];
      for (i = 0; i < x; i++)
        for (j = 0; j < x; j++)
          if (matrix[r * x + i][c * x + j] != ini) return 0;
    }
  }
  return 1;
}
int main() {
  int n, i, j, cal;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%s\n", inp);
    for (j = 0; j < n / 4; j++) {
      cal = func(inp[j]);
      matrix[i][j * 4] = (cal & 8);
      matrix[i][j * 4 + 1] = (cal & 4);
      matrix[i][j * 4 + 2] = (cal & 2);
      matrix[i][j * 4 + 3] = (cal & 1);
    }
  }
  for (i = 1; i <= n; i++)
    if (n % i == 0) divivi.push_back(i);
  for (i = divivi.size() - 1; i >= 1; i--)
    if (check(divivi[i], n)) {
      printf("%d\n", divivi[i]);
      return 0;
    }
  printf("%d\n", divivi[0]);
  return 0;
}
