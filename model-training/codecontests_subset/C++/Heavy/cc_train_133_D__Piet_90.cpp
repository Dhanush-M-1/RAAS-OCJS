#include <bits/stdc++.h>
using namespace std;
const char UP = '1';
const char DOWN = '2';
const char LEFT = '3';
const char RIGHT = '4';
const int MAX_N = 55;
string a[MAX_N];
int mas[MAX_N][MAX_N][7];
int bp_x, bp_y, bp_new_x, bp_new_y, m, n;
char dp, cp;
int way_up(int x, int y) {
  int ans = 0;
  char w = a[x][y];
  while ((x >= 0) && (a[x][y] == w)) {
    x--;
    ans++;
  }
  ans--;
  return (-ans);
}
int way_down(int x, int y) {
  int ans = 0;
  char w = a[x][y];
  while ((x < m) && (a[x][y] == w)) {
    x++;
    ans++;
  }
  ans--;
  return ans;
}
int way_right(int x, int y) {
  int ans = 0;
  char w = a[x][y];
  string s = a[x];
  while ((y < (int)s.length()) && (a[x][y] == w)) {
    y++;
    ans++;
  }
  ans--;
  return ans;
}
int way_left(int x, int y) {
  int ans = 0;
  char w = a[x][y];
  while ((y >= 0) && (a[x][y] == w)) {
    y--;
    ans++;
  }
  ans--;
  return (-ans);
}
void change_way() {
  if ((dp == RIGHT) && (cp == UP))
    cp = DOWN;
  else if ((dp == DOWN) && (cp == RIGHT))
    cp = LEFT;
  else if ((dp == LEFT) && (cp == DOWN))
    cp = UP;
  else if ((dp == UP) && (cp == LEFT))
    cp = RIGHT;
  else if ((dp == RIGHT) && (cp == DOWN)) {
    dp = DOWN;
    cp = RIGHT;
  } else if ((dp == DOWN) && (cp == LEFT)) {
    dp = LEFT;
    cp = DOWN;
  } else if ((dp == LEFT) && (cp == UP)) {
    dp = UP;
    cp = LEFT;
  } else if ((dp == UP) && (cp == RIGHT)) {
    dp = RIGHT;
    cp = UP;
  }
  return;
}
int main() {
  cin >> m >> n;
  for (int i = 0; i < m; i++) cin >> a[i];
  for (int i = 0; i < m; i++) {
    string s = a[i];
    for (int j = 0; j < (int)s.length(); j++)
      if (a[i][j] != '0') {
        mas[i][j][UP - '0'] = way_up(i, j);
        mas[i][j][DOWN - '0'] = way_down(i, j);
        mas[i][j][LEFT - '0'] = way_left(i, j);
        mas[i][j][RIGHT - '0'] = way_right(i, j);
      }
  }
  bp_x = 0;
  bp_y = 0;
  bp_new_x = 0;
  bp_new_y = 0;
  dp = RIGHT;
  cp = UP;
  for (int i = 0; i < n; i++) {
    if ((dp == LEFT) || (dp == RIGHT))
      bp_y += mas[bp_x][bp_y][dp - '0'];
    else
      bp_x += mas[bp_x][bp_y][dp - '0'];
    if ((cp == LEFT) || (cp == RIGHT))
      bp_y += mas[bp_x][bp_y][cp - '0'];
    else
      bp_x += mas[bp_x][bp_y][cp - '0'];
    if (dp == RIGHT) {
      if ((bp_y == (int)a[bp_x].length() - 1) || (a[bp_x][bp_y + 1] == '0'))
        change_way();
      else
        bp_y++;
    } else if (dp == LEFT) {
      if ((bp_y == 0) || (a[bp_x][bp_y - 1] == '0'))
        change_way();
      else
        bp_y--;
    } else if (dp == UP) {
      if ((bp_x == 0) || (a[bp_x - 1][bp_y] == '0'))
        change_way();
      else
        bp_x--;
    } else {
      if ((bp_x == m - 1) || (a[bp_x + 1][bp_y] == '0'))
        change_way();
      else
        bp_x++;
    }
  }
  cout << a[bp_x][bp_y];
  return 0;
}
