#include <bits/stdc++.h>
using namespace std;
short INF = 51;
struct block {
  short xl, yl, xr, yr;
  short col;
  block(short a, short b, short c, short d, short f) {
    xl = a;
    yl = b;
    xr = c;
    yr = d;
    col = f;
  }
  block() {
    xl = -1;
    yl = -1;
    xr = INF;
    yr = INF;
    col = -1;
  }
};
int main() {
  short n, n2;
  int m;
  cin >> n >> m;
  vector<string> tab(n);
  for (short i = 0; i < n; i++) {
    cin >> tab[i];
  }
  n2 = tab[0].size();
  vector<vector<short> > was(n + 2, vector<short>(n2 + 2, -1));
  vector<block> vec;
  short coun = -1;
  for (short i = 0; i < n; i++) {
    for (short j = 0; j < n2; j++) {
      if (was[i + 1][j + 1] == -1) {
        coun++;
        short maxx = 0, maxy = 0;
        queue<pair<short, short> > q;
        q.push({i, j});
        while (!q.empty()) {
          short x = q.front().first;
          short y = q.front().second;
          q.pop();
          if (was[x + 1][y + 1] != -1) {
            continue;
          }
          was[x + 1][y + 1] = coun;
          if (y + 1 < n2) {
            if (tab[x][y] == tab[x][y + 1]) {
              q.push({x, y + 1});
            } else {
              maxy = y;
            }
          } else {
            maxy = y;
          }
          if (x + 1 < n) {
            if (tab[x + 1][y] == tab[x][y]) {
              q.push({x + 1, y});
            } else {
              maxx = x;
            }
          } else {
            maxx = x;
          }
        }
        vec.push_back(block(i + 1, j + 1, maxx + 1, maxy + 1, tab[i][j] - '0'));
      }
    }
  }
  vec.push_back(block(-1, -1, -1, -1, 0));
  coun++;
  for (short i = 0; i <= n + 1; i++) {
    was[i][0] = coun;
    was[i][n2 + 1] = coun;
  }
  for (short i = 0; i <= n2 + 1; i++) {
    was[n + 1][i] = coun;
    was[0][i] = coun;
  }
  short dp = 0, cp = 1, bp = 0;
  vector<vector<short> > ans(coun, vector<short>(8, -1));
  bool w = true;
  for (int i = 0; i < m; i++) {
    if (w) {
      if (dp == 4 && cp == 1 && ans[bp][0] != -1) {
        w = false;
        m %= i - ans[bp][0];
        i = 0;
      }
      w = false;
      if (dp == 4 && cp == 0 && ans[bp][1] != -1) {
        w = false;
        m %= i - ans[bp][1];
        i = 0;
      }
      if (dp == 0 && cp == 1 && ans[bp][2] != -1) {
        w = false;
        m %= i - ans[bp][2];
        i = 0;
      }
      if (dp == 0 && cp == 0 && ans[bp][3] != -1) {
        w = false;
        m %= i - ans[bp][3];
        i = 0;
      }
      if (dp == 1 && cp == 1 && ans[bp][4] != -1) {
        w = false;
        m %= i - ans[bp][4];
        i = 0;
      }
      if (dp == 1 && cp == 0 && ans[bp][5] != -1) {
        w = false;
        m %= i - ans[bp][5];
        i = 0;
      }
      if (dp == 2 && cp == 1 && ans[bp][6] != -1) {
        w = false;
        m %= i - ans[bp][6];
        i = 0;
      }
      if (dp == 2 && cp == 0 && ans[bp][7] != -1) {
        w = false;
        m %= i - ans[bp][7];
        i = 0;
      }
    }
    if (dp == 4 && cp == 1) {
      ans[bp][0] = i;
      if (vec[was[vec[bp].xl - 1][vec[bp].yl]].col == 0) {
        cp = 0;
      } else {
        bp = was[vec[bp].xl - 1][vec[bp].yl];
      }
      continue;
    }
    if (dp == 4 && cp == 0) {
      ans[bp][1] = i;
      if (vec[was[vec[bp].xl - 1][vec[bp].yr]].col == 0) {
        dp = 0;
        cp = 1;
      } else {
        bp = was[vec[bp].xl - 1][vec[bp].yr];
      }
      continue;
    }
    if (dp == 0 && cp == 1) {
      ans[bp][2] = i;
      if (vec[was[vec[bp].xl][vec[bp].yr + 1]].col == 0) {
        cp = 0;
      } else {
        bp = was[vec[bp].xl][vec[bp].yr + 1];
      }
      continue;
    }
    if (dp == 0 && cp == 0) {
      ans[bp][3] = i;
      if (vec[was[vec[bp].xr][vec[bp].yr + 1]].col == 0) {
        dp = 1;
        cp = 1;
      } else {
        bp = was[vec[bp].xr][vec[bp].yr + 1];
      }
      continue;
    }
    if (dp == 1 && cp == 1) {
      ans[bp][4] = i;
      if (vec[was[vec[bp].xr + 1][vec[bp].yr]].col == 0) {
        cp = 0;
      } else {
        bp = was[vec[bp].xr + 1][vec[bp].yr];
      }
      continue;
    }
    if (dp == 1 && cp == 0) {
      ans[bp][5] = i;
      if (vec[was[vec[bp].xr + 1][vec[bp].yl]].col == 0) {
        dp = 2;
        cp = 1;
      } else {
        bp = was[vec[bp].xr + 1][vec[bp].yl];
      }
      continue;
    }
    if (dp == 2 && cp == 1) {
      ans[bp][6] = i;
      if (vec[was[vec[bp].xr][vec[bp].yl - 1]].col == 0) {
        cp = 0;
      } else {
        bp = was[vec[bp].xr][vec[bp].yl - 1];
      }
      continue;
    }
    if (dp == 2 && cp == 0) {
      ans[bp][7] = i;
      if (vec[was[vec[bp].xl][vec[bp].yl - 1]].col == 0) {
        dp = 4;
        cp = 1;
      } else {
        bp = was[vec[bp].xl][vec[bp].yl - 1];
      }
      continue;
    }
  }
  cout << vec[bp].col;
  return 0;
}
