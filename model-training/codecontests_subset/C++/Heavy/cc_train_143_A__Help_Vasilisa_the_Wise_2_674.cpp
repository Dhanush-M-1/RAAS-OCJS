#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
int board[2][2];
bool taken[10];
bool ans;
void check() {
  int a = board[0][0] + board[0][1];
  int b = board[1][0] + board[1][1];
  int c = board[0][0] + board[1][1];
  int d = board[0][1] + board[1][0];
  int e = board[0][0] + board[1][0];
  int f = board[0][1] + board[1][1];
  if (a == r1 and b == r2 and c == d1 and d == d2 and e == c1 and f == c2) {
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        cout << board[i][j] << " ";
      }
      cout << endl;
    }
    ans = true;
    return;
  } else {
    return;
  }
}
void solve(int i, int j) {
  if (j == 2) {
    i++;
    j = 0;
  }
  if (i == 2) {
    check();
    return;
  }
  for (int ii = 1; ii <= 9; ii++) {
    if (!taken[ii]) {
      taken[ii] = true;
      board[i][j] = ii;
      solve(i, j + 1);
      board[i][j] = 0;
      taken[ii] = false;
    }
  }
}
int main() {
  memset(taken, false, sizeof(taken));
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 2; j++) {
      board[i][j] = 0;
    }
  }
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  solve(0, 0);
  if (!ans) {
    cout << -1 << endl;
  }
}
