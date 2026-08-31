#include <bits/stdc++.h>
using namespace std;
template <class T>
T sqr(T x) {
  return x * x;
}
namespace std {
template <>
struct hash<pair<int, int> > {
  int operator()(pair<int, int> a) const {
    return a.first * 1234567 + a.second;
  }
};
}  // namespace std
unordered_map<pair<int, int>, int> m1;
vector<int> b;
vector<int> a[110000];
int n, m, ans;
int main() {
  int i, j, k, x, y, d;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d%d", &x, &y);
    a[x].push_back(y);
    m1[pair<int, int>(x, y)] = 1;
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
        if (m1.count(pair<int, int>(x + d, y)) &&
            m1.count(pair<int, int>(x, y + d)) &&
            m1.count(pair<int, int>(x + d, y + d)))
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
          if (m1.count(pair<int, int>(x + d, y)) &&
              m1.count(pair<int, int>(x + d, y + d)))
            ans++;
          if (x - d >= 0 && a[x - d].size() >= m)
            if (m1.count(pair<int, int>(x - d, y)) &&
                m1.count(pair<int, int>(x - d, y + d)))
              ans++;
        }
      }
    }
  printf("%d\n", ans);
}
