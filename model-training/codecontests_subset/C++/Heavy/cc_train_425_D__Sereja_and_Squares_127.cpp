#include <bits/stdc++.h>
using namespace std;
unordered_set<int> st[100007];
bool check(int x1, int x2, int y1, int y2) {
  return st[y1].count(x1) && st[y1].count(x2) && st[y2].count(x1) &&
         st[y2].count(x2);
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = (1); i <= (n); ++i) {
    int x, y;
    scanf("%d%d", &x, &y);
    st[x].insert(y);
  }
  vector<int> large;
  vector<int> small;
  long long ans = 0LL;
  int s = (int)sqrt(n);
  for (int i = (0); i <= (100000); ++i) {
    if ((int)st[i].size() > s)
      large.emplace_back(i);
    else
      small.emplace_back(i);
  }
  for (int i = (0); i <= ((int)large.size() - 1); ++i) {
    for (int j = (i + 1); j <= ((int)large.size() - 1); ++j) {
      int y1 = large[i];
      int y2 = large[j];
      if (st[y1].size() > st[y2].size()) swap(y1, y2);
      for (__typeof(st[y1].begin()) it = st[y1].begin(); it != st[y1].end();
           ++it) {
        int x1 = *it;
        int x2 = x1 - max(y2 - y1, y1 - y2);
        if (x2 >= 0) ans += check(x1, x2, y1, y2);
      }
    }
  }
  for (int i = (0); i <= ((int)small.size() - 1); ++i) {
    int y1 = small[i];
    for (__typeof(st[y1].begin()) _x1 = st[y1].begin(); _x1 != st[y1].end();
         ++_x1) {
      for (__typeof(st[y1].begin()) _x2 = st[y1].begin(); _x2 != st[y1].end();
           ++_x2) {
        int x1 = *_x1;
        int x2 = *_x2;
        if (x1 >= x2) continue;
        int y2 = y1 + max(x1 - x2, x2 - x1);
        if (y2 >= 0 && y2 < 100007) ans += check(x1, x2, y1, y2);
        y2 = y1 - max(x1 - x2, x2 - x1);
        if (y2 >= 0 && st[y2].size() > s) ans += check(x1, x2, y1, y2);
      }
    }
  }
  printf("%lld\n", ans);
  return 0;
}
