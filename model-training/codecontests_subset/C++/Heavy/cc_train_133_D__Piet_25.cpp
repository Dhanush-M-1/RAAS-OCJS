#include <bits/stdc++.h>
using namespace std;
const int maxm = 100;
int m, n;
string s[maxm];
int get(int x, int y) {
  if (x < 0 || y < 0 || x >= m || y >= s[0].length()) return 0;
  return s[x][y] - '0';
}
const int dx[] = {0, -1, 0, 1};
const int dy[] = {1, 0, -1, 0};
int turn(int v, int t) {
  if (t) return (v + 1) % 4;
  return (v + 3) % 4;
}
int x, y, dp, cp;
int px[maxm][maxm][4][2];
int py[maxm][maxm][4][2];
void prepare(int x, int y, int dp, int cp) {
  int c = get(x, y);
  if (c == 0) {
    px[x][y][dp][cp] = y;
    py[x][y][dp][cp] = x;
    return;
  }
  int ox = x, oy = y;
  while (get(x + dx[dp], y + dy[dp]) == c) {
    x += dx[dp];
    y += dy[dp];
  }
  dp = turn(dp, cp);
  while (get(x + dx[dp], y + dy[dp]) == c) {
    x += dx[dp];
    y += dy[dp];
  }
  px[ox][oy][dp][cp] = x;
  py[ox][oy][dp][cp] = y;
}
void prepare() {
  for (int i = 0; i < m; ++i)
    for (int j = 0; j < s[0].length(); ++j)
      for (int k = 0; k < 4; ++k) {
        prepare(i, j, k, 0);
        prepare(i, j, k, 1);
      }
}
void move() {
  if (get(px[x][y][dp][cp] + dx[dp], py[x][y][dp][cp] + dy[dp]) != 0) {
    int ox = px[x][y][dp][cp] + dx[dp];
    int oy = py[x][y][dp][cp] + dy[dp];
    x = ox;
    y = oy;
  } else {
    if (cp) {
      cp = 0;
      dp = turn(dp, 0);
    } else
      cp = 1;
  }
}
int main() {
  cin >> m >> n;
  getline(cin, s[0]);
  for (int i = 0; i < m; ++i) getline(cin, s[i]);
  x = y = 0;
  dp = 0;
  cp = 0;
  prepare();
  for (int i = 0; i < n; ++i) {
    move();
  }
  cout << get(x, y) << endl;
  return 0;
}
