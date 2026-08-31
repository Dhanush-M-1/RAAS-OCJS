#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007, M = 3e5 + 7;
long long powe(long long x, long long y) {
  x = x % mod;
  long long ans = 1;
  while (y > 0) {
    if (y & 1) {
      ans = (1ll * x * ans) % mod;
    }
    y >>= 1;
    x = (1ll * x * x) % mod;
  }
  return ans;
}
map<int, vector<pair<int, int>>> pos;
map<pair<int, int>, bool> vis;
int dx[] = {1, 1, 0, -1, -1, -1, 0, 1};
int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};
bool valid(int x, int y) {
  if (x > 1e9 || x < 1 || y > 1e9 || y < 1) return false;
  if (vis[{x, y}]) return false;
  if (!pos.count(x)) return false;
  for (auto k : pos[x]) {
    if (k.first <= y && k.second >= y) {
      vis[{x, y}] = true;
      return true;
    }
  }
  return false;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int x1, x2, y1, y2, n, a, b, c;
  cin >> x1 >> y1 >> x2 >> y2;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> b >> c;
    pos[a].push_back({b, c});
  }
  queue<pair<int, int>> q1, q2, emp;
  int dis = 1;
  q1.push({x1, y1});
  while (1) {
    if (q1.size() == 0) {
      cout << -1;
      break;
    }
    while (q1.size()) {
      auto k = q1.front();
      q1.pop();
      int x = k.first, y = k.second;
      for (int i = 0; i < 8; i++) {
        if (valid(x + dx[i], y + dy[i])) {
          if (x + dx[i] == x2 && y + dy[i] == y2) {
            cout << dis;
            return 0;
          }
          q2.push({x + dx[i], y + dy[i]});
        }
      }
    }
    dis++;
    swap(q1, q2);
    q2 = emp;
  }
  return 0;
}
