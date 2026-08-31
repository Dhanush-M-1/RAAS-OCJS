#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> vx[100001], vy[100001];
unordered_set<int> sx[100001], sy[100001];
int x[100000], y[100000];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < (int)(n); i++) {
    scanf("%d%d", x + i, y + i);
    vx[x[i]].push_back(y[i]);
    vy[y[i]].push_back(x[i]);
    sx[x[i]].insert(y[i]);
    sy[y[i]].insert(x[i]);
  }
  int ans = 0;
  for (int i = 0; i < (int)(n); i++) {
    if (vx[x[i]].size() < vy[y[i]].size()) {
      for (int e = 0; e < (int)(vx[x[i]].size()); e++)
        if (vx[x[i]][e] > y[i] && sy[y[i]].count(x[i] + vx[x[i]][e] - y[i]) &&
            sy[vx[x[i]][e]].count(x[i] + vx[x[i]][e] - y[i]))
          ++ans;
    } else {
      for (int e = 0; e < (int)(vy[y[i]].size()); e++)
        if (vy[y[i]][e] > x[i] && sx[x[i]].count(y[i] + vy[y[i]][e] - x[i]) &&
            sx[vy[y[i]][e]].count(y[i] + vy[y[i]][e] - x[i]))
          ++ans;
    }
  }
  cout << ans << endl;
  return 0;
}
