#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, bool> mp;
map<pair<int, int>, int> depth;
void bfs(int x0, int y0, int x1, int y1) {
  queue<pair<int, int> > q;
  q.push({x0, y0});
  depth[{x0, y0}] = 0;
  while (!q.empty()) {
    auto fr = q.front();
    q.pop();
    if (mp[make_pair(fr.first + 1, fr.second)] == true &&
        depth[make_pair(fr.first + 1, fr.second)] == -1) {
      depth[make_pair(fr.first + 1, fr.second)] = depth[fr] + 1;
      q.push(make_pair(fr.first + 1, fr.second));
    }
    if (mp[{fr.first, fr.second + 1}] == 1 &&
        depth[{fr.first, 1 + fr.second}] == -1) {
      depth[{fr.first, fr.second + 1}] = depth[fr] + 1;
      q.push({fr.first, fr.second + 1});
    }
    if (mp[{fr.first - 1, fr.second}] == 1 &&
        depth[{fr.first - 1, fr.second}] == -1) {
      depth[{fr.first - 1, fr.second}] = depth[fr] + 1;
      q.push({fr.first - 1, fr.second});
    }
    if (mp[{fr.first, fr.second - 1}] == 1 &&
        depth[{fr.first, fr.second - 1}] == -1) {
      depth[{fr.first, fr.second - 1}] = depth[fr] + 1;
      q.push({fr.first, fr.second - 1});
    }
    if (mp[{fr.first + 1, fr.second + 1}] == 1 &&
        depth[{fr.first + 1, fr.second + 1}] == -1) {
      depth[{fr.first + 1, fr.second + 1}] = depth[fr] + 1;
      q.push({fr.first + 1, fr.second + 1});
    }
    if (mp[{fr.first + 1, fr.second - 1}] == 1 &&
        depth[{fr.first + 1, fr.second - 1}] == -1) {
      depth[{fr.first + 1, fr.second - 1}] = depth[fr] + 1;
      q.push({fr.first + 1, fr.second - 1});
    }
    if (mp[{fr.first - 1, fr.second + 1}] == 1 &&
        depth[{fr.first - 1, fr.second + 1}] == -1) {
      depth[{fr.first - 1, fr.second + 1}] = depth[fr] + 1;
      q.push({fr.first - 1, fr.second + 1});
    }
    if (mp[{fr.first - 1, fr.second - 1}] == 1 &&
        depth[{fr.first - 1, fr.second - 1}] == -1) {
      depth[{fr.first - 1, fr.second - 1}] = depth[fr] + 1;
      q.push({fr.first - 1, fr.second - 1});
    }
  }
}
int main() {
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  int r, c1, c2;
  while (n--) {
    cin >> r >> c1 >> c2;
    for (int i = c1; i <= c2; i++) {
      mp[{r, i}] = true;
      depth[{r, i}] = -1;
    }
  }
  bfs(x0, y0, x1, y1);
  cout << depth[{x1, y1}];
  return 0;
}
