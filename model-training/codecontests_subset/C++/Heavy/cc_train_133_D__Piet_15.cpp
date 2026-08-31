#include <bits/stdc++.h>
using namespace std;
struct square {
  int color;
  bool used;
  pair<int, int> m[2][2];
};
int n, m;
square t[51][51];
bool check(int x, int y) {
  return x >= 0 && x < n && y >= 0 && y < m && t[x][y].color;
}
int main() {
  int k;
  cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    string s;
    cin >> s;
    m = (int)s.length();
    for (int j = 0; j < m; ++j) t[i][j].color = s[j] - '0';
  }
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j)
      if (!t[i][j].used) {
        int x = i, y = j, cur_color = t[i][j].color;
        while (x < n && t[x][j].color == cur_color) ++x;
        while (y < m && t[i][y].color == cur_color) ++y;
        for (int ii = i; ii < x; ++ii)
          for (int jj = j; jj < y; ++jj) {
            t[ii][jj].m[0][0].first = i;
            t[ii][jj].m[0][0].second = j;
            t[ii][jj].m[0][1].first = i;
            t[ii][jj].m[0][1].second = y - 1;
            t[ii][jj].m[1][0].first = x - 1;
            t[ii][jj].m[1][0].second = j;
            t[ii][jj].m[1][1].first = x - 1;
            t[ii][jj].m[1][1].second = y - 1;
            t[ii][jj].used = 1;
          }
      }
  int dp = 1, cp = 0, x = 0, y = 0;
  for (int step = 0; step < k; ++step) {
    int xx, yy;
    if (!dp)
      if (!cp) {
        xx = t[x][y].m[0][0].first;
        yy = t[x][y].m[0][0].second;
      } else {
        xx = t[x][y].m[0][1].first;
        yy = t[x][y].m[0][1].second;
      }
    if (dp == 1)
      if (!cp) {
        xx = t[x][y].m[0][1].first;
        yy = t[x][y].m[0][1].second;
      } else {
        xx = t[x][y].m[1][1].first;
        yy = t[x][y].m[1][1].second;
      }
    if (dp == 2)
      if (!cp) {
        xx = t[x][y].m[1][1].first;
        yy = t[x][y].m[1][1].second;
      } else {
        xx = t[x][y].m[1][0].first;
        yy = t[x][y].m[1][0].second;
      }
    if (dp == 3)
      if (!cp) {
        xx = t[x][y].m[1][0].first;
        yy = t[x][y].m[1][0].second;
      } else {
        xx = t[x][y].m[0][0].first;
        yy = t[x][y].m[0][0].second;
      }
    if (!dp) {
      if (check(xx - 1, yy)) {
        x = xx - 1;
        y = yy;
      } else if (!cp)
        cp = 1;
      else {
        cp = 0;
        dp = (dp + 1) % 4;
      }
      continue;
    }
    if (dp == 1) {
      if (check(xx, yy + 1)) {
        x = xx;
        y = yy + 1;
      } else if (!cp)
        cp = 1;
      else {
        cp = 0;
        dp = (dp + 1) % 4;
      }
      continue;
    }
    if (dp == 2) {
      if (check(xx + 1, yy)) {
        x = xx + 1;
        y = yy;
      } else if (!cp)
        cp = 1;
      else {
        cp = 0;
        dp = (dp + 1) % 4;
      }
      continue;
    }
    if (dp == 3) {
      if (check(xx, yy - 1)) {
        x = xx;
        y = yy - 1;
      } else if (!cp)
        cp = 1;
      else {
        cp = 0;
        dp = (dp + 1) % 4;
      }
      continue;
    }
  }
  cout << t[x][y].color;
  return 0;
}
