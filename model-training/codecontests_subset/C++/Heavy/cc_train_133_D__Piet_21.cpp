#include <bits/stdc++.h>
using std::cin;
using std::cout;
using std::list;
using std::map;
using std::string;
using std::vector;
const int SIZE = 100;
int a[SIZE][SIZE];
int main() {
  int n, m, x = 1, y = 1, dp = 1, cp = 0;
  cin >> m >> n;
  for (size_t k = 1; k <= m; k++) {
    string s;
    cin >> s;
    for (size_t i = 1; i <= s.size(); i++) a[k][i] = s[i - 1] - 48;
  }
  for (size_t k = 0; k < n; k++) {
    if (dp == 1 || dp == 2 && cp == 0 || dp == 0 && cp == 1)
      while (a[y][x] == a[y][x + 1]) x++;
    if (dp == 3 || dp == 2 && cp == 1 || dp == 0 && cp == 0)
      while (a[y][x] == a[y][x - 1]) x--;
    if (dp == 2 || dp == 1 && cp == 1 || dp == 3 && cp == 0)
      while (a[y][x] == a[y + 1][x]) y++;
    if (dp == 0 || dp == 1 && cp == 0 || dp == 3 && cp == 1)
      while (a[y][x] == a[y - 1][x]) y--;
    if (dp == 0) {
      if (a[y - 1][x] != 0)
        y--;
      else {
        if (cp == 0)
          cp = 1;
        else {
          cp = 0;
          dp = 1;
        }
      }
    } else if (dp == 1) {
      if (a[y][x + 1] != 0)
        x++;
      else {
        if (cp == 0)
          cp = 1;
        else {
          cp = 0;
          dp = 2;
        }
      }
    } else if (dp == 2) {
      if (a[y + 1][x] != 0)
        y++;
      else {
        if (cp == 0)
          cp = 1;
        else {
          cp = 0;
          dp = 3;
        }
      }
    } else if (dp == 3) {
      if (a[y][x - 1] != 0)
        x--;
      else {
        if (cp == 0)
          cp = 1;
        else {
          cp = 0;
          dp = 0;
        }
      }
    }
  }
  cout << a[y][x];
  return 0;
}
