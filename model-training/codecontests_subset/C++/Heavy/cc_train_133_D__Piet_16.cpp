#include <bits/stdc++.h>
using namespace std;
const int M = 50 + 10;
char board[M][M];
int dp[4][M][M];
int main() {
  int n, m;
  cin >> m >> n;
  int COL = -1;
  for (int i = 0; i < m; i++) {
    string s;
    cin >> s;
    COL = s.length();
    for (int j = 0; j < COL; j++) {
      board[i + 1][j + 1] = s[j];
    }
  }
  for (int row = 1; row <= m; row++) {
    dp[0][row][COL] = COL;
    for (int col = COL - 1; col >= 1; col--) {
      dp[0][row][col] =
          (board[row][col] == board[row][col + 1] ? dp[0][row][col + 1] : col);
    }
    dp[1][row][1] = 1;
    for (int col = 2; col <= COL; col++) {
      dp[1][row][col] =
          (board[row][col] == board[row][col - 1] ? dp[1][row][col - 1] : col);
    }
  }
  for (int col = 1; col <= COL; col++) {
    dp[2][1][col] = 1;
    for (int row = 2; row <= m; row++) {
      dp[2][row][col] =
          (board[row][col] == board[row - 1][col] ? dp[2][row - 1][col] : row);
    }
    dp[3][m][col] = m;
    for (int row = m - 1; row >= 1; row--) {
      dp[3][row][col] =
          (board[row][col] == board[row + 1][col] ? dp[3][row + 1][col] : row);
    }
  }
  int cnt = 1;
  int BProw = 1;
  int BPcol = 1;
  int DP = 0;
  int CP = 2;
  while (cnt <= n) {
    if (DP == 0 || DP == 1) {
      BPcol = dp[DP][BProw][BPcol];
      BProw = dp[CP][BProw][BPcol];
    } else {
      BProw = dp[DP][BProw][BPcol];
      BPcol = dp[CP][BProw][BPcol];
    }
    if (DP == 0 || DP == 1) {
      int step = 1 - 2 * DP;
      if (BPcol + step >= 1 && BPcol + step <= COL &&
          board[BProw][BPcol + step] != '0') {
        BPcol = BPcol + step;
        cnt++;
      } else {
        if (DP == 0) {
          if (CP == 2) {
            CP = 3;
            cnt++;
          } else {
            DP = 3;
            CP = 0;
            cnt++;
          }
        } else {
          if (CP == 3) {
            CP = 2;
            cnt++;
          } else {
            DP = 2;
            CP = 1;
            cnt++;
          }
        }
      }
    } else {
      int step = 2 * (DP - 2) - 1;
      if (BProw + step >= 1 && BProw + step <= m &&
          board[BProw + step][BPcol] != '0') {
        BProw = BProw + step;
        cnt++;
      } else {
        if (DP == 2) {
          if (CP == 1) {
            CP = 0;
            cnt++;
          } else {
            DP = 0;
            CP = 2;
            cnt++;
          }
        } else {
          if (CP == 0) {
            CP = 1;
            cnt++;
          } else {
            DP = 1;
            CP = 3;
            cnt++;
          }
        }
      }
    }
  }
  cout << board[BProw][BPcol] << endl;
  return 0;
}
