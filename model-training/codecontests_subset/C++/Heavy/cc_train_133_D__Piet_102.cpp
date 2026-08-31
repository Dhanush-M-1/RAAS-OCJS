#include <bits/stdc++.h>
using namespace std;
const int inf = numeric_limits<int>::max();
const double eps = 1.0e-12;
const double pi = 3.141592653589793238462643383279;
inline string readln() {
  string _s;
  getline(cin, _s);
  return _s;
}
int main() {
  int m, n;
  cin >> m >> n;
  readln();
  string s = readln();
  int p = s.length();
  int c[m][p];
  for (int j = 0; j < p; j++) c[0][j] = s[j] - '0';
  for (int i = 1; i <= m - 1; i++)
    for (int j = 0; j < p; j++) {
      char a;
      cin >> a;
      c[i][j] = a - '0';
    }
  pair<int, int> f[m][p][4][2];
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < p; j++) {
      for (int h = 0; h < 4; h++) {
        for (int k = 0; k < 2; k++) {
          int y = i;
          int x = j;
          while (x >= 0 && x < p && y >= 0 && y < m && c[y][x] == c[i][j]) {
            if (h == 0) {
              x++;
            } else if (h == 1) {
              y++;
            } else if (h == 2) {
              x--;
            } else if (h == 3) {
              y--;
            }
          }
          if (h == 0) {
            x--;
          } else if (h == 1) {
            y--;
          } else if (h == 2) {
            x++;
          } else if (h == 3) {
            y++;
          }
          int d;
          if (h == 0 && k == 0)
            d = 3;
          else if (h == 0 && k == 1)
            d = 1;
          else if (h == 1 && k == 0)
            d = 0;
          else if (h == 1 && k == 1)
            d = 2;
          else if (h == 2 && k == 0)
            d = 1;
          else if (h == 2 && k == 1)
            d = 3;
          else if (h == 3 && k == 0)
            d = 2;
          else if (h == 3 && k == 1)
            d = 0;
          while (x >= 0 && x < p && y >= 0 && y < m && c[y][x] == c[i][j]) {
            if (d == 0) {
              x++;
            } else if (d == 1) {
              y++;
            } else if (d == 2) {
              x--;
            } else if (d == 3) {
              y--;
            }
          }
          if (d == 0) {
            x--;
          } else if (d == 1) {
            y--;
          } else if (d == 2) {
            x++;
          } else if (d == 3) {
            y++;
          }
          f[i][j][h][k] = make_pair(y, x);
        }
      }
    }
  }
  int x = 0, y = 0;
  int h = 0, k = 0;
  for (int i = 0; i < n; i++) {
    y = f[y][x][h][k].first;
    x = f[y][x][h][k].second;
    if (h == 0) {
      x++;
    } else if (h == 1) {
      y++;
    } else if (h == 2) {
      x--;
    } else if (h == 3) {
      y--;
    }
    if (x >= 0 && x < p && y >= 0 && y < m && c[y][x] > 0)
      ;
    else {
      if (h == 0) {
        x--;
      } else if (h == 1) {
        y--;
      } else if (h == 2) {
        x++;
      } else if (h == 3) {
        y++;
      }
      if (k) h = (h + 1) % 4;
      k = (k + 1) % 2;
      ;
    }
  }
  cout << c[y][x] << "\n";
  return 0;
}
