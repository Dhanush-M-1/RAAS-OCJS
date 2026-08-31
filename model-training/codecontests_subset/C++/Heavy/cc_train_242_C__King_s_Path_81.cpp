#include <bits/stdc++.h>
using namespace std;
int main() {
  int sr = 0, sc = 0, dr = 0, dc = 0;
  cin >> sr >> sc >> dr >> dc;
  int ans = -1;
  set<pair<int, int> > pts;
  map<pair<int, int>, int> vis;
  queue<pair<pair<int, int>, int> > qu;
  qu.push({{sr, sc}, 0});
  int n = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r = 0, a = 0, b = 0;
    cin >> r >> a >> b;
    while (a <= b) {
      pts.insert({r, a});
      a++;
    }
  }
  while (!qu.empty()) {
    int r = qu.front().first.first;
    int c = qu.front().first.second;
    int d = qu.front().second;
    qu.pop();
    if (r == dr && c == dc) {
      ans = d;
      break;
    }
    if (!pts.count({r, c}) || vis[{r, c}] > 0) {
      continue;
    }
    vis[{r, c}]++;
    qu.push({{r, c + 1}, d + 1});
    qu.push({{r, c - 1}, d + 1});
    qu.push({{r + 1, c}, d + 1});
    qu.push({{r - 1, c}, d + 1});
    qu.push({{r - 1, c + 1}, d + 1});
    qu.push({{r - 1, c - 1}, d + 1});
    qu.push({{r + 1, c + 1}, d + 1});
    qu.push({{r + 1, c - 1}, d + 1});
  }
  cout << ans;
  return 0;
}
