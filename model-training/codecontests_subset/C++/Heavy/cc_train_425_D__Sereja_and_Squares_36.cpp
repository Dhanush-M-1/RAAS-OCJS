#include <bits/stdc++.h>
using namespace std;
const int SZ = 111111;
vector<int> xln[SZ], yln[SZ];
vector<pair<int, int> > wait[SZ];
int n, brd;
void rebuild() {
  for (int xv = 0; xv < SZ; ++xv)
    if (xln[xv].size() >= brd)
      for (auto yv : xln[xv]) yln[yv].push_back(xv);
}
int process(vector<int>* hgts) {
  for (int i = 0; i < SZ; ++i) wait[i].clear();
  for (int xv = 0; xv < SZ; ++xv) {
    if (hgts[xv].size() < brd)
      for (int fpn = 0; fpn < hgts[xv].size(); ++fpn)
        for (int spn = fpn + 1; spn < hgts[xv].size(); ++spn) {
          int fyv = hgts[xv][fpn];
          int syv = hgts[xv][spn];
          if (fyv > syv) swap(fyv, syv);
          int dlt = syv - fyv;
          if (xv + dlt < SZ) {
            wait[xv + dlt].push_back(make_pair(fyv, syv));
          }
          if (xv - dlt >= 0 && hgts[xv - dlt].size() >= brd) {
            wait[xv - dlt].push_back(make_pair(fyv, syv));
          }
        }
  }
  int retval = 0;
  vector<int> pts(SZ, -1);
  for (int xv = 0; xv < SZ; ++xv) {
    for (auto yv : hgts[xv]) pts[yv] = xv;
    for (auto& qp : wait[xv])
      if (pts[qp.first] == xv && pts[qp.second] == xv) {
        ++retval;
      }
  }
  return retval;
}
int main() {
  scanf("%d", &n);
  brd = sqrt(n) + 1;
  ;
  for (int i = 0; i < n; ++i) {
    int x, y;
    scanf("%d%d", &x, &y);
    xln[x].push_back(y);
  }
  int ans = process(xln);
  rebuild();
  ans += process(yln);
  printf("%d\n", ans);
  return 0;
}
