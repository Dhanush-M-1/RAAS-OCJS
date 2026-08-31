#include <bits/stdc++.h>
using namespace std;
pair<int, int> p[111111];
vector<int> row[111111], col[111111];
map<pair<int, int>, bool> mp;
int main() {
  int n, res = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &p[i].first, &p[i].second);
  }
  sort(p, p + n);
  for (int i = 0; i < n; i++) {
    int x = p[i].first, y = p[i].second;
    if (row[y].size() <= col[x].size()) {
      for (int x2 : row[y])
        if (mp[{x2, y - (x - x2)}] and mp[{x, y - (x - x2)}]) res++;
    } else {
      for (int y2 : col[x])
        if (mp[{x - (y - y2), y}] and mp[{x - (y - y2), y2}]) res++;
    }
    row[y].push_back(x);
    col[x].push_back(y);
    mp[{x, y}] = true;
  }
  printf("%d", res);
  return 0;
}
