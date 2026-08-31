#include <bits/stdc++.h>
using namespace std;
int x[110000];
int y[110000];
vector<vector<int> > vx(110000), vy(110000), xy(210000), yx(210000);
vector<set<int> > sx(110000), sy(110000);
int main(int argc, char** argv) {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &x[i], &y[i]);
  }
  for (int i = 0; i < n; i++) {
    vx[x[i]].push_back(i);
    vy[y[i]].push_back(i);
    yx[y[i] - x[i] + 100000].push_back(i);
    xy[x[i] - y[i] + 100000].push_back(i);
    sx[x[i]].insert(y[i]);
    sy[y[i]].insert(x[i]);
  }
  long long s1 = 0, s2 = 0, s3 = 0, s4 = 0;
  for (int i = 0; i < vx.size(); i++) s1 += vx[i].size() * vx[i].size();
  for (int i = 0; i < vy.size(); i++) s2 += vy[i].size() * vy[i].size();
  for (int i = 0; i < xy.size(); i++) s3 += xy[i].size() * xy[i].size();
  for (int i = 0; i < yx.size(); i++) s4 += yx[i].size() * yx[i].size();
  long long result = 0;
  if (s1 <= s2 && s1 <= s3 && s1 <= s4) {
    for (int i = 0; i < vx.size(); i++) {
      for (int j = 0; j < vx[i].size(); j++)
        for (int k = j + 1; k < vx[i].size(); k++) {
          int p1 = vx[i][j], p2 = vx[i][k];
          int len = fabs(y[p1] - y[p2]);
          if (sx[x[p1] + len].count(y[p1]) > 0 &&
              sx[x[p1] + len].count(y[p2]) > 0)
            result++;
        }
    }
  } else if (s2 <= s1 && s2 <= s3 && s2 <= s4) {
    for (int i = 0; i < vy.size(); i++) {
      for (int j = 0; j < vy[i].size(); j++)
        for (int k = j + 1; k < vy[i].size(); k++) {
          int p1 = vy[i][j], p2 = vy[i][k];
          int len = fabs(x[p1] - x[p2]);
          if (sy[y[p1] + len].count(x[p1]) > 0 &&
              sy[y[p1] + len].count(x[p2]) > 0)
            result++;
        }
    }
  } else if (s3 <= s2 && s3 <= s1 && s3 <= s4) {
    for (int i = 0; i < xy.size(); i++) {
      for (int j = 0; j < xy[i].size(); j++)
        for (int k = j + 1; k < xy[i].size(); k++) {
          int p1 = xy[i][j], p2 = xy[i][k];
          if (s1 <= s2 && sx[x[p1]].count(y[p2]) > 0 &&
              sx[x[p2]].count(y[p1]) > 0)
            result++;
          if (s2 < s1 && sy[y[p1]].count(x[p2]) > 0 &&
              sy[y[p2]].count(x[p1]) > 0)
            result++;
        }
    }
  } else {
    for (int i = 0; i < yx.size(); i++) {
      for (int j = 0; j < yx[i].size(); j++)
        for (int k = j + 1; k < yx[i].size(); k++) {
          int p1 = yx[i][j], p2 = yx[i][k];
          if (s1 <= s2 && sx[x[p1]].count(y[p2]) > 0 &&
              sx[x[p2]].count(y[p1]) > 0)
            result++;
          if (s2 < s1 && sy[y[p1]].count(x[p2]) > 0 &&
              sy[y[p2]].count(x[p1]) > 0)
            result++;
        }
    }
  }
  cout << result;
  return 0;
}
