#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 9;
int n, x, y, ans, mv, markx[N];
map<pair<int, int>, bool> mark;
pair<int, int> point[N];
vector<int> bx[N], by[N], bxy[N * 2];
bool check_is(pair<int, int> p) {
  int l = 0, r = mv, mid;
  while (l + 1 < r) {
    mid = (l + r) / 2;
    if (point[mid] <= p)
      l = mid;
    else
      r = mid;
  }
  return (point[l] == p);
}
bool calc(int x, int y, int an) {
  int t = max(x - point[an].first, y - point[an].second);
  return (check_is(make_pair(x - t, y)) && check_is(make_pair(x, y - t)) &&
          check_is(make_pair(x - t, y - t)));
}
void solve(int x, int y, int an) {
  int xy = x - y + N;
  mv = an;
  int mn = min(bxy[xy].size(), min(bx[x].size(), by[y].size()));
  if (mn == bx[x].size()) {
    for (int i = 0; i < bx[x].size(); i++) ans += calc(x, y, bx[x][i]);
  } else if (mn == by[y].size()) {
    for (int i = 0; i < by[y].size(); i++) ans += calc(x, y, by[y][i]);
  } else {
    for (int i = 0; i < bxy[xy].size(); i++) ans += calc(x, y, bxy[xy][i]);
  }
  bx[x].push_back(an);
  by[y].push_back(an);
  bxy[xy].push_back(an);
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &x, &y);
    ;
    mark[make_pair(x, y)] = 1;
    point[i] = make_pair(x, y);
  }
  sort(point, point + n);
  for (int i = 0; i < n; i++) solve(point[i].first, point[i].second, i);
  cout << ans << '\n';
}
