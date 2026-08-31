#include <bits/stdc++.h>
template <class T>
inline T sqr(T x) {
  return x * x;
}
#pragma comment(linker, "/STACK:64000000")
using namespace std;
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int n, m;
string s[50];
int BP, DP = 0, CP = 3;
struct point {
  int x, y;
  point(int X, int Y) {
    x = X;
    y = Y;
  }
  point() {}
};
struct rect {
  point p[4];
  int color;
  rect(point p0, point p1, point p2, point p3, int cur_color) {
    p[0] = p0;
    p[1] = p1;
    p[2] = p2;
    p[3] = p3;
    color = cur_color;
  }
  rect() {}
};
point curp(0, 0);
rect arr[50][50];
int dp[4][4];
bool used[50][50];
void init(int x, int y, rect r, int cur_color) {
  if (x < 0 || y < 0 || x == n || y == s[0].length() || cur_color != s[x][y] ||
      used[x][y])
    return;
  arr[x][y] = r;
  used[x][y] = 1;
  init(x + 1, y, r, cur_color);
  init(x, y + 1, r, cur_color);
  init(x - 1, y, r, cur_color);
  init(x, y - 1, r, cur_color);
}
int main() {
  dp[3][0] = 1;
  dp[3][2] = 0;
  dp[0][3] = 1;
  dp[0][1] = 2;
  dp[1][0] = 2;
  dp[1][2] = 3;
  dp[2][3] = 0;
  dp[2][1] = 3;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; ++i) cin >> s[i];
  memset(used, 0, sizeof used);
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < s[0].length(); ++j) {
      if (used[i][j]) continue;
      int l = 0, h = 0;
      while (j + l < s[0].length() && s[i][j] == s[i][j + l]) l++;
      while (h + i < n && s[i][j] == s[h + i][j]) h++;
      l--;
      h--;
      init(i, j,
           rect(point(i, j), point(i, j + l), point(i + h, j + l),
                point(i + h, j), s[i][j]),
           s[i][j]);
    }
  }
  BP = s[0][0];
  for (int i = 0; i < m; ++i) {
    curp = arr[curp.x][curp.y].p[dp[DP][CP]];
    if (curp.x + dx[DP] < 0 || curp.y + dy[DP] < 0 || curp.x + dx[DP] >= n ||
        curp.y + dy[DP] >= s[0].length() ||
        s[curp.x + dx[DP]][curp.y + dy[DP]] == '0') {
      if (CP + 1 != 4 && CP + 1 == DP || CP + 1 == 4 && DP == 0) {
        CP += 2;
        CP %= 4;
        continue;
      }
      if (CP - 1 >= 0 && CP - 1 == DP || CP - 1 == -1 && DP == 3) {
        CP--;
        if (CP == -1) CP = 3;
        DP++;
        DP %= 4;
        continue;
      }
    }
    BP = s[curp.x + dx[DP]][curp.y + dy[DP]];
    curp.x += dx[DP];
    curp.y += dy[DP];
  }
  cout << BP - '0';
  return 0;
}
