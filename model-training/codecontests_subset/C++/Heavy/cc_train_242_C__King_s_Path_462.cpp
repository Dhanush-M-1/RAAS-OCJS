#include <bits/stdc++.h>
using namespace std;
int ans = -1;
map<pair<int, int>, bool> visited, mp;
void bfs(int x1, int y1, int x2, int y2) {
  queue<pair<pair<int, int>, int>> q;
  q.push({{x1, y1}, 0});
  while (!q.empty()) {
    auto z = q.front();
    q.pop();
    visited[z.first] = 1;
    if (z.first.first == x2 && z.first.second == y2) {
      ans = z.second;
      break;
    }
    int x = z.first.first, y = z.first.second;
    if (x - 1 >= 1 && !visited[{x - 1, y}] && mp[{x - 1, y}]) {
      visited[{x - 1, y}] = true;
      q.push({{x - 1, y}, z.second + 1});
    }
    if (x + 1 <= 1e9 && !visited[{x + 1, y}] && mp[{x + 1, y}]) {
      visited[{x + 1, y}] = true;
      q.push({{x + 1, y}, z.second + 1});
    }
    if (y - 1 >= 1 && !visited[{x, y - 1}] && mp[{x, y - 1}]) {
      visited[{x, y - 1}] = true;
      q.push({{x, y - 1}, z.second + 1});
    }
    if (y + 1 <= 1e9 && !visited[{x, y + 1}] && mp[{x, y + 1}]) {
      visited[{x, y + 1}] = true;
      q.push({{x, y + 1}, z.second + 1});
    }
    if (x + 1 <= 1e9 && y + 1 <= 1e9 && !visited[{x + 1, y + 1}] &&
        mp[{x + 1, y + 1}]) {
      visited[{x + 1, y + 1}] = true;
      q.push({{x + 1, y + 1}, z.second + 1});
    }
    if (x + 1 <= 1e9 && y - 1 >= 1 && !visited[{x + 1, y - 1}] &&
        mp[{x + 1, y - 1}]) {
      visited[{x + 1, y - 1}] = true;
      q.push({{x + 1, y - 1}, z.second + 1});
    }
    if (x - 1 >= 1 && y + 1 <= 1e9 && !visited[{x - 1, y + 1}] &&
        mp[{x - 1, y + 1}]) {
      visited[{x - 1, y + 1}] = true;
      q.push({{x - 1, y + 1}, z.second + 1});
    }
    if (x - 1 >= 1 && y - 1 >= 1 && !visited[{x - 1, y - 1}] &&
        mp[{x - 1, y - 1}]) {
      visited[{x - 1, y - 1}] = true;
      q.push({{x - 1, y - 1}, z.second + 1});
    }
  }
}
int main() {
  ;
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  int n;
  cin >> n;
  set<pair<int, pair<int, int>>> s;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    s.insert({r, {a, b}});
  }
  for (auto it : s) {
    for (int i = it.second.first; i <= it.second.second; i++) {
      mp[{it.first, i}] = true;
    }
  }
  mp[{x1, y1}] = true;
  mp[{x2, y2}] = true;
  bfs(x1, y1, x2, y2);
  cout << ans;
  return 0;
}
