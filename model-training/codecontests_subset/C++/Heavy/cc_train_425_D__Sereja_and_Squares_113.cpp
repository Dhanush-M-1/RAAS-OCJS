#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
const int sqrtmaxn = (int)sqrt(maxn) + 1;
vector<int> v[maxn];
int ans;
inline bool find(int x, int y) {
  if (x >= maxn) return false;
  return binary_search(v[x].begin(), v[x].end(), y);
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    int x, y;
    scanf("%d%d", &x, &y);
    v[x].push_back(y);
  }
  for (int i = 0; i < maxn; i++) sort(v[i].begin(), v[i].end());
  for (int x = 0; x < maxn; x++) {
    if (v[x].size() <= sqrtmaxn) {
      for (int i = 0; i < v[x].size(); i++) {
        for (int j = i + 1; j < v[x].size(); j++) {
          int d = v[x][j] - v[x][i];
          if (find(x + d, v[x][i]) && find(x + d, v[x][j])) ans++;
        }
      }
    } else {
      for (int xx = x + 1; xx < maxn; xx++) {
        for (int i = 0; i < v[xx].size(); i++) {
          int yy = v[xx][i], d = xx - x;
          if (find(x, yy) && find(x, yy + d) && find(xx, yy + d)) ans++;
        }
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
