#include <bits/stdc++.h>
#pragma warning(disable : 4996)
int main() {
  int map[50][50];
  int border[4][50][50];
  int m;
  int rowSize;
  int colSize;
  int n;
  int rowCurr = 0;
  int colCurr = 0;
  int iCol, iRow;
  int iRun;
  int DP = 0;
  int CP = 0;
  scanf("%d %d\n", &m, &n);
  rowSize = m;
  for (iRow = 0; iRow < m; ++iRow) {
    char line[128] = {0};
    scanf("%s\n", line);
    colSize = 0;
    for (iCol = 0; line[iCol] >= '0' && line[iCol] <= '9'; ++iCol) {
      map[iRow][iCol] = (line[iCol] - '0');
    }
    colSize = iCol;
  }
  for (iRow = 0; iRow < rowSize; ++iRow) {
    for (iCol = 0; iCol < colSize; ++iCol) {
      int col = iCol;
      int row = iRow;
      while (col < colSize && map[iRow][col] == map[iRow][iCol]) ++col;
      --col;
      while (row < rowSize && map[row][col] == map[iRow][iCol]) ++row;
      --row;
      border[0][iRow][iCol] = (row << 8) | col;
      row = iRow;
      while (row >= 0 && map[row][col] == map[iRow][iCol]) --row;
      ++row;
      border[3][iRow][iCol] = (row << 8) | col;
      col = iCol;
      while (col >= 0 && map[row][col] == map[iRow][iCol]) --col;
      ++col;
      border[2][iRow][iCol] = (row << 8) | col;
      row = iRow;
      while (row < rowSize && map[row][col] == map[iRow][iCol]) ++row;
      --row;
      border[1][iRow][iCol] = (row << 8) | col;
    }
  }
  for (iRun = 0; iRun < n; ++iRun) {
    switch (DP) {
      case 0: {
        int col =
            (CP) ? border[0][rowCurr][colCurr] : border[3][rowCurr][colCurr];
        int row = col >> 8;
        col = (col & 0xFF);
        if (col < colSize - 1 && 0 != map[row][col + 1]) {
          colCurr = col + 1;
          rowCurr = row;
        } else {
          if (0 == CP)
            CP = 1;
          else {
            CP = 0;
            DP = 1;
          }
        }
      } break;
      case 1: {
        int col =
            (CP) ? border[1][rowCurr][colCurr] : border[0][rowCurr][colCurr];
        int row = col >> 8;
        col &= 0xFF;
        if (row < rowSize - 1 && 0 != map[row + 1][col]) {
          rowCurr = row + 1;
          colCurr = col;
        } else {
          if (0 == CP)
            CP = 1;
          else {
            CP = 0;
            DP = 2;
          }
        }
      } break;
      case 2: {
        int col =
            (CP) ? border[2][rowCurr][colCurr] : border[1][rowCurr][colCurr];
        int row = col >> 8;
        col &= 0xFF;
        if (col > 0 && 0 != map[row][col - 1]) {
          colCurr = col - 1;
          rowCurr = row;
        } else {
          if (0 == CP)
            CP = 1;
          else {
            CP = 0;
            DP = 3;
          }
        }
      } break;
      case 3: {
        int col =
            (CP) ? border[3][rowCurr][colCurr] : border[2][rowCurr][colCurr];
        int row = col >> 8;
        col &= 0xFF;
        if (row > 0 && 0 != map[row - 1][col]) {
          rowCurr = row - 1;
          colCurr = col;
        } else {
          if (0 == CP)
            CP = 1;
          else {
            CP = 0;
            DP = 0;
          }
        }
      } break;
    }
  }
  printf("%d\n", map[rowCurr][colCurr]);
  return (0);
}
