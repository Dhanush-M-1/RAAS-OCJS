#include <bits/stdc++.h>
#pragma GCC optimize "O3"
using namespace std;
constexpr int N = 100001;
int n;
vector<int> xs[N], ys[N];
pair<int, int> pts[N];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d %d", &pts[i].first, &pts[i].second);
    xs[pts[i].first].push_back(pts[i].second);
    ys[pts[i].second].push_back(pts[i].first);
  }
  for (int i = 0; i < N; ++i) {
    sort(xs[i].begin(), xs[i].end());
    sort(ys[i].begin(), ys[i].end());
  }
  long long ans = 0;
  for (int i = 0; i < n; ++i) {
    const int &x = pts[i].first, &y = pts[i].second;
    if (xs[x].size() < ys[y].size()) {
      for (int ny : xs[x]) {
        if (ny <= y) continue;
        int l = abs(ny - y);
        ans += (binary_search(ys[y].begin(), ys[y].end(), x + l) &&
                binary_search(ys[ny].begin(), ys[ny].end(), x + l));
      }
    } else {
      for (int nx : ys[y]) {
        if (nx <= x) continue;
        int l = abs(nx - x);
        ans += (binary_search(xs[x].begin(), xs[x].end(), y + l) &&
                binary_search(xs[nx].begin(), xs[nx].end(), y + l));
      }
    }
  }
  printf("%lld\n", ans);
}
