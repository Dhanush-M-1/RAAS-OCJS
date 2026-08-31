#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n, m;
  vector<vector<int> > used, blocks, desk;
  cin >> m >> n >> s;
  int h = s.length();
  used = vector<vector<int> >(m, vector<int>(h, 0));
  desk = vector<vector<int> >(m, vector<int>(h));
  for (int i = 0; i < m; ++i) {
    for (int j = 0; j < h; ++j) desk[i][j] = s[j] - '0';
    cin >> s;
  }
  int curr = 1;
  for (int i = 0; i < m; ++i)
    for (int j = 0; j < h; ++j)
      if (used[i][j] == 0 && desk[i][j] != 0) {
        int st_j = j, fn_j = j, st_i = i, fn_i = i;
        for (int g = j + 1; g < h && desk[i][g] == desk[i][j]; ++g, ++fn_j)
          ;
        for (int g = i + 1; g < m && desk[g][j] == desk[i][j]; ++g, ++fn_i)
          ;
        blocks.push_back(vector<int>(4));
        blocks[curr - 1][0] = st_i;
        blocks[curr - 1][1] = st_j;
        blocks[curr - 1][2] = fn_i;
        blocks[curr - 1][3] = fn_j;
        for (int q = st_i; q <= fn_i; ++q)
          for (int p = st_j; p <= fn_j; ++p) used[q][p] = curr;
        ++curr;
      }
  int d = 0, c = 0, pos = 1, x, y;
  for (int q = 0; q < n; ++q) {
    x = ((d == 1 || (d == 0 && c == 1) || (d == 2 && c == 0))
             ? blocks[pos - 1][2]
             : blocks[pos - 1][0]) +
        ((d == 1)   ? 1
         : (d == 3) ? -1
                    : 0);
    y = ((d == 0 || (d == 1 && c == 0) || (d == 3 && c == 1))
             ? blocks[pos - 1][3]
             : blocks[pos - 1][1]) +
        ((d == 0)   ? 1
         : (d == 2) ? -1
                    : 0);
    if ((x >= 0 && x < m) && (y >= 0 && y < h) && used[x][y] != 0) {
      pos = used[x][y];
    } else {
      if (c == 0) {
        c = 1;
      } else {
        c = 0;
        d = (d + 1) % 4;
      }
    }
  }
  cout << desk[blocks[pos - 1][0]][blocks[pos - 1][1]];
  return 0;
}
