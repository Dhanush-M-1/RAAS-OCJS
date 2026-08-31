#include <bits/stdc++.h>
using namespace std;
int read() {
  int n;
  char c;
  bool neg;
  n = 0;
  neg = false;
  for (c = getchar(); !(c >= '0' && c <= '9') && c != '-'; c = getchar())
    ;
  if (c == '-') {
    neg = true;
    c = getchar();
  }
  while ((c >= '0' && c <= '9')) {
    n = n * 10 + c - '0';
    c = getchar();
  }
  return neg ? -n : n;
}
const int MAXN = 50;
const int MAXM = 50;
int n, m, col;
char str[MAXN][MAXM + 1];
int grupo[MAXN][MAXM];
int sig[MAXN * MAXM][4][2];
void crearGrupos() {
  int i, j;
  col = 0;
  for (i = (0); i < (n); i++) {
    for (j = (0); j < (m); j++) {
      grupo[i][j] = -1;
      if (str[i][j] != '0') {
        if (i > 0 && str[i - 1][j] == str[i][j]) {
          grupo[i][j] = grupo[i - 1][j];
        }
        if (j > 0 && str[i][j - 1] == str[i][j]) {
          grupo[i][j] = grupo[i][j - 1];
        }
        if (grupo[i][j] == -1) {
          grupo[i][j] = col++;
        }
      }
    }
  }
}
int color(int x, int y) {
  return (x < 0 || x >= n || y < 0 || y >= m) ? -1 : grupo[x][y];
}
void crearSiguientes() {
  int i, j, k, x1, x2, y1, y2;
  for (i = (0); i < (col); i++) {
    x1 = 0x3f3f3f3f;
    x2 = -0x3f3f3f3f;
    y1 = 0x3f3f3f3f;
    y2 = -0x3f3f3f3f;
    for (j = (0); j < (n); j++) {
      for (k = (0); k < (m); k++) {
        if (grupo[j][k] != i) {
          continue;
        }
        x1 = min(x1, j);
        x2 = max(x2, j);
        y1 = min(y1, k);
        y2 = max(y2, k);
      }
    }
    sig[i][0][0] = color(x1, y2 + 1);
    sig[i][0][1] = color(x2, y2 + 1);
    sig[i][1][0] = color(x2 + 1, y2);
    sig[i][1][1] = color(x2 + 1, y1);
    sig[i][2][0] = color(x2, y1 - 1);
    sig[i][2][1] = color(x1, y1 - 1);
    sig[i][3][0] = color(x1 - 1, y1);
    sig[i][3][1] = color(x1 - 1, y2);
  }
}
int main() {
  int i, j, k, c, dp, cp;
  cin >> n >> k;
  for (i = (0); i < (n); i++) {
    cin >> str[i];
    m = strlen(str[i]);
  }
  crearGrupos();
  crearSiguientes();
  c = grupo[0][0];
  dp = 0;
  cp = 0;
  for (i = (0); i < (k); i++) {
    if (sig[c][dp][cp] == -1) {
      if (cp + 1 == 2) {
        dp = (dp + 1) % 4;
        cp = 0;
      } else {
        cp = 1;
      }
    } else {
      c = sig[c][dp][cp];
    }
  }
  for (i = (0); i < (n); i++) {
    for (j = (0); j < (m); j++) {
      if (grupo[i][j] == c) {
        break;
      }
    }
    if (j < m) {
      break;
    }
  }
  cout << str[i][j] << endl;
  return 0;
}
