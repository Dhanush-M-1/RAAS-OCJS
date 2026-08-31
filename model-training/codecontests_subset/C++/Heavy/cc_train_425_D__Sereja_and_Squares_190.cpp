#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
const int sqrtmaxn = (int)sqrt(maxn + .0) + 1;
vector<int> vec[maxn];
inline bool find(int x, int y) {
  if (x >= maxn) return false;
  return binary_search(vec[x].begin(), vec[x].end(), y);
}
int main() {
  int n;
  while (~scanf("%d", &n)) {
    for (int i = 0; i < n; ++i) {
      int x, y;
      scanf("%d%d", &x, &y);
      vec[x].push_back(y);
    }
    for (int i = 0; i < maxn; ++i) sort(vec[i].begin(), vec[i].end());
    long long ans = 0;
    for (int x = 0; x < maxn; ++x) {
      if (vec[x].size() < sqrtmaxn) {
        for (int i = 0; i < vec[x].size(); ++i) {
          for (int j = i + 1; j < vec[x].size(); ++j) {
            int d = vec[x][j] - vec[x][i];
            if (find(x + d, vec[x][i]) && find(x + d, vec[x][j])) ++ans;
          }
        }
      } else {
        for (int xx = x + 1; xx < maxn; ++xx) {
          for (int i = 0; i < vec[xx].size(); ++i) {
            int yy = vec[xx][i], d = xx - x;
            if (find(x, yy) && find(x, yy + d) && find(xx, yy + d)) ++ans;
          }
        }
      }
    }
    printf("%I64d\n", ans);
  }
  return 0;
}
