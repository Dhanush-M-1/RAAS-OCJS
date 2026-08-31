#include <bits/stdc++.h>
using namespace std;
const int maxq = 100001;
const int bord = 500;
vector<int> xs[maxq];
bool exists(int x, int y) {
  if (x >= maxq) return false;
  return binary_search((xs[x]).begin(), (xs[x]).end(), y);
}
int main() {
  int N;
  scanf("%d", &N);
  for (int i = 0; i < (int)(N); ++i) {
    int x, y;
    scanf("%d%d", &x, &y);
    xs[x].push_back(y);
  }
  for (int i = 0; i < (int)(maxq); ++i) {
    sort((xs[i]).begin(), (xs[i]).end());
  }
  long long ans = 0;
  for (int x = 0; x < (int)(maxq); ++x) {
    if (xs[x].size() < bord) {
      for (int i = 0; i < (int)(xs[x].size()); ++i) {
        for (int j = i + 1; j < xs[x].size(); ++j) {
          int d = xs[x][j] - xs[x][i];
          if (exists(x + d, xs[x][i]) && exists(x + d, xs[x][j])) {
            ++ans;
          }
        }
      }
    } else {
      for (int xx = x + 1; xx < maxq; ++xx) {
        for (int i = 0; i < (int)(xs[xx].size()); ++i) {
          int yy = xs[xx][i];
          int d = xx - x;
          if (exists(x, yy) && exists(x, yy + d) && exists(xx, yy + d)) {
            ++ans;
          }
        }
      }
    }
  }
  cout << ans << '\n';
  return 0;
}
