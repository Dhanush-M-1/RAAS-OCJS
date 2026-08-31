#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
vector<int> xs[maxn], ys[maxn];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    xs[y].push_back(x);
  }
  for (int i = 0; i < maxn; i++) {
    sort(xs[i].begin(), xs[i].end());
  }
  int SQRT = (int)sqrt(n) + 1;
  long long int ans = 0;
  for (int i = 0; i < maxn; i++) {
    if (xs[i].size() <= SQRT) {
      for (int j = 0; j < xs[i].size(); j++) {
        int x1 = xs[i][j];
        for (int k = j + 1; k < xs[i].size(); k++) {
          int x2 = xs[i][k];
          int dist = x2 - x1;
          int y2 = i + dist;
          if (y2 < maxn) {
            if (binary_search(xs[y2].begin(), xs[y2].end(), x1) &&
                binary_search(xs[y2].begin(), xs[y2].end(), x2)) {
              ans++;
            }
          }
          y2 = i - dist;
          if (y2 >= 0) {
            if (binary_search(xs[y2].begin(), xs[y2].end(), x1) &&
                binary_search(xs[y2].begin(), xs[y2].end(), x2)) {
              ans++;
            }
          }
        }
      }
      xs[i].clear();
    } else {
      for (int j = 0; j < xs[i].size(); j++) {
        ys[xs[i][j]].push_back(i);
      }
    }
  }
  for (int x = 0; x < maxn; x++) {
    assert(ys[x].size() <= SQRT);
    for (int i = 0; i < ys[x].size(); i++) {
      int y1 = ys[x][i];
      for (int j = i + 1; j < ys[x].size(); j++) {
        int y2 = ys[x][j];
        int x2 = x + (y2 - y1);
        if (x2 < maxn) {
          if (binary_search(ys[x2].begin(), ys[x2].end(), y1) &&
              binary_search(ys[x2].begin(), ys[x2].end(), y2)) {
            ans++;
          }
        }
      }
    }
  }
  printf("%lld\n", ans);
  return 0;
}
