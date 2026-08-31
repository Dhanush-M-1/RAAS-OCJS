#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
int a[100][100];
int step[100][100][4][2];
int n, k;
int ok(int a, int b) { return a >= 0 && a < n && b >= 0 && b < n; }
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (size_t j = 0; j < s.size(); j++) a[i][j] = s[j] - '0';
  }
  n = 50;
  int x = 0, y = 0;
  int dir = 0, cp = 0;
  int cnt = 0;
  while (1) {
    cnt++;
    if (step[x][y][dir][cp]) break;
    step[x][y][dir][cp] = cnt;
    while (ok(x + dx[dir], y + dy[dir]) &&
           a[x + dx[dir]][y + dy[dir]] == a[x][y]) {
      x += dx[dir];
      y += dy[dir];
    }
    if (cp == 0)
      dir = dir - 1;
    else
      dir = dir + 1;
    dir = dir + 8;
    dir %= 4;
    while (ok(x + dx[dir], y + dy[dir]) &&
           a[x + dx[dir]][y + dy[dir]] == a[x][y]) {
      x += dx[dir];
      y += dy[dir];
    }
    if (cp == 0)
      dir = dir + 1;
    else
      dir = dir - 1;
    dir = dir + 8;
    dir %= 4;
    if (ok(x + dx[dir], y + dy[dir]) && a[x + dx[dir]][y + dy[dir]] != 0) {
      x += dx[dir];
      y += dy[dir];
    } else {
      if (cp == 0)
        cp = 1;
      else {
        cp = 0;
        dir = dir + 1;
        dir %= 4;
      }
    }
  }
  int loop = cnt - step[x][y][dir][cp];
  cnt--;
  while (k >= cnt) {
    k -= loop;
  }
  int K = k;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < 4; k++) {
        for (int l = 0; l < 2; l++) {
          if (step[i][j][k][l] - 1 == K) {
            cout << a[i][j] << endl;
            return 0;
          }
        }
      }
    }
  }
}
