#include <bits/stdc++.h>
using namespace std;
int n;
pair<int, int> p[100005];
set<int> x[100005], y[100005];
bool BS(pair<int, int> t, int l, int r) {
  while (l <= r) {
    int mid = (l + r) >> 1;
    if (t < p[mid]) {
      r = mid - 1;
    } else if (t > p[mid]) {
      l = mid + 1;
    } else {
      return 1;
    }
  }
  return 0;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d%d", &p[i].first, &p[i].second);
    x[p[i].first].insert(p[i].second);
    y[p[i].second].insert(p[i].first);
  }
  sort(p + 1, p + 1 + n);
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    set<int>::iterator j = y[p[i].second].upper_bound(p[i].first);
    set<int>::iterator k = x[p[i].first].upper_bound(p[i].second);
    while (j != y[p[i].second].end() && k != x[p[i].first].end()) {
      if (*j - p[i].first < *k - p[i].second) {
        j++;
      } else if (*j - p[i].first > *k - p[i].second) {
        k++;
      } else {
        if (BS(make_pair(*j, *k), 1, n)) {
          ans++;
        }
        j++;
        k++;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
