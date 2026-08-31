#include <bits/stdc++.h>
using namespace std;
int m;
int n;
string board[50];
int blockn;
int cellBlock[50][50];
int blockCornerX[2500][2][2];
int blockCornerY[2500][2][2];
char solve() {
  memset(cellBlock, -1, sizeof(cellBlock));
  blockn = 0;
  int w = m;
  int h = board[0].size();
  for (int i = 0; i < w; i++) {
    for (int j = 0; j < h; j++) {
      if ((board[i][j] != '0') && (cellBlock[i][j] == -1)) {
        int a = i;
        while ((a < w) && (board[a][j] == board[i][j])) {
          a++;
        }
        int b = j;
        while ((b < h) && (board[i][b] == board[i][j])) {
          b++;
        }
        for (int x = i; x < a; x++) {
          for (int y = j; y < b; y++) {
            cellBlock[x][y] = blockn;
          }
        }
        for (int x = 0; x < 2; x++) {
          for (int y = 0; y < 2; y++) {
            blockCornerX[blockn][x][y] = i + (a - 1 - i) * x;
            blockCornerY[blockn][x][y] = j + (b - 1 - j) * y;
          }
        }
        blockn++;
      }
    }
  }
  int BP = 0;
  int dx[4] = {0, 1, 0, -1};
  int dy[4] = {1, 0, -1, 0};
  int DP = 0;
  int CP = -1;
  for (int t = 0; t < n; t++) {
    int nx = dx[DP] + dx[(DP + CP + 4) % 4];
    int ny = dy[DP] + dy[(DP + CP + 4) % 4];
    if (nx == -1) {
      nx = 0;
    } else {
      nx = 1;
    }
    if (ny == -1) {
      ny = 0;
    } else {
      ny = 1;
    }
    int cx = blockCornerX[BP][nx][ny];
    int cy = blockCornerY[BP][nx][ny];
    nx = cx + dx[DP];
    ny = cy + dy[DP];
    if ((nx < 0) || (nx >= w) || (ny < 0) || (ny >= h) ||
        (board[nx][ny] == '0')) {
      if (CP == -1) {
        CP = 1;
      } else {
        DP = (DP + 1) % 4;
        CP = -1;
      }
    } else {
      BP = cellBlock[nx][ny];
    }
  }
  return board[blockCornerX[BP][0][0]][blockCornerY[BP][0][0]];
}
inline void init() {}
int main() {
  while (cin >> m >> n) {
    for (int i = 0; i < m; i++) {
      cin >> board[i];
    }
    cout << solve() << endl;
  }
  return 0;
}
