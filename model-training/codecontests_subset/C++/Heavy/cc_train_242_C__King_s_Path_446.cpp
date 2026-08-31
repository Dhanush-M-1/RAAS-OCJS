#include <bits/stdc++.h>
using namespace std;
map<int, map<int, bool> > board;
int main(void) {
  ios::sync_with_stdio(0);
  int xo, yo, xf, yf;
  cin >> xo >> yo >> xf >> yf;
  queue<int> Q;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int i = a; i <= b; i++) board[r][i] = true;
  }
  int ans = -1;
  Q.push(xo);
  Q.push(yo);
  Q.push(0);
  while (!Q.empty()) {
    int x = Q.front();
    Q.pop();
    int y = Q.front();
    Q.pop();
    int d = Q.front();
    Q.pop();
    if (x == xf && y == yf) {
      ans = d;
      break;
    }
    if (board[x - 1][y - 1]) {
      Q.push((x - 1));
      Q.push((y - 1));
      Q.push((d + 1));
      board[x - 1][y - 1] = false;
    }
    if (board[x - 1][y]) {
      Q.push((x - 1));
      Q.push((y));
      Q.push((d + 1));
      board[x - 1][y] = false;
    }
    if (board[x - 1][y + 1]) {
      Q.push((x - 1));
      Q.push((y + 1));
      Q.push((d + 1));
      board[x - 1][y + 1] = false;
    }
    if (board[x][y - 1]) {
      Q.push((x));
      Q.push((y - 1));
      Q.push((d + 1));
      board[x][y - 1] = false;
    }
    if (board[x][y + 1]) {
      Q.push((x));
      Q.push((y + 1));
      Q.push((d + 1));
      board[x][y + 1] = false;
    }
    if (board[x + 1][y - 1]) {
      Q.push((x + 1));
      Q.push((y - 1));
      Q.push((d + 1));
      board[x + 1][y - 1] = false;
    }
    if (board[x + 1][y]) {
      Q.push((x + 1));
      Q.push((y));
      Q.push((d + 1));
      board[x + 1][y] = false;
    }
    if (board[x + 1][y + 1]) {
      Q.push((x + 1));
      Q.push((y + 1));
      Q.push((d + 1));
      board[x + 1][y + 1] = false;
    }
  }
  cout << ans << '\n';
  return 0;
}
