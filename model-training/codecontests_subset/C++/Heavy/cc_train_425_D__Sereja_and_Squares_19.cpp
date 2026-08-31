#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > a, b;
int n, s;
int main() {
  int i, j, x, y;
  scanf("%d", &n);
  for (i = 0; i < n; ++i) {
    scanf("%d%d", &x, &y);
    a.push_back(pair<int, int>(x, y));
    b.push_back(pair<int, int>(y, x));
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  for (i = 0; i < n; ++i) {
    x = a[i].first;
    y = a[i].second;
    vector<pair<int, int> >::iterator it =
        lower_bound(b.begin(), b.end(), pair<int, int>(y, x));
    for (j = i + 1;
         j < n && a[j].first == x && it != b.end() && it->first == y;) {
      int yy = a[j].second;
      int xx = it->second;
      int dx = xx - x;
      int dy = yy - y;
      if (dx < dy)
        ++it;
      else if (dy < dx)
        ++j;
      else {
        ++it;
        ++j;
        if (binary_search(a.begin(), a.end(), pair<int, int>(xx, yy))) ++s;
      }
    }
  }
  printf("%d\n", s);
  return 0;
}
