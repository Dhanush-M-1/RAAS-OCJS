#include <bits/stdc++.h>
using namespace std;
void RI() {}
template <typename... T>
void RI(int& head, T&... tail) {
  scanf("%d", &head);
  RI(tail...);
}
int n;
pair<int, int> p[100010];
vector<int> vx[100010], vy[100010];
inline bool has(int x, int y) {
  return binary_search(p, p + n, make_pair(x, y));
}
inline bool has(const vector<int>& v, int x) {
  return binary_search(begin(v), end(v), x);
}
int main() {
  RI(n);
  for (int i = 0; i < int(n); i++) RI(p[i].first, p[i].second);
  sort(p, p + n);
  int ans = 0;
  for (int i = 0; i < int(n); i++) {
    int x = p[i].first, y = p[i].second, d = x - y;
    if (((int)(vx[x]).size()) < ((int)(vy[y]).size())) {
      for (auto it = (vx[x]).begin(); it != (vx[x]).end(); it++)
        if (has(vy[y], *it + d) && has(*it + d, *it)) ans++;
    } else {
      for (auto it = (vy[y]).begin(); it != (vy[y]).end(); it++)
        if (has(vx[x], *it - d) && has(*it, *it - d)) ans++;
    }
    vx[x].push_back(y);
    vy[y].push_back(x);
  }
  printf("%d\n", ans);
  return 0;
}
