#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const long double PI = acos((long double)-1);
int dr[] = {0, 0, -1, -1, -1, 1, 1, 1};
int dc[] = {-1, 1, -1, 0, 1, -1, 0, 1};
void solve() {
  int x1, y1, x2, y2, n;
  cin >> x1 >> y1 >> x2 >> y2 >> n;
  map<pair<int, int>, bool> isValid;
  for (int i = 1; i <= n; ++i) {
    int r, c1, c2;
    cin >> r >> c1 >> c2;
    for (int j = c1; j <= c2; ++j) {
      isValid[{r, j}] = true;
    }
  }
  map<pair<int, int>, int> dist;
  dist[{x1, y1}] = 0;
  queue<pair<int, int> > q;
  q.push({x1, y1});
  while (!q.empty()) {
    pair<int, int> p = q.front();
    q.pop();
    int currR = p.first, currC = p.second;
    for (int i = 0; i < 8; ++i) {
      int newR = currR + dr[i];
      int newC = currC + dc[i];
      if (isValid.count({newR, newC}) && !dist.count({newR, newC})) {
        dist[{newR, newC}] = dist[{currR, currC}] + 1;
        q.push({newR, newC});
      }
    }
  }
  if (dist.count({x2, y2})) {
    cout << dist[{x2, y2}] << '\n';
  } else {
    cout << -1 << '\n';
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
