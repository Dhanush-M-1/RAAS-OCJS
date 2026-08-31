#include <bits/stdc++.h>
using namespace std;
int m, n;
char M[52][52];
int col = 1, row = 1;
int DP = 1;
int CP = 3;
void move_up() {
  while (M[row][col] == M[row - 1][col]) --row;
}
void move_down() {
  while (M[row][col] == M[row + 1][col]) ++row;
}
void move_left() {
  while (M[row][col] == M[row][col - 1]) --col;
}
void move_right() {
  while (M[row][col] == M[row][col + 1]) ++col;
}
void move_to(int nrow, int ncol) {
  if (M[nrow][ncol] == 0 || M[nrow][ncol] == '0') {
    if (CP == 3)
      CP = 1;
    else {
      CP = 3;
      DP = (DP + 1) % 4;
    }
  } else {
    col = ncol;
    row = nrow;
  }
}
void move() {
  switch (DP) {
    case 0:
      move_up();
      if (CP == 3)
        move_left();
      else
        move_right();
      move_to(row - 1, col);
      break;
    case 2:
      move_down();
      if (CP == 3)
        move_right();
      else
        move_left();
      move_to(row + 1, col);
      break;
    case 3:
      move_left();
      if (CP == 3)
        move_down();
      else
        move_up();
      move_to(row, col - 1);
      break;
    case 1:
      move_right();
      if (CP == 3)
        move_up();
      else
        move_down();
      move_to(row, col + 1);
      break;
  }
}
int main() {
  scanf("%i %i", &m, &n);
  for (int i = 1; i <= m; ++i) scanf("%s", M[i] + 1);
  while (n--) move();
  printf("%c\n", M[row][col]);
  return 0;
}
