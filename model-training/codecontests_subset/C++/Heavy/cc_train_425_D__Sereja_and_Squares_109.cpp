#include <bits/stdc++.h>
using namespace std;
template <class T>
T sqr(T x) {
  return x * x;
}
struct sp {
  int x, y;
  bool operator<(const sp &a) const { return x < a.x || x == a.x && y < a.y; }
  bool operator==(const sp &a) const { return x == a.x && y == a.y; }
};
namespace std {
template <>
struct hash<sp> {
  size_t operator()(sp a) const { return a.x * 9875321 + a.y; }
};
}  // namespace std
unordered_map<sp, int> m1;
vector<int> b;
vector<int> a[110000];
int n, m, ans;
int main() {
  int i, j, k, x, y, d;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d%d", &x, &y);
    a[x].push_back(y);
    m1[sp{x, y}] = 1;
  }
  m = sqrt(n);
  for (i = 0; i <= 100000; i++)
    if (a[i].size() >= m) b.push_back(i);
  for (i = 0; i < b.size(); i++)
    for (j = i + 1; j < b.size(); j++) {
      d = b[j] - b[i];
      x = b[i];
      for (k = 0; k < a[x].size(); k++) {
        y = a[x][k];
        if (m1.count(sp{x + d, y}) && m1.count(sp{x, y + d}) &&
            m1.count(sp{x + d, y + d}))
          ans++;
      }
    }
  for (i = 0; i <= 100000; i++)
    if (a[i].size() < m) {
      sort(a[i].begin(), a[i].end());
      x = i;
      for (j = 0; j < a[x].size(); j++) {
        y = a[x][j];
        for (k = j + 1; k < a[x].size(); k++) {
          d = a[x][k] - a[x][j];
          if (m1.count(sp{x + d, y}) && m1.count(sp{x + d, y + d})) ans++;
          if (x - d >= 0 && a[x - d].size() >= m)
            if (m1.count(sp{x - d, y}) && m1.count(sp{x - d, y + d})) ans++;
        }
      }
    }
  printf("%d\n", ans);
}
