#include <bits/stdc++.h>
using namespace std;
const int N = 100001;
vector<int> xx[N], yy[N];
int n;
unordered_set<int> M[N * 2];
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (int x, y, i = 0; i < n; ++i) {
    cin >> x >> y;
    M[x].insert(y);
    xx[x].push_back(y);
    yy[y].push_back(x);
  }
  for (int i = 0; i < N; ++i) {
    sort(xx[i].begin(), xx[i].end());
    sort(yy[i].begin(), yy[i].end());
  }
  long long rr = 0;
  vector<int>::iterator itx, ity;
  for (int lx, ly, x = 0; x < N; ++x) {
    for (int y : xx[x]) {
      itx = upper_bound(yy[y].begin(), yy[y].end(), x);
      lx = yy[y].end() - itx;
      ity = upper_bound(xx[x].begin(), xx[x].end(), y);
      ly = xx[x].end() - ity;
      if (lx < ly) {
        for (int l; itx != yy[y].end(); ++itx) {
          l = (*itx) - x;
          rr += M[x].count(y + l) * M[x + l].count(y + l);
        }
      } else {
        for (int l; ity != xx[x].end(); ++ity) {
          l = (*ity) - y;
          rr += M[x + l].count(y) * M[x + l].count(y + l);
        }
      }
    }
  }
  cout << rr;
  return 0;
}
