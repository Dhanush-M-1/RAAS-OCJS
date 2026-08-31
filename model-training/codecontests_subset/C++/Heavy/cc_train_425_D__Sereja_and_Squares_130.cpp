#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
int n;
pair<int, int> pt[N];
vector<int> vx[N], vy[N];
set<pair<int, int> > st;
void GetData() {
  scanf("%d", &n);
  for (int x, y, i = 0; i < n; ++i) {
    scanf("%d%d", &x, &y);
    vx[x].push_back(y);
    vy[y].push_back(x);
    st.insert(make_pair(x, y));
    pt[i] = make_pair(x, y);
  }
}
void Solve() {
  int i, j, k, p, q, x, y, ans = 0;
  for (i = 0; i < N; ++i) {
    if ((int)vx[i].size() > 0) {
      sort(vx[i].begin(), vx[i].end());
      vx[i].erase(unique(vx[i].begin(), vx[i].end()), vx[i].end());
    }
    if ((int)vy[i].size() > 0) {
      sort(vy[i].begin(), vy[i].end());
      vy[i].erase(unique(vy[i].begin(), vy[i].end()), vy[i].end());
    }
  }
  for (i = 0; i < n; ++i) {
    x = pt[i].first;
    y = pt[i].second;
    p = lower_bound(vy[y].begin(), vy[y].end(), x) - vy[y].begin();
    q = lower_bound(vx[x].begin(), vx[x].end(), y) - vx[x].begin();
    for (j = p - 1, k = q - 1; j >= 0 && k >= 0;) {
      if (x - vy[y][j] < y - vx[x][k])
        --j;
      else if (x - vy[y][j] > y - vx[x][k])
        --k;
      else {
        if (st.find(make_pair(vy[y][j], vx[x][k])) != st.end()) ans++;
        --j;
        --k;
      }
    }
  }
  printf("%d\n", ans);
}
int main() {
  GetData();
  Solve();
  return 0;
}
