#include <bits/stdc++.h>
using namespace std;
int x3, y3, x2, y2;
int o1[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
int o2[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
set<pair<int, int> > s;
map<pair<int, int>, int> f;
bool check(int x, int y) {
  return (x >= 1 && x <= 1000000000 && y >= 1 && y <= 1000000000) &&
         s.count(pair<int, int>(x, y)) == 1;
}
int bfs() {
  queue<pair<int, int> > q;
  q.push(pair<int, int>(x3, y3));
  f[pair<int, int>(x3, y3)] = 0;
  while (q.size()) {
    int u = q.front().first, v = q.front().second;
    q.pop();
    for (int i = 0; i <= 7; i++) {
      int x = u + o1[i], y = v + o2[i];
      if (check(x, y) &&
          f[pair<int, int>(u, v)] + 1 < f[pair<int, int>(x, y)]) {
        f[pair<int, int>(x, y)] = f[pair<int, int>(u, v)] + 1;
        q.push(pair<int, int>(x, y));
      }
    }
  }
  int ans = f[pair<int, int>(x2, y2)];
  if (ans == INT_MAX) return -1;
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> x3 >> y3 >> x2 >> y2;
  if (x3 > x2) swap(x3, x2), swap(y3, y2);
  int n;
  cin >> n;
  while (n--) {
    int x, a, b;
    cin >> x >> a >> b;
    for (int i = a; i <= b; i++) {
      s.insert(pair<int, int>(x, i));
      f[pair<int, int>(x, i)] = INT_MAX;
    }
  }
  cout << bfs();
  return 0;
}
