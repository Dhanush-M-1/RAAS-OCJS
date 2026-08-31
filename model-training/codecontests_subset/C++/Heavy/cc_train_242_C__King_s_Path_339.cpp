#include <bits/stdc++.h>
using namespace std;
long long sr, sc, er, ec, a, b, n, r;
map<long long, vector<pair<long long, long long>>> m;
pair<pair<long long, long long>, long long> test;
map<pair<long long, long long>, bool> vis;
const int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
const int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
bool valid(long long a, long long b) { return (a > 0 && b > 0); }
long long bfs() {
  queue<pair<pair<long long, long long>, long long>> q;
  q.push({{sr, sc}, 0});
  vis[{sr, sc}] = 1;
  while (!q.empty()) {
    test = q.front();
    q.pop();
    long long l, r;
    l = test.first.first;
    r = test.first.second;
    for (int i = 0; i < 8; ++i) {
      if (vis[{l + dx[i], r + dy[i]}] || !valid(l + dx[i], r + dy[i])) continue;
      if (l + dx[i] == er && r + dy[i] == ec) return test.second + 1;
      for (auto it : m[l + dx[i]]) {
        if (r + dy[i] >= it.first && r + dy[i] <= it.second) {
          vis[{l + dx[i], r + dy[i]}] = 1;
          q.push({{l + dx[i], r + dy[i]}, test.second + 1});
          break;
        }
      }
    }
  }
  return -1;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> sr >> sc >> er >> ec;
  cin >> n;
  while (n--) {
    cin >> r >> a >> b;
    m[r].push_back({a, b});
  }
  cout << bfs();
  return 0;
}
