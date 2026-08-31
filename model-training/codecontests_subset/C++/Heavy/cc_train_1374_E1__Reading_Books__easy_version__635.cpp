#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 7;
int n, m, k;
struct node {
  int t, id;
  bool operator<(const node &oth) const { return t < oth.t; }
};
vector<node> sa[4];
int sz[4], ans;
int tsz[4], tans;
int main() {
  scanf("%d%d%d", &n, &m, &k);
  int t, a, b;
  for (int i = 1; i <= n; ++i) {
    scanf("%d%d%d", &t, &a, &b);
    sa[(b << 1) + a].push_back(node{t, i});
  }
  for (int i = 0; i < 4; ++i) sort(sa[i].begin(), sa[i].end());
  ans = -1;
  tans = 0;
  for (node p : sa[3]) {
    tans += p.t;
  }
  tsz[3] = sa[3].size();
  for (int i = sa[3].size(); i >= 0; --i) {
    while (tsz[1] + tsz[3] < k) {
      if (tsz[1] >= sa[1].size()) break;
      tans += sa[1][tsz[1]++].t;
    }
    while (tsz[2] + tsz[3] < k) {
      if (tsz[2] >= sa[2].size()) break;
      tans += sa[2][tsz[2]++].t;
    }
    int rest = m - tsz[0] - tsz[1] - tsz[2] - tsz[3];
    while (rest < 0 && tsz[0] > 0) {
      tsz[0]--;
      tans -= sa[0][tsz[0]].t;
      ++rest;
    }
    while (rest > 0) {
      int Minp = -1;
      for (int j = 0; j < 4; ++j) {
        if (tsz[j] < sa[j].size() &&
            (Minp == -1 || sa[j][tsz[j]].t < sa[Minp][tsz[Minp]].t))
          Minp = j;
      }
      if (Minp == -1) break;
      tans += sa[Minp][tsz[Minp]++].t;
      --rest;
    }
    if (rest == 0 && tsz[1] + tsz[3] >= k && tsz[2] + tsz[3] >= k) {
      if (ans == -1 || ans > tans) {
        ans = tans;
        memcpy(sz, tsz, sizeof(tsz));
      }
    }
    tsz[3]--;
    if (tsz[3] >= 0) tans -= sa[3][tsz[3]].t;
  }
  printf("%d\n", ans);
  if (ans == -1) return 0;
  vector<int> res;
  for (int i = 0; i < 4; ++i) {
    for (int j = 0; j < sz[i]; ++j) {
      res.push_back(sa[i][j].id);
    }
  }
  for (int i = 0; i < res.size(); ++i) {
    printf("%d%c", res[i], i == res.size() - 1 ? '\n' : ' ');
  }
}
