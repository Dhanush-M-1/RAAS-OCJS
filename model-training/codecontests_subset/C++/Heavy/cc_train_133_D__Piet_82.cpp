#include <bits/stdc++.h>
using namespace std;
vector<vector<int> > s;
struct block {
  int u;
  int l;
  int d;
  int r;
};
vector<block> bl;
void step(int &bp, int &state) {
  int dx, dy, x, y;
  x = bl[bp].u;
  y = bl[bp].l;
  dx = -1;
  dy = -1;
  if (state / 2 == 0) {
    y = bl[bp].r;
    dy = 1;
  } else if (state / 2 == 1) {
    x = bl[bp].d;
    y = bl[bp].r;
    dx = 1;
    dy = 1;
  } else if (state / 2 == 2) {
    x = bl[bp].d;
    dx = 1;
  }
  if (state / 2 % 2 == 0) {
    if (state % 2 == 0) {
      dy = 0;
    } else {
      dx = 0;
    }
  } else {
    if (state % 2 != 0) {
      dy = 0;
    } else {
      dx = 0;
    }
  }
  if (s[x + dx][y + dy] == -1) {
    state++;
    state %= 8;
  } else {
    bp = s[x + dx][y + dy];
  }
}
int main() {
  int n, m;
  cin >> m >> n;
  vector<vector<char> > p(m + 2, vector<char>(52, '0'));
  s = vector<vector<int> >(m + 2, vector<int>(52, -1));
  int bp = 0;
  int state = 1;
  int d = -1;
  getchar();
  int t;
  for (int i = 1; i <= m; i++) {
    char c = getchar();
    t = 1;
    while (c != '\n' && c != EOF) {
      p[i][t] = c;
      c = getchar();
      if (p[i][t] == p[i - 1][t]) {
        s[i][t] = s[i - 1][t];
      } else if (p[i][t] == p[i][t - 1]) {
        s[i][t] = s[i][t - 1];
      } else if (p[i][t] != '0') {
        d++;
        s[i][t] = d;
      }
      t++;
    }
  }
  bl = vector<block>(d + 1);
  for (int i = 1; i <= m; i++) {
    for (int j = 1; j <= 50; j++) {
      if (p[i][j] != p[i - 1][j] && p[i][j] != p[i][j - 1] && p[i][j] != '0') {
        bl[s[i][j]].u = i;
        bl[s[i][j]].l = j;
      }
      if (p[i][j] != p[i + 1][j] && p[i][j] != p[i][j + 1] && p[i][j] != '0') {
        bl[s[i][j]].d = i;
        bl[s[i][j]].r = j;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    step(bp, state);
  }
  cout << p[bl[bp].u][bl[bp].l];
  return 0;
}
