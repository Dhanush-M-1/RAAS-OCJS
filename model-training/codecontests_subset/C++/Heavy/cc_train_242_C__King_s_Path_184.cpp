#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 100;
int dx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
map<long long, bool> map1;
struct node {
  long long x, y, val, step;
};
long long getpos(long long x, long long y) { return 1e9 * x + y; }
int main(void) {
  cin.tie(0);
  std::ios::sync_with_stdio(false);
  long long x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long _r, _a, _b;
    cin >> _r >> _a >> _b;
    for (long long j = _a; j <= _b; j++) {
      map1[getpos(_r, j)] = 1;
    }
  }
  queue<node> q;
  q.push({x0, y0, getpos(x0, y0), 0});
  map1[getpos(x0, y0)] = 1;
  while (q.size()) {
    node u = q.front();
    q.pop();
    if (u.x == x1 && u.y == y1) {
      cout << u.step << endl;
      return 0;
    }
    for (int i = 0; i < 8; i++) {
      long long v1 = u.x + dx[i];
      long long v2 = u.y + dy[i];
      long long v3 = getpos(v1, v2);
      long long v4 = u.step + 1;
      if (map1[v3] == 1 && v1 >= 1 && v1 <= 1e9 && v2 >= 1 && v2 <= 1e9) {
        q.push({v1, v2, v3, v4});
        map1[v3] = 0;
      }
    }
  }
  cout << "-1" << endl;
  return 0;
}
