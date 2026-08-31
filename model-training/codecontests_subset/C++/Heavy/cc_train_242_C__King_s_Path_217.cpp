#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, -1, 1, -1, -1, 1, 1};
int dy[] = {1, -1, 0, 0, 1, -1, -1, 1};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  set<pair<int, int> > allowed;
  for (int i = 0; i < n; i++) {
    int a, b, r;
    cin >> r >> a >> b;
    for (int x = a; x <= b; x++) {
      allowed.insert(pair<int, int>(r, x));
    }
  }
  queue<int> q;
  q.push(x0);
  q.push(y0);
  q.push(0);
  set<pair<int, int> > seen;
  seen.insert(pair<int, int>(x0, y0));
  while (q.size()) {
    int x = q.front();
    q.pop();
    int y = q.front();
    q.pop();
    int d = q.front();
    q.pop();
    if (x == x1 && y == y1) {
      cout << d << '\n';
      return 0;
    }
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      pair<int, int> c = pair<int, int>(nx, ny);
      if (!seen.count(c) && allowed.count(c)) {
        seen.insert(c);
        q.push(nx);
        q.push(ny);
        q.push(d + 1);
      }
    }
  }
  cout << -1 << '\n';
}
