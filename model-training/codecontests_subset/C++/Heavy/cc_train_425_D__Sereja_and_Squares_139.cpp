#include <bits/stdc++.h>
const int N = 200005;
using namespace std;
int n, blo, h[N], g[N];
struct poi {
  int x, y;
} a[N];
vector<int> P[N];
bool cmp(poi a, poi b) { return (a.x < b.x || (a.x == b.x && a.y < b.y)); }
bool find(int x, int y) {
  int l = 0, r = (int)P[x].size() - 1;
  for (; l <= r;) {
    int mid = (l + r) / 2;
    if (P[x][mid] == y) return true;
    if (y < P[x][mid])
      r = mid - 1;
    else
      l = mid + 1;
  }
  return false;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d%d", &a[i].x, &a[i].y);
  }
  sort(a + 1, a + n + 1, cmp);
  for (int i = 1; i <= n; ++i) P[a[i].x].push_back(a[i].y);
  blo = 200;
  long long ans = 0;
  for (int i = 0; i <= (N - 5) / 2; ++i)
    if ((int)P[i].size() >= blo) {
      for (int k = 0; k <= (int)P[i].size() - 1; ++k) ++g[P[i][k]];
      for (int j = i + 1; j <= (N - 5) / 2; ++j) {
        for (int k = 0; k <= (int)P[j].size() - 1; ++k) ++h[P[j][k]];
        for (int k = 0; k <= (int)P[j].size() - 1; ++k)
          if (g[P[j][k]] && h[P[j][k] + j - i] && g[P[j][k] + j - i]) ++ans;
        for (int k = 0; k <= (int)P[j].size() - 1; ++k) --h[P[j][k]];
      }
      for (int k = 0; k <= (int)P[i].size() - 1; ++k) --g[P[i][k]];
    }
  for (int i = 0; i <= (N - 5) / 2; ++i)
    if (P[i].size() < blo) {
      for (int j = 0; j <= (int)P[i].size() - 1; ++j)
        for (int k = j + 1; k <= (int)P[i].size() - 1; ++k) {
          int x = P[i][j], y = P[i][k], L = y - x;
          if (find(i + L, x) && find(i + L, y)) ++ans;
        }
    }
  printf("%lld\n", ans);
  return 0;
}
