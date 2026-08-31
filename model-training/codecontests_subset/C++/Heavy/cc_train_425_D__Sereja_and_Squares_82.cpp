#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > h[100002];
vector<int> a[100002];
vector<int> xx;
vector<int> block;
bool v[100002];
bool mark[100002];
int n, bm, xn, ans;
int solveBlock(int i, int j) {
  i = xx[i];
  j = xx[j];
  int delta = j - i, s = 0;
  int q = 0, pp = 0, qq = 0;
  for (int p = 0; p < a[i].size(); ++p) {
    while (q < a[j].size() && a[j][q] < a[i][p]) ++q;
    if (q > a[j].size()) break;
    if (a[i][p] == a[j][q]) {
      while (pp < a[i].size() && a[i][pp] < a[i][p] + delta) ++pp;
      if (pp > a[i].size()) break;
      while (qq < a[j].size() && a[j][qq] < a[j][q] + delta) ++qq;
      if (qq > a[j].size()) break;
      if (a[i][pp] == a[i][p] + delta && a[j][qq] == a[j][q] + delta) ++s;
    }
  }
  return s;
}
int main() {
  int i, j, x, y, p, q;
  scanf("%d", &n);
  bm = sqrt(n);
  for (i = 0; i < n; ++i) {
    scanf("%d%d", &x, &y);
    a[x].push_back(y);
    xx.push_back(x);
  }
  sort(xx.begin(), xx.end());
  xn = unique(xx.begin(), xx.end()) - xx.begin();
  for (i = 0; i < xn; ++i) {
    j = xx[i];
    sort(a[j].begin(), a[j].end());
    if (a[j].size() >= bm) {
      v[i] = 1;
      block.push_back(i);
    }
  }
  for (i = 0; i < block.size(); ++i)
    for (j = i + 1; j < block.size(); ++j)
      ans += 2 * solveBlock(block[i], block[j]);
  for (i = 0; i < xn; ++i)
    if (!v[i]) {
      j = xx[i];
      for (p = 0; p < a[j].size(); ++p)
        for (q = p + 1; q < a[j].size(); ++q) {
          int delta = a[j][q] - a[j][p];
          if (j - delta >= 0 && a[j - delta].size())
            h[j - delta].push_back(pair<int, int>(a[j][p], a[j][q]));
          if (j + delta < 100002 && a[j + delta].size())
            h[j + delta].push_back(pair<int, int>(a[j][p], a[j][q]));
        }
    }
  for (i = 0; i < xn; ++i) {
    j = xx[i];
    for (p = 0; p < a[j].size(); ++p) mark[a[j][p]] = 1;
    for (p = 0; p < h[j].size(); ++p)
      if (mark[h[j][p].first] && mark[h[j][p].second]) {
        if (v[i])
          ans += 2;
        else
          ++ans;
      }
    for (p = 0; p < a[j].size(); ++p) mark[a[j][p]] = 0;
  }
  printf("%d\n", ans / 2);
  return 0;
}
