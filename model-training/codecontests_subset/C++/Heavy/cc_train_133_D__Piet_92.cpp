#include <bits/stdc++.h>
using namespace std;
const int INF = INT_MAX;
const double EPS = 1e-10;
inline double SQR(double x) { return x * x; }
inline long long SQR(long long x) { return x * x; }
inline int SQR(int x) { return x * x; }
inline double SQR3(double x) { return x * x * x; }
inline void DEBUG() { puts("jackie"); }
inline bool zero(double x) { return abs(x) < EPS; }
inline int inInt() {
  int x = 0, c;
  while ((unsigned int)((c = getchar()) - '0') >= 10) {
    if ('-' == c) return -inInt();
  }
  do {
    x = (x << 3) + (x << 1) + (c - '0');
  } while ((unsigned int)((c = getchar()) - '0') < 10);
  return x;
}
inline void outInt(int x) {
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (x >= 10) outInt(x / 10);
  putchar((x % 10) + '0');
}
char mat[100][100];
pair<int, int> dir[100][100][4][2];
int M, N;
int len;
int DP, BPy, BPx, CP;
inline bool isValid(int x, int y) {
  return (x >= 0 && x < M && y >= 0 && y < len);
}
int main() {
  scanf("%d %d", &M, &N);
  for (int i = 0; i < M; i++) {
    scanf("%s", mat[i]);
  }
  len = strlen(mat[0]);
  for (int i = 0; i < M; i++) {
    for (int j = 0; j < len; j++) mat[i][j] -= '0';
  }
  int tmp;
  for (int i = 0; i < M; i++) {
    for (int j = 0; j < len; j++) {
      int x = i, y = j;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        y++;
      }
      y--;
      tmp = x;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        x--;
      }
      x++;
      dir[i][j][0][0] = make_pair(x, y);
      x = tmp;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        x++;
      }
      x--;
      dir[i][j][0][1] = make_pair(x, y);
      x = i, y = j;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        x++;
      }
      x--;
      tmp = y;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        y++;
      }
      y--;
      dir[i][j][1][0] = make_pair(x, y);
      y = tmp;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        y--;
      }
      y++;
      dir[i][j][1][1] = make_pair(x, y);
      x = i, y = j;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        y--;
      }
      y++;
      tmp = x;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        x++;
      }
      x--;
      dir[i][j][2][0] = make_pair(x, y);
      x = tmp;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        x--;
      }
      x++;
      dir[i][j][2][1] = make_pair(x, y);
      x = i, y = j;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        x--;
      }
      x++;
      tmp = y;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        y--;
      }
      y++;
      dir[i][j][3][0] = make_pair(x, y);
      y = tmp;
      while (isValid(x, y) && mat[x][y] == mat[i][j]) {
        y++;
      }
      y--;
      dir[i][j][3][1] = make_pair(x, y);
    }
  }
  BPx = 0, BPy = 0;
  DP = 0;
  CP = 0;
  int tx, ty;
  for (int i = 0; i < N; i++) {
    tx = dir[BPx][BPy][DP][CP].first;
    ty = dir[BPx][BPy][DP][CP].second;
    switch (DP) {
      case 0: {
        ty++;
        break;
      }
      case 1: {
        tx++;
        break;
      }
      case 2: {
        ty--;
        break;
      }
      case 3: {
        tx--;
        break;
      }
    }
    if (isValid(tx, ty) && 0 != mat[tx][ty]) {
      BPx = tx, BPy = ty;
    } else {
      if (CP == 0)
        CP = 1;
      else {
        CP = 0;
        DP = (DP + 1) % 4;
      }
    }
  }
  printf("%d\n", mat[BPx][BPy]);
  return 0;
}
