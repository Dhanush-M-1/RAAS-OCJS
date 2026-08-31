#include <bits/stdc++.h>
using namespace std;
int n;
char input[5205], B[5205][5205];
string board[5205];
void fill(int r, char original) {
  if (original == '0') board[r] += "0000";
  if (original == '1') board[r] += "0001";
  if (original == '2') board[r] += "0010";
  if (original == '3') board[r] += "0011";
  if (original == '4') board[r] += "0100";
  if (original == '5') board[r] += "0101";
  if (original == '6') board[r] += "0110";
  if (original == '7') board[r] += "0111";
  if (original == '8') board[r] += "1000";
  if (original == '9') board[r] += "1001";
  if (original == 'A') board[r] += "1010";
  if (original == 'B') board[r] += "1011";
  if (original == 'C') board[r] += "1100";
  if (original == 'D') board[r] += "1101";
  if (original == 'E') board[r] += "1110";
  if (original == 'F') board[r] += "1111";
}
int solve(int x) {
  for (int i = 1; i <= n; i += x) {
    for (int j = 1; j <= n; j += x) {
      char now = board[i][j];
      for (int k = i; k < i + x; k++) {
        for (int q = j; q < j + x; q++) {
          if (board[k][q] == now)
            continue;
          else
            return 0;
        }
      }
    }
  }
  return 1;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%s", &input);
    board[i] += ' ';
    for (int j = 0; j < n / 4; j++) {
      fill(i, input[j]);
    }
  }
  for (int i = n; i >= 1; i--) {
    if (!(n % i)) {
      if (solve(i)) {
        printf("%d\n", i);
        return 0;
      }
    }
  }
  return 0;
}
