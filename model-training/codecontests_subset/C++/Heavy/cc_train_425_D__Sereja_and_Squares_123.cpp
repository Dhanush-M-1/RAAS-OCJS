#include <bits/stdc++.h>
using namespace std;
int n, res = 0;
vector<vector<int>> xy, yx;
vector<unordered_set<int>> xyh, yxh;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  xy.assign(1e5 + 1, vector<int>());
  yx.assign(1e5 + 1, vector<int>());
  xyh.assign(1e5 + 1, unordered_set<int>());
  yxh.assign(1e5 + 1, unordered_set<int>());
  for (int i = 0; i < n; ++i) {
    int x, y;
    cin >> x >> y;
    xy[x].push_back(y);
    yx[y].push_back(x);
    xyh[x].insert(y);
    yxh[y].insert(x);
  }
  for (int i = 0; i <= 1e5; ++i) {
    sort(xy[i].begin(), xy[i].end());
    sort(yx[i].begin(), yx[i].end());
  }
  for (int i = 0; i <= 1e5; ++i) {
    for (int j = 0; j < (int)xy[i].size(); ++j) {
      auto it = upper_bound(yx[xy[i][j]].begin(), yx[xy[i][j]].end(), i);
      if ((int)xy[i].size() - i - 1 < yx[xy[i][j]].end() - it) {
        for (int k = j + 1; k < (int)xy[i].size(); ++k) {
          int sz = xy[i][k] - xy[i][j];
          assert(sz > 0);
          if (yxh[xy[i][j]].find(i + sz) != yxh[xy[i][j]].end() &&
              yxh[xy[i][k]].find(i + sz) != yxh[xy[i][k]].end()) {
            res++;
          }
        }
      } else {
        for (int k = (it - yx[xy[i][j]].begin()); k < (int)yx[xy[i][j]].size();
             ++k) {
          int sz = yx[xy[i][j]][k] - i;
          assert(sz > 0);
          if (xyh[i].find(xy[i][j] + sz) != xyh[i].end() &&
              xyh[yx[xy[i][j]][k]].find(xy[i][j] + sz) !=
                  xyh[yx[xy[i][j]][k]].end()) {
            res++;
          }
        }
      }
    }
  }
  cout << res;
  return 0;
}
